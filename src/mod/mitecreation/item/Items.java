package mod.mitecreation.item;

//import mod.mitecreation.block.BlockCobblestone;
import mod.mitecreation.block.BlockCobblestone;
import mod.mitecreation.block.Blocks;
import mod.mitecreation.materil.Materials;
import mod.mitecreation.util.*;
import net.minecraft.*;

import static mod.mitecreation.block.Blocks.*;
import static net.minecraft.Item.getMatchingItem;
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
    public static final yi tungstenBucketMilk = (yi)(new yi(Util.getNextItemID(), Materials.tungsten)).setContainerItem(tungstenBucket);

    public static final Item rustedIronBlock = new ItemBlock(Blocks.rustedIronBlock);

    public static final ItemClub clubStone = createInstance(ItemClub.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.stone);
    public static final ItemDagger daggerStone = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.stone);

    public static final ItemBucket woodBucketEmpty = (ItemBucket) new ItemBucket(Util.getNextItemID(), Materials.wood,null);
    public static final ItemBucket woodBucketWater = (ItemBucket) new ItemBucket(Util.getNextItemID(), Materials.wood,Materials.water).setContainerItem(woodBucketEmpty);
    public static final yi woodBucketMilk = (yi) new yi(Util.getNextItemID(), Materials.wood).setContainerItem(woodBucketEmpty);

    public static final ItemBucket rustedIronBucketEmpty = new ItemBucket(Util.getNextItemID(), Material.rusted_iron, null);
    public static final ItemBucket rustedIronBucketWater = (ItemBucket) new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.water).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketLava = (ItemBucket)new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.lava).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketStone = (ItemBucket) new ItemBucket(Util.getNextItemID(), Material.rusted_iron, Material.stone).setContainerItem(rustedIronBucketEmpty);
    public static final yi rustedIronBucketMilk = (yi)(new yi(Util.getNextItemID(), Material.rusted_iron)).setContainerItem(rustedIronBucketEmpty);

    public static final ItemSword swordEmerald = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Material.emerald);
    public static final ItemSword swordDiamond = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Material.diamond);

//    public static final ItemHoe hoeFlint = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.flint);

    public static final ItemStone itemStone = null;

    public static void itemRegister() {
        if(true) {
            return;
        }
        if(false) {
            Item[] items = Item.itemsList;
            items[0] = null;
            try {
                Item.itemsList[0] = null;
                Accessor.modifyStatic(Items.class.getField("itemStone"), new ItemStone(Block.stone, new String[]{"tile.stone", "tile.deepslate"}));
                itemStone.setMaxStackSize(4);
                Block.blocksList[4] = null;
                Accessor.modifyStatic(Block.class.getField("cobblestone"), new BlockCobblestone());
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        register("coins/iron", coinIron, CreativeModeTab.tabMisc);
        register("coins/rusted_iron", coinRustedIron, CreativeModeTab.tabMisc);

        register("nuggets/rusted_iron", rustedIronNugget, CreativeModeTab.tabMaterials);
        register("ingots/rusted_iron", ingotRustedIron, CreativeModeTab.tabMaterials);
        ingotRustedIron.setMaxStackSize(8);

        register("fishing_rods/rusted_iron_uncast", fishingRodRustedIron, CreativeModeTab.tabTools);
        fishingRodRustedIron.setLowestCraftingDifficultyToProduce(Item.flint.getLowestCraftingDifficultyToProduce());

        register("rusted_iron_block", rustedIronBlock, CreativeModeTab.tabBlock);
        rustedIronBlock.setMaxStackSize(4);

        register("ingots/tungsten", ingotTungsten, CreativeModeTab.tabMaterials);
        ingotTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("nuggets/tungsten", tungstenNugget, CreativeModeTab.tabMaterials);
        tungstenNugget.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("armor/tungsten_helmet", helmetTungsten, CreativeModeTab.tabCombat);
        helmetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chestplate", plateTungsten, CreativeModeTab.tabCombat);
        plateTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_leggings", legsTungsten, CreativeModeTab.tabCombat);
        legsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_boots", bootsTungsten, CreativeModeTab.tabCombat);
        bootsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_helmet", helmetChainTungsten, CreativeModeTab.tabCombat);
        helmetChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_chestplate", plateChainTungsten, CreativeModeTab.tabCombat);
        plateChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_leggings", legsChainTungsten, CreativeModeTab.tabCombat);
        legsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("armor/tungsten_chainmail_boots", bootsChainTungsten, CreativeModeTab.tabCombat);
        bootsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("tools/tungsten/tungsten_battle_axe", battleAxeTungsten, CreativeModeTab.tabCombat);
        battleAxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_dagger", daggerTungsten, CreativeModeTab.tabCombat);
        daggerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_sword", swordTungsten, CreativeModeTab.tabCombat);
        swordTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_war_hammer", warHammerTungsten, CreativeModeTab.tabCombat);
        warHammerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("tools/tungsten/tungsten_axe", axeTungsten, CreativeModeTab.tabTools);
        axeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_hatchet", hatchetTungsten, CreativeModeTab.tabTools);
        hatchetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_hoe", hoeTungsten, CreativeModeTab.tabTools);
        hoeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_knife", knifeTungsten, CreativeModeTab.tabTools);
        knifeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_pickaxe", pickaxeTungsten, CreativeModeTab.tabTools);
        pickaxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_mattock", mattockTungsten, CreativeModeTab.tabTools);
        mattockTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_scythe", scytheTungsten, CreativeModeTab.tabTools);
        scytheTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_shears", shearsTungsten, CreativeModeTab.tabTools);
        shearsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("tools/tungsten/tungsten_shovel", shovelTungsten, CreativeModeTab.tabTools);
        shovelTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("fishing_rods/tungsten_uncast", fishingRodTungsten, CreativeModeTab.tabTools);
        fishingRodTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("doors/tungsten", doorTungsten, CreativeModeTab.tabRedstone);
        doorTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("chains/tungsten", chainTungsten, CreativeModeTab.tabMaterials);
        chainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("coins/tungsten", coinTungsten, CreativeModeTab.tabMisc);
        coinTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("arrows/tungsten", arrowTungsten, CreativeModeTab.tabCombat);
        arrowTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        register("buckets/tungsten/empty", tungstenBucket, CreativeModeTab.tabMisc);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        register("buckets/tungsten/lava", tungstenBucketLava, CreativeModeTab.tabMisc);
        register("buckets/tungsten/milk", tungstenBucketMilk, CreativeModeTab.tabFood);
        register("buckets/tungsten/stone", tungstenBucketStone, CreativeModeTab.tabMisc);
        register("buckets/tungsten/water", tungstenBucketWater, CreativeModeTab.tabMisc);

        register("raw_nuggets/rusted_iron", rawRustedIronNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/copper", rawCopperNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/silver", rawSilverNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/gold", rawGoldNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/ancient_metal", rawAncientMetalNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/tungsten", rawTungstenNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/mithril", rawMithrilNugget, CreativeModeTab.tabMaterials);
        register("raw_nuggets/adamantium", rawAdamantiumNugget, CreativeModeTab.tabMaterials);

        register("tools/stone/stone_club", clubStone, CreativeModeTab.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());
        register("tools/stone/stone_dagger", daggerStone, CreativeModeTab.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());

        register("buckets/wood/empty", woodBucketEmpty, CreativeModeTab.tabMisc);
        register("buckets/wood/water", woodBucketWater, CreativeModeTab.tabMisc);
        register("buckets/wood/milk", woodBucketMilk, CreativeModeTab.tabFood);

        register("buckets/rusted_iron/empty", rustedIronBucketEmpty, CreativeModeTab.tabMisc);
        register("buckets/rusted_iron/lava", rustedIronBucketLava, CreativeModeTab.tabMisc);
        register("buckets/rusted_iron/milk", rustedIronBucketMilk, CreativeModeTab.tabFood);
        register("buckets/rusted_iron/stone", rustedIronBucketStone, CreativeModeTab.tabMisc);
        register("buckets/rusted_iron/water", rustedIronBucketWater, CreativeModeTab.tabMisc);

        register("tools/emerald/emerald_sword", swordEmerald, CreativeModeTab.tabCombat);
        register("tools/diamond/diamond_sword", swordDiamond, CreativeModeTab.tabCombat);

//        register("tool/flint/flint_hoe", hoeFlint, CreativeModeTab.tabTools);
    }

    public static void recipeRegister(CraftingManager c) {
        c.addShapelessRecipeP(new ItemStack(rustedIronNugget,1),true,Item.arrowRustedIron);
        c.addShapelessRecipeP(new ItemStack(ingotRustedIron, 1), true, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget);
        c.addShapelessRecipeP(new ItemStack(rustedIronNugget, 9), true, ingotRustedIron);
        c.addRecipeP(new ItemStack(anvilRustedIron, 1), true, "###", "@$@", "$$$", Character.valueOf('#'), rustedIronBlock, Character.valueOf('$'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.axeRustedIron, 1), true, "QQ@", "QS@", "@S@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('S'), Item.stick);
        c.addRecipeP(new ItemStack(Item.axeRustedIron, 1), true, "@QQ", "@SQ", "@S@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('S'), Item.stick);
        c.addRecipeP(new ItemStack(Item.arrowRustedIron, 1), true, "@Q@", "@W@", "@E@", Character.valueOf('Q'), rustedIronNugget, Character.valueOf('W'), Item.stick, Character.valueOf('E'), Item.feather);
        c.addRecipeP(new ItemStack(Item.bootsRustedIron, 1), true, "@@@", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.bootsRustedIron, 1), true, "Q@Q", "Q@Q", "@@@", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.chainRustedIron, 1), true, "@Q@", "Q@Q", "@Q@", Character.valueOf('Q'), rustedIronNugget);
        c.addRecipeP(new ItemStack(Item.daggerRustedIron, 1), true, "@Q", "@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.daggerRustedIron, 1), true, "Q@", "W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.battleAxeRustedIron, 1), true, "Q@Q", "QWQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hatchetRustedIron, 1), true, "QW", "@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hatchetRustedIron, 1), true, "WQ", "W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron, 1), true, "QQ@", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron, 1), true, "@QQ", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron, 1), true, "@QQ", "@@W", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron, 1), true, "QQ@", "W@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.mattockRustedIron, 1), true, "QQQ", "@WQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.pickaxeRustedIron, 1), true, "QQQ", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.scytheRustedIron, 1), true, "WQ@", "W@Q", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(anvilRustedIron, 1), true, "QQQ", "@W@", "WWW", Character.valueOf('Q'), rustedIronBlock, Character.valueOf('W'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.shearsRustedIron, 1), true, "Q@", "@Q", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.shearsRustedIron, 1), true, "@Q", "Q@", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron, 1), true, "@Q@", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron, 1), true, "Q@@", "W@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron, 1), true, "@@Q", "@@W", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron, 1), true, "Q@@", "Q@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron, 1), true, "@Q@", "@Q@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron, 1), true, "@@Q", "@@Q", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(Item.warHammerRustedIron, 1), true, "QQQ", "QWQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        c.addRecipeP(new ItemStack(rustedIronBlock, 1), true, "QQQ", "QQQ", "QQQ", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.helmetRustedIron, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.legsRustedIron, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.plateRustedIron, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), ingotRustedIron);
        c.addRecipeP(new ItemStack(Item.helmetChainRustedIron, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.bootsChainRustedIron, 1), true, "Q@Q", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.legsChainRustedIron, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.plateChainRustedIron, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Items.fishingRodRustedIron, 1), true, "  Q", " Q@", "QW@", Character.valueOf('Q'), Item.stick, Character.valueOf('@'), Item.silk, Character.valueOf('W'), Items.rustedIronNugget);

//        c.addShapelessRecipeP(new ItemStack(tungstenNugget, 1), true, Items.arrowTungsten);
//        c.addShapelessRecipeP(new ItemStack(ingotTungsten, 1), true, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget, tungstenNugget);
//        c.addShapelessRecipeP(new ItemStack(tungstenNugget, 9), true, ingotTungsten);
//        c.addRecipeP(new ItemStack(anvilTungsten, 1), true, "###", "@$@", "$$$", Character.valueOf('#'), tungstenBlock, Character.valueOf('$'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.axeTungsten, 1), true, "QQ@", "QS@", "@S@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('S'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.axeTungsten, 1), true, "@QQ", "@SQ", "@S@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('S'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.arrowTungsten, 1), true, "@Q@", "@W@", "@E@", Character.valueOf('Q'), tungstenNugget, Character.valueOf('W'), Item.stick, Character.valueOf('E'), Item.feather);
//        c.addRecipeP(new ItemStack(Items.bootsTungsten, 1), true, "@@@", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.bootsTungsten, 1), true, "Q@Q", "Q@Q", "@@@", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.chainTungsten, 1), true, "@Q@", "Q@Q", "@Q@", Character.valueOf('Q'), tungstenNugget);
//        c.addRecipeP(new ItemStack(Items.daggerTungsten, 1), true, "@Q", "@W", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.daggerTungsten, 1), true, "Q@", "W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.battleAxeTungsten, 1), true, "Q@Q", "QWQ", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hatchetTungsten, 1), true, "QW", "@W", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hatchetTungsten, 1), true, "WQ", "W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hoeTungsten, 1), true, "QQ@", "@W@", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hoeTungsten, 1), true, "@QQ", "@W@", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hoeTungsten, 1), true, "@QQ", "@@W", "@@W", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.hoeTungsten, 1), true, "QQ@", "W@@", "W@@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.mattockTungsten, 1), true, "QQQ", "@WQ", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.pickaxeTungsten, 1), true, "QQQ", "@W@", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.scytheTungsten, 1), true, "WQ@", "W@Q", "W@@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(anvilTungsten, 1), true, "QQQ", "@W@", "WWW", Character.valueOf('Q'), tungstenBlock, Character.valueOf('W'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.shearsTungsten, 1), true, "Q@", "@Q", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.shearsTungsten, 1), true, "@Q", "Q@", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.shovelTungsten, 1), true, "@Q@", "@W@", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.shovelTungsten, 1), true, "Q@@", "W@@", "W@@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.shovelTungsten, 1), true, "@@Q", "@@W", "@@W", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.swordTungsten, 1), true, "Q@@", "Q@@", "W@@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.swordTungsten, 1), true, "@Q@", "@Q@", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.swordTungsten, 1), true, "@@Q", "@@Q", "@@W", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(Items.warHammerTungsten, 1), true, "QQQ", "QWQ", "@W@", Character.valueOf('Q'), ingotTungsten, Character.valueOf('W'), Item.stick);
//        c.addRecipeP(new ItemStack(tungstenBlock, 1), true, "QQQ", "QQQ", "QQQ", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.helmetTungsten, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.legsTungsten, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.plateTungsten, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), ingotTungsten);
//        c.addRecipeP(new ItemStack(Items.helmetChainTungsten, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), Items.chainTungsten);
//        c.addRecipeP(new ItemStack(Items.bootsChainTungsten, 1), true, "Q@Q", "Q@Q", Character.valueOf('Q'), Items.chainTungsten);
//        c.addRecipeP(new ItemStack(Items.legsChainTungsten, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), Items.chainTungsten);
//        c.addRecipeP(new ItemStack(Items.plateChainTungsten, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), Items.chainTungsten);
//        c.addRecipeP(new ItemStack(Items.fishingRodTungsten, 1), true, "  Q", " Q@", "QW@", Character.valueOf('Q'), Item.stick, Character.valueOf('@'), Item.silk, Character.valueOf('W'), Items.tungstenNugget);
    }
    public static void registerBasicToolRecipes(RecipeRegister register, Material material) {
        Item item = getMatchingItem(ItemIngot.class, material);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemSword.class, material)), true,
                "A",
                "A",
                "S",
                'A', item,
                'S', Item.stick);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemHoe.class, material)),true,
                "AA",
                "S ",
                "S ",
                'A',item,
                'S',Item.stick);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemAxe.class, material)),true,
                "AA",
                "SA",
                "S ",
                'A',item,
                'S',Item.stick);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemShovel.class, material)),true,
                "A",
                "S",
                "S",
                'A',item,
                'S',Item.stick);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemPickaxe.class, material)),true,
                "AAA",
                " S ",
                " S ",
                'A',item,
                'S',Item.stick);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemFishingRod.class, material)),true,
                "  S",
                " SG",
                "SAG",
                'A',getMatchingItem(ItemNugget.class,item.getExclusiveMaterial()),
                'S',Item.stick,
                'G',Item.silk);
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemShears.class, material)),true,
                "A ",
                " A",
                'A',item);
        registerArmorRecipe(register,item,material);
    }
    public static void registerMITEToolRecipe(RecipeRegister register, Material material){
        Item item = Item.getMatchingItem(ItemIngot.class,material);
        Item item_nugget = getMatchingItem(ItemNugget.class,item.getExclusiveMaterial());
        Item item_chain = Item.getMatchingItem(ItemChain.class,material);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemArrow.class,material)), true,
                "C",
                "B",
                "A",
                'A', Item.feather,
                'B', Item.stick,
                'C', item_nugget);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemChain.class,material)), true,
                " A ",
                "A A",
                " A ",
                'A', item_nugget);
        registerArmorRecipe(register,item_chain,material);
        register.registerShapedRecipe(new ItemStack(ItemBucket.getPeer(material,null)), true,
                "A A",
                " A ",
                'A', item);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemScythe.class,material)), true,
                "SA ",
                "S A",
                "S  ",
                'A', item,
                'S', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemMattock.class,material)), true,
                "AAA",
                " SA",
                " S ",
                'A', item,
                'S', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemHatchet.class,material)), true,
                " BA",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemWarHammer.class,material)), true,
                "AAA",
                "ABA",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemDagger.class,material)), true,
                " A ",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemBattleAxe.class,material)), true,
                "A A",
                "ABA",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemDoor.class,material)), true,
                "AA",
                "AA",
                "AA",
                'A', item);
    }
    public static void registerArmorRecipe(RecipeRegister register,Item item, Material material){
        if(item instanceof ItemChain) {
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemHelmet.class,material,true)),true,
                    "AAA",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemCuirass.class,material,true)),true,
                    "A A",
                    "AAA",
                    "AAA",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemLeggings.class,material,true)),true,
                    "AAA",
                    "A A",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemBoots.class,material,true)),true,
                    "A A",
                    "A A",
                    'A',item);
        } else {
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemHelmet.class,material,false)),true,
                    "AAA",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemCuirass.class,material,false)),true,
                    "A A",
                    "AAA",
                    "AAA",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemLeggings.class,material,false)),true,
                    "AAA",
                    "A A",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemBoots.class,material,false)),true,
                    "A A",
                    "A A",
                    'A',item);
        }
    }
    public static void registerFullMetalToolRecipe(RecipeRegister register, Material material){
        registerBasicToolRecipes(register,material);
        registerMITEToolRecipe(register,material);
    }
    public static void registerRecipes(RecipeRegister register) {
        register.registerShapelessRecipe(new ItemStack(ingotTungsten, 9), true,
                blockTungsten);
        register.registerShapelessRecipe(new ItemStack(tungstenNugget, 9), true,
                ingotTungsten);
        register.registerShapelessRecipe(new ItemStack(ingotRustedIron, 9), true,
                rustedIronBlock);
        register.registerShapelessRecipe(new ItemStack(rustedIronNugget, 9), true,
                ingotRustedIron);
        registerArmorRecipe(register, ingotTungsten, Materials.tungsten);
//        registerArmorRecipe(register, ingotRustedIron, Materials.rusted_iron);
        registerFullMetalToolRecipe(register,Materials.tungsten);
//        registerFullMetalToolRecipe(register,Material.rusted_iron);

        ItemCoin[] coins = new ItemCoin[]{
                 coinIron, coinTungsten};
        for (ItemCoin coin : coins) {
            for (int plank_subtype = 1; plank_subtype <= 9; ++plank_subtype) {
                register.registerShapelessRecipe(new ItemStack(coin.getNuggetPeer(), plank_subtype), true, new ItemStack(coin, plank_subtype)).resetDifficulty(25);
            }
            register.registerShapelessRecipe(new ItemStack(coin), true, new ItemStack(coin.getNuggetPeer()));
        }
        register.registerShapelessRecipe(new ItemStack(Items.tungstenBucket, 1), false,
                Items.tungstenBucketStone).resetDifficulty(100);
        register.registerShapelessRecipe(new ItemStack(Items.rustedIronBucketEmpty, 1), false,
                Items.rustedIronBucketStone).resetDifficulty(100);
        register.registerShapelessRecipe(new ItemStack(rustedIronNugget,1),true,Item.arrowRustedIron);
        register.registerShapelessRecipe(new ItemStack(ingotRustedIron, 1), true, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget, rustedIronNugget);
        register.registerShapelessRecipe(new ItemStack(rustedIronNugget, 9), true, ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(anvilRustedIron, 1), true, "###", "@$@", "$$$", Character.valueOf('#'), rustedIronBlock, Character.valueOf('$'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.axeRustedIron, 1), true, "QQ@", "QS@", "@S@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('S'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.axeRustedIron, 1), true, "@QQ", "@SQ", "@S@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('S'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.arrowRustedIron, 1), true, "@Q@", "@W@", "@E@", Character.valueOf('Q'), rustedIronNugget, Character.valueOf('W'), Item.stick, Character.valueOf('E'), Item.feather);
        register.registerShapedRecipe(new ItemStack(Item.bootsRustedIron, 1), true, "@@@", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.bootsRustedIron, 1), true, "Q@Q", "Q@Q", "@@@", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.chainRustedIron, 1), true, "@Q@", "Q@Q", "@Q@", Character.valueOf('Q'), rustedIronNugget);
        register.registerShapedRecipe(new ItemStack(Item.daggerRustedIron, 1), true, "@Q", "@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.daggerRustedIron, 1), true, "Q@", "W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.battleAxeRustedIron, 1), true, "Q@Q", "QWQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hatchetRustedIron, 1), true, "QW", "@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hatchetRustedIron, 1), true, "WQ", "W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hoeRustedIron, 1), true, "QQ@", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hoeRustedIron, 1), true, "@QQ", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hoeRustedIron, 1), true, "@QQ", "@@W", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.hoeRustedIron, 1), true, "QQ@", "W@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.mattockRustedIron, 1), true, "QQQ", "@WQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.pickaxeRustedIron, 1), true, "QQQ", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.scytheRustedIron, 1), true, "WQ@", "W@Q", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(anvilRustedIron, 1), true, "QQQ", "@W@", "WWW", Character.valueOf('Q'), rustedIronBlock, Character.valueOf('W'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.shearsRustedIron, 1), true, "Q@", "@Q", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.shearsRustedIron, 1), true, "@Q", "Q@", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.shovelRustedIron, 1), true, "@Q@", "@W@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.shovelRustedIron, 1), true, "Q@@", "W@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.shovelRustedIron, 1), true, "@@Q", "@@W", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.swordRustedIron, 1), true, "Q@@", "Q@@", "W@@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.swordRustedIron, 1), true, "@Q@", "@Q@", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.swordRustedIron, 1), true, "@@Q", "@@Q", "@@W", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.warHammerRustedIron, 1), true, "QQQ", "QWQ", "@W@", Character.valueOf('Q'), ingotRustedIron, Character.valueOf('W'), Item.stick);
        register.registerShapedRecipe(new ItemStack(rustedIronBlock, 1), true, "QQQ", "QQQ", "QQQ", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.helmetRustedIron, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.legsRustedIron, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.plateRustedIron, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), ingotRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.helmetChainRustedIron, 1), true, "QQQ", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.bootsChainRustedIron, 1), true, "Q@Q", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.legsChainRustedIron, 1), true, "QQQ", "Q@Q", "Q@Q", Character.valueOf('Q'), Item.chainRustedIron);
        register.registerShapedRecipe(new ItemStack(Item.plateChainRustedIron, 1), true, "Q@Q", "QQQ", "QQQ", Character.valueOf('Q'), Item.chainRustedIron);
        register.registerShapedRecipe(new ItemStack(Items.fishingRodRustedIron, 1), true, "  Q", " Q@", "QW@", Character.valueOf('Q'), Item.stick, Character.valueOf('@'), Item.silk, Character.valueOf('W'), Items.rustedIronNugget);

    }
        public static void furnaceRecipeRegister(RecipesFurnace recipesFurnace){
        recipesFurnace.addSmelting(rawCopperNugget.itemID,new ItemStack(Item.copperNugget,1));
        Item.copperNugget.setXPReward(1);
        recipesFurnace.addSmelting(rawSilverNugget.itemID,new ItemStack(Item.silverNugget,1));
        Item.silverNugget.setXPReward(1);
        recipesFurnace.addSmelting(rawGoldNugget.itemID,new ItemStack(Item.goldNugget,1));
        Item.goldNugget.setXPReward(2);
        recipesFurnace.addSmelting(rustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        recipesFurnace.addSmelting(rawRustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        recipesFurnace.addSmelting(rawAncientMetalNugget.itemID,new ItemStack(Item.ancientMetalNugget,1));
        Item.ancientMetalNugget.setXPReward(2);
        recipesFurnace.addSmelting(rawMithrilNugget.itemID,new ItemStack(Item.mithrilNugget,1));
        Item.mithrilNugget.setXPReward(4);
        recipesFurnace.addSmelting(rawAdamantiumNugget.itemID,new ItemStack(Item.adamantiumNugget,1));
        Item.adamantiumNugget.setXPReward(10);
    }
    private static Item register(String string, Item item, CreativeModeTab creativeModeTab) {
        item.setResourceLocation(string);
        item.setUnlocalizedName(string);
        item.setCreativeTab(creativeModeTab);
        return item;
    }
}
