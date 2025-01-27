package mod.mitecreation.world.structure;

import net.minecraft.*;

import java.util.Random;

public class ComponentCTRuins extends ComponentScatteredFeature {

    public ComponentCTRuins() {
    }

    public ComponentCTRuins(Random par1Random, int par2, int par3) {
        super(par1Random, par2, 64, par3, 5, 2, 5);
    }

    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
        if (!this.func_74935_a(par1World, par3StructureBoundingBox, 0)) {
            return false;
        } else {
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 5, 0, 1, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 1, 0, 5, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 5, 5, 0, 5, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 5, 0, 1, 5, 0, 5, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 0, 2, 4, 0, 2, Block.woodDoubleSlab.blockID, Block.woodDoubleSlab.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 0, 2, 2, 0, 4, Block.woodDoubleSlab.blockID, Block.woodDoubleSlab.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 0, 4, 3, 0, 4, Block.woodDoubleSlab.blockID, Block.woodDoubleSlab.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 3, 0, 3, 4, 0, 3, Block.woodSingleSlab.blockID, Block.woodSingleSlab.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 0, 4, 4, 0, 4, Block.woodSingleSlab.blockID, Block.woodSingleSlab.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 4, 1, 1, 5, 1, 1, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 5, 1, 1, 5, 1, 5, Block.gravel.blockID, Block.gravel.blockID, false);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 5, 5, 1, 5, Block.gravel.blockID, Block.gravel.blockID, false);
            this.placeBlockAtCurrentPosition(par1World, Block.stoneSingleSlab.blockID, 0, 1, 1, 1, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.stoneSingleSlab.blockID, 0, 3, 1, 1, par3StructureBoundingBox);
            this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 3, 1, 1, 4, Block.stoneSingleSlab.blockID, Block.stoneSingleSlab.blockID, false);
            this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 0, 5, 2, 1, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 0, 5, 2, 4, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 0, 2, 2, 5, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.woodSingleSlab.blockID, 0, 4, 2, 5, par3StructureBoundingBox);
            this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 5, 2, 2, 5, 2, 3, Block.stairsWoodOak.blockID, 1, Block.stairsWoodOak.blockID, 2, false);

            if (par2Random.nextInt(2) == 0)
                this.placeBlockRelativeWithAdjustedMetadata(par1World, Block.furnaceHardenedClayIdle, 2, 1, 4, 5, par3StructureBoundingBox);
            if (par2Random.nextInt(3) == 1)
                this.placeBlockRelativeWithAdjustedMetadata(par1World, Block.workbench, 4, 1, 2, 0, par3StructureBoundingBox);

            return true;
        }
    }
}
