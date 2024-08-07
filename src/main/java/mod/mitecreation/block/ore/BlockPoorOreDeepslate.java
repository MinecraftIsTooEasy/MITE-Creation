package mod.mitecreation.block.ore;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;

import java.util.Random;

import static mod.mitecreation.block.CreationBlock.*;

public class BlockPoorOreDeepslate extends BlockOre implements IBlockWithSubtypes {
    public Material vein_material;
    public static final String[] POOR_ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] POOR_ORE_ICONS;
    public BlockSubtypes subtypes = new BlockSubtypes(new String[] {"deepslate_poor", "deepslate_poor"});

    public BlockPoorOreDeepslate(int par1, Material vein_material, int min_harvest_level) {
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
        if (par2 < 0 || par2 >= POOR_ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }

        return this.POOR_ORE_ICONS[par2];
    }

//    @Override
//    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
//        Random random = new Random();
//        boolean suppress_fortune;
//        int id_dropped;
//        int metadata_dropped = 0;
//        int quantity_dropped = 1;
//        if (blockBreakInfo.wasExploded()) {
//            if (this == oreEmeraldPoor) {
//                id_dropped = Item.shardEmerald.itemID;
//            } else if (this == oreDiamondPoor) {
//                id_dropped = Item.shardDiamond.itemID;
//            } else if (this == oreLapisPoor) {
//                id_dropped = Item.dyePowder.itemID;
//                metadata_dropped = 4;
//                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
//            } else {
//                id_dropped = this == oreNetherQuartzPoor ? Item.shardNetherQuartz.itemID : (this == oreCoalPoor ? -1 : this.blockID);
//            }
//        } else {
//            //if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
//            //    return super.dropBlockAsEntityItem(blockBreakInfo);
//            //}
//            if (!blockBreakInfo.wasHarvestedByPlayer()) {
//                return super.dropBlockAsEntityItem(blockBreakInfo);
//            }
//            if (this == oreCoalPoor) {
//                id_dropped = Item.coal.itemID;
//            } else if (this == oreDiamondPoor) {
//                id_dropped = Item.diamond.itemID;
//            } else if (this == oreLapisPoor) {
//                id_dropped = Item.dyePowder.itemID;
//                metadata_dropped = 4;
//                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
//            } else {
//                id_dropped = this == oreEmeraldPoor ? Item.emerald.itemID : (this == oreNetherQuartzPoor ? Item.netherQuartz.itemID : this.blockID);
//            }
//            if (this == oreCopperPoor) {
//                id_dropped = CreationItem.rawCopperNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == oreIronPoor) {
//                id_dropped = CreationItem.rawRustedIronNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == oreSilverPoor) {
//                id_dropped = CreationItem.rawSilverNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == oreGold) {
//                id_dropped = CreationItem.rawGoldNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == CreationBlock.oreTungstenPoor) {
//                id_dropped = CreationItem.rawTungstenNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == oreMithrilPoor) {
//                id_dropped = CreationItem.rawMithrilNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            } else if (this == oreAdamantiumPoor) {
//                id_dropped = CreationItem.rawAdamantiumNugget.itemID;
//                quantity_dropped = 3 + random.nextInt(2) + random.nextInt(2);
//            }
//        }
//        //if (metadata_dropped == -1) {
//        //    metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
//        //}
//        //boolean bl2 = suppress_fortune = id_dropped == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
//        //if (id_dropped != -1 && blockBreakInfo.getMetadata() == 0) {
//        //    DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(id_dropped));
//        //}
//        return super.dropBlockAsEntityItem(blockBreakInfo, id_dropped, metadata_dropped, quantity_dropped, 1);
//    }

    @Override
    public void addItemBlockMaterials(ItemBlock item_block) {
        item_block.addMaterial(this.blockMaterial, this.vein_material);
    }

    @Override
    public float getBlockHardness(int metadata) {
        return super.getBlockHardness(metadata) * 0.7F * 1.25F;
    }

    @Override
    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return 1;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.POOR_ORE_ICONS = new Icon[POOR_ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.POOR_ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (POOR_ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + POOR_ORE_TEXTURE_TYPES[i];
            }

            this.POOR_ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
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