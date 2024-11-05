package mod.mitecreation.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.BlockSlab;
import net.minecraft.Icon;
import net.minecraft.Material;

public class BlockDeepSlateBrickSlabGroup extends BlockSlab {
    protected final Block modelBlock = RegistryInit.deepStaleBrick;
    protected final int modelBlockMetadata = 0;
    protected final String name = "deepSlateBrick";

    public BlockDeepSlateBrickSlabGroup(int id, Material material) {
        super(id, material);
    }

    @Override
    public float getBlockHardness(int metadata) {
        return modelBlock.getBlockHardness(metadata) / 2.0F;
    }
    @Override
    public int getGroup() {
        return 112;
    }
    @Override
    public String[] getTypes() {
        return new String[]{name};
    }
    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata == 0 || metadata == 8;
    }
    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return 0;
    }
    @Override
    public Icon getIcon(int par1, int par2) {
        return this.modelBlock.getIcon(par1, this.modelBlockMetadata);
    }
    @Override
    public Block getModelBlock(int metadata) {
        return modelBlock;
    }
}