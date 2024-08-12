package mod.mitecreation.block;

import net.minecraft.Block;
import net.minecraft.BlockSlab;
import net.minecraft.Icon;
import net.minecraft.Material;

public class BlockDeepSlateBrickSlabGroup  extends BlockSlab {

    private static String[] types = new String[]{"deepSlateBrick"};
    private static Block[] model_blocks;

    public BlockDeepSlateBrickSlabGroup(int id, Material material) {
        super(id, material);
    }

    @Override
    public int getGroup() {
        return 112;
    }

    @Override
    public String[] getTypes() {
        return types;
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata == 0;
    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 1;
    }

    @Override
    public float getBlockHardness(int metadata) {
        return this.getModelBlock(metadata).getBlockHardness(metadata);
    }

    @Override
    public Block getModelBlock(int metadata) {
        if (model_blocks == null) {
            model_blocks = new Block[] {CreationBlock.deepStaleBrick};
        }
        return CreationBlock.deepStaleBrick;
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        Block model_block = this.getModelBlock(metadata & 1);
        return model_block.getIcon(side, model_block.getBlockSubtypeUnchecked(metadata & 1));
    }
}