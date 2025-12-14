package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.List;

import static mod.mitecreation.init.CTRegistryInit.getBlockID;

public class BlockCTDeepSlateDoubleSlab extends BlockDoubleSlab {

    private BlockSlab single_slab;

    public BlockCTDeepSlateDoubleSlab(int id, BlockSlab single_slab) {
        super(id, single_slab);
        if (single_slab != this.getSingleSlab()) {
            Minecraft.setErrorMessage("BlockDeepSlateDoubleSlab: single slab mismatch");
        }
        this.single_slab = single_slab;
        this.setUnlocalizedName("slab.group" + single_slab.getGroup());
    }

    private BlockSlab getSingleSlab() {
        if (this.single_slab == null) {
            this.single_slab = CTRegistryInit.cobbledDeepStaleSingleSlab;
        }
        return this.single_slab;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.single_slab.getIcon(side, metadata);
    }

    @Override
    public String getMetadataNotes() {
        return "Bits 1, 2 for subtype";
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata < 4 && this.getSingleSlab().isValidMetadata(metadata);
    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        return this.getSingleSlab().getBlockSubtypeUnchecked(metadata);
    }

    public String getFullSlabName(int metadata) {
        return this.single_slab.getFullSlabName(metadata);
    }

    @Override
    public int idPicked(World world, int x, int y, int z) {
        return this.single_slab.blockID;
    }

    @Override
    public boolean canBeCarried() {
        return false;
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.wasExploded()) {
            Object model_block;
            if (this.blockMaterial == Material.wood) {
                model_block = wood;
            } else if (this.blockMaterial == Material.stone) {
                if (this.blockID == CTRegistryInit.cobbledDeepStaleSingleSlab.blockID || this.blockID == CTRegistryInit.cobbledDeepStaleDoubleSlab.blockID) {
                    model_block = CTRegistryInit.deepStaleBrick;
                } else if (this.blockID == CTRegistryInit.deepStaleBrickSingleSlab.blockID || this.blockID == CTRegistryInit.deepStaleBrickDoubleSlab.blockID) {
                    model_block = CTRegistryInit.cobbledDeepStale;
                } else {
                    model_block = null;
                }
                info.setMetadata(0);
            } else {
                Minecraft.setErrorMessage("dropBlockAsEntityItem: blockMaterial " + this.blockMaterial + " not handled");
                model_block = null;
            }

            return model_block == null ? 0 : ((Block) model_block).dropBlockAsEntityItem(info);
        } else {
            return this.dropBlockAsEntityItem(info, this.createStackedBlock(info.getMetadata()));
        }
    }

    @Override
    public String getNameDisambiguationForReferenceFile(int metadata) {
        return "double";
    }

    @Override
    public float getBlockHardness(int metadata) {
        return this.single_slab.getBlockHardness(metadata) * 2.0F;
    }

    @Override
    public int getMinHarvestLevel(int metadata) {
        return this.single_slab.getMinHarvestLevel(metadata);
    }

    @Override
    public ItemStack createStackedBlock(int metadata) {
        ItemStack item_stack = this.single_slab.createStackedBlock(metadata);
        item_stack.stackSize *= 2;
        return item_stack;
    }

    @Override
    public void getItemStacks(int id, CreativeTabs creative_tabs, List list) {
        if (creative_tabs == null) {
            super.getItemStacks(id, creative_tabs, list);
        }
    }
}