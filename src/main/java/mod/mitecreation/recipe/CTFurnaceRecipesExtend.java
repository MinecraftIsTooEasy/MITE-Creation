package mod.mitecreation.recipe;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.FurnaceRecipes;
import net.minecraft.Item;
import net.minecraft.ItemStack;

public class CTFurnaceRecipesExtend {

    public static void registerFurnaceRecipe() {
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawCopperNugget.itemID,new ItemStack(Item.copperNugget,1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawSilverNugget.itemID,new ItemStack(Item.silverNugget,1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawGoldNugget.itemID,new ItemStack(Item.goldNugget,1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawRustedIronNugget.itemID,new ItemStack(Item.ironNugget, 1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawAncientMetalNugget.itemID,new ItemStack(Item.ancientMetalNugget, 1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawTungstenNugget.itemID,new ItemStack(CTRegistryInit.tungstenNugget, 1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawMithrilNugget.itemID,new ItemStack(Item.mithrilNugget, 1));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.rawAdamantiumNugget.itemID,new ItemStack(Item.adamantiumNugget, 1));

        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreTungsten.blockID, new ItemStack(CTRegistryInit.ingotTungsten));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreTungstenDeepslate.blockID, new ItemStack(CTRegistryInit.ingotTungsten));

        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreCopperDeepslate.blockID, new ItemStack(Item.ingotCopper));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreSilverDeepslate.blockID, new ItemStack(Item.ingotSilver));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreGoldDeepslate.blockID, new ItemStack(Item.ingotGold));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreIronDeepslate.blockID, new ItemStack(Item.ingotIron));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreMithrilDeepslate.blockID, new ItemStack(Item.ingotMithril));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreAdamantiumDeepslate.blockID, new ItemStack(Item.ingotAdamantium));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreEmeraldDeepslate.blockID, new ItemStack(Item.emerald));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreDiamondDeepslate.blockID, new ItemStack(Item.diamond));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreRedstoneDeepslate.blockID, new ItemStack(Item.redstone, 4));
        FurnaceRecipes.smelting().addSmelting(CTRegistryInit.oreLapisDeepslate.blockID, new ItemStack(Item.dyePowder, 4, 4));
    }
}
