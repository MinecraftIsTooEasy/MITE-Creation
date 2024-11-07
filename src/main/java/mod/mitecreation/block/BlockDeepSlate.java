package mod.mitecreation.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;

public class BlockDeepSlate extends Block {
    private Icon side_icon;
    private Icon top_icon;
    private Icon bottom_icon;

    public BlockDeepSlate(int par1) {
        super(par1, Material.stone, new BlockConstants());
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, RegistryInit.cobbledDeepStale);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            //top
            case 1 -> this.top_icon;
            //bottom
            case 0 -> this.bottom_icon;
            //Side
            case 2, 3, 5, 4 -> this.side_icon;
            default -> super.getIcon(side, metadata);
        };
    }


    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.side_icon = par1IconRegister.registerIcon("deepslate");
        this.top_icon = par1IconRegister.registerIcon("deepslate_top");
        this.bottom_icon = par1IconRegister.registerIcon("deepslate_bottom");
    }

}
