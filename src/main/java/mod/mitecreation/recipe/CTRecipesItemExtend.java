package mod.mitecreation.recipe;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.item.ItemCTFishingRod;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

import static mod.mitecreation.init.CTRegistryInit.*;
import static net.minecraft.Item.getMatchingItem;

public class CTRecipesItemExtend {

    public static void registerBasicToolRecipes(CraftingRecipeRegisterEvent register, Material material) {
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
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemCTFishingRod.class, material)),true,
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

    public static void registerMITEToolRecipe(CraftingRecipeRegisterEvent register, Material material) {
        Item item = Item.getMatchingItem(ItemIngot.class, material);
        Item item_nugget = getMatchingItem(ItemNugget.class, item.getExclusiveMaterial());
        Item item_chain = Item.getMatchingItem(ItemChain.class, material);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemArrow.class, material)), true,
                "C",
                "B",
                "A",
                'A', Item.feather,
                'B', Item.stick,
                'C', item_nugget);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemChain.class, material)), true,
                " A ",
                "A A",
                " A ",
                'A', item_nugget);
        registerArmorRecipe(register, item_chain, material);
        register.registerShapedRecipe(new ItemStack(ItemBucket.getPeer(material, null)), true,
                "A A",
                " A ",
                'A', item);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemScythe.class, material)), true,
                "SA ",
                "S A",
                "S  ",
                'A', item,
                'S', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemMattock.class, material)), true,
                "AAA",
                " SA",
                " S ",
                'A', item,
                'S', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemHatchet.class, material)), true,
                "BA",
                "B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemWarHammer.class, material)), true,
                "AAA",
                "ABA",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemDagger.class, material)), true,
                "A",
                "B",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemBattleAxe.class, material)), true,
                "A A",
                "ABA",
                " B ",
                'A', item,
                'B', Item.stick);
        register.registerShapedRecipe(new ItemStack(Item.getMatchingItem(ItemDoor.class, material)), true,
                "AA",
                "AA",
                "AA",
                'A', item);
    }
    public static void registerArmorRecipe(CraftingRecipeRegisterEvent register, Item item, Material material){
        if(item instanceof ItemChain) {
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemHelmet.class, material,true)),true,
                    "AAA",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemCuirass.class, material,true)),true,
                    "A A",
                    "AAA",
                    "AAA",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemLeggings.class, material,true)),true,
                    "AAA",
                    "A A",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemBoots.class, material,true)),true,
                    "A A",
                    "A A",
                    'A',item);
        } else {
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemHelmet.class, material,false)),true,
                    "AAA",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemCuirass.class, material,false)),true,
                    "A A",
                    "AAA",
                    "AAA",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemLeggings.class, material,false)),true,
                    "AAA",
                    "A A",
                    "A A",
                    'A',item);
            register.registerShapedRecipe(new ItemStack(ItemArmor.getMatchingArmor(ItemBoots.class, material,false)),true,
                    "A A",
                    "A A",
                    'A',item);
        }
    }

    public static void registerNuggetToIngotRecipe(CraftingRecipeRegisterEvent register, Item item, Material material) {
        register.registerShapedRecipe(new ItemStack(getMatchingItem(ItemIngot.class, material)), true,
                "AAA",
                "AAA",
                "AAA",
                'A', item);
    }


        public static void registerFullMetalToolRecipe(CraftingRecipeRegisterEvent register, Material material) {
        registerBasicToolRecipes(register, material);
        registerMITEToolRecipe(register, material);
    }

    public static void registerRecipes(CraftingRecipeRegisterEvent register) {
        register.registerShapelessRecipe(new ItemStack(ingotTungsten, 9), true,
                blockTungsten);
        register.registerShapelessRecipe(new ItemStack(ingotRustedIron, 9), true,
                rustedIronBlock);
        register.registerShapelessRecipe(new ItemStack(rustedIronNugget, 9), true,
                ingotRustedIron);
        register.registerShapelessRecipe(new ItemStack(tungstenNugget, 9), true,
                ingotTungsten);

        registerFullMetalToolRecipe(register, CTMaterials.tungsten);
        registerNuggetToIngotRecipe(register, tungstenNugget, CTMaterials.tungsten);

        ItemCoin[] creationCoins = {coinRustedIron, coinIron, coinTungsten};
        for (ItemCoin coin : creationCoins) {
            for (int num = 1; num <= 9; num++) {
                register.registerShapelessRecipe(new ItemStack(coin.getNuggetPeer(), num), true, new ItemStack(coin, num)).difficulty(25);
            }
            register.registerShapelessRecipe(new ItemStack(coin), true, new ItemStack(coin.getNuggetPeer()));
        }

        register.registerShapelessRecipe(new ItemStack(CTRegistryInit.tungstenBucket, 1),
                false, CTRegistryInit.tungstenBucketStone).difficulty(100);
        register.registerShapelessRecipe(new ItemStack(CTRegistryInit.rustedIronBucketEmpty, 1),
                false, CTRegistryInit.rustedIronBucketStone).difficulty(100);

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
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.fishingRodRustedIron, 1), true, "  Q", " Q@", "QW@", Character.valueOf('Q'), Item.stick, Character.valueOf('@'), Item.silk, Character.valueOf('W'), CTRegistryInit.rustedIronNugget);

        for (int i = 0; i < Block.blocksList.length; i++) {
            Block block = Block.getBlock(i);
            if ((block instanceof BlockFlower || block instanceof BlockFlowerMulti) && !(block instanceof BlockDeadBush)) {
                register.registerShapedRecipe(new ItemStack(snowBerryPorridge, 1), true,
                        "SF",
                        "BF",
                        'F', block,
                        'B', Item.bowlEmpty,
                        'S', snowBerries);
            }
        }

        FurnaceRecipes.smelting().addSmelting(rawCopperNugget.itemID, new ItemStack(Item.copperNugget,1));
        Item.copperNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawSilverNugget.itemID, new ItemStack(Item.silverNugget,1));
        Item.silverNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawGoldNugget.itemID, new ItemStack(Item.goldNugget,1));
        Item.goldNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(rustedIronNugget.itemID, new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawRustedIronNugget.itemID, new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawAncientMetalNugget.itemID, new ItemStack(Item.ancientMetalNugget,1));
        Item.ancientMetalNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(rawMithrilNugget.itemID, new ItemStack(Item.mithrilNugget,1));
        Item.mithrilNugget.setXPReward(4);
        FurnaceRecipes.smelting().addSmelting(rawAdamantiumNugget.itemID, new ItemStack(Item.adamantiumNugget,1));
        Item.adamantiumNugget.setXPReward(10);
    }
}
