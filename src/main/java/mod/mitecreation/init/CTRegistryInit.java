package mod.mitecreation.init;

import huix.glacier.api.entrypoint.IGameRegistry;
import huix.glacier.api.registry.MinecraftRegistry;
import mod.mitecreation.block.*;
import mod.mitecreation.block.ore.normal.*;
import mod.mitecreation.client.audio.CTStepSound;
import mod.mitecreation.client.audio.CTStepSoundDeepslateBrick;
import mod.mitecreation.creativetab.CreativeTabsCreationBlock;
import mod.mitecreation.creativetab.CreativeTabsCreationItem;
import mod.mitecreation.creativetab.CreativeTabsCreationTool;
import mod.mitecreation.item.ItemCTFishingRod;
import mod.mitecreation.item.ItemCTSnowBerryBowl;
import mod.mitecreation.item.ItemCTRawNugget;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.api.block.*;
import moddedmite.rustedironcore.api.item.IngotItem;
import net.minecraft.*;
import net.xiaoyu233.fml.api.block.StrongBoxBlock;
import net.xiaoyu233.fml.api.item.NuggetItem;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import static net.minecraft.Block.*;
import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class CTRegistryInit implements IGameRegistry {
    public static final CreativeTabs tabCreationBlock = new CreativeTabsCreationBlock();
    public static final CreativeTabs tabCreationItem = new CreativeTabsCreationItem();
    public static final CreativeTabs tabCreationTool = new CreativeTabsCreationTool();

    public static final StepSound soundDeepslateFootstep = new CTStepSound(new ResourceLocation(CreationModInit.ID, "deepslate"), 1.0F, 1.0F);
    public static final StepSound soundDeepslateBrickFootstep = new CTStepSoundDeepslateBrick(new ResourceLocation(CreationModInit.ID, "deepslate_bricks"), 1.0F, 1.0F);

    public static final MinecraftRegistry registry = new MinecraftRegistry(CreationModInit.NAMESPACE).initAutoItemRegister();
//    public static IDAllocator allocatorCT = new IDAllocator(CreationModInit.ID, 128 , 256);

    public static Block rustedIronBlock;
    public static final BlockAnvil anvilRustedIron;
    public static final Block oreTungsten;
    public static final Block blockTungsten;
    public static final Block fenceTungsten;
    public static final Block doorTungsten;
    public static final BlockAnvil anvilTungsten;
    public static final BlockCTDeepStaleBrick deepStaleBrick;
    public static final BLockCTDeepSlateMagma deepStaleMagma;
    public static final Block cobbledDeepStale;
    public static final Block stairsCobbleDeepSlate;
    public static final Block stairsDeepSlateBrick;
    public static final BlockCTSandGravel gravelSand;
    public static final BlockCTDeepSlateGravel gravelDeepSlate;
    public static final Block cobbleDeepStaleWall;
    public static final Block deepStaleBrickWall;
    public static final Block deepSlate;
    public static final BlockCTCobbleDeepSlateSlabGroup cobbledDeepStaleSingleSlab;
    public static final BlockCTDeepSlateDoubleSlab cobbledDeepStaleDoubleSlab;
    public static final BlockCTDeepSlateBrickSlabGroup deepStaleBrickSingleSlab;
    public static final BlockCTDeepSlateDoubleSlab deepStaleBrickDoubleSlab;
    public static final BlockCTAncientRelict ancientRelict;
    public static final WorkbenchBlock tungstenWorkBench;
    public static final Block oreIronDeepslate;
    public static final Block oreCoalDeepslate;
    public static final Block oreLapisDeepslate;
    public static final Block oreDiamondDeepslate;
    public static final Block oreEmeraldDeepslate;
    public static final Block oreCopperDeepslate;
    public static final Block oreSilverDeepslate;
    public static final Block oreMithrilDeepslate;
    public static final Block oreAdamantiumDeepslate;
    public static final Block oreTungstenDeepslate;
    public static final Block oreGoldDeepslate;
    public static final Block oreRedstoneDeepslate;
    public static final BlockCTDeepslateSilverFish deepslateSilverFish;
    public static final Block chestTungsten;
    public static final Block oreRedstoneDeepslateGlowing;
    public static final BlockCTWood peachPlanks;
    public static final BlockCTLog peachWood;
    public static final BlockCTLeaves peachLeaves;
    public static final Block peachSapling;
    public static final BlockCTPeachPlanksSlabGroup peachPlanksSingleSlab;
    public static final BlockCTPeachPlanksDoubleSlab peachPlanksDoubleSlab;
    public static final Block stairsPeachPlanks;
    public static final BlockCTSnowBerry snowBerry;
    public static final Block basalt;

    public static final ItemCoin coinIron = (ItemCoin) createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, getItemID("coinIron"), Material.iron).setCreativeTab(tabCreationItem);
    public static final ItemCoin coinRustedIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, getItemID("coinRustedIron"), Material.rusted_iron);
    public static final NuggetItem rustedIronNugget = new NuggetItem(getItemID("rustedIronNugget"), Material.rusted_iron);
    public static final IngotItem ingotRustedIron = (IngotItem) new IngotItem(getItemID("ingotRustedIron"), Material.rusted_iron).setMaxStackSize(8);
    public static ItemCTFishingRod fishingRodRustedIron = (ItemCTFishingRod)(new ItemCTFishingRod(getItemID("fishingRodRustedIron"), Material.rusted_iron)).setUnlocalizedName("fishingRod");
    public static final ItemCTRawNugget rawRustedIronNugget = new ItemCTRawNugget(getItemID("rawRustedIronNugget"), Material.rusted_iron);
    public static final ItemCTRawNugget rawCopperNugget = new ItemCTRawNugget(getItemID("rawCopperNugget"), Material.copper);
    public static final ItemCTRawNugget rawSilverNugget = new ItemCTRawNugget(getItemID("rawSilverNugget"), Material.silver);
    public static final ItemCTRawNugget rawGoldNugget = new ItemCTRawNugget(getItemID("rawGoldNugget"), Material.gold);
    public static final ItemCTRawNugget rawAncientMetalNugget = new ItemCTRawNugget(getItemID("rawAncientMetalNugget"), Material.ancient_metal);
    public static final ItemCTRawNugget rawTungstenNugget = new ItemCTRawNugget(getItemID("rawTungstenNugget"), CTMaterials.tungsten);
    public static final ItemCTRawNugget rawMithrilNugget = new ItemCTRawNugget(getItemID("rawMithrilNugget"), Material.mithril);
    public static final ItemCTRawNugget rawAdamantiumNugget = new ItemCTRawNugget(getItemID("rawAdamantiumNugget"), Material.adamantium);
    public static final ItemNugget tungstenNugget = (ItemNugget) createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, getItemID("tungstenNugget"), CTMaterials.tungsten).setXPReward(3);
    public static final Item ingotTungsten = createInstance(ItemIngot.class,new Class[]{int.class, Material.class},getItemID("ingotTungsten"), CTMaterials.tungsten).setXPReward(25);
    public static final ItemWarHammer warHammerTungsten = createInstance(ItemWarHammer.class, new Class[]{int.class, Material.class}, getItemID("warHammerTungsten"), CTMaterials.tungsten);
    public static final ItemBattleAxe battleAxeTungsten = createInstance(ItemBattleAxe.class, new Class[]{int.class, Material.class}, getItemID("battleAxeTungsten"), CTMaterials.tungsten);
    public static final ItemSword swordTungsten = createInstance(ItemSword.class, new Class[]{int.class, Material.class}, getItemID("swordTungsten"), CTMaterials.tungsten);
    public static final ItemDagger daggerTungsten = createInstance(ItemDagger.class, new Class[]{int.class, Material.class}, getItemID("daggerTungsten"), CTMaterials.tungsten);
    public static final ItemPickaxe pickaxeTungsten = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, getItemID("pickaxeTungsten"), CTMaterials.tungsten);
    public static final ItemShovel shovelTungsten = createInstance(ItemShovel.class, new Class[]{int.class, Material.class}, getItemID("shovelTungsten"), CTMaterials.tungsten);
    public static final ItemAxe axeTungsten = createInstance(ItemAxe.class, new Class[]{int.class, Material.class},getItemID("axeTungsten"), CTMaterials.tungsten);
    public static final ItemHoe hoeTungsten = createInstance(ItemHoe.class, new Class[]{int.class ,Material.class},getItemID("hoeTungsten"), CTMaterials.tungsten);
    public static final ItemKnife knifeTungsten = createInstance(ItemKnife.class, new Class[]{int.class, Material.class}, getItemID("knifeTungsten"), CTMaterials.tungsten);
    public static final ItemMattock mattockTungsten = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},getItemID("mattockTungsten"), CTMaterials.tungsten);
    public static final ItemScythe scytheTungsten = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},getItemID("scytheTungsten"), CTMaterials.tungsten);
    public static final ItemShears shearsTungsten = createInstance(ItemShears.class,new Class[]{int.class,Material.class},getItemID("shearsTungsten"), CTMaterials.tungsten);
    public static final ItemHatchet hatchetTungsten = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},getItemID("hatchetTungsten"), CTMaterials.tungsten);
    public static ItemCTFishingRod fishingRodTungsten = (ItemCTFishingRod) (new ItemCTFishingRod(getItemID("fishingRodTungsten"), CTMaterials.tungsten)).setUnlocalizedName("fishingRod");
    public static final ItemArmor helmetTungsten = new ItemHelmet(getItemID("helmetTungsten"), CTMaterials.tungsten,false);
    public static final ItemArmor helmetChainTungsten = new ItemHelmet(getItemID("helmetChainTungsten"), CTMaterials.tungsten,true);
    public static final ItemArmor plateTungsten = new ItemCuirass(getItemID("plateTungsten"), CTMaterials.tungsten,false);
    public static final ItemArmor plateChainTungsten = new ItemCuirass(getItemID("plateChainTungsten"), CTMaterials.tungsten,true);
    public static final ItemArmor legsTungsten = new ItemLeggings(getItemID("legsTungsten"), CTMaterials.tungsten,false);
    public static final ItemArmor legsChainTungsten = new ItemLeggings(getItemID("legsChainTungsten"), CTMaterials.tungsten,true);
    public static final ItemArmor bootsTungsten = new ItemBoots(getItemID("bootsTungsten"), CTMaterials.tungsten,false);
    public static final ItemArmor bootsChainTungsten = new ItemBoots(getItemID("bootsChainTungsten"), CTMaterials.tungsten,true);
    public static final Item doorTungstenItem = new ItemDoor(getItemID("doorTungstenItem"), CTMaterials.tungsten).setCreativeTab(tabCreationBlock);
    public static final ItemChain chainTungsten = createInstance(ItemChain.class,new Class[]{int.class,Material.class},getItemID("chainTungsten"), CTMaterials.tungsten);
    public static final ItemCoin coinTungsten = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, getItemID("coinTungsten"), CTMaterials.tungsten);
    public static final ItemArrow arrowTungsten = new ItemArrow(getItemID("arrowTungsten"), CTMaterials.tungsten);
    public static final ItemBucket tungstenBucket = new ItemBucket(getItemID("tungstenBucket"), CTMaterials.tungsten, null);
    public static final ItemBucket tungstenBucketWater = (ItemBucket) new ItemBucket(getItemID("tungstenBucketWater"), CTMaterials.tungsten, Material.water).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketLava = (ItemBucket) new ItemBucket(getItemID("tungstenBucketLava"), CTMaterials.tungsten, Material.lava).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketStone = (ItemBucket) new ItemBucket(getItemID("tungstenBucketStone"), CTMaterials.tungsten, Material.stone).setContainerItem(tungstenBucket);
    public static final ItemBucketMilk tungstenBucketMilk = (ItemBucketMilk) (new ItemBucketMilk(getItemID("tungstenBucketMilk"), CTMaterials.tungsten)).setContainerItem(tungstenBucket);
//    public static final Item rustedIronItemBlock = new ItemBlock(rustedIronBlock).setMaxStackSize(4).setCreativeTab(tabCreationBlock);
    public static final ItemClub clubStone = createInstance(ItemClub.class,new Class[]{int.class,Material.class},getItemID("clubStone"), CTMaterials.stone);
    public static final ItemDagger daggerStone = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},getItemID("daggerStone"), CTMaterials.stone);
    public static final ItemBucket woodBucketEmpty = new ItemBucket(getItemID("woodBucketEmpty"), Material.wood,null);
    public static final ItemBucket woodBucketWater = (ItemBucket) new ItemBucket(getItemID("woodBucketWater"), Material.wood, Material.water).setContainerItem(woodBucketEmpty);
    public static final ItemBucketMilk woodBucketMilk = (ItemBucketMilk) new ItemBucketMilk(getItemID("woodBucketMilk"), Material.wood).setContainerItem(woodBucketEmpty);
    public static final ItemBucket rustedIronBucketEmpty = new ItemBucket(getItemID("rustedIronBucketEmpty"), Material.rusted_iron, null);
    public static final ItemBucket rustedIronBucketWater = (ItemBucket) new ItemBucket(getItemID("rustedIronBucketWater"), Material.rusted_iron, Material.water).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketLava = (ItemBucket)new ItemBucket(getItemID("rustedIronBucketLava"), Material.rusted_iron, Material.lava).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucket rustedIronBucketStone = (ItemBucket) new ItemBucket(getItemID("rustedIronBucketStone"), Material.rusted_iron, Material.stone).setContainerItem(rustedIronBucketEmpty);
    public static final ItemBucketMilk rustedIronBucketMilk = (ItemBucketMilk) (new ItemBucketMilk(getItemID("rustedIronBucketMilk"), Material.rusted_iron)).setContainerItem(rustedIronBucketEmpty);
    public static final ItemSword swordEmerald = createInstance(ItemSword.class ,new Class[]{int.class, Material.class}, getItemID("swordEmerald"), Material.emerald);
    public static final ItemSword swordDiamond = createInstance(ItemSword.class, new Class[]{int.class, Material.class}, getItemID("swordDiamond"), Material.diamond);
    public static final ItemHorseArmor horseArmorTungsten = createInstance(ItemHorseArmor.class,new Class[]{int.class, Material.class}, getItemID("horseArmorTungsten"), CTMaterials.tungsten);
    public static final ItemFood peach = (new ItemFood(getItemID("peach"), Material.fruit, 2, 1, 1000, false, false, true, "peach")).setPlantProduct();
    public static final ItemShovel shovelPeachWood = createInstance(ItemShovel.class, new Class[]{int.class, Material.class}, getItemID("shovelPeachWood"), CTMaterials.peachWood);
    public static final ItemSword swordPeachWood = createInstance(ItemSword.class, new Class[]{int.class, Material.class}, getItemID("swordPeachWood"), CTMaterials.peachWood);
    public static final ItemFood snowBerries = (new ItemFood(getItemID("snowBerries"), Material.fruit, 1, 2, 500, false, false, true, "snow_berries")).setPotionEffect(Potion.poison.id, 10, 0, 0.4F).setPlantProduct();
    public static final ItemCTSnowBerryBowl snowBerryPorridge = (ItemCTSnowBerryBowl) (new ItemCTSnowBerryBowl(getItemID("snowBerryPorridge"), Material.fruit, "snow_berry_stew")).setFoodValue(3, 2, 250, false, false, true).setPlantProduct();
    public static final Item fragsDecayCreeper = (new Item(getItemID("fragsDecayCreeper"), Material.frags, CreationModInit.COLON_ID + "frag/decay_creeper"));

    private void registerItem(String resource, String name, Item item) {
        resource = CreationModInit.COLON_ID + resource;
        item.setCreativeTab(tabCreationItem);
        registry.registerItem(resource, name, item);
    }
    private void registerItemTool(String resource, String name, Item item) {
        resource = CreationModInit.COLON_ID + resource;
        item.setCreativeTab(tabCreationTool);
        registry.registerItem(resource, name, item);
    }

    private void registerBlock(Block block, String resource, String name) {
        resource = CreationModInit.COLON_ID + resource;
        block.setCreativeTab(tabCreationBlock);
        registry.registerBlock(block, resource, name);
    }

    private void registerBlock(Block block, String resource, String name, CreativeTabs creativeTab) {
        resource = CreationModInit.COLON_ID + resource;
        block.setCreativeTab(creativeTab);
        registry.registerBlock(block, resource, name);
    }

    private void registerBlock(Block block, String resource) {
        resource = CreationModInit.COLON_ID + resource;
        registry.registerBlock(block, resource);
    }

    private void registerBlockAnvil(BlockAnvil block, String resource, String name) {
        resource = CreationModInit.COLON_ID + resource;
        block.setCreativeTab(tabCreationBlock);
        registry.registerBlockAnvil(block, resource, name);
    }

    private static int getItemID(String name) {
        return IdUtil.getNextItemID();
    }

    public static int getBlockID(String name) {
        return IdUtil.getNextBlockID();
    }

    @Override
    public void onGameRegistry() {
        //Register Items Heat Level
//        registry.registerItemHeatLevel(rawCopperNugget.itemID, 1);
//        registry.registerItemHeatLevel(rawSilverNugget.itemID, 1);
//        registry.registerItemHeatLevel(rawGoldNugget.itemID, 1);
//        registry.registerItemHeatLevel(rawRustedIronNugget.itemID, 2);
//        registry.registerItemHeatLevel(rustedIronNugget.itemID, 2);
//        registry.registerItemHeatLevel(rawAncientMetalNugget.itemID, 2);
//        registry.registerItemHeatLevel(rawMithrilNugget.itemID, 3);
//        registry.registerItemHeatLevel(rawTungstenNugget.itemID, 3);
//        registry.registerItemHeatLevel(rawAdamantiumNugget.itemID, 4);
        { // reset/set burn xp
            Item.copperNugget.setXPReward(1);
            Item.silverNugget.setXPReward(1);
            Item.goldNugget.setXPReward(2);
            Item.ironNugget.setXPReward(1);
            Item.ancientMetalNugget.setXPReward(2);
            Item.mithrilNugget.setXPReward(4);
            Item.adamantiumNugget.setXPReward(10);
        }

        //Register Items
        registry.registerItem("coins/iron", "coinIron",  coinIron);
        registerItem("coins/rusted_iron", "coinRustedIron", coinRustedIron);
        registerItem("nuggets/rusted_iron", "rustedIronNugget", rustedIronNugget);
        registerItem("ingots/rusted_iron", "ingotRustedIron", ingotRustedIron);
        registerItemTool("fishing_rods/rusted_iron_uncast", "fishingRodRustedIron", fishingRodRustedIron);
//        registerItem("rusted_iron_block", rustedIronItemBlock);
        registerItem("ingots/tungsten", "ingotTungsten", ingotTungsten);
        registerItem("nuggets/tungsten", "tungstenNugget", tungstenNugget);
        registerItemTool("armor/tungsten_helmet", "helmetTungsten", helmetTungsten);
        registerItemTool("armor/tungsten_chestplate", "plateTungsten", plateTungsten);
        registerItemTool("armor/tungsten_leggings", "legsTungsten", legsTungsten);
        registerItemTool("armor/tungsten_boots", "bootsTungsten", bootsTungsten);
        registerItemTool("armor/tungsten_chainmail_helmet", "helmetChainTungsten", helmetChainTungsten);
        registerItemTool("armor/tungsten_chainmail_chestplate", "plateChainTungsten", plateChainTungsten);
        registerItemTool("armor/tungsten_chainmail_leggings", "legsChainTungsten", legsChainTungsten);
        registerItemTool("armor/tungsten_chainmail_boots", "bootsChainTungsten", bootsChainTungsten);
        registerItemTool("armor/horse/tungsten", "horseArmorTungsten", horseArmorTungsten);
        registerItemTool("tools/tungsten/tungsten_battle_axe", "battleAxeTungsten", battleAxeTungsten);
        registerItemTool("tools/tungsten/tungsten_dagger", "daggerTungsten", daggerTungsten);
        registerItemTool("tools/tungsten/tungsten_sword", "swordTungsten", swordTungsten);
        registerItemTool("tools/tungsten/tungsten_war_hammer", "warHammerTungsten", warHammerTungsten);
        registerItemTool("tools/tungsten/tungsten_axe", "axeTungsten", axeTungsten);
        registerItemTool("tools/tungsten/tungsten_hatchet", "hatchetTungsten", hatchetTungsten);
        registerItemTool("tools/tungsten/tungsten_hoe", "hoeTungsten", hoeTungsten);
        registerItemTool("tools/tungsten/tungsten_knife", "knifeTungsten", knifeTungsten);
        registerItemTool("tools/tungsten/tungsten_pickaxe", "pickaxeTungsten", pickaxeTungsten);
        registerItemTool("tools/tungsten/tungsten_mattock", "mattockTungsten", mattockTungsten);
        registerItemTool("tools/tungsten/tungsten_scythe", "scytheTungsten", scytheTungsten);
        registerItemTool("tools/tungsten/tungsten_shears", "shearsTungsten", shearsTungsten);
        registerItemTool("tools/tungsten/tungsten_shovel", "shovelTungsten", shovelTungsten);
        registerItemTool("fishing_rods/tungsten_uncast", "fishingRodTungsten", fishingRodTungsten);
        registerItem("doors/tungsten", "doorTungsten", doorTungstenItem);
        registerItem("chains/tungsten", "chainTungsten", chainTungsten);
        registerItem("coins/tungsten", "coinTungsten", coinTungsten);
        registerItemTool("arrows/tungsten", "arrowTungsten", arrowTungsten);
        registerItemTool("buckets/tungsten/empty", "tungstenBucket", tungstenBucket);
        registerItemTool("buckets/tungsten/lava", "tungstenBucketLava", tungstenBucketLava);
        registerItemTool("buckets/tungsten/milk", "tungstenBucketMilk", tungstenBucketMilk);
        registerItemTool("buckets/tungsten/stone", "tungstenBucketStone", tungstenBucketStone);
        registerItemTool("buckets/tungsten/water", "tungstenBucketWater", tungstenBucketWater);
        registerItem("raw_nuggets/rusted_iron", "rawRustedIronNugget", rawRustedIronNugget);
        registerItem("raw_nuggets/copper", "rawCopperNugget", rawCopperNugget);
        registerItem("raw_nuggets/silver", "rawSilverNugget", rawSilverNugget);
        registerItem("raw_nuggets/gold", "rawGoldNugget", rawGoldNugget);
        registerItem("raw_nuggets/ancient_metal", "rawAncientMetalNugget", rawAncientMetalNugget);
        registerItem("raw_nuggets/tungsten", "rawTungstenNugget", rawTungstenNugget);
        registerItem("raw_nuggets/mithril", "rawMithrilNugget", rawMithrilNugget);
        registerItem("raw_nuggets/adamantium", "rawAdamantiumNugget", rawAdamantiumNugget);
        registerItemTool("tools/stone/stone_club", "clubStone", clubStone);
        registerItemTool("tools/stone/stone_dagger", "daggerStone", daggerStone);
        registerItemTool("buckets/wood/empty", "woodBucketEmpty", woodBucketEmpty);
        registerItemTool("buckets/wood/water", "woodBucketWater", woodBucketWater);
        registerItemTool("buckets/wood/milk", "woodBucketMilk", woodBucketMilk);
        registerItemTool("buckets/rusted_iron/empty", "rustedIronBucketEmpty", rustedIronBucketEmpty);
        registerItemTool("buckets/rusted_iron/lava", "rustedIronBucketLava", rustedIronBucketLava);
        registerItemTool("buckets/rusted_iron/milk", "rustedIronBucketMilk", rustedIronBucketMilk);
        registerItemTool("buckets/rusted_iron/stone", "rustedIronBucketStone", rustedIronBucketStone);
        registerItemTool("buckets/rusted_iron/water", "rustedIronBucketWater", rustedIronBucketWater);
        registerItemTool("tools/emerald/emerald_sword", "swordEmerald", swordEmerald);
        registerItemTool("tools/diamond/diamond_sword", "swordDiamond", swordDiamond);
        registerItem("food/peach", "peach", peach);
        registerItemTool("tools/peach_wood/peach_wood_shovel", "shovelPeachWood", shovelPeachWood);
        registerItemTool("tools/peach_wood/peach_wood_sword", "swordPeachWood", swordPeachWood);
        registerItem("food/snow_berries", "snowBerries", snowBerries);
        registerItem("bowl/snow_berry", "snowBerryStew", snowBerryPorridge);
        registerItem("frag/decay_creeper", "frags_decay_creeper", fragsDecayCreeper);

        //Register Blocks
        registerBlock(rustedIronBlock, "rusted_iron_block", "rustedIronBlock");
        registerBlockAnvil(anvilRustedIron, "rusted_iron_anvil", "anvilRustedIron");
        registerBlockAnvil(anvilTungsten, "tungsten_anvil", "anvilTungsten");
        registerBlock(oreTungsten, "ore/tungsten_ore", "oreTungsten");
        registerBlock(blockTungsten, "block/tungsten_block", "blockTungsten");
        registerBlock(fenceTungsten, "bars/tungsten_bars", "fenceTungsten");
        registerBlock(doorTungsten, "door/door_tungsten", "doorTungsten", null);
        registerBlock(deepStaleBrick, "deepslate_brick", "deepStaleBrick");
        registerBlock(deepStaleMagma, "deepslate_brick_magma", "deepStaleMagma");
        registerBlock(cobbledDeepStale, "cobbled_deepslate", "cobbledDeepStale");
        registerBlock(stairsCobbleDeepSlate, "cobble_deepslate_stairs", "stairsCobbleDeepSlate");
        registerBlock(stairsDeepSlateBrick, "deepslate_brick_stairs", "stairsDeepSlateBrick");
        registerBlock(cobbleDeepStaleWall, "cobble_deepslate_wall", "cobbleDeepStaleWall");
        registerBlock(deepStaleBrickWall, "deepslate_brick_wall", "deepStaleBrickWall");
        registerBlock(gravelSand, "sand_gravel", "gravelSand");
        registerBlock(gravelDeepSlate, "deepslate_gravel", "gravelDeepSlate");
        registerBlock(deepSlate, "deepslate", "deepSlate");
        registerBlock(cobbledDeepStaleSingleSlab, "cobbledDeepslateSlab", "cobbledDeepslateSlab");
        registerBlock(cobbledDeepStaleDoubleSlab, "cobbledDeepslateSlab", "cobbledDeepslateSlab");
        registerBlock(deepStaleBrickSingleSlab, "deepslateBrickSlab", "deepslateBrickSlab");
        registerBlock(deepStaleBrickDoubleSlab, "deepslateBrickSlab", "deepslateBrickSlab");
        registerBlock(ancientRelict, "ancient_relict", "ancientRelict");
        registerBlock(tungstenWorkBench, "toolbench.tungsten", "toolbench.tungsten");
        registerBlock(oreIronDeepslate, "ore/normal/iron_ore_normal", "oreIronDeepslate");
        registerBlock(oreCoalDeepslate, "ore/normal/coal_ore_normal", "oreCoalDeepslate");
        registerBlock(oreLapisDeepslate, "ore/normal/lapis_ore_normal", "oreLapisDeepslate");
        registerBlock(oreDiamondDeepslate, "ore/normal/diamond_ore_normal", "oreDiamondDeepslate");
        registerBlock(oreEmeraldDeepslate, "ore/normal/emerald_ore_normal", "oreEmeraldDeepslate");
        registerBlock(oreCopperDeepslate, "ore/normal/copper_ore_normal", "oreCopperDeepslate");
        registerBlock(oreSilverDeepslate, "ore/normal/silver_ore_normal", "oreSilverDeepslate");
        registerBlock(oreMithrilDeepslate, "ore/normal/mithril_ore_normal", "oreMithrilDeepslate");
        registerBlock(oreAdamantiumDeepslate, "ore/normal/adamantium_ore_normal", "oreAdamantiumDeepslate");
        registerBlock(oreTungstenDeepslate, "ore/normal/tungsten_ore_normal", "oreTungstenDeepslate");
        registerBlock(oreGoldDeepslate, "ore/normal/gold_ore_normal", "oreGoldDeepslate");
        registerBlock(oreRedstoneDeepslate, "ore/normal/redstone_ore_normal", "oreRedstoneDeepslate");
        registerBlock(deepslateSilverFish, "monsterDeepslateEgg", "monsterDeepslateEgg");
        registerBlock(chestTungsten, "tungsten_chest", "chestTungsten");
        registerBlock(oreRedstoneDeepslateGlowing, "ore/normal/redstone_ore_normal", "oreRedstoneDeepslate");
        registerBlock(peachPlanks, "wood", "peachPlanks");
        registerBlock(peachWood, "log", "peachLogs");
        registerBlock(peachLeaves, "leaves_peach", "peachLeaves");
        registerBlock(peachSapling, "sapling", "peachSapling");
        registerBlock(peachPlanksSingleSlab, "wood", "woodSlab");
        registerBlock(peachPlanksDoubleSlab, "wood", "woodSlab");
        registerBlock(stairsPeachPlanks, "peach_planks_stairs", "stairsPeachPlanks");
        registerBlock(snowBerry, "bushes", "sonwBerry");
        registerBlock(basalt,"basalt","basalt");
    }

    static {
        rustedIronBlock = new BlockOreStorage(getBlockID("rustedIronBlock"), Material.rusted_iron);
        anvilRustedIron = (BlockAnvil) new BlockCTAnvil(getBlockID("anvilRustedIron"), Material.rusted_iron).setStepSound(soundAnvilFootstep);
        oreTungsten = (new BlockOre(getBlockID("oreTungsten"), CTMaterials.tungsten, 4)).setHardness(3.25F).setResistance(15.0F);
        blockTungsten = (new BlockOreStorage(getBlockID("blockTungsten"), CTMaterials.tungsten)).setStepSound(soundMetalFootstep);
        fenceTungsten = (new PaneBlock(getBlockID("fenceTungsten"), CreationModInit.COLON_ID + "bars/tungsten_bars", CreationModInit.COLON_ID + "bars/tungsten_bars", CTMaterials.tungsten, false)).setStepSound(soundMetalFootstep).setResistance(24.0F).setHardness(12.8F).setMinHarvestLevel(4);
        doorTungsten = (new DoorBlock(getBlockID("doorTungsten"), CTMaterials.tungsten, () -> Item.getItem(CTRegistryInit.doorTungsten))).setStepSound(soundMetalFootstep).setMinHarvestLevel(4);
        anvilTungsten = (BlockAnvil) new BlockCTAnvil(getBlockID("anvilTungsten"), CTMaterials.tungsten).setStepSound(soundAnvilFootstep);
        deepStaleBrick = (BlockCTDeepStaleBrick) (new BlockCTDeepStaleBrick(getBlockID("deepStaleBrick"))).setHardness(1.8F).setResistance(15.0F).setStepSound(soundDeepslateBrickFootstep);
        deepStaleMagma = (BLockCTDeepSlateMagma) (new BLockCTDeepSlateMagma(getBlockID("deepStaleMagma"))).setHardness(1.8F).setResistance(15.0F).setStepSound(soundDeepslateFootstep);
        cobbledDeepStale = (new BlockCTCobbledDeepSlate(getBlockID("cobbledDeepStale"))).setHardness(2.5F).setResistance(15.0F).setStepSound(soundDeepslateFootstep);
        stairsCobbleDeepSlate = (new StairsBlock(getBlockID("stairsCobbleDeepSlate"), cobbledDeepStale, 0)).setStepSound(soundDeepslateFootstep);
        stairsDeepSlateBrick = (new StairsBlock(getBlockID("stairsDeepSlateBrick"), deepStaleBrick, 0)).setStepSound(soundDeepslateFootstep);
        cobbleDeepStaleWall = new WallBlock(getBlockID("cobbleDeepStaleWall"), cobbledDeepStale).setHardness(2.5F).setResistance(15.0F).setStepSound(soundDeepslateFootstep);
        deepStaleBrickWall = new WallBlock(getBlockID("deepStaleBrickWall"), deepStaleBrick).setHardness(1.8F).setResistance(15.0F).setStepSound(soundDeepslateFootstep);
        gravelSand = (BlockCTSandGravel) (new BlockCTSandGravel(getBlockID("gravelSand"))).setHardness(0.6F).setStepSound(soundSandFootstep);
        gravelDeepSlate = (BlockCTDeepSlateGravel) (new BlockCTDeepSlateGravel(getBlockID("gravelDeepSlate"))).setHardness(0.8F).setStepSound(soundGravelFootstep);
        deepSlate = (new BlockCTDeepSlate(getBlockID("deepSlate"))).setHardness(3.0F).setResistance(15.0F).setStepSound(soundDeepslateFootstep);
        cobbledDeepStaleSingleSlab = (BlockCTCobbleDeepSlateSlabGroup) (new BlockCTCobbleDeepSlateSlabGroup(getBlockID("cobbledDeepStaleSingleSlab"), Material.stone)).setStepSound(soundDeepslateFootstep);
        cobbledDeepStaleDoubleSlab = (BlockCTDeepSlateDoubleSlab) (new BlockCTDeepSlateDoubleSlab(getBlockID("cobbledDeepStaleDoubleSlab"), cobbledDeepStaleSingleSlab)).setStepSound(soundDeepslateFootstep);
        deepStaleBrickSingleSlab = (BlockCTDeepSlateBrickSlabGroup) (new BlockCTDeepSlateBrickSlabGroup(getBlockID("deepStaleBrickSingleSlab"), Material.stone)).setStepSound(soundDeepslateBrickFootstep);
        deepStaleBrickDoubleSlab = (BlockCTDeepSlateDoubleSlab) (new BlockCTDeepSlateDoubleSlab(getBlockID("deepStaleBrickDoubleSlab"), deepStaleBrickSingleSlab)).setStepSound(soundDeepslateBrickFootstep);
        ancientRelict = (BlockCTAncientRelict) new BlockCTAncientRelict(getBlockID("ancientRelict")).setHardness(2.5F).setStepSound(soundDeepslateFootstep);
        tungstenWorkBench = (WorkbenchBlock) new BlockCTWorkbench(getBlockID("tungstenWorkBench"), CTMaterials.tungsten, 0.55F, Material.ancient_metal).setStepSound(soundWoodFootstep);
        oreIronDeepslate = (new BlockIronOreDeepslate(getBlockID("oreIronDeepslate"), Material.iron, 2)).setHardness(3.0F).setStepSound(soundDeepslateFootstep);
        oreCoalDeepslate = (new BlockCoalOreDeepslate(getBlockID("oreCoalDeepslate"), Material.coal, 2)).setHardness(1.2F).setStepSound(soundDeepslateFootstep);
        oreLapisDeepslate = (new BlockLapisOreDeepslate(getBlockID("oreLapisDeepslate"), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundDeepslateFootstep);
        oreDiamondDeepslate = (new BlockDiamondOreDeepslate(getBlockID("oreDiamondDeepslate"), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundDeepslateFootstep);
        oreEmeraldDeepslate = (new BlockEmeraldOreDeepslate(getBlockID("oreEmeraldDeepslate"), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundDeepslateFootstep);
        oreCopperDeepslate = (new BlockCopperOreDeepslate(getBlockID("oreCopperDeepslate"), Material.copper, 2)).setHardness(2.5F).setStepSound(soundDeepslateFootstep);
        oreSilverDeepslate = (new BlockSilverOreDeepslate(getBlockID("oreSilverDeepslate"), Material.silver, 2)).setHardness(2.5F).setStepSound(soundDeepslateFootstep);
        oreMithrilDeepslate = (new BlockMithrilOreDeepslate(getBlockID("oreMithrilDeepslate"), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundDeepslateFootstep);
        oreAdamantiumDeepslate = (new BlockAdamantiumOreDeepslate(getBlockID("oreAdamantiumDeepslate"), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundDeepslateFootstep);
        oreTungstenDeepslate = (new BlockTungstenOreDeepslate(getBlockID("oreTungstenDeepslate"), CTMaterials.tungsten, 3)).setHardness(3.25F).setStepSound(soundDeepslateFootstep);
        oreGoldDeepslate = (new BlockGoldOreDeepslate(getBlockID("oreGoldDeepslate"), Material.gold, 2)).setHardness(2.4F).setStepSound(soundDeepslateFootstep);
        oreRedstoneDeepslate = (new BlockRedstoneOreDeepslate(getBlockID("oreRedstoneDeepslate"), false)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundDeepslateFootstep);
        deepslateSilverFish = (BlockCTDeepslateSilverFish) (new BlockCTDeepslateSilverFish(getBlockID("deepslateSilverFish"))).setHardness(1.0F).setStepSound(soundDeepslateFootstep);
        chestTungsten = new StrongBoxBlock(getBlockID("chestTungsten"), CTMaterials.tungsten).setStepSound(soundMetalFootstep);
        oreRedstoneDeepslateGlowing = (new BlockRedstoneOreDeepslate(getBlockID("oreRedstoneDeepslateGlowing"), false)).setHardness(3.0F).setResistance(5.0F).setLightValue(0.625F).setStepSound(soundDeepslateFootstep);
        peachPlanks = (BlockCTWood) (new BlockCTWood(getBlockID("peachPlanks"))).setResistance(5.0F).setStepSound(soundWoodFootstep);
        peachWood = (BlockCTLog) (new BlockCTLog(getBlockID("peachWood"))).setStepSound(soundWoodFootstep);
        peachLeaves = (BlockCTLeaves) (new BlockCTLeaves(getBlockID("peachLeaves"))).setHardness(0.2f).setLightOpacity(1).setStepSound(soundGrassFootstep);
        peachSapling = (new BlockCTSapling(getBlockID("peachSapling"))).setHardness(0.02F).setStepSound(soundGrassFootstep);
        peachPlanksSingleSlab = (BlockCTPeachPlanksSlabGroup) (new BlockCTPeachPlanksSlabGroup(getBlockID("peachPlanksSingleSlab"), Material.wood)).setStepSound(soundWoodFootstep);
        peachPlanksDoubleSlab = (BlockCTPeachPlanksDoubleSlab) (new BlockCTPeachPlanksDoubleSlab(getBlockID("peachPlanksDoubleSlab"), peachPlanksSingleSlab)).setStepSound(soundWoodFootstep);
        stairsPeachPlanks = (new StairsBlock(getBlockID("stairsPeachPlanks"), peachPlanks, 0)).setStepSound(soundWoodFootstep);
        snowBerry = (BlockCTSnowBerry) (new BlockCTSnowBerry(getBlockID("snowBerry"))).setHardness(0.05F).setStepSound(soundGrassFootstep);
        basalt = new BlockStone(getBlockID("basalt")).setHardness(2.5f).setResistance(10.0f).setStepSound(soundStoneFootstep);
    }
}
