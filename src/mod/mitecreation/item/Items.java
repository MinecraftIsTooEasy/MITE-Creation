package mod.mitecreation.item;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.materil.Materials;
import mod.mitecreation.util.Util;
import net.minecraft.*;

import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class Items {
    public static final ItemCoin coinIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Util.getNextItemID(), Material.iron);
    public static final ItemCoin coinRustedIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Util.getNextItemID(), Material.rusted_iron);

    public static final ItemNuggets rustedIronNugget = new ItemNuggets(Util.getNextItemID(),Material.rusted_iron);
    public static final ItemIngots ingotRustedIron = new ItemIngots(Util.getNextItemID(),Material.rusted_iron);

    public static ItemFishingRod fishingRodRustedIron = (ItemFishingRod)(new ItemFishingRod(Util.getNextItemID(), Materials.rusted_iron)).setUnlocalizedName("fishingRod");

    public static final ItemRawNugget rawRustedIronNugget = new ItemRawNugget(Util.getNextItemID(),Material.rusted_iron);
    public static final ItemRawNugget rawCopperNugget = new ItemRawNugget(Util.getNextItemID(),Material.copper);
    public static final ItemRawNugget rawSilverNugget = new ItemRawNugget(Util.getNextItemID(),Material.silver);
    public static final ItemRawNugget rawGoldNugget = new ItemRawNugget(Util.getNextItemID(),Material.gold);
    public static final ItemRawNugget rawAncientMetalNugget = new ItemRawNugget(Util.getNextItemID(),Material.ancient_metal);
    public static final ItemRawNugget rawTungstenNugget = new ItemRawNugget(Util.getNextItemID(), Materials.tungsten);
    public static final ItemRawNugget rawMithrilNugget = new ItemRawNugget(Util.getNextItemID(),Material.mithril);
    public static final ItemRawNugget rawAdamantiumNugget = new ItemRawNugget(Util.getNextItemID(),Material.adamantium);

    public static final ItemNugget tungstenNugget = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final Item ingotTungsten = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten).setXPReward(75);

    public static final ItemWarHammer warHammerTungsten = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemBattleAxe battleAxeTungsten = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemSword swordTungsten = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Materials.tungsten);
    public static final ItemDagger daggerTungsten = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemPickaxe pickaxeTungsten = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemShovel shovelTungsten = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemAxe axeTungsten = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemHoe hoeTungsten = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemKnife knifeTungsten = createInstance(ItemKnife.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemMattock mattockTungsten = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemScythe scytheTungsten = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemShears shearsTungsten = createInstance(ItemShears.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemHatchet hatchetTungsten = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static ItemFishingRod fishingRodTungsten = (ItemFishingRod)(new ItemFishingRod(Util.getNextItemID(), Materials.tungsten)).setUnlocalizedName("fishingRod");

    public static final ItemArmor helmetTungsten = new ItemHelmet(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor helmetChainTungsten = new ItemHelmet(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor plateTungsten = new ItemCuirass(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor plateChainTungsten = new ItemCuirass(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor legsTungsten = new ItemLeggings(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor legsChainTungsten = new ItemLeggings(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor bootsTungsten = new ItemBoots(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor bootsChainTungsten = new ItemBoots(Util.getNextItemID(),Materials.tungsten,true);

    public static final Item doorTungsten= new ItemDoor(Util.getNextItemID(), Materials.tungsten);
    public static final ItemChain chainTungsten = createInstance(ItemChain.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemCoin coinTungsten = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Util.getNextItemID(), Materials.tungsten);
    public static final ItemArrow arrowTungsten = new ItemArrow(Util.getNextItemID(), Materials.tungsten);

    public static final ItemBucket tungstenBucket = new ItemBucket(Util.getNextItemID(), Materials.tungsten, null);
    public static final ItemBucket tungstenBucketWater = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.water).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketLava = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.lava).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketStone = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.stone).setContainerItem(tungstenBucket);
    public static final ItemBucketMilk tungstenBucketMilk = (ItemBucketMilk) (new ItemBucketMilk(Util.getNextItemID(), Materials.tungsten)).setContainerItem(tungstenBucket);

    public static final Item rustedIronBlock = new ItemBlock(Blocks.rustedIronBlock);

    public static final ItemClub clubStone = createInstance(ItemClub.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.stone);
    public static final ItemDagger daggerStone = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.stone);

    public static final ItemBucket woodBucketEmpty = (ItemBucket) new ItemBucket(Util.getNextItemID(), Materials.wood,null);
    public static final ItemBucket woodBucketWater = (ItemBucket) new ItemBucket(Util.getNextItemID(), Materials.wood,Materials.water).setContainerItem(woodBucketEmpty);
    public static final ItemBucketMilk woodBucketMilk = (ItemBucketMilk) new ItemBucketMilk(Util.getNextItemID(), Materials.wood).setContainerItem(woodBucketEmpty);

    public static final ItemBucket rustedIronBucketEmpty = new ItemBucket(Util.getNextItemID(), Material.rusted_iron, null);
    public static final ItemBucket rustedIronBucketWater = (ItemBucket) new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.water).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketLava = (ItemBucket)new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.lava).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketStone = (ItemBucket) new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.stone).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucketMilk rustedIronBucketMilk = (ItemBucketMilk)(new ItemBucketMilk(Util.getNextItemID(), Material.rusted_iron)).setContainerItem(rustedIronBucketEmpty);

    public static final ItemSword swordEmerald = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Material.emerald);
    public static final ItemSword swordDiamond = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Material.diamond);

//    public static final ItemHoe hoeFlint = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.flint);

    public static final ItemStone itemStone = null;

    public static void itemRegister() {
//        if(true) {
//            return;
//        }
//        if(false) {
//            Item[] items = Item.itemsList;
//            items[0] = null;
//            try {
//                Item.itemsList[0] = null;
//                Accessor.modifyStatic(Items.class.getField("itemStone"), new ItemStone(Block.stone, new String[]{"tile.stone", "tile.deepslate"}));
//                itemStone.setMaxStackSize(4);
//                Block.blocksList[4] = null;
//                Accessor.modifyStatic(Block.class.getField("cobblestone"), new BlockCobblestone());
//            } catch (NoSuchFieldException e) {
//                throw new RuntimeException(e);
//            }
//        }
        register("coins/iron", coinIron, CreativeTabs.tabMisc);
        register("coins/rusted_iron", coinRustedIron, CreativeTabs.tabMisc);

        register("nuggets/rusted_iron", rustedIronNugget, CreativeTabs.tabMaterials);
        register("ingots/rusted_iron", ingotRustedIron, CreativeTabs.tabMaterials);
        ingotRustedIron.setMaxStackSize(8);

        register("fishing_rods/rusted_iron_uncast", fishingRodRustedIron, CreativeTabs.tabTools);
        fishingRodRustedIron.setLowestCraftingDifficultyToProduce(Item.flint.getLowestCraftingDifficultyToProduce());

        register("rusted_iron_block", rustedIronBlock, CreativeTabs.tabBlock);
        rustedIronBlock.setMaxStackSize(4);

        register("ingots/tungsten", ingotTungsten, CreativeTabs.tabMaterials);
        ingotTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("nuggets/tungsten", tungstenNugget, CreativeTabs.tabMaterials);
        tungstenNugget.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("armor/tungsten_helmet", helmetTungsten, CreativeTabs.tabCombat);
        helmetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chestplate", plateTungsten, CreativeTabs.tabCombat);
        plateTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_leggings", legsTungsten, CreativeTabs.tabCombat);
        legsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_boots", bootsTungsten, CreativeTabs.tabCombat);
        bootsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_helmet", helmetChainTungsten, CreativeTabs.tabCombat);
        helmetChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_chestplate", plateChainTungsten, CreativeTabs.tabCombat);
        plateChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_leggings", legsChainTungsten, CreativeTabs.tabCombat);
        legsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_boots", bootsChainTungsten, CreativeTabs.tabCombat);
        bootsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("tools/tungsten/tungsten_battle_axe", battleAxeTungsten, CreativeTabs.tabCombat);
        battleAxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_dagger", daggerTungsten, CreativeTabs.tabCombat);
        daggerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_sword", swordTungsten, CreativeTabs.tabCombat);
        swordTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_war_hammer", warHammerTungsten, CreativeTabs.tabCombat);
        warHammerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("tools/tungsten/tungsten_axe", axeTungsten, CreativeTabs.tabTools);
        axeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_hatchet", hatchetTungsten, CreativeTabs.tabTools);
        hatchetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_hoe", hoeTungsten, CreativeTabs.tabTools);
        hoeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_knife", knifeTungsten, CreativeTabs.tabTools);
        knifeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_pickaxe", pickaxeTungsten, CreativeTabs.tabTools);
        pickaxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_mattock", mattockTungsten, CreativeTabs.tabTools);
        mattockTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_scythe", scytheTungsten, CreativeTabs.tabTools);
        scytheTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_shears", shearsTungsten, CreativeTabs.tabTools);
        shearsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_shovel", shovelTungsten, CreativeTabs.tabTools);
        shovelTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("fishing_rods/tungsten_uncast", fishingRodTungsten, CreativeTabs.tabTools);
        fishingRodTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("doors/tungsten", doorTungsten, CreativeTabs.tabRedstone);
        doorTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("chains/tungsten", chainTungsten, CreativeTabs.tabMaterials);
        chainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("coins/tungsten", coinTungsten, CreativeTabs.tabMisc);
        coinTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("arrows/tungsten", arrowTungsten, CreativeTabs.tabCombat);
        arrowTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("buckets/tungsten/empty", tungstenBucket, CreativeTabs.tabMisc);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("buckets/tungsten/lava", tungstenBucketLava, CreativeTabs.tabMisc);
        register("buckets/tungsten/milk", tungstenBucketMilk, CreativeTabs.tabFood);
        register("buckets/tungsten/stone", tungstenBucketStone, CreativeTabs.tabMisc);
        register("buckets/tungsten/water", tungstenBucketWater, CreativeTabs.tabMisc);

        register("raw_nuggets/rusted_iron", rawRustedIronNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/copper", rawCopperNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/silver", rawSilverNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/gold", rawGoldNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/ancient_metal", rawAncientMetalNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/tungsten", rawTungstenNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/mithril", rawMithrilNugget, CreativeTabs.tabMaterials);
        register("raw_nuggets/adamantium", rawAdamantiumNugget, CreativeTabs.tabMaterials);

        register("tools/stone/stone_club", clubStone, CreativeTabs.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());
        register("tools/stone/stone_dagger", daggerStone, CreativeTabs.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());

        register("buckets/wood/empty", woodBucketEmpty, CreativeTabs.tabMisc);
        register("buckets/wood/water", woodBucketWater, CreativeTabs.tabMisc);
        register("buckets/wood/milk", woodBucketMilk, CreativeTabs.tabFood);

        register("buckets/rusted_iron/empty", rustedIronBucketEmpty, CreativeTabs.tabMisc);
        register("buckets/rusted_iron/lava", rustedIronBucketLava, CreativeTabs.tabMisc);
        register("buckets/rusted_iron/milk", rustedIronBucketMilk, CreativeTabs.tabFood);
        register("buckets/rusted_iron/stone", rustedIronBucketStone, CreativeTabs.tabMisc);
        register("buckets/rusted_iron/water", rustedIronBucketWater, CreativeTabs.tabMisc);

        register("tools/emerald/emerald_sword", swordEmerald, CreativeTabs.tabCombat);
        register("tools/diamond/diamond_sword", swordDiamond, CreativeTabs.tabCombat);

//        register("tool/flint/flint_hoe", hoeFlint, CreativeTabs.tabTools);
    }
    private static Item register(String string, Item item, CreativeTabs creativeModeTab) {
        item.useVanillaTexture(string);
        item.setUnlocalizedName(string);
        item.setCreativeTab(creativeModeTab);
        return item;
    }
}
