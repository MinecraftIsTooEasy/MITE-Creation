package mod.mitecreation.mixin.block.tileentity;

import net.minecraft.*;
import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityBeacon.class)
public abstract class TileEntityBeaconMixin extends TileEntity {
    private float c;
    private boolean isBeaconActive;
    private int levels = -1;
//    @Inject(method = "updateState", at = @At("HEAD"))
//    private void injectUpdateState(CallbackInfo ci) {
    @Overwrite
    public void updateState() {
        if (!this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord)) {
            this.isBeaconActive = false;
            this.levels = 0;
        } else {
            this.isBeaconActive = true;
            this.levels = 0;

            for(int var1 = 1; var1 <= 4; this.levels = var1++) {
                int var2 = this.yCoord - var1;
                if (var2 < 0) {
                    break;
                }

                boolean var3 = true;

                for(int var4 = this.xCoord - var1; var4 <= this.xCoord + var1 && var3; ++var4) {
                    for(int var5 = this.zCoord - var1; var5 <= this.zCoord + var1; ++var5) {
                        int var6 = this.worldObj.getBlockId(var4, var2, var5);
                        if (var6 != Block.blockEmerald.blockID && var6 != Block.blockDiamond.blockID && var6 != Block.blockCopper.blockID && var6 != Block.blockSilver.blockID && var6 != Block.blockGold.blockID && var6 != Block.blockIron.blockID && var6 != Block.blockMithril.blockID && var6 != Block.blockAdamantium.blockID && var6 != Block.blockAncientMetal.blockID &&  var6 != Blocks.blockTungsten.blockID) {
                            var3 = false;
                            break;
                        }
                    }
                }

                if (!var3) {
                    break;
                }
            }

            if (this.levels == 0) {
                this.isBeaconActive = false;
            }
        }
    }

//    @Inject(method = "isItemValidForSlot", at = @At("HEAD"), cancellable = true)
//    private void injectiIsItemValidForSlot(int par1, ItemStack par2ItemStack, CallbackInfoReturnable<Boolean> cir) {
//        cir.setReturnValue(par2ItemStack.itemID == Item.emerald.itemID || par2ItemStack.itemID == Item.diamond.itemID || par2ItemStack.itemID == Item.ingotMithril.itemID || par2ItemStack.itemID == Item.ingotAdamantium.itemID || par2ItemStack.itemID == Items.ingotTungsten.itemID);

    @Overwrite
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return par2ItemStack.itemID == Item.emerald.itemID || par2ItemStack.itemID == Item.diamond.itemID || par2ItemStack.itemID == Item.ingotMithril.itemID || par2ItemStack.itemID == Item.ingotAdamantium.itemID || par2ItemStack.itemID == Items.ingotTungsten.itemID;
    }
}

