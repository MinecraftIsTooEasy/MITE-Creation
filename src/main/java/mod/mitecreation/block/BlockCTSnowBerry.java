package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;

public class BlockCTSnowBerry extends BlockBush {
    public static final int BLUEBERRY = 0;
    public static final String[] types = new String[]{"snow_berry"};
    private Icon[] icons;

    public BlockCTSnowBerry(int id) {
        super(id);
        float width = 0.4f;
        float height = 0.7f;
        this.setBlockBoundsForAllThreads(0.5f - width, 0.0, 0.5f - width, 0.5f + width, height, 0.5f + width);
    }

    @Override
    public void registerIcons(IconRegister icon_register) {
        this.icons = new Icon[types.length * 2];
        for (int i = 0; i < types.length; ++i) {
            if (types[i] == null) continue;
            this.icons[i * 2] = icon_register.registerIcon(this.getTextureName() + "/" + types[i]);
            this.icons[i * 2 + 1] = icon_register.registerIcon(this.getTextureName() + "/" + types[i] + "_picked");
        }
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.icons[this.getBlockSubtype(metadata) * 2 + (hasBerries(metadata) ? 0 : 1)];
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return (metadata & 3) < types.length;
    }

    @Override
    public int getItemSubtype(int metadata) {
        return setBerryGrowth(this.getBlockSubtype(metadata), getMaxBerryGrowth());
    }

    public static int getMaxBerryGrowth() {
        return 3;
    }

    public static boolean hasBerries(int metadata) {
        return getBerryGrowth(metadata) == getMaxBerryGrowth();
    }

    public static int setBerryGrowth(int metadata, int growth) {
        return metadata & 3 | MathHelper.clamp_int(growth, 0, getMaxBerryGrowth()) << 2;
    }

    public static int getBerryGrowth(int metadata) {
        return metadata >> 2;
    }

    public static int incrementBerryGrowth(int metadata) {
        return setBerryGrowth(metadata, getBerryGrowth(metadata) + 1);
    }

    public static int setToMaximumBerryGrowth(int metadata) {
        return setBerryGrowth(metadata, getMaxBerryGrowth());
    }

    public static int getMetadataForBushWithBerries(int subtype) {
        return setToMaximumBerryGrowth(subtype);
    }

    public boolean isBiomeSuitable(BiomeGenBase biome, int metadata) {
        return biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills || biome == BiomeGenBase.iceMountains || biome == BiomeGenBase.icePlains;
    }

    @Override
    public boolean canBePlacedAt(World world, int x, int y, int z, int metadata) {
        return this.isBiomeSuitable(world.getBiomeGenForCoords(x, z), metadata) && world.canBlockSeeTheSky(x, y, z) && super.canBePlacedAt(world, x, y, z, metadata);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        int metadata = world.getBlockMetadata(x, y, z);
        if (!hasBerries(metadata)) {
            return false;
        }
        if (player.onServer()) {
            this.dropBlockAsEntityItem(new BlockBreakInfo(world, x, y, z).setPickedBy(player), CTRegistryInit.snowBerries);
            world.setBlock(x, y, z, this.blockID, setBerryGrowth(metadata, 0), 2);
        }
        return true;
    }

    public boolean fertilize(World world, int x, int y, int z, ItemStack item_stack) {
        Item item = item_stack.getItem();
        if (item == Item.dyePowder) {
            int metadata = world.getBlockMetadata(x, y, z);
            if (hasBerries(metadata)) {
                return false;
            }
            if (!world.isRemote) {
                int growth_added = MathHelper.getRandomIntegerInRange(world.rand, 1, 2);
                while (growth_added-- > 0) {
                    metadata = incrementBerryGrowth(metadata);
                }
                world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
            }
            return true;
        }
        return false;
    }

    @Override
    public int dropBlockAsItself(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info) + super.dropBlockAsItself(info);
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (hasBerries(info.getMetadata()) && (info.wasHarvestedByPlayer() || info.wasSelfDropped() || info.wasNotLegal())) {
            return this.dropBlockAsEntityItem(info, CTRegistryInit.snowBerries);
        }
        return 0;
    }

    @Override
    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return entity instanceof EntityPlayer && entity.getAsPlayer().inCreativeMode() ? item_stack.getItemSubtype() : setBerryGrowth(item_stack.getItemSubtype(), 0);
    }

    @Override
    public float getGrowthRate(World world, int x, int y, int z) {
        float growth_rate = 0.1f;
        BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
        growth_rate *= this.getTemperatureGrowthRateModifier(biome.temperature);
        growth_rate *= this.getHumidityGrowthRateModifier(biome.isHighHumidity());
        return growth_rate *= this.getGlobalGrowthRateModifierFromMITE();
    }

    @Override
    public boolean updateTick(World world, int x, int y, int z, Random rand) {
        if (super.updateTick(world, x, y, z, rand)) {
            return true;
        }
        int metadata = world.getBlockMetadata(x, y, z);
        if (this.hasBerries(metadata)) {
            return false;
        }
        int berry_growth = getBerryGrowth(metadata);
        float growth_rate = this.getGrowthRate(world, x, y, z);
        if (growth_rate == 0.0f) {
            return false;
        }
        int blv = world.getBlockLightValue(x, y + 1, z);
        if (this.isLightLevelSuitableForGrowth(blv) && rand.nextFloat() < growth_rate) {
            world.setBlockMetadataWithNotify(x, y, z, incrementBerryGrowth(metadata), 2);
            return true;
        }
        return false;
    }

    @Override
    public float getLowestOptimalTemperature() {
        return BiomeGenBase.taigaHills.temperature;
    }

    @Override
    public float getHighestOptimalTemperature() {
        return BiomeGenBase.taiga.temperature;
    }
}
