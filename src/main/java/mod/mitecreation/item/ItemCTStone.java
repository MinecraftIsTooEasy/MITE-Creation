package mod.mitecreation.item;

import net.minecraft.Block;
import net.minecraft.ItemMultiTextureTile;
import net.minecraft.ItemStack;

public class ItemCTStone extends ItemMultiTextureTile {

    public ItemCTStone(Block block, String[] names) {
        super(block, names);
    }

    @Override
    public String getUnlocalizedName(ItemStack item_stack) {
        if (item_stack == null) {
            return super.getUnlocalizedName();
        }
        if(item_stack.getItemSubtype() == 1) {
            return "tile.deepSlate.name";
        } else {
            return "tile.stone.name";
        }
    }
}
