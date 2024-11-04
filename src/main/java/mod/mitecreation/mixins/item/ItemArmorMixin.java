package mod.mitecreation.mixins.item;

import mod.mitecreation.material.CreationMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemArmor.class)
public abstract class ItemArmorMixin extends Item implements IDamageableItem {
    @Shadow
    protected Material effective_material;

    @Mutable
    @Final
    @Shadow
    private final boolean is_chain_mail;

    public ItemArmorMixin(int par1, Material material, int par4, boolean is_chain_mail, boolean isChainMail) {
        super(par1, material, (String)null);
        this.effective_material = material;
        this.is_chain_mail = isChainMail;
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Unique
    private int creationArmorProtection() {
        int protection;
        if (this.effective_material == CreationMaterials.tungsten) {
            protection = 9;
        } else {
            return 0;
        }
        if (this.is_chain_mail) {
            protection -= 2;
        }
        return protection;
    }

    @Inject(method = "getMaterialProtection", at = @At("HEAD"), cancellable = true)
    private void getMaterialProtectionCreation(CallbackInfoReturnable<Integer> cir) {
        int protection = this.creationArmorProtection();
        if (protection != 0) cir.setReturnValue(protection);
    }
}

