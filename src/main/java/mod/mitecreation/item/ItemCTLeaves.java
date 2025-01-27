package mod.mitecreation.item;

import mod.mitecreation.block.BlockCTLeaves;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

public class ItemCTLeaves extends ItemBlock {
    public ItemCTLeaves(Block block) {
        super(block);
    }

    public int getMetadata(int par1) {
        return 0;
    }

    public Icon getIconFromSubtype(int par1) {
        return CTRegistryInit.peachLeaves.getIcon(0, par1);
    }

    public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
        int var3 = par1ItemStack.getItemSubtype();
        return (var3 & 1) == 1 ? ColorizerFoliage.getFoliageColorPine() : ((var3 & 2) == 2 ? ColorizerFoliage.getFoliageColorBirch() : ColorizerFoliage.getFoliageColorBasic());
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        if (par1ItemStack == null) {
            return super.getUnlocalizedName();
        } else {
            int var2 = par1ItemStack.getItemSubtype();

            if (var2 < 0 || var2 >= BlockCTLeaves.LEAF_TYPES.length) {
                var2 = 0;
            }

            return super.getUnlocalizedName() + "." + BlockCTLeaves.LEAF_TYPES[var2];
        }
    }

    public float getCompostingValue() {
        return 1.0F;
    }
}

