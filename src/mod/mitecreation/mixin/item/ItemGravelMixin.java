package mod.mitecreation.mixin.item;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemGravel.class)
public class ItemGravelMixin extends ItemMultiTexture{

    public ItemGravelMixin(Block block, String[] names) {
        super(block, new String[]{"gravel",""});
    }

    @Override
    public String getUnlocalizedName(ItemStack item_stack) {
        if (item_stack == null) {
            return super.getUnlocalizedName();
        }
        int metadata = item_stack.getItemSubtype();
        switch (metadata){
            case 1:
                return "tile.gravelNether";
            case 2:
                return "tile.gravelDeepslate";
            case 3:
                return "tile.gravelSand";
            default:
                return "tile.gravel";
        }
    }
}
