package mod.mitecreation.mixin.block;

import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.material.CTMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockStrongbox.class)
public class BlockStrongboxMixin extends Block {
    protected BlockStrongboxMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = {"registerIcons(Lnet/minecraft/IconRegister;)V"}, at = {@At("RETURN")})
    private void injectTextureInit(IconRegister register, CallbackInfo callbackInfo) {
        if (this.blockMaterial == CTMaterials.tungsten) {
            this.blockIcon = register.registerIcon(CreationModInit.RESOURCE_ID + "block/tungsten_block");
        }
    }
}
