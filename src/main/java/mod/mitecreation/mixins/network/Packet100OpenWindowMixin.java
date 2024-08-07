package mod.mitecreation.mixins.network;

import mod.mitecreation.tileentity.ReforgeTileEntity;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( Packet100OpenWindow.class)
public class Packet100OpenWindowMixin {
    @Unique
    private static final int TYPE_REFORGE = 20;

    @Shadow
    public int inventoryType;
    @Shadow
    public int slotsCount;
    @Shadow
    public boolean useProvidedWindowTitle;
    @Shadow
    public int windowId;
    @Shadow
    public String windowTitle;
    @Shadow
    public int x;
    @Shadow
    public int y;
    @Shadow
    public int z;

    @Inject(method = "handleOpenWindow", at = @At("HEAD"), cancellable = true)
    public void handleOpenWindow(EntityClientPlayerMP player, CallbackInfo ci) {
        WorldClient world = player.worldObj.getAsWorldClient();
        TileEntity tile_entity = world.getBlockTileEntity(this.x, this.y, this.z);
        if (this.inventoryType == TYPE_REFORGE) {
            ReforgeTileEntity reforgeTile = (ReforgeTileEntity) tile_entity;
//            System.out.println("windows");
            player.displayReforgeGui(this.x, this.y, this.z, reforgeTile);
            player.openContainer.windowId = this.windowId;
            ci.cancel();
        }
    }

}
