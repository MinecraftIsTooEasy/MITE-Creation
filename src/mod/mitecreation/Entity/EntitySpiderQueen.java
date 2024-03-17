package mod.mitecreation.entity;

import net.minecraft.*;

import java.util.Iterator;
import java.util.List;

public class EntitySpiderQueen extends EntityArachnid {
    private final int num_webs;
    public EntitySpiderQueen(World par1World) {
        super(par1World, 1.45F);
        this.num_webs = 6;
    }
    private EntitySkeleton getMountedSkeleton() {
        Object var2;
        do {
            var2 = this.worldObj.isUnderworld() ? new EntityLongdeadGuardian(this.worldObj) : new EntitySkeleton(this.worldObj);
            ((EntitySkeleton)var2).setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            ((EntitySkeleton)var2).onSpawnWithEgg((EntityLivingData)null);
        } while(((EntitySkeleton)var2).getSkeletonType() != 0);

        return (EntitySkeleton)var2;
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
            if (result.entityLostHealth() && target instanceof EntityLiving) {
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 5));
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.poison.id, 850, 0));
            }
            return result;
        } else {
            return result;
        }
    }

    private int spawnCounter;
    private int spawnSums;
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
        if (!getWorld().isRemote) {
            if (spawnSums < 8)
                if (spawnCounter < 20) {
                    ++this.spawnCounter;
                } else {
                    EntityCaveSpider caveSpider = new EntityCaveSpider(worldObj);
                    caveSpider.setPosition(posX + this.rand.nextInt(8) - this.rand.nextInt(8), posY, posZ - this.rand.nextInt(8) + this.rand.nextInt(8));
                    caveSpider.refreshDespawnCounter(-9600);
                    worldObj.spawnEntityInWorld(caveSpider);
                    caveSpider.onSpawnWithEgg(null);
                    caveSpider.entityFX(EnumEntityFX.summoned);
                    spawnCounter = 0;
                    spawnSums++;
                }
        }

    }
//    public void onDeath(DamageSource damageSource) {
//        super.onDeath(damageSource);
//        int day = this.worldObj.getDayOfWorld();
//        Entity player = damageSource.getResponsibleEntity();
//        if (player instanceof EntityPlayer) {
//            int count = Math.min(3,1 + day / 48);
//            for (int i = 0; i < count; ++i) {
//                this.dropItem(Item.diamond);
//            }
//            this.dropItem(Items.voucherSpiderQueen);
//            this.dropItem(Items.spiderQueenSilk);
//        }
//    }

    public int getExperienceValue() {
        return super.getExperienceValue() * 6;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

}
