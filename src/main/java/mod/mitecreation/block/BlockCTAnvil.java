package mod.mitecreation.block;

import mod.mitecreation.init.CreationModInit;
import net.minecraft.BlockAnvil;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockCTAnvil extends BlockAnvil {
    public BlockCTAnvil(int par1, Material metal_type) {
        super(par1, metal_type);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(CreationModInit.RESOURCEID + "anvil/" + this.metal_type.name + "/base");
        super.iconArray = new Icon[anvilIconNames.length];

        for(int var2 = 0; var2 < super.iconArray.length; ++var2) {
            super.iconArray[var2] = par1IconRegister.registerIcon(CreationModInit.RESOURCEID + "anvil/" + this.metal_type.name + "/" + anvilIconNames[var2]);
        }

    }
}
