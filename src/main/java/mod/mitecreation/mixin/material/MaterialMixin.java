package mod.mitecreation.mixin.material;

import mod.mitecreation.api.CreationMaterial;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Material.class)
public class MaterialMixin implements CreationMaterial {

    @Shadow
    protected float durability;
    @Shadow
    protected int min_harvest_level;
    @Shadow
    protected String name;

    @Override
    @Unique
    public float getDurability() {
        return this.durability;
    }

    @Override
    @Unique
    public int getMinHarvestLevel() {
        return this.min_harvest_level;
    }

    @Override
    @Unique
    public String getName() {
        return this.name;
    }
}
