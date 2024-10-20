package mod.mitecreation.entity;

import net.minecraft.*;

public class EntityDevilBat extends EntityVampireBat {
    private int attack_cooldown = 10;
    private int feed_cooldown = 20;

    public EntityDevilBat(World world) {
        super(world);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(SharedMonsterAttributes.attackDamage, 3.0D);
        this.setEntityAttribute(SharedMonsterAttributes.followRange, 64);
        this.setEntityAttribute(SharedMonsterAttributes.maxHealth, 8);
    }

    protected void collideWithEntity(Entity entity) {
        super.collideWithEntity(entity);

        if (this.attack_cooldown <= 0 && entity == this.getAttackTarget()) {
            if (this.boundingBox.copy().scaleXZ(0.5D).intersectsWith(entity.boundingBox)) {
                EntityDamageResult result = EntityMob.attackEntityAsMob(this, entity);

                if (result != null && result.entityLostHealth()) {
                    this.heal(result.getAmountOfHealthLost(), EnumEntityFX.vampiric_gain);

                    if (entity instanceof EntityOcelot) {
                        EntityOcelot ocelot = (EntityOcelot) entity;

                        if (ocelot.getHealth() > 0.0F && ocelot.getTarget() == null) {
                            ocelot.setTarget(this);
                        }
                    }

                    if (this.getHealth() >= this.getMaxHealth()) {
                        this.feed_cooldown = 20;
                    }
                }
            }

            this.attack_cooldown = 10;
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.attack_cooldown > 0) {
            --this.attack_cooldown;
        }
        if (this.feed_cooldown > 0) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.feed_cooldown = 0;
            } else if (--this.feed_cooldown > 0) {
                EntityLivingBase target = this.getAttackTarget();

                if (target != null && !this.preysUpon(target)) {
                    this.setAttackTarget((EntityLivingBase) null);
                }
            }
        }
        if (this.getTicksExistedWithOffset() % 20 == 0) {
            this.setAttackTarget(this.worldObj.getClosestPrey(this, 128.0D, true, false));
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 4;
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
