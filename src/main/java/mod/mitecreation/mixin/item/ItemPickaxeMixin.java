package mod.mitecreation.mixin.item;

import mod.mitecreation.material.CreationMaterials;
import net.minecraft.ItemPickaxe;
import net.minecraft.ItemTool;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemPickaxe.class)
public abstract class ItemPickaxeMixin extends ItemTool {
    protected ItemPickaxeMixin(int par1, Material material) {
        super(par1, material);
    }

    @Inject(method = "<init>",at = @At("RETURN"))
    public void creatonInjectInit(CallbackInfo callbackInfo) {
        this.addMaterialsEffectiveAgainst(new Material[]{CreationMaterials.tungsten});
    }
}
