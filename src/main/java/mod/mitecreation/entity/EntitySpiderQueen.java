package mod.mitecreation.entity;

import net.minecraft.*;

import java.util.Iterator;
import java.util.List;

public class EntitySpiderQueen extends EntityArachnid {

    private final int num_webs;
    int num_troops_summoned;


    public EntitySpiderQueen(World par1World) {
        super(par1World, 1.5F);
        this.num_webs = 6;
    }

    private EntitySkeleton getMountedSkeleton() {
        EntitySkeleton skeleton;
        do {
            skeleton = new EntityLongdeadGuardian(this.worldObj);
            skeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            skeleton.onSpawnWithEgg((EntityLivingData)null);
        }
        while (skeleton.getSkeletonType() != 0);
        return skeleton;
    }

    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData) {
        Object var2 = super.onSpawnWithEgg(par1EntityLivingData);
        if (this.worldObj.rand.nextInt(100) == 0) {
            EntitySkeleton var3 = this.getMountedSkeleton();
            this.worldObj.spawnEntityInWorld(var3);
            var3.mountEntity(this);
        }
        if (var2 == null) {
            var2 = new SpiderEffectsGroupData();

            if (this.worldObj.difficultySetting > 2 && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ)) {
                ((SpiderEffectsGroupData)var2).func_111104_a(this.worldObj.rand);
            }
        }
        if (var2 instanceof SpiderEffectsGroupData) {
            int var4 = ((SpiderEffectsGroupData)var2).field_111105_a;
            if (var4 > 0 && Potion.potionTypes[var4] != null) {
                this.addPotionEffect(new PotionEffect(var4, Integer.MAX_VALUE));
            }
        }
        return (EntityLivingData)var2;
    }

    public float getNaturalDefense() {
        return 4.0F;
    }

    public float getNaturalDefense(DamageSource damage_source) {
        return super.getNaturalDefense(damage_source) + (damage_source.bypassesMundaneArmor() ? 0.0F : this.getNaturalDefense());
    }

    protected String getLivingSound() {
        return "imported.mob.demonspider.say";
    }

    protected String getHurtSound() {
        return "imported.mob.demonspider.hurt";
    }

    protected String getDeathSound() {
        return "imported.mob.demonspider.death";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4) {
        this.makeSound("mob.spider.step", 0.55F, 1.0F);
    }

    protected float getSoundVolume(String sound) {
        return super.getSoundVolume(sound) * 1.3F;
    }

    protected float getSoundPitch(String sound) {
        return super.getSoundPitch(sound) * 0.6F;
    }

    public boolean peacefulDuringDay() {
        return false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(SharedMonsterAttributes.maxHealth, 24.0);
        this.setEntityAttribute(SharedMonsterAttributes.followRange, 40.0);
        this.setEntityAttribute(SharedMonsterAttributes.attackDamage, 12.0);
        this.setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.92);
    }

    public EntityDamageResult attackEntityAsMob(Entity target) {
        EntityDamageResult result = super.attackEntityAsMob(target);
        if (result != null && !result.entityWasDestroyed()) {
            if (result.entityLostHealth() && target instanceof EntityLivingBase) {
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.poison.id, 960, 0));
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 5));
            }
            return result;
        } else {
            return result;
        }
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.num_troops_summoned = par1NBTTagCompound.getByte("num_troops_summoned");
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.num_troops_summoned > 0) {
            par1NBTTagCompound.setByte("num_troops_summoned", (byte) this.num_troops_summoned);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote) {
            List nearby_spiders = this.worldObj.getEntitiesWithinAABB(EntityArachnid.class, this.boundingBox.expand(16.0, 8.0, 16.0));
            Iterator i = nearby_spiders.iterator();
            if (this.getTicksExistedWithOffset() % 100 == 0) {
                while (i.hasNext()) {
                    EntityArachnid spiders = (EntityArachnid) i.next();
                    if (spiders == this) continue;
                    spiders.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
                }
            }
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.onServer()) {
            if (!this.isNoDespawnRequired() && this.getTarget() instanceof EntityPlayer) {
                this.func_110163_bv();
            }

            if (this.getTicksExistedWithOffset() % 20 == 0) {
                EntityLivingBase target = this.getTarget();

                if (target != null) {
                    if (target.isDead || target.getHealth() <= 0.0F || (double) this.getDistanceToEntity(target) > 16.0D || !this.canSeeEntity(target)) {
                        target = null;
                    }

                    if (this.num_troops_summoned < 6 && target instanceof EntityPlayer && this.rand.nextInt(8) < 7 - this.num_troops_summoned) {
                        this.num_troops_summoned += this.trySummonTroop(target);

                        if (this.num_troops_summoned < 6 && this.rand.nextBoolean()) {
                            this.num_troops_summoned += this.trySummonTroop(target);
                        }
                    }
                }

                List nearby_spider = this.worldObj.getEntitiesWithinAABB(EntityArachnid.class, this.boundingBox.expand(16.0D, 8.0D, 16.0D));
                Class troop_class = EntityCaveSpider.class;
                Iterator i = nearby_spider.iterator();

                while (i.hasNext()) {
                    EntityArachnid entity_spider = (EntityArachnid) i.next();

                    if (entity_spider == this || entity_spider.canSeeEntity(this, true)) {
                        if (entity_spider.getHealth() < entity_spider.getMaxHealth()) {
                            entity_spider.heal(1.0F);
                        }

                        if (this.num_troops_summoned > 0 && entity_spider.getClass() == troop_class && (entity_spider.getAttackTarget() == null && entity_spider.getHealthFraction() >= 1.0F && this.rand.nextFloat() < 0.05F || entity_spider.despawn_counter >= 0)) {
                            int despawn_counter = entity_spider.despawn_counter;
                            entity_spider.despawn_counter = Integer.MAX_VALUE;

                            if (entity_spider.canDespawn()) {
                                entity_spider.tryDespawnEntity();

                                if (entity_spider.isDead) {
                                    --this.num_troops_summoned;
                                } else {
                                    entity_spider.despawn_counter = despawn_counter;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private int trySummonTroop(EntityLivingBase target) {
        int spider_queen_x = this.getBlockPosX();
        int spider_queen_y = this.getFootBlockPosY();
        int spider_queen_z = this.getBlockPosZ();
        int target_x = target.getBlockPosX();
        int target_y = target.getFootBlockPosY();
        int target_z = target.getBlockPosZ();
        Vec3 spider_queen_leg_pos = this.getFootPosPlusFractionOfHeight(0.25F);
        Vec3 spider_queen_head_pos = this.getFootPosPlusFractionOfHeight(0.75F);
        Class troop_class = EntityCaveSpider.class;
        int max_num_attempts = 48 - this.num_troops_summoned * 8;
        int attempts = 0;
        EntityArachnid spider;

        while (true) {
            if (attempts >= max_num_attempts) {
                return 0;
            }

            spider = (EntityArachnid) ((WorldServer) this.worldObj).tryCreateNewLivingEntityCloseTo(spider_queen_x, spider_queen_y, spider_queen_z, 2, 8, troop_class, EnumCreatureType.monster);

            if (spider != null) {

                if (this.worldObj.getClosestVulnerablePlayer(spider, 4.0D, false) == null && (spider.canSeeEntity(target, true))) {
                    double distance_sq_to_summoning_spider_queen = spider.getDistanceSqToEntity(this);
                    Iterator i = this.worldObj.getAsWorldServer().playerEntities.iterator();

                    while (i.hasNext()) {
                        EntityPlayer navigator = (EntityPlayer) i.next();

                        if (navigator.getHealth() > 0.0F && spider.getDistanceSqToEntity(navigator) < distance_sq_to_summoning_spider_queen) {
                            spider = null;
                            break;
                        }
                    }

                    if (spider != null) {
                        label102: {
                            PathNavigate var23 = spider.getNavigator();
                            Vec3 skeleton_eye_pos = spider.getEyePos();
                            boolean can_raycast_to_summoner = skeleton_eye_pos.squareDistanceTo(spider_queen_leg_pos) < 256.0D && this.worldObj.checkForNoBlockCollision(skeleton_eye_pos, spider_queen_leg_pos, RaycastPolicies.for_piercing_projectile);
                            World var10000;
                            PathEntity path;
                            PathPoint final_point;

                            if (!can_raycast_to_summoner) {
                                can_raycast_to_summoner = skeleton_eye_pos.squareDistanceTo(spider_queen_head_pos) < 256.0D && this.worldObj.checkForNoBlockCollision(skeleton_eye_pos, spider_queen_head_pos, RaycastPolicies.for_piercing_projectile);

                                if (!can_raycast_to_summoner) {
                                    path = this.worldObj.getEntityPathToXYZ(spider, spider_queen_x, spider_queen_y, spider_queen_z, 16.0F, var23.canPassOpenWoodenDoors, false, var23.avoidsWater, var23.canSwim);

                                    if (path == null) {
                                        break label102;
                                    }

                                    final_point = path.getFinalPathPoint();
                                    var10000 = this.worldObj;

                                    if (World.getDistanceSqFromDeltas((float) (final_point.xCoord - spider_queen_x), (float) (final_point.yCoord - spider_queen_y), (float) (final_point.zCoord - spider_queen_z)) > 2.0D) {
                                        break label102;
                                    }
                                }
                            }

                            path = this.worldObj.getEntityPathToXYZ(spider, target_x, target_y, target_z, 16.0F, var23.canPassOpenWoodenDoors, false, var23.avoidsWater, var23.canSwim);

                            if (path != null) {
                                final_point = path.getFinalPathPoint();
                                var10000 = this.worldObj;

                                if (World.getDistanceSqFromDeltas((float) (final_point.xCoord - target_x), (float) (final_point.yCoord - target_y), (float) (final_point.zCoord - target_z)) <= 2.0D) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            ++attempts;
        }

        spider.refreshDespawnCounter(-9600);
        this.worldObj.spawnEntityInWorld(spider);
        spider.onSpawnWithEgg((EntityLivingData) null);
        spider.setAttackTarget(target);
        spider.entityFX(EnumEntityFX.summoned);
        return 1;
    }

    public int getExperienceValue() {
        return super.getExperienceValue() * 6;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

}
