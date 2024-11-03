package mod.mitecreation.recipe;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.FurnaceRecipes;
import net.minecraft.Item;
import net.minecraft.ItemStack;

public class FurnaceRecipesExtend {

    public static void furnaceRecipeRegister() {
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawCopperNugget.itemID,new ItemStack(Item.copperNugget,1));
        Item.copperNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawSilverNugget.itemID,new ItemStack(Item.silverNugget,1));
        Item.silverNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawGoldNugget.itemID,new ItemStack(Item.goldNugget,1));
        Item.goldNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawRustedIronNugget.itemID,new ItemStack(Item.ironNugget, 1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawAncientMetalNugget.itemID,new ItemStack(Item.ancientMetalNugget, 1));
        Item.ancientMetalNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawTungstenNugget.itemID,new ItemStack(RegistryInit.tungstenNugget, 1));
        RegistryInit.tungstenNugget.setXPReward(3);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawMithrilNugget.itemID,new ItemStack(Item.mithrilNugget, 1));
        Item.mithrilNugget.setXPReward(4);
        FurnaceRecipes.smelting().addSmelting(RegistryInit.rawAdamantiumNugget.itemID,new ItemStack(Item.adamantiumNugget, 1));
        Item.adamantiumNugget.setXPReward(10);

        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreTungsten.blockID, new ItemStack(RegistryInit.ingotTungsten));
        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreTungstenDeepslate.blockID, new ItemStack(RegistryInit.ingotTungsten));

        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreCopperDeepslate.blockID, new ItemStack(Item.ingotCopper));
        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreSilverDeepslate.blockID, new ItemStack(Item.ingotSilver));
        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreGoldDeepslate.blockID, new ItemStack(Item.ingotGold));
        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreIronDeepslate.blockID, new ItemStack(Item.ingotIron));
        FurnaceRecipes.smelting().addSmelting(Block.oreMithril.blockID, new ItemStack(Item.ingotMithril));
        FurnaceRecipes.smelting().addSmelting(RegistryInit.oreAdamantiumDeepslate.blockID, new ItemStack(Item.ingotAdamantium));
    }
}
