package mod.mitecreation.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;

public class BlockCobbleDeepSlateSlabGroup extends BlockSlab {

    private static String[] types = new String[]{"cobbledDeepSlate"};
    private static Block[] model_blocks;

    public BlockCobbleDeepSlateSlabGroup(int id, Material material) {
        super(id, material);
    }

    @Override
    public int getGroup() {
        return 111;
    }

    @Override
    public String[] getTypes() {
        return types;
    }

//    @Override
//    public boolean isValidMetadata(int metadata) {
//        return metadata == 0;
//    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 4;
    }

    @Override
    public float getBlockHardness(int metadata) {
        return this.getModelBlock(metadata).getBlockHardness(metadata);
    }

    @Override
    public Block getModelBlock(int metadata) {
        if (model_blocks == null) {
            model_blocks = new Block[]{RegistryInit.cobbleDeepStale};
        }
        return model_blocks[0];
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        Block model_block = this.getModelBlock(metadata & 1);
        return model_block.getIcon(side, model_block.getBlockSubtypeUnchecked(metadata & 1));
    }
}
