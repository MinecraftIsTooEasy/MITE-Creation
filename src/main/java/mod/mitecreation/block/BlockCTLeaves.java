package mod.mitecreation.block;

import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class BlockCTLeaves extends BlockLeaves {
    public static final String[] LEAF_TYPES = new String[]{"peach", "peach", "peach", "peach"};
    public static final String[][] LEAF_TEXTURE = new String[][]{{"leaves_peach", "leaves_peach", "leaves_peach", "leaves_peach"}, {"leaves_peach_opaque", "leaves_peach_opaque", "leaves_peach_opaque", "leaves_peach_opaque"}};
    private int iconType;
    private Icon[][] iconArray = new Icon[2][];
    int[] adjacentTreeBlocks;

    public BlockCTLeaves(int par1) {
        super(par1);
        this.setCreativeTab(CTRegistryInit.tabCreationBlock);
    }

    @Override
    public int getBlockColor() {
        return 0xFFFFFF;
    }

    @Override
    public int getRenderColor(int par1) {
        return 0xFFFFFF;
    }

    @Override
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return 0xFFFFFF;
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        if (par1World.decorating) {
            return;
        }
        int var7 = 1;
        int var8 = var7 + 1;
        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    for (int var11 = -var7; var11 <= var7; ++var11) {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);
                        if (var12 != CTRegistryInit.peachLeaves.blockID) continue;
                        int var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11);
                        par1World.setBlockMetadataWithNotify(par2 + var9, par3 + var10, par4 + var11, var13 | 8, 4);
                    }
                }
            }
        }
    }

    @Override
    public boolean updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        int subtype;

        if ((var6 & 8) != 0 && (var6 & 4) == 0) {
            byte var24 = 4;
            subtype = var24 + 1;
            byte var9 = 32;
            int var10 = var9 * var9;
            int var11 = var9 / 2;

            if (this.adjacentTreeBlocks == null) {
                this.adjacentTreeBlocks = new int[var9 * var9 * var9];
            }

            int var12;

            if (par1World.checkChunksExist(par2 - subtype, par3 - subtype, par4 - subtype, par2 + subtype, par3 + subtype, par4 + subtype)) {
                int var13;
                int var14;
                int var15;
                int var13_plus_var11;
                int var13_plus_var11_minus_1_times_var10;

                for (var12 = -var24; var12 <= var24; ++var12) {
                    var13_plus_var11 = (var12 + var11) * var10 + var11;

                    for (var13 = -var24; var13 <= var24; ++var13) {
                        var13_plus_var11_minus_1_times_var10 = (var13 + var11) * var9;

                        for (var14 = -var24; var14 <= var24; ++var14) {
                            var15 = par1World.getBlockId(par2 + var12, par3 + var13, par4 + var14);

                            if (var15 == CTRegistryInit.peachWood.blockID) {
                                this.adjacentTreeBlocks[var13_plus_var11 + var13_plus_var11_minus_1_times_var10 + var14] = 0;
                            } else if (var15 == CTRegistryInit.peachLeaves.blockID) {
                                this.adjacentTreeBlocks[var13_plus_var11 + var13_plus_var11_minus_1_times_var10 + var14] = -2;
                            } else {
                                this.adjacentTreeBlocks[var13_plus_var11 + var13_plus_var11_minus_1_times_var10 + var14] = -1;
                            }
                        }
                    }
                }

                for (var12 = 1; var12 <= 4; ++var12) {
                    for (var13 = -var24; var13 <= var24; ++var13) {
                        var13_plus_var11 = var13 + var11;
                        var13_plus_var11_minus_1_times_var10 = (var13_plus_var11 - 1) * var10;
                        int var13_plus_var11_plus_1_times_var10 = (var13_plus_var11 + 1) * var10;
                        int var13_plus_var11_times_var10 = var13_plus_var11 * var10;

                        for (var14 = -var24; var14 <= var24; ++var14) {
                            int var14_plus_var11 = var14 + var11;
                            int var14_plus_var11_times_var9 = var14_plus_var11 * var9;

                            for (var15 = -var24; var15 <= var24; ++var15) {
                                int index1 = var13_plus_var11_times_var10 + var14_plus_var11_times_var9 + var15 + var11;

                                if (this.adjacentTreeBlocks[index1] == var12 - 1) {
                                    int index2 = var13_plus_var11_minus_1_times_var10 + var14_plus_var11_times_var9 + var15 + var11;

                                    if (this.adjacentTreeBlocks[index2] == -2) {
                                        this.adjacentTreeBlocks[index2] = var12;
                                    }

                                    index2 = var13_plus_var11_plus_1_times_var10 + var14_plus_var11_times_var9 + var15 + var11;

                                    if (this.adjacentTreeBlocks[index2] == -2) {
                                        this.adjacentTreeBlocks[index2] = var12;
                                    }

                                    index2 = var13_plus_var11_times_var10 + (var14_plus_var11 - 1) * var9 + var15 + var11;

                                    if (this.adjacentTreeBlocks[index2] == -2) {
                                        this.adjacentTreeBlocks[index2] = var12;
                                    }

                                    index2 = var13_plus_var11_times_var10 + (var14_plus_var11 + 1) * var9 + var15 + var11;

                                    if (this.adjacentTreeBlocks[index2] == -2) {
                                        this.adjacentTreeBlocks[index2] = var12;
                                    }

                                    index2 = var13_plus_var11_times_var10 + var14_plus_var11_times_var9 + (var15 + var11 - 1);

                                    if (this.adjacentTreeBlocks[index2] == -2) {
                                        this.adjacentTreeBlocks[index2] = var12;
                                    }

                                    if (this.adjacentTreeBlocks[index1 + 1] == -2) {
                                        this.adjacentTreeBlocks[index1 + 1] = var12;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

            if (var12 >= 0) {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & -9, 4);
                return true;
            } else {
                this.removeLeaves(par1World, par2, par3, par4);
                return true;
            }
        } else {
            if (RNG.chance_in_100[++RNG.random_number_index + (int) par1World.total_time & 32767] && !wasPlaced(var6) && (!par1World.getAsWorldServer().fast_forwarding || RNG.chance_in_32[++RNG.random_number_index & 32767]) && par5Random.nextInt(500) == 0) {
                if (par1World.getBiomeGenForCoords(par2, par4).isSwampBiome() && par5Random.nextInt(2) == 0) {
                    return false;
                }

                Item item = Item.stick;

                if (par5Random.nextInt(3) > 0) {
                    item = CTRegistryInit.peach;
                }

                this.dropBlockAsEntityItem((new BlockBreakInfo(par1World, par2, par3, par4)).setWindfall(), item);
            }

            return false;
        }
    }

    @Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.isBlockTopFlatAndSolid(par2, par3 - 1, par4) && par5Random.nextInt(15) == 1) {
            double var6 = (float)par2 + par5Random.nextFloat();
            double var8 = (double)par3 - 0.05;
            double var10 = (float)par4 + par5Random.nextFloat();
            par1World.spawnParticle(EnumParticle.dripWater, var6, var8, var10, 0.0, 0.0, 0.0);
        }
    }

    private void removeLeaves(World par1World, int par2, int par3, int par4) {
        this.dropBlockAsEntityItem(new BlockBreakInfo(par1World, par2, par3, par4).setDroppedSelf());
        par1World.setBlockToAir(par2, par3, par4);
        Block block_above = par1World.getBlock(par2, par3 + 1, par4);
        if (block_above instanceof BlockUnderminable) {
            ((BlockUnderminable)block_above).tryToFall(par1World, par2, par3 + 1, par4);
        }
    }

    public static boolean wasPlaced(int metadata) {
        return BitHelper.isBitSet(metadata, 4);
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (BitHelper.isBitSet(info.getMetadata(), 4)) {
            return 0;
        }
        if (info.getBiome().isSwampBiome() && info.world.rand.nextInt(2) == 0) {
            return 0;
        }
        int leaf_kind = this.getBlockSubtype(info.getMetadata());
        int num_drops = this.dropBlockAsEntityItem(info, CTRegistryInit.peachSapling.blockID, leaf_kind, 1, 0.01f);
        if (num_drops > 0) {
            return num_drops;
        }
        num_drops = this.dropBlockAsEntityItem(info, Item.stick.itemID, 0, 1, 0.05f);
        if (num_drops > 0) {
            return num_drops;
        }
        if (leaf_kind == 0) {
            return this.dropBlockAsEntityItem(info, CTRegistryInit.peach.itemID, 0, 1, 0.005f);
        }
        return 0;
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 16;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 3;
    }

    public Icon getIcon(int par1, int par2) {
        return (par2 & 3) == 1 ? this.iconArray[this.iconType][1] : ((par2 & 3) == 3 ? this.iconArray[this.iconType][3] : ((par2 & 3) == 2 ? this.iconArray[this.iconType][2] : this.iconArray[this.iconType][0]));
    }

    public void setGraphicsLevel(boolean par1) {
        this.graphicsLevel = par1;
        this.iconType = par1 ? 0 : 1;
    }

    @Override
    public boolean hidesAdjacentSide(IBlockAccess block_access, int x, int y, int z, Block neighbor, int side) {
        return !this.graphicsLevel;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        for (int var2 = 0; var2 < LEAF_TEXTURE.length; ++var2) {
            this.iconArray[var2] = new Icon[LEAF_TEXTURE[var2].length];
            for (int var3 = 0; var3 < LEAF_TEXTURE[var2].length; ++var3) {
                this.iconArray[var2][var3] = par1IconRegister.registerIcon(CreationModInit.RESOURCEID + LEAF_TEXTURE[var2][var3]);
            }
        }
    }
}
