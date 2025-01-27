package mod.mitecreation.block.ore;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

import java.util.Random;


public class BlockOreDeepslate extends BlockOre implements IBlockWithSubtypes {
    public Material vein_material;
    public static final String[] ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] ORE_ICONS;
    public BlockSubtypes subtypes = new BlockSubtypes(new String[]{"deepslate", "deepslate"});

    public BlockOreDeepslate(int par1, Material vein_material, int min_harvest_level) {
        super(par1, vein_material, min_harvest_level);
        this.vein_material = vein_material;
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setMinHarvestLevel(min_harvest_level);
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 2;
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }

        return this.ORE_ICONS[par2];
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        Random random = new Random();
        boolean suppress_fortune;
        int id_dropped;
        int metadata_dropped = 0;
        int quantity_dropped = 1;
        if (blockBreakInfo.wasExploded()) {
            if (this == CTRegistryInit.oreEmeraldDeepslate) {
                id_dropped = Item.shardEmerald.itemID;
            } else if (this == CTRegistryInit.oreDiamondDeepslate) {
                id_dropped = Item.shardDiamond.itemID;
            } else if (this == CTRegistryInit.oreLapisDeepslate) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                id_dropped = this == oreNetherQuartz ? Item.shardNetherQuartz.itemID : (this == CTRegistryInit.oreCoalDeepslate ? -1 : this.blockID);
            }
        } else {
            //if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
            //    return super.dropBlockAsEntityItem(blockBreakInfo);
            //}
            if (!blockBreakInfo.wasHarvestedByPlayer()) {
                return super.dropBlockAsEntityItem(blockBreakInfo);
            }
            if (this == CTRegistryInit.oreCoalDeepslate) {
                id_dropped = Item.coal.itemID;
            } else if (this == CTRegistryInit.oreDiamondDeepslate) {
                id_dropped = Item.shardDiamond.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreLapisDeepslate) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else if (this == CTRegistryInit.oreEmeraldDeepslate) {
                id_dropped = Item.shardEmerald.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else {
                id_dropped = this == CTRegistryInit.oreEmeraldDeepslate ? Item.emerald.itemID : (this == oreNetherQuartz ? Item.netherQuartz.itemID : this.blockID);
            }
            if (this == CTRegistryInit.oreCopperDeepslate) {
                id_dropped = CTRegistryInit.rawCopperNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreIronDeepslate) {
                id_dropped = CTRegistryInit.rawRustedIronNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreSilverDeepslate) {
                id_dropped = CTRegistryInit.rawSilverNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreGoldDeepslate) {
                id_dropped = CTRegistryInit.rawGoldNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreTungstenDeepslate) {
                id_dropped = CTRegistryInit.rawTungstenNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreMithrilDeepslate) {
                id_dropped = CTRegistryInit.rawMithrilNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            } else if (this == CTRegistryInit.oreAdamantiumDeepslate) {
                id_dropped = CTRegistryInit.rawAdamantiumNugget.itemID;
                quantity_dropped =7 + random.nextInt(4);
            }
        }
        if (metadata_dropped == -1) {
            metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
        }
        boolean bl2 = suppress_fortune = id_dropped == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
        if (id_dropped != -1 && blockBreakInfo.getMetadata() == 0) {
            DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(id_dropped));
        }
        float chance = suppress_fortune ? 1.0F : 1.0F + (float)blockBreakInfo.getHarvesterFortune() * 0.1F * 3.0F;

        return super.dropBlockAsEntityItem(blockBreakInfo, id_dropped, metadata_dropped, quantity_dropped, chance);
    }

    @Override
    public void addItemBlockMaterials(ItemBlock item_block) {
        item_block.addMaterial(this.blockMaterial, this.vein_material);
    }

    @Override
    public float getBlockHardness(int metadata) {
        return super.getBlockHardness(metadata) * 1.25F;
    }

//    @Override
//    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
//        if (this.isDeepslate(world.getBlockMetadata(x, y, z)))
//            return 3;
//        else
//            return 1;
//    }

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

    @Override
    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    @Override
    public String[] getNames() {
        return this.subtypes.getNames();
    }
}