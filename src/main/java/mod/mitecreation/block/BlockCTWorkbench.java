package mod.mitecreation.block;

import mod.mitecreation.init.CreationModInit;
import moddedmite.rustedironcore.api.block.WorkbenchBlock;
import net.minecraft.Block;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockCTWorkbench extends WorkbenchBlock {
    private Icon workbench_icon_top;

    public BlockCTWorkbench(int id, Material material, float speedModifier, Material checkAgainst) {
        super(id, material, speedModifier, checkAgainst);
    }


    public Icon getIcon(int side, int metadata) {
        if (side == 0) {
            return Block.planks.getBlockTextureFromSide(side);
        } else if (side == 1) {
            return this.workbench_icon_top;
        } else {
            return side != 2 && side != 3 ? this.my_side_icon : this.my_front_icon;
        }
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.workbench_icon_top = par1IconRegister.registerIcon("crafting_table_top");
        this.my_front_icon = par1IconRegister.registerIcon(CreationModInit.COLON_ID + "crafting_table/" + this.getMaterial().name + "/front");
        this.my_side_icon = par1IconRegister.registerIcon(CreationModInit.COLON_ID + "crafting_table/" + this.getMaterial().name + "/side");
    }
}
