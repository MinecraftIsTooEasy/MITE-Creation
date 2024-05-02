package mod.mitecreation.recipe;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import net.minecraft.FurnaceRecipes;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

import static mod.mitecreation.item.Items.*;

public class FurnaceRecipesExtend {

    public static void furnaceRecipeRegister(RecipeRegistryEvent recipesFurnace) {
        FurnaceRecipes.smelting().addSmelting(rawCopperNugget.itemID,new ItemStack(Item.copperNugget,1));
        Item.copperNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawSilverNugget.itemID,new ItemStack(Item.silverNugget,1));
        Item.silverNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawGoldNugget.itemID,new ItemStack(Item.goldNugget,1));
        Item.goldNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(rustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawRustedIronNugget.itemID,new ItemStack(Item.ironNugget,1));
        Item.ironNugget.setXPReward(1);
        FurnaceRecipes.smelting().addSmelting(rawAncientMetalNugget.itemID,new ItemStack(Item.ancientMetalNugget,1));
        Item.ancientMetalNugget.setXPReward(2);
        FurnaceRecipes.smelting().addSmelting(rawMithrilNugget.itemID,new ItemStack(Item.mithrilNugget,1));
        Item.mithrilNugget.setXPReward(4);
        FurnaceRecipes.smelting().addSmelting(rawAdamantiumNugget.itemID,new ItemStack(Item.adamantiumNugget,1));
        Item.adamantiumNugget.setXPReward(10);
        FurnaceRecipes.smelting().smelting().addSmelting(Blocks.oreTungsten.blockID, new ItemStack(Items.ingotTungsten));
    }
}
