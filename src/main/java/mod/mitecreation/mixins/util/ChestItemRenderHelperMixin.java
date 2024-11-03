package mod.mitecreation.mixins.util;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChestItemRenderHelper.class)
public class ChestItemRenderHelperMixin {
    @Unique
    private TileEntityChest tungstenChest;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void ChestItemRenderHelper(CallbackInfo ci) {
        this.tungstenChest = new TileEntityChest(EnumChestType.strongbox, RegistryInit.chestTungsten);
    }

    @Inject(method = "renderChest", at = @At("RETURN"))
    public void renderChest(Block par1Block, int par2, float par3, CallbackInfo ci) {
        if (par1Block.blockID == RegistryInit.chestTungsten.blockID) {
            TileEntityRenderer.instance.renderTileEntityAt(this.tungstenChest, 0.0, 0.0, 0.0, 0.0F);
        }
    }
}
