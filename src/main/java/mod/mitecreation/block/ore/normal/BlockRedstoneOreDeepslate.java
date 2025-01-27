package mod.mitecreation.block.ore.normal;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

import static mod.mitecreation.init.CTRegistryInit.oreRedstoneDeepslate;
import static mod.mitecreation.init.CTRegistryInit.oreRedstoneDeepslateGlowing;

public class BlockRedstoneOreDeepslate extends Block {
    public static final String[] ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] ORE_ICONS;
    private boolean glowing;

    public BlockRedstoneOreDeepslate(int par1, boolean par2) {
        super(par1, Material.stone, new BlockConstants());
        if (par2) {
            this.setTickRandomly(true);
        }

        this.glowing = par2;
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }
        return this.ORE_ICONS[par2];
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.ORE_ICONS = new Icon[ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + ORE_TEXTURE_TYPES[i];
            }
            this.ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
        }
    }

    public int tickRate(World par1World) {
        return 30;
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        this.glow(par1World, par2, par3, par4);
        super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
    }

    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        this.glow(par1World, par2, par3, par4);
        super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        if (!this.glowing) {
            if (player.onClient()) {
                this.sparkle(world, x, y, z);
            } else {
                this.glow(world, x, y, z);
            }

            return true;
        } else {
            return false;
        }
    }

    public void onBlockDamageStageChange(int x, int y, int z, Entity entity, int damage_stage) {
        if (entity != null && !entity.onClient()) {
            if (damage_stage > -1 && entity.worldObj.getBlock(x, y, z) == oreRedstoneDeepslate) {
                this.glow(entity.worldObj, x, y, z);
            }

        }
    }

    private void glow(World world, int x, int y, int z) {
        if (!world.isRemote && this == oreRedstoneDeepslate) {
            world.setBlock(x, y, z, oreRedstoneDeepslateGlowing.blockID, world.getBlockMetadata(x, y, z), 3);
        }

    }

    public boolean updateTick(World world, int x, int y, int z, Random random) {
        return this == oreRedstoneDeepslateGlowing ? world.setBlock(x, y, z, oreRedstoneDeepslate.blockID, world.getBlockMetadata(x, y, z), 3) : false;
    }

    public void onBlockAboutToBeBroken(BlockBreakInfo info) {
        if (info.block == oreRedstoneDeepslateGlowing) {
            info.setBlock(oreRedstoneDeepslate, info.getMetadata(), 0);
        }

    }

    public boolean canBeCarried() {
        return !this.glowing;
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, Item.redstone.itemID, 0, 3 + info.world.rand.nextInt(3), 1.0F + (float)info.getHarvesterFortune() * 0.1F);
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (this.glowing) {
            this.sparkle(par1World, par2, par3, par4);
        }

    }

    private void sparkle(World par1World, int par2, int par3, int par4) {
        if (par1World.isRemote) {
            Random var5 = par1World.rand;
            double var6 = 0.0625;

            for(int var8 = 0; var8 < 6; ++var8) {
                double var9 = (double)((float)par2 + var5.nextFloat());
                double var11 = (double)((float)par3 + var5.nextFloat());
                double var13 = (double)((float)par4 + var5.nextFloat());
                if (var8 == 0 && !par1World.isBlockStandardFormOpaqueCube(par2, par3 + 1, par4)) {
                    var11 = (double)(par3 + 1) + var6;
                }

                if (var8 == 1 && !par1World.isBlockStandardFormOpaqueCube(par2, par3 - 1, par4)) {
                    var11 = (double)(par3 + 0) - var6;
                }

                if (var8 == 2 && !par1World.isBlockStandardFormOpaqueCube(par2, par3, par4 + 1)) {
                    var13 = (double)(par4 + 1) + var6;
                }

                if (var8 == 3 && !par1World.isBlockStandardFormOpaqueCube(par2, par3, par4 - 1)) {
                    var13 = (double)(par4 + 0) - var6;
                }

                if (var8 == 4 && !par1World.isBlockStandardFormOpaqueCube(par2 + 1, par3, par4)) {
                    var9 = (double)(par2 + 1) + var6;
                }

                if (var8 == 5 && !par1World.isBlockStandardFormOpaqueCube(par2 - 1, par3, par4)) {
                    var9 = (double)(par2 + 0) - var6;
                }

                if (var9 < (double)par2 || var9 > (double)(par2 + 1) || var11 < 0.0 || var11 > (double)(par3 + 1) || var13 < (double)par4 || var13 > (double)(par4 + 1)) {
                    par1World.spawnParticle(EnumParticle.reddust, var9, var11, var13, 0.0, 0.0, 0.0);
                }
            }

        }
    }

    public ItemStack createStackedBlock(int par1) {
        return new ItemStack(CTRegistryInit.oreRedstoneDeepslate);
    }

    public String getNameDisambiguationForReferenceFile(int metadata) {
        return this.glowing ? "lit" : "unlit";
    }
}
