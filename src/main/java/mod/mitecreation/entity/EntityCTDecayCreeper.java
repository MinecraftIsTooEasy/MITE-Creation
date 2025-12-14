package mod.mitecreation.entity;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.EntityCreeper;
import net.minecraft.World;

public class EntityCTDecayCreeper extends EntityCreeper {
    public EntityCTDecayCreeper(World par1World) {
        super(par1World);
        this.explosionRadius *= 2.5F;
    }

    @Override
    public int getFragParticle() {
        return CTRegistryInit.fragsDecayCreeper.itemID;
    }

    @Override
    public boolean isHarmedByFire() {
        return false;
    }

    @Override
    public int getExperienceValue() {
        return super.getExperienceValue() * 2;
    }

    @Override
    protected float getSoundVolume(String sound) {
        return super.getSoundVolume(sound) * 0.7F;
    }

    @Override
    protected float getSoundPitch(String sound) {
        return super.getSoundPitch(sound) * 0.75F;
    }
}
