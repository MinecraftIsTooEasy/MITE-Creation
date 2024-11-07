package mod.mitecreation.mixin.block.titleentity;

import mod.mitecreation.material.CreationMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityChestRenderer.class)
public class TileEntityChestRendererMixin extends TileEntitySpecialRenderer {
    @Unique
    private static final ResourceLocation RES_TUNGSTEN_SINGLE = new ResourceLocation("textures/entity/chest/tungsten_single.png");

    @Override
    @Shadow
    public void renderTileEntityAt(TileEntity tileEntity, double v, double v1, double v2, float v3) {
    }

    @Inject(
            method = {"renderTileEntityChestAt(Lnet/minecraft/TileEntityChest;DDDF)V"},
            slice = {@Slice(
                    from = @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/TileEntityChestRenderer;RES_CHRISTMAS_SINGLE:Lnet/minecraft/ResourceLocation;",
                            opcode = 178
                    ),
                    to = @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/TileEntityChestRenderer;largeChestModel:Lnet/minecraft/ModelChest;",
                            opcode = 180
                    )
            )},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/TileEntityChestRenderer;bindTexture(Lnet/minecraft/ResourceLocation;)V",
                    shift = At.Shift.AFTER
            )}
    )
    private void injectGetCreationChestTexture(TileEntityChest par1TileEntityChest, double par2, double par4, double par6, float par8, CallbackInfo callbackInfo){
        if (par1TileEntityChest.getBlockMaterial() == CreationMaterials.tungsten) {
            this.bindTexture(RES_TUNGSTEN_SINGLE);
        }
    }
}
