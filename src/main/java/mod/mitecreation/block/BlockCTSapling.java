package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.world.gen.WorldGenCTPeachTrees;
import net.minecraft.*;

import java.util.Random;

public class BlockCTSapling extends BlockSapling {
    public static final String[] WOOD_TYPES = new String[]{"peach", "blank", "blank", "blank"};
    private Icon[] saplingIcon;

    public BlockCTSapling(int par1) {
        super(par1);
        float var2 = 0.4f;
        this.setBlockBoundsForAllThreads(0.5f - var2, 0.0, 0.5f - var2, 0.5f + var2, var2 * 2.0f, 0.5f + var2);
        this.setMaxStackSize(16);
        this.setCreativeTab(CTRegistryInit.tabCreationBlock);
        this.setCushioning(0.2f);
    }

    @Override
    public boolean updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (super.updateTick(par1World, par2, par3, par4, par5Random)) {
            return true;
        }
        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(28) == 0) {
            return this.markOrGrowMarked(par1World, par2, par3, par4, par5Random);
        }
        return false;
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        return this.saplingIcon[this.getBlockSubtype(par2)];
    }

    public boolean markOrGrowMarked(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!BlockCTSapling.canGrowInBiome(this.getItemSubtype(par1World.getBlockMetadata(par2, par3, par4)), par1World.getBiomeGenForCoords(par2, par4))) {
            return false;
        }
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        if ((var6 & 8) == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8, 4);
            return true;
        }
        this.growTree(par1World, par2, par3, par4, par5Random);
        return par1World.getBlock(par2, par3, par4) != this || par1World.getBlockMetadata(par2, par3, par4) != var6;
    }

    private void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
        int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
        WorldGenerator var7 = null;
        int var8 = 0;
        int var9 = 0;
        var7 = new WorldGenCTPeachTrees(true);
        par1World.setBlock(par2, par3, par4, 0, 0, 4);
        if (!((WorldGenerator) var7).generate(par1World, par5Random, par2 + var8, par3, par4 + var9)) {
            par1World.setBlock(par2, par3, par4, this.blockID, var6, 4);
        }
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.saplingIcon = new Icon[WOOD_TYPES.length];
        for (int var2 = 0; var2 < this.saplingIcon.length; ++var2) {
            this.saplingIcon[var2] = par1IconRegister.registerIcon(this.getTextureName() + "_" + WOOD_TYPES[var2]);
        }
    }

    public static boolean canGrowInBiome(int subtype, BiomeGenBase biome) {
        if (!biome.hasRainfall()) {
            return false;
        }
        if (subtype == 0) {
            return biome.temperature >= 0.4f;
        }
        return true;
    }
}