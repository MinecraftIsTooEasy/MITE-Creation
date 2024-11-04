package mod.mitecreation.init;

import huix.glacier.api.entrypoint.IGameRegistry;
import huix.glacier.api.registry.MinecraftRegistry;
import mod.mitecreation.block.*;
import mod.mitecreation.block.ore.normal.*;
import mod.mitecreation.creativetab.CreativeTabsCreationBlock;
import mod.mitecreation.creativetab.CreativeTabsCreationItem;
import mod.mitecreation.creativetab.CreativeTabsCreationTool;
import mod.mitecreation.item.CreationItemFishingRod;
import mod.mitecreation.item.ItemRawNugget;
import mod.mitecreation.material.CreationMaterials;
import moddedmite.rustedironcore.api.block.*;
import moddedmite.rustedironcore.api.item.IngotItem;
import net.minecraft.*;
import net.xiaoyu233.fml.api.block.AnvilBlock;
import net.xiaoyu233.fml.api.block.StrongBoxBlock;
import net.xiaoyu233.fml.api.item.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import static net.minecraft.Block.*;
import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class RegistryInit implements IGameRegistry {
    public static final CreativeTabs tabCreationBlock = new CreativeTabsCreationBlock();
    public static final CreativeTabs tabCreationItem = new CreativeTabsCreationItem();
    public static final CreativeTabs tabCreationTool = new CreativeTabsCreationTool();
    //TODO deepslate step sound
    public static final StepSound soundDeepslateFootstep = new StepSound("deepslate", 1.0F, 1.0F);

    public static final MinecraftRegistry registry = new MinecraftRegistry("Creation").initAutoItemRegister();
    
    public static Block rustedIronBlock;
    public static final BlockAnvil anvilRustedIron;
    public static final Block oreTungsten;
    public static final Block blockTungsten;
    public static final Block fenceTungsten;
    public static final Block doorTungsten;
    public static final BlockAnvil anvilTungsten;
    public static final BlockDeepStaleBrick deepStaleBrick;
    public static final BLockDeepSlateMagma deepStaleMagma;
    public static final Block cobbleDeepStale;
    public static final Block stairsCobbleDeepSlate;
    public static final Block stairsDeepSlateBrick;
    public static final BlockSandGravel gravelSand;
    public static final BlockDeepSlateGravel gravelDeepSlate;
    public static final Block cobbleDeepStaleWall;
    public static final Block deepStaleBrickWall;
    public static final Block deepSlate;
    public static final BlockCobbleDeepSlateSlabGroup cobbledDeepStaleSingleSlab;
    public static final BlockDeepSlateDoubleSlab cobbledDeepStaleDoubleSlab;
    public static final BlockDeepSlateBrickSlabGroup deepStaleBrickSingleSlab;
    public static final BlockDeepSlateDoubleSlab deepStaleBrickDoubleSlab;
    public static final BlockAncientRelict ancientRelict;
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
    public static final BlockDeepslateSilverFish deepslateSilverFish;
    public static final Block chestTungsten;
    
    public static final ItemCoin coinIron = (ItemCoin) createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.iron).setCreativeTab(tabCreationItem);
    public static final ItemCoin coinRustedIron = (ItemCoin) createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.rusted_iron).setCreativeTab(tabCreationItem);
    public static final NuggetItem rustedIronNugget = (NuggetItem) new NuggetItem(IdUtil.getNextItemID(), Material.rusted_iron).setCreativeTab(tabCreationItem);
    public static final IngotItem ingotRustedIron = (IngotItem) new IngotItem(IdUtil.getNextItemID(), Material.rusted_iron).setMaxStackSize(8).setCreativeTab(tabCreationItem);
    public static CreationItemFishingRod fishingRodRustedIron = (CreationItemFishingRod)(new CreationItemFishingRod(IdUtil.getNextItemID(), Material.rusted_iron)).setUnlocalizedName("fishingRod").setCreativeTab(tabCreationTool);
    public static final ItemRawNugget rawRustedIronNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.rusted_iron).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawCopperNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.copper).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawSilverNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.silver).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawGoldNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.gold).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawAncientMetalNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.ancient_metal).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawTungstenNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawMithrilNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.mithril).setCreativeTab(tabCreationItem);
    public static final ItemRawNugget rawAdamantiumNugget = (ItemRawNugget) new ItemRawNugget(IdUtil.getNextItemID(), Material.adamantium).setCreativeTab(tabCreationItem);
    public static final ItemNugget tungstenNugget = (ItemNugget) createInstance(ItemNugget.class, new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationItem);
    public static final Item ingotTungsten = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setXPReward(25).setCreativeTab(tabCreationItem);
    public static final ItemWarHammer warHammerTungsten = (ItemWarHammer) createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemBattleAxe battleAxeTungsten = (ItemBattleAxe) createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemSword swordTungsten = (ItemSword) createInstance(ItemSword.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemDagger daggerTungsten = (ItemDagger) createInstance(ItemDagger.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemPickaxe pickaxeTungsten = (ItemPickaxe) createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemShovel shovelTungsten = (ItemShovel) createInstance(ItemShovel.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemAxe axeTungsten = (ItemAxe) createInstance(ItemAxe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemHoe hoeTungsten = (ItemHoe) createInstance(ItemHoe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemKnife knifeTungsten = (ItemKnife) createInstance(ItemKnife.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemMattock mattockTungsten = (ItemMattock) createInstance(ItemMattock.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemScythe scytheTungsten = (ItemScythe) createInstance(ItemScythe.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemShears shearsTungsten = (ItemShears) createInstance(ItemShears.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemHatchet hatchetTungsten = (ItemHatchet) createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static CreationItemFishingRod fishingRodTungsten = (CreationItemFishingRod)(new CreationItemFishingRod(IdUtil.getNextItemID(), CreationMaterials.tungsten)).setUnlocalizedName("fishingRod").setCreativeTab(tabCreationTool);
    public static final ItemArmor helmetTungsten = (ItemArmor) new ItemHelmet(IdUtil.getNextItemID(), CreationMaterials.tungsten,false).setCreativeTab(tabCreationTool);
    public static final ItemArmor helmetChainTungsten = (ItemArmor) new ItemHelmet(IdUtil.getNextItemID(), CreationMaterials.tungsten,true).setCreativeTab(tabCreationTool);
    public static final ItemArmor plateTungsten = (ItemArmor) new ItemCuirass(IdUtil.getNextItemID(), CreationMaterials.tungsten,false).setCreativeTab(tabCreationTool);
    public static final ItemArmor plateChainTungsten = (ItemArmor) new ItemCuirass(IdUtil.getNextItemID(), CreationMaterials.tungsten,true).setCreativeTab(tabCreationTool);
    public static final ItemArmor legsTungsten = (ItemArmor) new ItemLeggings(IdUtil.getNextItemID(), CreationMaterials.tungsten,false).setCreativeTab(tabCreationTool);
    public static final ItemArmor legsChainTungsten = (ItemArmor) new ItemLeggings(IdUtil.getNextItemID(), CreationMaterials.tungsten,true).setCreativeTab(tabCreationTool);
    public static final ItemArmor bootsTungsten = (ItemArmor) new ItemBoots(IdUtil.getNextItemID(), CreationMaterials.tungsten,false).setCreativeTab(tabCreationTool);
    public static final ItemArmor bootsChainTungsten = (ItemArmor) new ItemBoots(IdUtil.getNextItemID(), CreationMaterials.tungsten,true).setCreativeTab(tabCreationTool);
    public static final Item doorTungstenItem = new ItemDoor(IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationBlock);
    public static final ItemChain chainTungsten = (ItemChain) createInstance(ItemChain.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationItem);
    public static final ItemCoin coinTungsten = (ItemCoin) createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationItem);
    public static final ItemArrow arrowTungsten = (ItemArrow) new ItemArrow(IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);
    public static final ItemBucket tungstenBucket = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), CreationMaterials.tungsten, null).setCreativeTab(tabCreationTool);
    public static final ItemBucket tungstenBucketWater = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), CreationMaterials.tungsten, Material.water).setContainerItem(tungstenBucket).setCreativeTab(tabCreationTool);
    public static final ItemBucket tungstenBucketLava = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), CreationMaterials.tungsten, Material.lava).setContainerItem(tungstenBucket).setCreativeTab(tabCreationTool);
    public static final ItemBucket tungstenBucketStone = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), CreationMaterials.tungsten, Material.stone).setContainerItem(tungstenBucket).setCreativeTab(tabCreationTool);
    public static final ItemBucketMilk tungstenBucketMilk = (ItemBucketMilk) (new ItemBucketMilk(IdUtil.getNextItemID(), CreationMaterials.tungsten)).setContainerItem(tungstenBucket).setCreativeTab(tabCreationTool);
//    public static final Item rustedIronItemBlock = new ItemBlock(rustedIronBlock).setMaxStackSize(4).setCreativeTab(tabCreationBlock);
    public static final ItemClub clubStone = (ItemClub) createInstance(ItemClub.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.stone).setCreativeTab(tabCreationTool);
    public static final ItemDagger daggerStone = (ItemDagger) createInstance(ItemDagger.class,new Class[]{int.class,Material.class},IdUtil.getNextItemID(), CreationMaterials.stone).setCreativeTab(tabCreationTool);
    public static final ItemBucket woodBucketEmpty = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.wood,null).setCreativeTab(tabCreationTool);
    public static final ItemBucket woodBucketWater = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.wood, Material.water).setContainerItem(woodBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemBucketMilk woodBucketMilk = (ItemBucketMilk) new ItemBucketMilk(IdUtil.getNextItemID(), Material.wood).setContainerItem(woodBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemBucket rustedIronBucketEmpty = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, null).setCreativeTab(tabCreationTool);
    public static final ItemBucket rustedIronBucketWater = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.water).setContainerItem(rustedIronBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemBucket rustedIronBucketLava = (ItemBucket)new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.lava).setContainerItem(rustedIronBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemBucket rustedIronBucketStone = (ItemBucket) new ItemBucket(IdUtil.getNextItemID(), Material.rusted_iron, Material.stone).setContainerItem(rustedIronBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemBucketMilk rustedIronBucketMilk = (ItemBucketMilk)(new ItemBucketMilk(IdUtil.getNextItemID(), Material.rusted_iron)).setContainerItem(rustedIronBucketEmpty).setCreativeTab(tabCreationTool);
    public static final ItemSword swordEmerald = (ItemSword) createInstance(ItemSword.class,new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.emerald).setCreativeTab(tabCreationTool);
    public static final ItemSword swordDiamond = (ItemSword) createInstance(ItemSword.class,new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), Material.diamond).setCreativeTab(tabCreationTool);
    public static ItemHorseArmor horseArmorTungsten = (ItemHorseArmor) createInstance(ItemHorseArmor.class,new Class[]{int.class, Material.class}, IdUtil.getNextItemID(), CreationMaterials.tungsten).setCreativeTab(tabCreationTool);


    @Override
    public void onGameRegistry() {
        //Register Items
        registry.registerItem("coins/iron", coinIron);
        registry.registerItem("coins/rusted_iron", coinRustedIron);
        registry.registerItem("nuggets/rusted_iron", rustedIronNugget);
        registry.registerItem("ingots/rusted_iron", ingotRustedIron);
        registry.registerItem("fishing_rods/rusted_iron_uncast", fishingRodRustedIron).setLowestCraftingDifficultyToProduce(Item.flint.getLowestCraftingDifficultyToProduce());
//        registry.registerItem("rusted_iron_block", rustedIronItemBlock);
        registry.registerItem("ingots/tungsten", ingotTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("nuggets/tungsten", tungstenNugget).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_helmet", helmetTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_chestplate", plateTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_leggings", legsTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_boots", bootsTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_chainmail_helmet", helmetChainTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_chainmail_chestplate", plateChainTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_chainmail_leggings", legsChainTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/tungsten_chainmail_boots", bootsChainTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("armor/horse/tungsten", horseArmorTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_battle_axe", battleAxeTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_dagger", daggerTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_sword", swordTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_war_hammer", warHammerTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_axe", axeTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_hatchet", hatchetTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_hoe", hoeTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_knife", knifeTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_pickaxe", pickaxeTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_mattock", mattockTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_scythe", scytheTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_shears", shearsTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/tungsten/tungsten_shovel", shovelTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("fishing_rods/tungsten_uncast", fishingRodTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("doors/tungsten", doorTungstenItem).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("chains/tungsten", chainTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("coins/tungsten", coinTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("arrows/tungsten", arrowTungsten).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("buckets/tungsten/empty", tungstenBucket).setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
        registry.registerItem("buckets/tungsten/lava", tungstenBucketLava);
        registry.registerItem("buckets/tungsten/milk", tungstenBucketMilk);
        registry.registerItem("buckets/tungsten/stone", tungstenBucketStone);
        registry.registerItem("buckets/tungsten/water", tungstenBucketWater);
        registry.registerItem("raw_nuggets/rusted_iron", rawRustedIronNugget);
        registry.registerItem("raw_nuggets/copper", rawCopperNugget);
        registry.registerItem("raw_nuggets/silver", rawSilverNugget);
        registry.registerItem("raw_nuggets/gold", rawGoldNugget);
        registry.registerItem("raw_nuggets/ancient_metal", rawAncientMetalNugget);
        registry.registerItem("raw_nuggets/tungsten", rawTungstenNugget);
        registry.registerItem("raw_nuggets/mithril", rawMithrilNugget);
        registry.registerItem("raw_nuggets/adamantium", rawAdamantiumNugget);
        registry.registerItem("tools/stone/stone_club", clubStone).setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());
        registry.registerItem("tools/stone/stone_dagger", daggerStone).setLowestCraftingDifficultyToProduce(Item.clubWood.getLowestCraftingDifficultyToProduce());
        registry.registerItem("buckets/wood/empty", woodBucketEmpty);
        registry.registerItem("buckets/wood/water", woodBucketWater);
        registry.registerItem("buckets/wood/milk", woodBucketMilk);
        registry.registerItem("buckets/rusted_iron/empty", rustedIronBucketEmpty);
        registry.registerItem("buckets/rusted_iron/lava", rustedIronBucketLava);
        registry.registerItem("buckets/rusted_iron/milk", rustedIronBucketMilk);
        registry.registerItem("buckets/rusted_iron/stone", rustedIronBucketStone);
        registry.registerItem("buckets/rusted_iron/water", rustedIronBucketWater);
        registry.registerItem("tools/emerald/emerald_sword", swordEmerald);
        registry.registerItem("tools/diamond/diamond_sword", swordDiamond);

        //Register Blocks
        registry.registerBlock(rustedIronBlock, "rusted_iron_block");
        registry.registerBlockAnvil(anvilRustedIron, "rusted_iron_anvil");
        registry.registerBlockAnvil(anvilTungsten, "tungsten_anvil");
        registry.registerBlock(oreTungsten, "ore/tungsten_ore");
        registry.registerBlock(blockTungsten, "block/tungsten_block");
        registry.registerBlock(fenceTungsten, "bars/tungsten_bars");
        registry.registerBlock(doorTungsten, "door/door_tungsten");
        registry.registerBlock(deepStaleBrick, "deepslate_brick");
        registry.registerBlock(deepStaleMagma, "deepslate_brick_magma");
        registry.registerBlock(cobbleDeepStale, "cobble_deepslate");
        registry.registerBlock(stairsCobbleDeepSlate, "cobble_deepslate_stairs");
        registry.registerBlock(stairsDeepSlateBrick, "deepslate_brick_stairs");
        registry.registerBlock(cobbleDeepStaleWall, "cobble_deepslate_wall");
        registry.registerBlock(deepStaleBrickWall, "deepslate_brick_wall");
        registry.registerBlock(gravelSand, "sand_gravel");
        registry.registerBlock(gravelDeepSlate, "deepslate_gravel");
        registry.registerBlock(deepSlate, "deepslate");
        registry.registerBlock(cobbledDeepStaleSingleSlab, "cobbledDeepslateSlab");
        registry.registerBlock(cobbledDeepStaleDoubleSlab, "cobbledDeepslateSlab");
        registry.registerBlock(deepStaleBrickSingleSlab, "deepslateBrickSlab");
        registry.registerBlock(deepStaleBrickDoubleSlab, "deepslateBrickSlab");
        registry.registerBlock(ancientRelict, "ancient_relict");
        registry.registerBlock(tungstenWorkBench, "toolbench.tungsten");
        registry.registerBlock(oreIronDeepslate, "ore/normal/iron_ore_normal");
        registry.registerBlock(oreCoalDeepslate, "ore/normal/coal_ore_normal");
        registry.registerBlock(oreLapisDeepslate, "ore/normal/lapis_ore_normal");
        registry.registerBlock(oreDiamondDeepslate, "ore/normal/diamond_ore_normal");
        registry.registerBlock(oreEmeraldDeepslate, "ore/normal/emerald_ore_normal");
        registry.registerBlock(oreCopperDeepslate, "ore/normal/copper_ore_normal");
        registry.registerBlock(oreSilverDeepslate, "ore/normal/silver_ore_normal");
        registry.registerBlock(oreMithrilDeepslate, "ore/normal/mithril_ore_normal");
        registry.registerBlock(oreAdamantiumDeepslate, "ore/normal/adamantium_ore_normal");
        registry.registerBlock(oreTungstenDeepslate, "ore/normal/tungsten_ore_normal");
        registry.registerBlock(oreGoldDeepslate, "ore/normal/gold_ore_normal");
        registry.registerBlock(oreRedstoneDeepslate, "ore/normal/redstone_ore_normal");
        registry.registerBlock(deepslateSilverFish, "monsterDeepslateEgg");
        registry.registerBlock(chestTungsten, "tungsten_chest");
    }
    static {
        rustedIronBlock = new BlockOreStorage(IdUtil.getNextBlockID(), Material.rusted_iron).setCreativeTab(tabCreationBlock);

        anvilRustedIron = (BlockAnvil) new AnvilBlock(IdUtil.getNextBlockID(), Material.rusted_iron).setStepSound(soundAnvilFootstep).setCreativeTab(tabCreationBlock);

        oreTungsten = (new BlockOre(IdUtil.getNextBlockID(), CreationMaterials.tungsten, 4))
                .setHardness(3.25F).setResistance(15.0F).setCreativeTab(tabCreationBlock);

        blockTungsten = (new BlockOreStorage(IdUtil.getNextBlockID(), CreationMaterials.tungsten))
                .setStepSound(soundMetalFootstep).setCreativeTab(tabCreationBlock);

        fenceTungsten = (new PaneBlock(IdUtil.getNextBlockID(), "bars/tungsten_bars", "bars/tungsten_bars", CreationMaterials.tungsten, false))
                .setStepSound(soundMetalFootstep).setResistance(24.0F).setHardness(12.8F).setMinHarvestLevel(4).setCreativeTab(tabCreationBlock);

        doorTungsten = (new DoorBlock(IdUtil.getNextBlockID(), CreationMaterials.tungsten, () -> Item.getItem(RegistryInit.doorTungsten)))
                .setStepSound(soundMetalFootstep).setMinHarvestLevel(4).setCreativeTab(tabCreationBlock);

        anvilTungsten = (BlockAnvil) new AnvilBlock(IdUtil.getNextBlockID(), CreationMaterials.tungsten).setStepSound(soundAnvilFootstep).setCreativeTab(tabCreationBlock);

        deepStaleBrick = (BlockDeepStaleBrick) (new BlockDeepStaleBrick(IdUtil.getNextBlockID()))
                .setHardness(1.8F).setResistance(15.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("deepStaleBrick").setTextureName("deepstale_brick").setCreativeTab(tabCreationBlock);

        deepStaleMagma = (BLockDeepSlateMagma) (new BLockDeepSlateMagma(IdUtil.getNextBlockID()))
                .setHardness(1.8F).setResistance(15.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("deepStaleMagma").setTextureName("deepslatemagma").setCreativeTab(tabCreationBlock);

        cobbleDeepStale = (new CreationBlock(IdUtil.getNextBlockID(), Material.stone, new BlockConstants()))
                .setHardness(2.5F).setResistance(15.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("cobbleDeepStale").setCreativeTab(CreativeTabs.tabBlock).setTextureName("cobbledeepstale").setCreativeTab(tabCreationBlock);

        stairsCobbleDeepSlate = (new StairsBlock(IdUtil.getNextBlockID(), cobbleDeepStale, 0)).setUnlocalizedName("stairsDeepSlate").setCreativeTab(tabCreationBlock);

        stairsDeepSlateBrick = (new StairsBlock(IdUtil.getNextBlockID(), deepStaleBrick, 0)).setUnlocalizedName("stairsDeepSlateBrick").setCreativeTab(tabCreationBlock);

        cobbleDeepStaleWall = new WallBlock(IdUtil.getNextBlockID(), cobbleDeepStale).setHardness(2.5F).setResistance(15.0F)
                .setUnlocalizedName("cobbleDeepSlateWall").setCreativeTab(tabCreationBlock);

        deepStaleBrickWall = new WallBlock(IdUtil.getNextBlockID(), deepStaleBrick).setHardness(1.8F).setResistance(15.0F)
                .setUnlocalizedName("deepSlateBrickWall").setCreativeTab(tabCreationBlock);

        gravelSand = (BlockSandGravel) (new BlockSandGravel(IdUtil.getNextBlockID())).setHardness(0.6F)
                .setStepSound(soundSandFootstep).setUnlocalizedName("gravelSand").setCreativeTab(CreativeTabs.tabBlock)
                .setTextureName("gravelSand").setCreativeTab(tabCreationBlock);

        gravelDeepSlate = (BlockDeepSlateGravel) (new BlockDeepSlateGravel(IdUtil.getNextBlockID())).setHardness(0.8F)
                .setStepSound(soundSandFootstep).setUnlocalizedName("gravelDeepSlate").setCreativeTab(CreativeTabs.tabBlock)
                .setTextureName("gravelDeepSlate").setCreativeTab(tabCreationBlock);

        deepSlate = (new BlockDeepSlate(3348))
                .setHardness(3.0F).setResistance(15.0F).setStepSound(soundDeepslateFootstep).setUnlocalizedName("deepSlate").setTextureName("deepSlate").setCreativeTab(tabCreationBlock);

        cobbledDeepStaleSingleSlab = (BlockCobbleDeepSlateSlabGroup) (new BlockCobbleDeepSlateSlabGroup(IdUtil.getNextBlockID(), Material.stone))
                .setStepSound(soundDeepslateFootstep).setCreativeTab(tabCreationBlock);

        cobbledDeepStaleDoubleSlab = (BlockDeepSlateDoubleSlab) (new BlockDeepSlateDoubleSlab(IdUtil.getNextBlockID(), cobbledDeepStaleSingleSlab))
                .setStepSound(soundDeepslateFootstep).setCreativeTab(tabCreationBlock);

        deepStaleBrickSingleSlab = (BlockDeepSlateBrickSlabGroup) (new BlockDeepSlateBrickSlabGroup(IdUtil.getNextBlockID(), Material.stone))
                .setStepSound(soundDeepslateFootstep).setCreativeTab(tabCreationBlock);

        deepStaleBrickDoubleSlab = (BlockDeepSlateDoubleSlab) (new BlockDeepSlateDoubleSlab(IdUtil.getNextBlockID(), deepStaleBrickSingleSlab))
                .setStepSound(soundDeepslateFootstep).setCreativeTab(tabCreationBlock);

        ancientRelict = (BlockAncientRelict) new BlockAncientRelict(IdUtil.getNextBlockID()).setHardness(2.5F).setCreativeTab(CreativeTabs.tabBlock)
                .setStepSound(soundDeepslateFootstep).setUnlocalizedName("ancientRelict").setCreativeTab(tabCreationBlock);

        tungstenWorkBench = new WorkbenchBlock(IdUtil.getNextBlockID(), CreationMaterials.tungsten, 0.55F, Material.ancient_metal);
        oreIronDeepslate = (new BlockIronOreDeepslate(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreIron").setTextureName("iron_ore").setCreativeTab(tabCreationBlock);

        oreCoalDeepslate = (new BlockCoalOreDeepslate(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreCoal").setTextureName("coal_ore").setCreativeTab(tabCreationBlock);

        oreLapisDeepslate = (new BlockLapisOreDeepslate(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreLapis").setTextureName("lapis_ore").setCreativeTab(tabCreationBlock);

        oreDiamondDeepslate = (new BlockDiamondOreDeepslate(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore").setCreativeTab(tabCreationBlock);

        oreEmeraldDeepslate = (new BlockEmeraldOreDeepslate(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore").setCreativeTab(tabCreationBlock);

        oreCopperDeepslate = (new BlockCopperOreDeepslate(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreCopper").setTextureName("copper_ore").setCreativeTab(tabCreationBlock);

        oreSilverDeepslate = (new BlockSilverOreDeepslate(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreSilver").setTextureName("silver_ore").setCreativeTab(tabCreationBlock);

        oreMithrilDeepslate = (new BlockMithrilOreDeepslate(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore").setCreativeTab(tabCreationBlock);

        oreAdamantiumDeepslate = (new BlockAdamantiumOreDeepslate(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore").setCreativeTab(tabCreationBlock);

        oreTungstenDeepslate = (new BlockTungstenOreDeepslate(IdUtil.getNextBlockID(), CreationMaterials.tungsten, 3)).setHardness(3.25F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore").setCreativeTab(tabCreationBlock);

        oreGoldDeepslate = (new BlockGoldOreDeepslate(IdUtil.getNextBlockID(), Material.gold, 2)).setHardness(2.4F).setStepSound(soundDeepslateFootstep)
                .setUnlocalizedName("oreGold").setTextureName("gold_ore").setCreativeTab(tabCreationBlock);

        oreRedstoneDeepslate = (new BlockRedstoneOreDeepslate(IdUtil.getNextBlockID(), false)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundDeepslateFootstep)
                .setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("oreRedstone").setTextureName("redstone_ore").setCreativeTab(tabCreationBlock);

        deepslateSilverFish = (BlockDeepslateSilverFish) (new BlockDeepslateSilverFish(IdUtil.getNextBlockID())).setHardness(1.0F).setUnlocalizedName("monsterDeepslateEgg").setCreativeTab(tabCreationBlock);

        chestTungsten = new StrongBoxBlock(IdUtil.getNextBlockID(), CreationMaterials.tungsten).setStepSound(soundMetalFootstep).setUnlocalizedName("chestTungsten").setCreativeTab(tabCreationBlock);
    }
}
