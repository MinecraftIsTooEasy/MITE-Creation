package mod.mitecreation.block;

import net.minecraft.*;

public class BlockSlabGroupCreation extends BlockSlab {
    private static String[] types = new String[]{"cobbleDeepSlate", "deepSlateBrick"};
    private static Block[] model_blocks;
    private Icon side_icon;

    public BlockSlabGroupCreation(int id, Material material) {
        super(id, material);
    }

    public int getGroup() {
        return 114514;
    }

    public String[] getTypes() {
        return types;
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 16 && this.getBlockSubtypeUnchecked(metadata) != 2;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 2;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("deepslate_slab_top");
        this.side_icon = par1IconRegister.registerIcon("deepslate_slab_side");
    }

    public Block getModelBlock(int metadata) {
        if (model_blocks == null) {
            model_blocks = new Block[]{CreationBlock.cobbleDeepStale, CreationBlock.deepStaleBrick};
        }

        return model_blocks[this.getBlockSubtype(metadata)];
    }

    public Icon getIcon(int side, int metadata) {
        Block model_block = this.getModelBlock(metadata);

        if (model_block != CreationBlock.cobbleDeepStale) {
            if (model_block == CreationBlock.deepStaleBrick) {
                return model_block.getIcon(side, 0);
            } else {
                return side != 0 && side != 1 ? this.side_icon : this.blockIcon;
            }
        }
        return side != 0 && side != 1 ? this.side_icon : this.blockIcon;
    }
}
