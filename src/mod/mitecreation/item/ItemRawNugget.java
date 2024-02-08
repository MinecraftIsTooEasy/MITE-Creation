package mod.mitecreation.item;

import net.minecraft.ItemNugget;
import net.minecraft.Material;

public class ItemRawNugget extends ItemNugget {
    protected ItemRawNugget(int id, Material material) {
        super(id, material);
        this.setMaxStackSize(32);
    }
}
