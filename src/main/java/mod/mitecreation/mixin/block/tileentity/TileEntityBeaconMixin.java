package mod.mitecreation.mixin.block.tileentity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.*;
import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityBeacon.class)
public abstract class TileEntityBeaconMixin extends TileEntity {

    @Inject(method = "isItemValidForSlot", at = @At("HEAD"), cancellable = true)
    private void isItemValidForSlotCreation(int par1, ItemStack par2ItemStack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(par2ItemStack.itemID == Items.ingotTungsten.itemID);
    }
//    @Overwrite
//    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
//        return par2ItemStack.itemID == Item.emerald.itemID || par2ItemStack.itemID == Item.diamond.itemID || par2ItemStack.itemID == Item.ingotMithril.itemID || par2ItemStack.itemID == Item.ingotAdamantium.itemID || par2ItemStack.itemID == Items.ingotTungsten.itemID;
//    }

    @ModifyExpressionValue(method = "updateState", at = @At(value = "INVOKE", target = "Lnet/minecraft/World; getBlockId(III)I"))
    private int updateStateCreation(int original) {
        if (original == Block.blockAncientMetal.blockID || original == Blocks.blockTungsten.blockID)
            return Block.blockEmerald.blockID;
        return original;
    }
}

