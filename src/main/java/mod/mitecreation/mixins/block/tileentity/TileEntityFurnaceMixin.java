package mod.mitecreation.mixins.block.tileentity;

import mod.mitecreation.api.IItem;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TileEntityFurnace.class)
public class TileEntityFurnaceMixin extends TileEntityMixin {

    @Shadow
    private ItemStack[] furnaceItemStacks;
    @Shadow
    public int furnaceCookTime;
    @Shadow
    public int heat_level;

    @Shadow
    public ItemStack getInputItemStack() {
        return null;
    }

    @Inject(method = "getHeatLevelRequired", at = @At("HEAD"), cancellable = true)
    private static void creationInjectGetHeatLevelRequired(int item_id, CallbackInfoReturnable<Integer> cir) {
        if (item_id == CreationItem.rawAdamantiumNugget.itemID)
            cir.setReturnValue(4);
        if (item_id == CreationItem.rawMithrilNugget.itemID || item_id == CreationItem.rawTungstenNugget.itemID)
            cir.setReturnValue(3);
        if (item_id == CreationItem.rawRustedIronNugget.itemID || item_id == CreationItem.rustedIronNugget.itemID || item_id == CreationItem.rawAncientMetalNugget.itemID)
            cir.setReturnValue(2);
        if (item_id == CreationItem.rawCopperNugget.itemID || item_id == CreationItem.rawSilverNugget.itemID || item_id == CreationItem.rawGoldNugget.itemID)
            cir.setReturnValue(1);
    }

    @Redirect(method = "smeltItem", at = @At(value = "FIELD", opcode = Opcodes.PUTFIELD, target = "Lnet/minecraft/ItemStack;stackSize:I", ordinal = 1))
    private void injectSmeltRecipe(ItemStack itemStack, int value) {
        int n2 = 0;
        if (this.getInputItemStack() != null) {
            n2 = this.getInputItemStack().itemID == Block.sand.blockID && itemStack.itemID == Block.sandStone.blockID ? 4 : (this.getInputItemStack().itemID == Block.sand.blockID && itemStack.itemID == Block.glass.blockID ? 4 : (this.getInputItemStack().itemID == Block.blockIron.blockID && itemStack.itemID == Item.ingotMithril.itemID ? 4 : (this.getInputItemStack().itemID == Block.blockMithril.blockID && itemStack.itemID == Item.ingotAdamantium.itemID ? 1 : 1)));
        }
        itemStack.stackSize -= n2;
    }

    @ModifyConstant(method = "updateEntity", constant = @Constant(intValue = 200))
    private int modifyCookTimeCreation(int constant){
        if (this.heat_level != 0){
            return ((IItem) this.furnaceItemStacks[0].getItem()).getCookTime(this.heat_level) / this.heat_level;
        }
        return constant;
    }

    @Overwrite
    public int getCookProgressScaled(int n) {
        return this.furnaceItemStacks[0] == null ? this.furnaceCookTime * n / 200 : this.furnaceCookTime * n / (((IItem) this.furnaceItemStacks[0].getItem()).getCookTime(this.heat_level) / Math.max(this.heat_level, 1));
    }
}

