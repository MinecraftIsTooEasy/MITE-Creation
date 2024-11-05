package mod.mitecreation.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockDeepSlate extends Block {
    public BlockDeepSlate(int par1) {
        super(par1, Material.stone, new BlockConstants());
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, RegistryInit.cobbleDeepStale);
    }
}
