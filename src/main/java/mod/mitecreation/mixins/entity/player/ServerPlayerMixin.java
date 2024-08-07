package mod.mitecreation.mixins.entity.player;

import mod.mitecreation.container.ReforgeContainer;
import mod.mitecreation.tileentity.ReforgeTileEntity;
import mod.mitecreation.injected_interfaces.IIPlayer;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ServerPlayer.class )
public class ServerPlayerMixin extends EntityPlayer implements IIPlayer {

    @Shadow
    public NetServerHandler playerNetServerHandler;
    @Shadow
    private int currentWindowId;

    public ServerPlayerMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Unique
    @Override
    public void displayReforgeGui(int x, int y, int z, ReforgeTileEntity tileEntity) {
        this.incrementWindowID();
        TileEntity tile_entity = this.worldObj.getBlockTileEntity(x, y, z);
        this.playerNetServerHandler.sendPacketToPlayer((new Packet100OpenWindow(this.currentWindowId,
                20, tile_entity.getCustomInvName(), 9, tile_entity.hasCustomName())).setCoords(x, y, z));
        this.openContainer = new ReforgeContainer(this, (ReforgeTileEntity) tile_entity);
        this.openContainer.windowId = this.currentWindowId;
        ReflectHelper.dyCast(ServerPlayer.class, this).
                sendContainerAndContentsToPlayer(this.openContainer, this.openContainer.getInventory());
    }


    @Shadow
    private void incrementWindowID(){

    }

    @Shadow
    public INetworkManager getNetManager() {
        return null;
    }

    @Shadow
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {

    }

    @Shadow
    public boolean canCommandSenderUseCommand(int i, String string) {
        return false;
    }

    @Shadow
    public ChunkCoordinates getPlayerCoordinates() {
        return null;
    }
}

