package mod.mitecreation.mixin.item;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ItemStack.class)
public class ItemStackMixin {
    @Shadow
    EnumQuality quality;
    @Shadow
    int itemID;
    
    @Overwrite
    public ItemStack setQuality(EnumQuality enumQuality) {
        Item item = this.getItem();
        if (item == null) {
            Minecraft.setErrorMessage("setQuality: item_stack.getItem()==null");
            return new ItemStack(item,1);
        }
        if (item.hasQuality()) {
            if (enumQuality == null) {
                enumQuality = EnumQuality.average;
            }
            this.quality = enumQuality;
        } else if (enumQuality != null) {
            Minecraft.setErrorMessage("setQuality: item \"" + this.getItem().getItemDisplayName(new ItemStack(item,1)) + "\" does not have quality");
            return new ItemStack(item,1);
        }
        return new ItemStack(item,1);
    }
    @Shadow
    private String getDisplayName() {
        return null;
    }
    @Shadow
    public Item getItem() {
        return null;
    }

//    @Overwrite
//    public boolean isBlock() {
//        try {
//            FishModLoader.LOGGER.info(this.itemID);
//            FishModLoader.LOGGER.info(this.getItem());
//
//            return this.getItem() instanceof ItemBlock;
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
}