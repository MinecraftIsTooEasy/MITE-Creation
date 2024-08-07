package mod.mitecreation.block.ore;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;

import java.util.Random;

import static mod.mitecreation.block.CreationBlock.*;

public class BlockRichOre extends BlockOre implements IBlockWithSubtypes {
    public Material vein_material;
    public static final String[] RICH_ORE_TEXTURE_TYPES = new String[]{null, null};
    public static Icon[] RICH_ORE_ICONS;
    public BlockSubtypes subtypes = new BlockSubtypes(new String[] {"rich", "rich"});

    public BlockRichOre(int par1, Material vein_material, int min_harvest_level) {
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
        if (par2 < 0 || par2 >= RICH_ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }

        return this.RICH_ORE_ICONS[par2];
    }

//    @Override
//    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
//        Random random = new Random();
//        boolean suppress_fortune;
//        int id_dropped;
//        int metadata_dropped = 0;
//        int quantity_dropped = 1;
//        if (blockBreakInfo.wasExploded()) {
//            if (this == oreEmeraldRich) {
//                id_dropped = Item.shardEmerald.itemID;
//            } else if (this == oreDiamondRich) {
//                id_dropped = Item.shardDiamond.itemID;
//            } else if (this == oreLapisRich) {
//                id_dropped = Item.dyePowder.itemID;
//                metadata_dropped = 4;
//                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
//            } else {
//                id_dropped = this == oreNetherQuartzRich ? Item.shardNetherQuartz.itemID : (this == oreCoalRich ? -1 : this.blockID);
//            }
//        } else {
//            //if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
//            //    return super.dropBlockAsEntityItem(blockBreakInfo);
//            //}
//            if (!blockBreakInfo.wasHarvestedByPlayer()) {
//                return super.dropBlockAsEntityItem(blockBreakInfo);
//            }
//            if (this == oreCoalRich) {
//                id_dropped = Item.coal.itemID;
//            } else if (this == oreDiamondRich) {
//                id_dropped = Item.diamond.itemID;
//            } else if (this == oreLapisRich) {
//                id_dropped = Item.dyePowder.itemID;
//                metadata_dropped = 4;
//                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
//            } else {
//                id_dropped = this == oreEmeraldRich ? Item.emerald.itemID : (this == oreNetherQuartzRich ? Item.netherQuartz.itemID : this.blockID);
//            }
//            if (this == oreCopperRich) {
//                id_dropped = CreationItem.rawCopperNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == oreIronRich) {
//                id_dropped = CreationItem.rawRustedIronNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == oreSilverRich) {
//                id_dropped = CreationItem.rawSilverNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == oreGold) {
//                id_dropped = CreationItem.rawGoldNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == CreationBlock.oreTungstenRich) {
//                id_dropped = CreationItem.rawTungstenNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == oreMithrilRich) {
//                id_dropped = CreationItem.rawMithrilNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
//            } else if (this == oreAdamantiumRich) {
//                id_dropped = CreationItem.rawAdamantiumNugget.itemID;
//                quantity_dropped = 14 + random.nextInt(5) + random.nextInt(5);;
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
        return super.getBlockHardness(metadata) * 1.4F;
    }

    @Override
    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
        return 1;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.RICH_ORE_ICONS = new Icon[RICH_ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.RICH_ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (RICH_ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + RICH_ORE_TEXTURE_TYPES[i];
            }

            this.RICH_ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
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
