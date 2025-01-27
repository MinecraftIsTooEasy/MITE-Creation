package mod.mitecreation.block;

import net.minecraft.Block;
import net.minecraft.BlockConstants;
import net.minecraft.Material;

public class BlockCTCobbledDeepSlate extends Block {
    public BlockCTCobbledDeepSlate(int par1) {
        super(par1, Material.stone, new BlockConstants());
        this.setHardness(2.5F);
    }
}
