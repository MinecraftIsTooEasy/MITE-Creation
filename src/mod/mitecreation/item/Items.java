package mod.mitecreation.item;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.materil.Materials;
import mod.mitecreation.mixin.recipe.CraftingManagerInvoker;
import mod.mitecreation.util.RecipeRegister;
import mod.mitecreation.util.Util;
import net.minecraft.*;
import net.xiaoyu233.fml.FishModLoader;

import static net.minecraft.Item.getMatchingItem;
import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class Items {
    public static final ItemCoin coinIron = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Util.getNextItemID(), Materials.iron);

    public static final ItemNuggets rustedIronNugget = new ItemNuggets(Util.getNextItemID(),Material.rusted_iron);
    public static final ItemIngots rustedIronIngot = new ItemIngots(Util.getNextItemID(),Material.rusted_iron);

    public static final ItemRawNugget rawRustedIronNugget = new ItemRawNugget(Util.getNextItemID(),Material.rusted_iron);
    public static final ItemRawNugget rawCopperNugget = new ItemRawNugget(Util.getNextItemID(),Material.copper);
    public static final ItemRawNugget rawSilverNugget = new ItemRawNugget(Util.getNextItemID(),Material.silver);
    public static final ItemRawNugget rawGoldNugget = new ItemRawNugget(Util.getNextItemID(),Material.gold);
    public static final ItemRawNugget rawAncientMetalNugget = new ItemRawNugget(Util.getNextItemID(),Material.ancient_metal);
    public static final ItemRawNugget rawTungstenNugget = new ItemRawNugget(Util.getNextItemID(), Materials.tungsten);
    public static final ItemRawNugget rawMithrilNugget = new ItemRawNugget(Util.getNextItemID(),Material.mithril);
    public static final ItemRawNugget rawAdamantiumNugget = new ItemRawNugget(Util.getNextItemID(),Material.adamantium);

    public static final ItemArmor tungstenHelmet = new ItemHelmet(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenChestplate = new ItemCuirass(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenLeggings = new ItemLeggings(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenBoots = new ItemBoots(Util.getNextItemID(),Materials.tungsten,false);
    public static final ItemArmor tungstenHelmetChain = new ItemHelmet(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenChestplateChain = new ItemCuirass(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenLeggingsChain = new ItemLeggings(Util.getNextItemID(),Materials.tungsten,true);
    public static final ItemArmor tungstenBootsChain = new ItemBoots(Util.getNextItemID(),Materials.tungsten,true);

    public static final ItemNugget tungstenNugget = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final Item tungstenIngot = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten).setXPReward(75);

    public static final ItemWarHammer tungstenWarHammer = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemBattleAxe tungstenBattleAxe = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemSword tungstenSword = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Util.getNextItemID(), Materials.tungsten);
    public static final ItemDagger tungstenDagger = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemPickaxe tungstenPickaxe = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemShovel tungstenShovel = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemAxe tungstenAxe = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemHoe tungstenHoe = createInstance(ItemHoe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemKnife tungstenKnife = createInstance(ItemKnife.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemMattock tungstenMattock = createInstance(ItemMattock.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemScythe tungstenScythe = createInstance(ItemScythe.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemShears tungstenShears = createInstance(ItemShears.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemHatchet tungstenHatchet = createInstance(ItemHatchet.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static ItemFishingRod fishingRodTungsten = (ItemFishingRod)(new ItemFishingRod(Util.getNextItemID(), Materials.tungsten)).setUnlocalizedName("fishingRod");

    public static final Item doorTungsten= new ItemDoor(Util.getNextItemID(), Materials.tungsten);
    public static final ItemChain tungstenChain = createInstance(ItemChain.class,new Class[]{int.class,Material.class},Util.getNextItemID(),Materials.tungsten);
    public static final ItemCoin coinTungsten = createInstance(ItemCoin.class, new Class[]{int.class, Material.class}, Util.getNextItemID(), Materials.tungsten);
    public static final ItemArrow arrowTungsten = new ItemArrow(Util.getNextItemID(), Materials.tungsten);

    public static final ItemBucket tungstenBucket = new ItemBucket(Util.getNextItemID(), Materials.tungsten, null);
    public static final ItemBucket tungstenBucketWater = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.water).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketLava = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.lava).setContainerItem(tungstenBucket);
    public static final ItemBucket tungstenBucketStone = (ItemBucket)new ItemBucket(Util.getNextItemID(), Materials.tungsten, Material.stone).setContainerItem(tungstenBucket);
    public static final yi tungstenBucketMilk = (yi)(new yi(Util.getNextItemID(), Materials.tungsten)).setContainerItem(tungstenBucket);

    public static final Item rustedIronBlock = new ItemBlock(Blocks.rustedIronBlock);
    //public static final Item rustedIronAnvil = new ItemAnvil(Blocks.rustedIronAnvil);
    
    public static void itemRegister() {
        if(true){
            return;
        }
        if(false) {
            register("coins/iron", coinIron, CreativeModeTab.tabMisc);

            register("nuggets/rusted_iron", rustedIronNugget, CreativeModeTab.tabMaterials);
            register("ingots/rusted_iron", rustedIronIngot, CreativeModeTab.tabMaterials);
            rustedIronIngot.setMaxStackSize(8);

            register("rusted_iron_block", rustedIronBlock, CreativeModeTab.tabBlock);
            rustedIronBlock.setMaxStackSize(4);
            //register("rusted_iron_anvil", rustedIronAnvil, CreativeModeTab.tabDecorations);
            //rustedIronAnvil.setMaxStackSize(1);

            register("ingot/tungsten", tungstenIngot, CreativeModeTab.tabMaterials);
            tungstenIngot.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("ingot/nugget/tungsten", tungstenNugget, CreativeModeTab.tabMaterials);
            tungstenNugget.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

            register("armor/tungsten_helmet", tungstenHelmet, CreativeModeTab.tabCombat);
            tungstenHelmet.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_chestplate", tungstenChestplate, CreativeModeTab.tabCombat);
            tungstenChestplate.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_leggings", tungstenLeggings, CreativeModeTab.tabCombat);
            tungstenLeggings.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_boots", tungstenBoots, CreativeModeTab.tabCombat);
            tungstenBoots.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_chainmail_helmet", tungstenHelmetChain, CreativeModeTab.tabCombat);
            tungstenHelmetChain.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_chainmail_chestplate", tungstenChestplateChain, CreativeModeTab.tabCombat);
            tungstenChestplateChain.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_chainmail_leggings", tungstenLeggingsChain, CreativeModeTab.tabCombat);
            tungstenLeggingsChain.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("armor/tungsten_chainmail_boots", tungstenBootsChain, CreativeModeTab.tabCombat);
            tungstenBootsChain.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

            register("tools/tungsten/tungsten_battle_axe", tungstenBattleAxe, CreativeModeTab.tabCombat);
            tungstenBattleAxe.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_dagger", tungstenDagger, CreativeModeTab.tabCombat);
            tungstenDagger.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_sword", tungstenSword, CreativeModeTab.tabCombat);
            tungstenSword.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_war_hammer", tungstenWarHammer, CreativeModeTab.tabCombat);
            tungstenWarHammer.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

            register("tools/tungsten/tungsten_axe", tungstenAxe, CreativeModeTab.tabTools);
            tungstenAxe.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_hatchet", tungstenHatchet, CreativeModeTab.tabTools);
            tungstenHatchet.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_hoe", tungstenHoe, CreativeModeTab.tabTools);
            tungstenHoe.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_knife", tungstenKnife, CreativeModeTab.tabTools);
            tungstenKnife.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_pickaxe", tungstenPickaxe, CreativeModeTab.tabTools);
            tungstenPickaxe.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_mattock", tungstenMattock, CreativeModeTab.tabTools);
            tungstenMattock.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_scythe", tungstenScythe, CreativeModeTab.tabTools);
            tungstenScythe.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_shears", tungstenShears, CreativeModeTab.tabTools);
            tungstenShears.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("tools/tungsten/tungsten_shovel", tungstenShovel, CreativeModeTab.tabTools);
            tungstenShovel.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("items/fishing_rods/tungsten_uncast", fishingRodTungsten, CreativeModeTab.tabTools);
            fishingRodTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

            register("doors/tungsten", doorTungsten, CreativeModeTab.tabRedstone);
            doorTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("chains/tungsten", tungstenChain, CreativeModeTab.tabMaterials);
            tungstenChain.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("coins/tungsten", coinTungsten, CreativeModeTab.tabMisc);
            coinTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("arrows/tungsten", arrowTungsten, CreativeModeTab.tabCombat);
            arrowTungsten.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());

            register("buckets/tungsten/empty", tungstenBucket, CreativeModeTab.tabMisc);
            tungstenBucket.setLowestCraftingDifficultyToProduce(Item.ingotAncientMetal.getLowestCraftingDifficultyToProduce());
            register("buckets/tungsten/lava", tungstenBucketLava, CreativeModeTab.tabMisc);
            register("buckets/tungsten/milk", tungstenBucketMilk, CreativeModeTab.tabMisc);
            register("buckets/tungsten/stone", tungstenBucketStone, CreativeModeTab.tabMisc);
            register("buckets/tungsten/water", tungstenBucketWater, CreativeModeTab.tabMisc);

            register("raw_nuggets/rusted_iron", rawRustedIronNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/copper", rawCopperNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/silver", rawSilverNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/gold", rawGoldNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/ancient_metal", rawAncientMetalNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/ancient_metal", rawAncientMetalNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/tungsten", rawTungstenNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/mithril", rawMithrilNugget, CreativeModeTab.tabMaterials);
            register("raw_nuggets/adamantium", rawAdamantiumNugget, CreativeModeTab.tabMaterials);
        }
        
    }
    public static void recipeRegister(CraftingManager c) {
        c.addShapelessRecipeP(new ItemStack(rustedIronNugget,1),true,Item.arrowRustedIron);
        c.addShapelessRecipeP(new ItemStack(rustedIronIngot,1),true,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget,rustedIronNugget);
        c.addShapelessRecipeP(new ItemStack(rustedIronNugget,9),true,rustedIronIngot);
        //c.addRecipeP(new ItemStack(rustedIronAnvil,1),true,"###","@$@","$$$",Character.valueOf('#'),rustedIronBlock,Character.valueOf('$'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.axeRustedIron,1),true,"QQ@","QS@","@S@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('S'),Item.stick);
        c.addRecipeP(new ItemStack(Item.axeRustedIron,1),true,"@QQ","@SQ","@S@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('S'),Item.stick);
        c.addRecipeP(new ItemStack(Item.arrowRustedIron,1),true,"@Q@","@W@","@E@",Character.valueOf('Q'),rustedIronNugget,Character.valueOf('W'),Item.stick,Character.valueOf('E'),Item.feather);
        c.addRecipeP(new ItemStack(Item.bootsRustedIron,1),true,"@@@","Q@Q","Q@Q",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.bootsRustedIron,1),true,"Q@Q","Q@Q","@@@",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.chainRustedIron,1),true,"@Q@","Q@Q","@Q@",Character.valueOf('Q'),rustedIronNugget);
        c.addRecipeP(new ItemStack(Item.daggerRustedIron,1),true,"@Q","@W",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.daggerRustedIron,1),true,"Q@","W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.battleAxeRustedIron,1),true,"Q@Q","QWQ","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hatchetRustedIron,1),true,"QW","@W",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hatchetRustedIron,1),true,"WQ","W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron,1),true,"QQ@","@W@","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron,1),true,"@QQ","@W@","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron,1),true,"@QQ","@@W","@@W",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.hoeRustedIron,1),true,"QQ@","W@@","W@@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.mattockRustedIron,1),true,"QQQ","@WQ","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.pickaxeRustedIron,1),true,"QQQ","@W@","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.scytheRustedIron,1),true,"WQ@","W@Q","W@@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        //c.addRecipeP(new ItemStack(rustedIronAnvil,1),true,"QQQ","@W@","WWW",Character.valueOf('Q'),rustedIronBlock,Character.valueOf('W'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.shearsRustedIron,1),true,"Q@","@Q",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.shearsRustedIron,1),true,"@Q","Q@",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron,1),true,"@Q@","@W@","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron,1),true,"Q@@","W@@","W@@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.shovelRustedIron,1),true,"@@Q","@@W","@@W",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron,1),true,"Q@@","Q@@","W@@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron,1),true,"@Q@","@Q@","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.swordRustedIron,1),true,"@@Q","@@Q","@@W",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(Item.warHammerRustedIron,1),true,"QQQ","QWQ","@W@",Character.valueOf('Q'),rustedIronIngot,Character.valueOf('W'),Item.stick);
        c.addRecipeP(new ItemStack(rustedIronBlock,1),true,"QQQ","QQQ","QQQ",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.helmetRustedIron,1),true,"QQQ","Q@Q",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.legsRustedIron,1),true,"QQQ","Q@Q","Q@Q",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.plateRustedIron,1),true,"Q@Q","QQQ","QQQ",Character.valueOf('Q'),rustedIronIngot);
        c.addRecipeP(new ItemStack(Item.helmetChainRustedIron,1),true,"QQQ","Q@Q",Character.valueOf('Q'),Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.bootsChainRustedIron,1),true,"Q@Q","Q@Q",Character.valueOf('Q'),Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.legsChainRustedIron,1),true,"QQQ","Q@Q","Q@Q",Character.valueOf('Q'),Item.chainRustedIron);
        c.addRecipeP(new ItemStack(Item.plateChainRustedIron,1),true,"Q@Q","QQQ","QQQ",Character.valueOf('Q'),Item.chainRustedIron);

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
        if(item instanceof ItemChain){
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
        }else {
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
//        registerMITEToolRecipe(register,material);
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
