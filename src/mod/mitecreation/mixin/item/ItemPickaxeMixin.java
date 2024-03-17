package mod.mitecreation.mixin.item;

import net.minecraft.*;
import mod.mitecreation.materil.Materials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemPickaxe.class)
public class ItemPickaxeMixin extends ItemTool {
    protected ItemPickaxeMixin(int par1, Material material) {
        super(par1, material);
    }
    @Inject(method = "<init>",at = @At("RETURN"))
    public void injectCtor(CallbackInfo callbackInfo) {
        this.addMaterialsEffectiveAgainst(new Material[]{Materials.tungsten});
    }
    @Shadow
    public float getBaseDamageVsEntity() {
        return 0;
    }

    @Shadow
    public float getBaseDecayRateForBreakingBlock(Block block) {
        return 0;
    }

    @Shadow
    public float getBaseDecayRateForAttackingEntity(ItemStack itemStack) {
        return 0;
    }

    @Shadow
    public String getToolType() {
        return null;
    }

    @Shadow
    public int getNumComponentsForDurability() {
        return 0;
    }
}
