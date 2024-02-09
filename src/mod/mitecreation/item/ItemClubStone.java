package mod.mitecreation.item;

import net.minecraft.ItemCudgel;
import net.minecraft.Material;

public class ItemClubStone extends ItemCudgel {
    protected ItemClubStone(int par1, Material material) {
        super(par1, material);
        this.setReachBonus(0.5F);
    }
    public String getToolType() {
        return "Stone Club";
    }

    public float getBaseDamageVsEntity() {
        return super.getBaseDamageVsEntity() + 2.0F;
    }

    public boolean canBlock() {
        return true;
    }

    public int getNumComponentsForDurability() {
        return 2;
    }
}
