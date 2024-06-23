package mod.mitecreation.item;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.materil.Materials;
import mod.mitecreation.util.Util;
import mod.rustedironcore.api.item.IngotItem;
import net.minecraft.*;
import net.xiaoyu233.fml.api.item.NuggetItem;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;
import static mod.mitecreation.MITECreationMod.CreationNameSpace;

@SuppressWarnings("ConstantConditions")
public class CreationItem {

    public static final ItemCoin coinIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.iron);
    public static final ItemCoin coinRustedIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.rusted_iron);

    public static final NuggetItem rustedIronNugget = new NuggetItem(IdUtil.getNextItemID(),Material.rusted_iron);
    public static final IngotItem ingotRustedIron = new IngotItem(IdUtil.getNextItemID(),Material.rusted_iron);

    public static ItemFishingRod fishingRodRustedIron = (ItemFishingRod)(new ItemFishingRod(IdUtil.getNextItemID(), Materials.rusted_iron)).setUnlocalizedName("fishingRod");

    public static final ItemRawNugget rawRustedIronNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.rusted_iron);
    public static final ItemRawNugget rawCopperNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.copper);
    public static final ItemRawNugget rawSilverNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.silver);
    public static final ItemRawNugget rawGoldNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.gold);
    public static final ItemRawNugget rawAncientMetalNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.ancient_metal);
    public static final ItemRawNugget rawTungstenNugget = new ItemRawNugget(IdUtil.getNextItemID(), Materials.tungsten);
    public static final ItemRawNugget rawMithrilNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.mithril);
    public static final ItemRawNugget rawAdamantiumNugget = new ItemRawNugget(IdUtil.getNextItemID(),Material.adamantium);

    public static final ItemNugget tungstenNugget = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final Item ingotTungsten = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten).setXPReward(75);

    public static final ItemWarHammer warHammerTungsten = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemBattleAxe battleAxeTungsten = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemSword swordTungsten = createInstance(ItemSword.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), Materials.tungsten);
    public static final ItemDagger daggerTungsten = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemPickaxe pickaxeTungsten = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemShovel shovelTungsten = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemAxe axeTungsten = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemHoe hoeTungsten = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemKnife knifeTungsten = createInstance(ItemKnife.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemMattock mattockTungsten = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemScythe scytheTungsten = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemShears shearsTungsten = createInstance(ItemShears.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemHatchet hatchetTungsten = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static ItemFishingRod fishingRodTungsten = (ItemFishingRod)(new ItemFishingRod(IdUtil.getNextItemID(), Materials.tungsten)).setUnlocalizedName("fishingRod");

    public static final ItemArmor helmetTungsten = new ItemHelmet(IdUtil.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor helmetChainTungsten = new ItemHelmet(IdUtil.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor plateTungsten = new ItemCuirass(IdUtil.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor plateChainTungsten = new ItemCuirass(IdUtil.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor legsTungsten = new ItemLeggings(IdUtil.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor legsChainTungsten = new ItemLeggings(IdUtil.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor bootsTungsten = new ItemBoots(IdUtil.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor bootsChainTungsten = new ItemBoots(IdUtil.getNextItemID(),Materials.tungsten,true);

    public static final Item doorTungsten= new ItemDoor(IdUtil.getNextItemID(), Materials.tungsten);
    public static final ItemChain chainTungsten = createInstance(ItemChain.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.tungsten);
    public static final ItemCoin coinTungsten = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Materials.tungsten);
    public static final ItemArrow arrowTungsten = new ItemArrow(IdUtil.getNextItemID(), Materials.tungsten);

    public static final ItemBucket tungstenBucket = new ItemBucket(IdUtil.getNextItemID(), Materials.tungsten, null);
    public static final ItemBucket tungstenBucketWater = (ItemBucket)new ItemBucket(IdUtil.getNextItemID(), Materials.tungsten, Material.water).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketLava = (ItemBucket)new ItemBucket(IdUtil.getNextItemID(), Materials.tungsten, Material.lava).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketStone = (ItemBucket)new ItemBucket(IdUtil.getNextItemID(), Materials.tungsten, Material.stone).setContainerItem(tungstenBucket);
    public static final ItemBucketMilk tungstenBucketMilk = (ItemBucketMilk) (new ItemBucketMilk(IdUtil.getNextItemID(), Materials.tungsten)).setContainerItem(tungstenBucket);

    public static final Item rustedIronBlock = new ItemBlock(CreationBlock.rustedIronBlock);

    public static final ItemClub clubStone = createInstance(ItemClub.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.stone);
    public static final ItemDagger daggerStone = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.stone);

    public static final ItemBucket woodBucketEmpty = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Materials.wood,null);
    public static final ItemBucket woodBucketWater = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Materials.wood,Materials.water).setContainerItem(woodBucketEmpty);
    public static final ItemBucketMilk woodBucketMilk = (ItemBucketMilk) new ItemBucketMilk(IdUtil.getNextItemID(), Materials.wood).setContainerItem(woodBucketEmpty);

    public static final ItemBucket rustedIronBucketEmpty = new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, null);
    public static final ItemBucket rustedIronBucketWater = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.water).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketLava = (ItemBucket)new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.lava).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketStone = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.stone).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucketMilk rustedIronBucketMilk = (ItemBucketMilk)(new ItemBucketMilk(IdUtil.getNextItemID(), Material.rusted_iron)).setContainerItem(rustedIronBucketEmpty);

    public static final ItemSword swordEmerald = createInstance(ItemSword.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), Material.emerald);
    public static final ItemSword swordDiamond = createInstance(ItemSword.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), Material.diamond);

//    public static final ItemHoe hoeFlint = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(),Materials.flint);

    public static final ItemStone itemStone = null;

    public static void itemRegister(ItemRegistryEvent event) {
//        if(true) {
//            return;
//        }
//        if(false) {
//            Item[] items = Item.itemsList;
//            items[0] = null;
//            try {
//                Item.itemsList[0] = null;
//                Accessor.modifyStatic(Items.class.getField("itemStone"), new ItemStone(Block.stone, new String[]{"tile.stone", "tile.deepSlate"}));
//                itemStone.setMaxStackSize(4);
//                Block.blocksList[4] = null;
//                Accessor.modifyStatic(Block.class.getField("cobblestone"), new BlockCobblestone());
//            } catch (NoSuchFieldException e) {
//                throw new RuntimeException(e);
//            }
//        }
        event.register(CreationNameSpace, "coins/iron", coinIron, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"coins/rusted_iron", coinRustedIron, CreativeTabs.tabMisc);

        event.register(CreationNameSpace,"nuggets/rusted_iron", rustedIronNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"ingots/rusted_iron", ingotRustedIron, CreativeTabs.tabMaterials);
        ingotRustedIron.setMaxStackSize(8);

        event.register(CreationNameSpace,"fishing_rods/rusted_iron_uncast", fishingRodRustedIron, CreativeTabs.tabTools);
        fishingRodRustedIron.setLowestCraftingDifficultyToProduce(Item.flint.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"rusted_iron_block", rustedIronBlock, CreativeTabs.tabBlock);
        rustedIronBlock.setMaxStackSize(4);

        event.register(CreationNameSpace,"ingots/tungsten", ingotTungsten, CreativeTabs.tabMaterials);
        ingotTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"nuggets/tungsten", tungstenNugget, CreativeTabs.tabMaterials);
        tungstenNugget.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"armor/tungsten_helmet", helmetTungsten, CreativeTabs.tabCombat);
        helmetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_chestplate", plateTungsten, CreativeTabs.tabCombat);
        plateTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_leggings", legsTungsten, CreativeTabs.tabCombat);
        legsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_boots", bootsTungsten, CreativeTabs.tabCombat);
        bootsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_chainmail_helmet", helmetChainTungsten, CreativeTabs.tabCombat);
        helmetChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_chainmail_chestplate", plateChainTungsten, CreativeTabs.tabCombat);
        plateChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_chainmail_leggings", legsChainTungsten, CreativeTabs.tabCombat);
        legsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"armor/tungsten_chainmail_boots", bootsChainTungsten, CreativeTabs.tabCombat);
        bootsChainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"tools/tungsten/tungsten_battle_axe", battleAxeTungsten, CreativeTabs.tabCombat);
        battleAxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_dagger", daggerTungsten, CreativeTabs.tabCombat);
        daggerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_sword", swordTungsten, CreativeTabs.tabCombat);
        swordTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_war_hammer", warHammerTungsten, CreativeTabs.tabCombat);
        warHammerTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"tools/tungsten/tungsten_axe", axeTungsten, CreativeTabs.tabTools);
        axeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_hatchet", hatchetTungsten, CreativeTabs.tabTools);
        hatchetTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_hoe", hoeTungsten, CreativeTabs.tabTools);
        hoeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_knife", knifeTungsten, CreativeTabs.tabTools);
        knifeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_pickaxe", pickaxeTungsten, CreativeTabs.tabTools);
        pickaxeTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_mattock", mattockTungsten, CreativeTabs.tabTools);
        mattockTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_scythe", scytheTungsten, CreativeTabs.tabTools);
        scytheTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_shears", shearsTungsten, CreativeTabs.tabTools);
        shearsTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/tungsten/tungsten_shovel", shovelTungsten, CreativeTabs.tabTools);
        shovelTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"fishing_rods/tungsten_uncast", fishingRodTungsten, CreativeTabs.tabTools);
        fishingRodTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"doors/tungsten", doorTungsten, CreativeTabs.tabRedstone);
        doorTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"chains/tungsten", chainTungsten, CreativeTabs.tabMaterials);
        chainTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"coins/tungsten", coinTungsten, CreativeTabs.tabMisc);
        coinTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"arrows/tungsten", arrowTungsten, CreativeTabs.tabCombat);
        arrowTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"buckets/tungsten/empty", tungstenBucket, CreativeTabs.tabMisc);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"buckets/tungsten/lava", tungstenBucketLava, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/tungsten/milk", tungstenBucketMilk, CreativeTabs.tabFood);
        event.register(CreationNameSpace,"buckets/tungsten/stone", tungstenBucketStone, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/tungsten/water", tungstenBucketWater, CreativeTabs.tabMisc);

        event.register(CreationNameSpace,"raw_nuggets/rusted_iron", rawRustedIronNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/copper", rawCopperNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/silver", rawSilverNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/gold", rawGoldNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/ancient_metal", rawAncientMetalNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/tungsten", rawTungstenNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/mithril", rawMithrilNugget, CreativeTabs.tabMaterials);
        event.register(CreationNameSpace,"raw_nuggets/adamantium", rawAdamantiumNugget, CreativeTabs.tabMaterials);

        event.register(CreationNameSpace,"tools/stone/stone_club", clubStone, CreativeTabs.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());
        event.register(CreationNameSpace,"tools/stone/stone_dagger", daggerStone, CreativeTabs.tabCombat);
        tungstenBucket.setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());

        event.register(CreationNameSpace,"buckets/wood/empty", woodBucketEmpty, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/wood/water", woodBucketWater, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/wood/milk", woodBucketMilk, CreativeTabs.tabFood);

        event.register(CreationNameSpace,"buckets/rusted_iron/empty", rustedIronBucketEmpty, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/rusted_iron/lava", rustedIronBucketLava, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/rusted_iron/milk", rustedIronBucketMilk, CreativeTabs.tabFood);
        event.register(CreationNameSpace,"buckets/rusted_iron/stone", rustedIronBucketStone, CreativeTabs.tabMisc);
        event.register(CreationNameSpace,"buckets/rusted_iron/water", rustedIronBucketWater, CreativeTabs.tabMisc);

        event.register(CreationNameSpace,"tools/emerald/emerald_sword", swordEmerald, CreativeTabs.tabCombat);
        event.register(CreationNameSpace,"tools/diamond/diamond_sword", swordDiamond, CreativeTabs.tabCombat);

//        register("tool/flint/flint_hoe", hoeFlint, CreativeTabs.tabTools);
        Util.initItemArray();
    }
}
