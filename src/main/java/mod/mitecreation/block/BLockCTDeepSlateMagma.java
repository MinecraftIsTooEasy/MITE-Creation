package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class BLockCTDeepSlateMagma extends Block {
    public static final String[] STONE_MAGMA_TYPES = new String[]{ "deepslatebrick", "cobbledeepslate"};
    public static final String[] STONE_MAGMA_TEXTURE_TYPES = new String[]{"deepslate_brick", "cobble_deepslate"};
    private Icon[] ICONS;

    public BLockCTDeepSlateMagma(int par1) {
        super(par1, Material.stone, new BlockConstants());
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightValue(0.75F);
        this.setTickRandomly(true);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= STONE_MAGMA_TEXTURE_TYPES.length) {
            par2 = 0;
        }

        return this.ICONS[par2];
    }

    public String getMetadataNotes() {
        return "0=CobbleSlate, 1=DeepSlateBrick";
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 2;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 3;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.ICONS = new Icon[STONE_MAGMA_TEXTURE_TYPES.length];

        for(int i = 0; i < this.ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (STONE_MAGMA_TEXTURE_TYPES[i] != null) {
                textureName = "creation:" + STONE_MAGMA_TEXTURE_TYPES[i] + "_magma";
            }

            this.ICONS[i] = par1IconRegister.registerIcon(textureName);
        }

    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return info.wasExploded() ? this.dropBlockAsEntityItem(info, CTRegistryInit.cobbledDeepStale) : super.dropBlockAsEntityItem(info);
    }

    public boolean updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        int random = par5Random.nextInt(3);
        int i;
        int j;

        for (i = 0; i < random; ++i) {
            par2 += par5Random.nextInt(3) - 1;
            ++par3;
            par4 += par5Random.nextInt(3) - 1;
            j = par1World.getBlockId(par2, par3, par4);

            if (j == 0) {
                if (BlockStationary.isFlammable(par1World, par2 - 1, par3, par4) || BlockStationary.isFlammable(par1World, par2 + 1, par3, par4) || BlockStationary.isFlammable(par1World, par2, par3, par4 - 1) || BlockStationary.isFlammable(par1World, par2, par3, par4 + 1) || BlockStationary.isFlammable(par1World, par2, par3 - 1, par4) || BlockStationary.isFlammable(par1World, par2, par3 + 1, par4)) {
                    par1World.setBlock(par2, par3, par4, fire.blockID);
                    return false;
                }
            } else if (getBlock(j).isSolid(par1World, par2, par3, par4)) {
                return false;
            }
        }

        if (random == 0) {
            i = par2;
            j = par4;

            for (int var9 = 0; var9 < 3; ++var9) {
                par2 = i + par5Random.nextInt(3) - 1;
                par4 = j + par5Random.nextInt(3) - 1;

                if (par1World.isAirBlock(par2, par3 + 1, par4) && BlockStationary.isFlammable(par1World, par2, par3, par4)) {
                    par1World.setBlock(par2, par3 + 1, par4, fire.blockID);
                }
            }
        }

        return false;
    }
}
