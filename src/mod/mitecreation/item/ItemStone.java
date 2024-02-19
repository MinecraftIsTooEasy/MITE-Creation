package mod.mitecreation.item;

import net.minecraft.Block;
import net.minecraft.ItemMultiTexture;
import net.minecraft.ItemStack;

public class ItemStone extends ItemMultiTexture {

    public ItemStone(Block block, String[] names) {
        super(block, names);
    }

    @Override
    public String getUnlocalizedName(ItemStack item_stack) {
        if (item_stack == null) {
            return super.getUnlocalizedName();
        }
        if(item_stack.getItemSubtype() == 1) {
            return "tile.deepslate.name";
        } else {
            return "tile.stone.name";
        }
    }
}
