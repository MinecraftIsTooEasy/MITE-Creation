package mod.mitecreation.entity;

import net.minecraft.*;
import net.xiaoyu233.fml.FishModLoader;

import java.util.Iterator;
import java.util.List;

public class EntitySpirit extends EntityMob {
    private int heal_counter;
    private int max_num_evasions;
    private int num_evasions;
    private int teleportDelay;
    private Entity lastEntityToAttack;
    private boolean isAggressive;

    public EntitySpirit(World par1World) {
        super(par1World);
        this.setSize(0.5F, 2.8F);
        this.stepHeight = 1.0F;
        if (par1World != null && this.onServer()) {
            this.max_num_evasions = this.num_evasions = 8;
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(SharedMonsterAttributes.maxHealth, 30.0);
        this.setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.35);
        this.setEntityAttribute(SharedMonsterAttributes.attackDamage, 15.0);
        if (FishModLoader.hasMod("mite_ite")) {
            int day = this.getWorld() != null ? this.getWorld().getDayOfWorld() : 0;
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(80.0 + (double)day / 20.0);
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.35);
            this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(35.0 + (double)day / 20.0);
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, (byte)0);
        this.dataWatcher.addObject(17, (byte)0);
        this.dataWatcher.addObject(18, (byte)0);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("carried", (short)this.getCarried());
        par1NBTTagCompound.setShort("carriedData", (short)this.getCarryingData());
        par1NBTTagCompound.setByte("max_num_evasions", (byte)this.max_num_evasions);
        par1NBTTagCompound.setByte("num_evasions", (byte)this.num_evasions);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setCarried(par1NBTTagCompound.getShort("carried"));
        this.setCarryingData(par1NBTTagCompound.getShort("carriedData"));
        this.max_num_evasions = par1NBTTagCompound.getByte("max_num_evasions");
        this.num_evasions = par1NBTTagCompound.getByte("num_evasions");
    }

    public EntityItem findTargetEntityItem(float max_distance) {
        Iterator i = this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.boundingBox.expand((double)max_distance, (double)(max_distance * 0.25F), (double)max_distance)).iterator();

        EntityItem entity_item;
        do {
            do {
                do {
                    if (!i.hasNext()) {
                        return null;
                    }

                    entity_item = (EntityItem)i.next();
                } while(entity_item.isWet());
            } while(entity_item.isBurning() && this.isHarmedByFire());
        } while(!this.willPickupAsValuable(entity_item.getEntityItem()));

        return entity_item;
    }

    public void onLivingUpdate() {
        if (this.lastEntityToAttack != this.entityToAttack) {
            AttributeInstance var1 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
        }

        this.lastEntityToAttack = this.entityToAttack;
        int var6;

        for(var6 = 0; var6 < 2; ++var6) {
            this.worldObj.spawnParticle(EnumParticle.portal_nether, this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
        }

        boolean has_teleported = false;
        if (this.entityToAttack == null && this.worldObj.isDaytime() && !this.worldObj.isRemote && this.rand.nextInt(4) == 0) {
            float var7 = this.getBrightness(1.0F);
            if (var7 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var7 - 0.4F) * 2.0F) {
                this.entityToAttack = null;
                this.setScreaming(false);
                this.isAggressive = false;
                if (this.teleportRandomly()) {
                    has_teleported = true;
                }
            }
        }

        if (this.onServer() && !has_teleported && this.getTicksExistedWithOffset() % 20 == 0 && this.rand.nextInt(10) == 0 && this.tryTeleportToValuableItem()) {
            has_teleported = true;
        }

        if (this.onServer() && (this.isWet() || this.isBurning())) {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.isAggressive = false;
            this.teleportRandomly();
        }

        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0) {
            this.setScreaming(false);
        }

        this.isJumping = false;
        if (this.entityToAttack != null) {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }

        if (!this.worldObj.isRemote && this.isEntityAlive()) {
            if (this.entityToAttack != null) {
                if (++this.teleportDelay > 30) {
                    if (this.rand.nextInt(2) == 0) {
                        if (this.rand.nextInt(3) == 0) {
                            this.teleportRandomly();
                        } else {
                            this.teleportToEntity(this.entityToAttack);
                        }
                    }

                    this.teleportDelay = 0;
                }
            } else {
                this.setScreaming(false);
                this.teleportDelay = 0;
            }
        }
        if (this.onServer() && this.getHealth() > 0.0F) {
            int ticks_existed_with_offset = this.getTicksExistedWithOffset();
            if (this.num_evasions < this.max_num_evasions && ticks_existed_with_offset % 600 == 0) {
                ++this.num_evasions;
            }
            if (this.hasPath() && (this.getTarget() != null || this.fleeing) && ticks_existed_with_offset % 10 == 0 && this.rand.nextInt(3) == 0) {
                PathEntity path = this.getPathToEntity();
                if (!path.isFinished()) {
                    int n = path.getNumRemainingPathPoints();
                    if (n > 1) {
                        int path_index_advancement = MathHelper.clamp_int(this.rand.nextInt(n), 1, 4);
                        PathPoint path_point = path.getPathPointFromCurrentIndex(path_index_advancement);
                        if ((double)path_point.distanceSqTo(this) > 3.0 && this.tryTeleportTo((double)path_point.xCoord + 0.5, (double)path_point.yCoord, (double)path_point.zCoord + 0.5)) {
                            path.setCurrentPathIndex(path.getCurrentPathIndex() + path_index_advancement - 1);
                        }
                    }
                }
            }
        }

        super.onLivingUpdate();
    }

    private EntityItem getNearestObtainableValuableItem() {
        EntityItem nearest_obtainable_valuable_item = null;
        double distance_sq_to_nearest_obtainable_valuable_item = 0.0;
        List items = this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.boundingBox.expand(16.0, 8.0, 16.0));
        Iterator i = items.iterator();

        while(true) {
            EntityItem entity_item;
            double distance_sq;
            do {
                int x;
                int y;
                int z;
                do {
                    do {
                        ItemStack item_stack;
                        do {
                            do {
                                do {
                                    do {
                                        if (!i.hasNext()) {
                                            return nearest_obtainable_valuable_item;
                                        }

                                        entity_item = (EntityItem)i.next();
                                    } while(entity_item.isDead);
                                } while(entity_item.isWet());
                            } while(entity_item.isBurning() && this.isHarmedByFire());

                            item_stack = entity_item.getEntityItem();
                        } while(!this.willPickupAsValuable(item_stack));

                        x = entity_item.getBlockPosX();
                        y = entity_item.getBlockPosY();
                        z = entity_item.getBlockPosZ();
                    } while(!this.worldObj.isAirOrPassableBlock(x, y + 1, z, false));
                } while(!this.worldObj.isAirOrPassableBlock(x, y + 2, z, false));

                distance_sq = this.getDistanceSqToEntity(entity_item);
            } while(nearest_obtainable_valuable_item != null && !(distance_sq < distance_sq_to_nearest_obtainable_valuable_item));

            nearest_obtainable_valuable_item = entity_item;
            distance_sq_to_nearest_obtainable_valuable_item = distance_sq;
        }
    }

    private boolean tryTeleportToValuableItem() {
        if (this.onClient()) {
            Minecraft.setErrorMessage("tryTeleportToValuableItem: called on client");
        }

        if (!this.isWet() && !this.isBurning()) {
            EntityItem entity_item = this.getNearestObtainableValuableItem();
            if (entity_item == null) {
                return false;
            } else {
                int x = entity_item.getBlockPosX();
                int y = entity_item.getBlockPosY();
                int z = entity_item.getBlockPosZ();
                return this.teleportTo((double)x + 0.5, this.worldObj.getBlockCollisionTopY(x, y, z, this), (double)z + 0.5);
            }
        } else {
            return false;
        }
    }

    protected boolean teleportRandomly() {
        if (this.onClient()) {
            Minecraft.setErrorMessage("teleportRandomly: called on client");
        }

        if (this.isDecoy()) {
            return false;
        } else if (this.tryTeleportToValuableItem()) {
            return true;
        } else {
            double var1 = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
            double var3 = this.posY + (double)(this.rand.nextInt(64) - 32);
            double var5 = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
            return this.teleportTo(var1, var3, var5);
        }
    }

    protected boolean teleportToEntity(Entity par1Entity) {
        int x = par1Entity.getBlockPosX() + this.rand.nextInt(7) - 3;
        int y = par1Entity.getBlockPosY() + 3;
        int z = par1Entity.getBlockPosZ() + this.rand.nextInt(7) - 3;

        for(int dy = 0; dy >= -6 && this.worldObj.isAirOrPassableBlock(x, y - 1, z, false); --dy) {
            --y;
        }

        return this.teleportTo((double)((float)x + 0.5F), (double)((float)y + 0.1F), (double)((float)z + 0.5F));
    }

    protected boolean teleportTo(double par1, double par3, double par5) {
        double var7 = this.posX;
        double var9 = this.posY;
        double var11 = this.posZ;
        this.posX = par1;
        this.posY = par3;
        this.posZ = par5;
        boolean var13 = false;
        int var14 = MathHelper.floor_double(this.posX);
        int var15 = MathHelper.floor_double(this.posY);
        int var16 = MathHelper.floor_double(this.posZ);
        if (this.worldObj.blockExists(var14, var15, var16)) {
            boolean var17 = false;

            while(!var17 && var15 > 0) {
                if (this.worldObj.isBlockSolid(var14, var15 - 1, var16)) {
                    var17 = true;
                } else {
                    --this.posY;
                    --var15;
                }
            }
        }

        if (!var13) {
            this.setPosition(var7, var9, var11);
            return false;
        } else {
            int x = MathHelper.floor_double(this.posX);
            int y = MathHelper.floor_double(this.posY);
            int z = MathHelper.floor_double(this.posZ);
            World var10000 = this.worldObj;
            double distance = (double)World.getDistanceFromDeltas(this.posX - var7, this.posY - var9, this.posZ - var11);
            this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y, z, (new SignalData()).setByte(EnumParticle.portal_nether.ordinal()).setShort((int)(8.0 * distance)).setApproxPosition((double)MathHelper.floor_double(var7), (double)MathHelper.floor_double(var9), (double)MathHelper.floor_double(var11)));
            this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y + 1, z, (new SignalData()).setByte(EnumParticle.portal_nether.ordinal()).setShort((int)(8.0 * distance)).setApproxPosition((double)MathHelper.floor_double(var7), (double)MathHelper.floor_double(var9 + 1.0), (double)MathHelper.floor_double(var11)));
            this.worldObj.playSoundEffect(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    protected String getLivingSound() {
        return this.isScreaming() ? "imported.mob.spirit.scream" : "imported.mob.spirit.idle";
    }

    protected String getHurtSound() {
        return "imported.mob.spirit.hit";
    }

    protected String getDeathSound() {
        return "imported.mob.spirit.death";
    }

    protected int getDropItemId() {
        return Item.enderPearl.itemID;
    }

    public void setCarried(int par1) {
        this.dataWatcher.updateObject(16, (byte)(par1 & 255));
    }

    public int getCarried() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void setCarryingData(int par1) {
        this.dataWatcher.updateObject(17, (byte)(par1 & 255));
    }

    public int getCarryingData() {
        return this.dataWatcher.getWatchableObjectByte(17);
    }

    public boolean isScreaming() {
        return this.dataWatcher.getWatchableObjectByte(18) > 0;
    }

    public void setScreaming(boolean par1) {
        this.dataWatcher.updateObject(18, (byte)(par1 ? 1 : 0));
    }

    public boolean isEntityBiologicallyAlive() {
        return false;
    }

    public void tryAddArrowToContainedItems(EntityArrow entity_arrow) {
    }

    public boolean isFrenzied() {
        return false;
    }

    protected float getSoundVolume(String sound) {
        return 0.75F;
    }

    public boolean tryTeleportTo(double pos_x, double pos_y, double pos_z) {
        if (!this.isDead && !(this.getHealth() <= 0.0F)) {
            int x = MathHelper.floor_double(pos_x);
            int y = MathHelper.floor_double(pos_y);
            int z = MathHelper.floor_double(pos_z);
            if (y >= 1 && this.worldObj.blockExists(x, y, z)) {
                while(true) {
                    --y;
                    if (this.worldObj.isBlockSolid(x, y, z)) {
                        ++y;
                        if (!this.worldObj.isBlockSolid(x, y, z) && !this.worldObj.isLiquidBlock(x, y, z)) {
                            double delta_pos_x = pos_x - this.posX;
                            double delta_pos_y = pos_y - this.posY;
                            double delta_pos_z = pos_z - this.posZ;
                            AxisAlignedBB bb = this.boundingBox.translateCopy(delta_pos_x, delta_pos_y, delta_pos_z);
                            if (this.worldObj.getCollidingBoundingBoxes(this, bb).isEmpty() && !this.worldObj.isAnyLiquid(bb)) {
                                World var10000 = this.worldObj;
                                double distance = (double)World.getDistanceFromDeltas(delta_pos_x, delta_pos_y, delta_pos_z);
                                this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y, z, (new SignalData()).setByte(EnumParticle.portal_nether.ordinal()).setShort((int)(16.0 * distance)).setApproxPosition((double)MathHelper.floor_double(this.posX), (double)MathHelper.floor_double(this.posY), (double)MathHelper.floor_double(this.posZ)));
                                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "mob.endermen.portal", 1.0F, 1.0F);
                                this.setPosition(pos_x, pos_y, pos_z);
                                this.send_position_update_immediately = true;
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    if (y < 1) {
                        return false;
                    }
                    --pos_y;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean tryTeleportAwayFrom(Entity entity, double min_distance) {
        if (!this.isDead && !(this.getHealth() <= 0.0F)) {
            double min_distance_sq = min_distance * min_distance;
            int x = this.getBlockPosX();
            int y = this.getFootBlockPosY();
            int z = this.getBlockPosZ();
            double threat_pos_x = entity == null ? this.posX : entity.posX;
            double threat_pos_z = entity == null ? this.posZ : entity.posZ;

            for(int attempts = 0; attempts < 64; ++attempts) {
                int dx = this.rand.nextInt(11) - 5;
                int dy = this.rand.nextInt(9) - 4;
                int dz = this.rand.nextInt(11) - 5;
                if (Math.abs(dx) >= 3 || Math.abs(dz) >= 3) {
                    int try_x = x + dx;
                    int try_y = y + dy;
                    int try_z = z + dz;
                    double try_pos_x = (double)try_x + 0.5;
                    double try_pos_z = (double)try_z + 0.5;
                    World var10000 = this.worldObj;
                    if (!(World.getDistanceSqFromDeltas(try_pos_x - threat_pos_x, try_pos_z - threat_pos_z) < min_distance_sq) && try_y >= 1 && this.worldObj.blockExists(try_x, try_y, try_z)) {
                        do {
                            --try_y;
                        } while(!this.worldObj.isBlockSolid(try_x, try_y, try_z) && try_y >= 1);

                        if (try_y >= 1) {
                            ++try_y;
                            if (!this.worldObj.isBlockSolid(try_x, try_y, try_z) && !this.worldObj.isLiquidBlock(try_x, try_y, try_z) && this.tryTeleportTo(try_pos_x, (double)try_y, try_pos_z)) {
                                EntityPlayer target = this.findPlayerToAttack(Math.min(this.getMaxTargettingRange(), 24.0F));
                                if (target != null && target != this.getTarget()) {
                                    this.setTarget(target);
                                }

                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.getHealth() < this.getMaxHealth()) {
            this.heal(0.05F);
        }
    }

    public EntityDamageResult attackEntityFrom(Damage damage) {
        boolean can_evade = !damage.isFallDamage() && !damage.isFireDamage() && !damage.isPoison();
        if (can_evade && this.num_evasions > 0) {
            --this.num_evasions;
            if (this.tryTeleportAwayFrom(this.getTarget(), 8.0)) {
                return null;
            }
        }
        return super.attackEntityFrom(damage);
    }

    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
    }

    public int getExperienceValue() {
        return super.getExperienceValue() * 4;
    }

    @Override
    public float getReach() {
        return super.getReach() * 1.5F;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

    @Override
    public boolean isHarmedByFire() {
        return false;
    }

    @Override
    public boolean isHarmedByLava() {
        return false;
    }
}

