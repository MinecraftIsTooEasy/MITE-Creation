package mod.mitecreation.block;

import net.minecraft.*;

public class BlockDeepSlate extends Block {

    public BlockDeepSlate(int par1) {
        super(par1, Material.stone, new BlockConstants());
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, CreationBlock.cobbleDeepStale);
    }
}
