package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class BlockCTDeepslateSilverFish extends BlockSilverfish {
    public static final String[] silverfishStoneTypes = new String[]{"deepslate", "cobbledDeepslate", "deepslateBrick"};

    public BlockCTDeepslateSilverFish(int par1) {
        super(par1);
        this.setHardness(1.0F);
        this.setTickRandomly(true);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 == 1) {
            return CTRegistryInit.cobbledDeepStale.getBlockTextureFromSide(par1);
        } else if (par2 == 2) {
            return CTRegistryInit.deepStaleBrick.getBlockTextureFromSide(par1);
        }
        return CTRegistryInit.deepSlate.getBlockTextureFromSide(par1);
    }

    public void registerIcons(IconRegister par1IconRegister) {
    }

    public static boolean getPosingIdByMetadata(int par0) {
        return par0 == CTRegistryInit.deepSlate.blockID || par0 == CTRegistryInit.cobbledDeepStale.blockID || par0 == CTRegistryInit.deepStaleBrick.blockID;
    }

    public static int getMetadataForBlockType(int par0) {
        return par0 == CTRegistryInit.cobbledDeepStale.blockID ? 1 : (par0 == CTRegistryInit.deepStaleBrick.blockID ? 2 : 0);
    }

    public ItemStack createStackedBlock(int par1) {
        Block var2 = CTRegistryInit.deepSlate;
        if (par1 == 1) {
            var2 = CTRegistryInit.cobbledDeepStale;
        }

        if (par1 == 2) {
            var2 = CTRegistryInit.deepStaleBrick;
        }

        return new ItemStack(var2);
    }

    public String getMetadataNotes() {
        return "0=Deepslate, 1=Cobbled Deepslate, 2=Deepslate Brick";
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 3;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata;
    }

    public static EntitySilverfish getSilverfishTypeForMetadata(World world, int metadata) {
        if (metadata == 3) {
            return new EntityNetherspawn(world);
        } else {
            return (EntitySilverfish)(world.isUnderworld() ? new EntityHoarySilverfish(world) : new EntitySilverfish(world));
        }
    }

    public static void spawnSilverfishEntity(World world, int x, int y, int z, int metadata, EntityLivingBase target) {
        int updated_metadata = getUpdatedSilverfishBlockMetadata(world, x, y, z, metadata);
        if (updated_metadata != metadata) {
            convertNeighborMetadata(world, x, y, z, metadata, updated_metadata);
            metadata = updated_metadata;
        }

        EntitySilverfish entity_silverfish = getSilverfishTypeForMetadata(world, metadata);
        entity_silverfish.setLocationAndAngles((double)x + 0.5, (double)y, (double)z + 0.5, 0.0F, 0.0F);
        world.spawnEntityInWorld(entity_silverfish);
        entity_silverfish.spawnExplosionParticle();
        entity_silverfish.setTarget(target);
        entity_silverfish.makeLivingSound();
        entity_silverfish.refreshDespawnCounter(-9600);
    }

    public static int getUpdatedSilverfishBlockMetadata(World world, int x, int y, int z, int metadata) {
        return metadata == 0 && world.blockTypeIsNearTo(Block.oreCopper.blockID, x, y, z, 3, 3) ? 4 : metadata;
    }

    public static boolean updateSilverfishType(World world, int x, int y, int z, int metadata) {
        int updated_metadata = getUpdatedSilverfishBlockMetadata(world, x, y, z, metadata);
        if (updated_metadata != metadata) {
            convertVeinMetadata(world, x, y, z, metadata, updated_metadata, false);
            return true;
        } else {
            return false;
        }
    }

    public static boolean updateSilverfishType(World world, int x, int y, int z) {
        return updateSilverfishType(world, x, y, z, world.getBlockMetadata(x, y, z));
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.wasSilverfish() || info.getResponsiblePlayer() != null) {
            spawnSilverfishEntity(info.world, info.x, info.y, info.z, info.getMetadata(), info.getResponsiblePlayer());
        }

        return 0;
    }

    public static void convertNeighborMetadata(World world, int x, int y, int z, int old_metadata, int new_metadata) {
        if (world.blockExists(x - 1, y, z)) {
            convertVeinMetadata(world, x - 1, y, z, old_metadata, new_metadata, true);
        }

        if (world.blockExists(x + 1, y, z)) {
            convertVeinMetadata(world, x + 1, y, z, old_metadata, new_metadata, true);
        }

        if (world.blockExists(x, y - 1, z)) {
            convertVeinMetadata(world, x, y - 1, z, old_metadata, new_metadata, true);
        }

        if (world.blockExists(x, y + 1, z)) {
            convertVeinMetadata(world, x, y + 1, z, old_metadata, new_metadata, true);
        }

        if (world.blockExists(x, y, z - 1)) {
            convertVeinMetadata(world, x, y, z - 1, old_metadata, new_metadata, true);
        }

        if (world.blockExists(x, y, z + 1)) {
            convertVeinMetadata(world, x, y, z + 1, old_metadata, new_metadata, true);
        }

    }

    public static void convertVeinMetadata(World world, int x, int y, int z, int old_metadata, int new_metadata, boolean perform_check) {
        if (!perform_check || world.getBlock(x, y, z) == silverfish && world.getBlockMetadata(x, y, z) == old_metadata) {
            world.setBlockMetadataWithNotify(x, y, z, new_metadata, 2);
            convertNeighborMetadata(world, x, y, z, old_metadata, new_metadata);
        }

    }

    public boolean updateTick(World world, int x, int y, int z, Random random) {
        if (super.updateTick(world, x, y, z, random)) {
            return true;
        } else if (!world.isPlayerNearby((double)x, (double)y, (double)z, 16.0)) {
            return false;
        } else {
            int metadata = world.getBlockMetadata(x, y, z);
            if (metadata == 0) {
                Chunk chunk = world.getChunkFromBlockCoords(x, z);
                if (chunk.doAllNeighborsExist(1, false, false)) {
                    return updateSilverfishType(world, x, y, z, metadata);
                }
            }

            return false;
        }
    }
}