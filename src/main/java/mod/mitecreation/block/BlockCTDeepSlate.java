package mod.mitecreation.block;

import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

public class BlockCTDeepSlate extends Block {
    private Icon side_icon;
    private Icon top_icon;
    private Icon bottom_icon;

    public BlockCTDeepSlate(int par1) {
        super(par1, Material.stone, new BlockConstants());
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, CTRegistryInit.cobbledDeepStale);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return switch (side) {
            case 1 -> this.top_icon;
            case 0 -> this.bottom_icon;
            case 2, 3, 5, 4 -> this.side_icon;
            default -> super.getIcon(side, metadata);
        };
    }


    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.side_icon = par1IconRegister.registerIcon(CreationModInit.COLON_ID + "deepslate");
        this.top_icon = par1IconRegister.registerIcon(CreationModInit.COLON_ID + "deepslate_top");
        this.bottom_icon = par1IconRegister.registerIcon(CreationModInit.COLON_ID + "deepslate_bottom");
    }

}
