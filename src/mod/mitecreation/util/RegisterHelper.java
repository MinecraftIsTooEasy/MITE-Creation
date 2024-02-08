package mod.mitecreation.util;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.mixin.recipe.CraftingManagerInvoker;
import net.minecraft.CraftingManager;
import net.minecraft.ShapedRecipes;
import net.minecraft.ShapelessRecipes;
import mod.mitecreation.item.Items;


import java.util.ArrayList;

@SuppressWarnings("RedundantCast")
public class RegisterHelper {
    public static ArrayList<RecipesArgs> shapedRecipes = new ArrayList<>();
    public static ArrayList<RecipesArgs> shapelessRecipe = new ArrayList<>();
    private float difficulty;
    public static void registerAllItems(){
        Items.itemRegister();
        Blocks.registerBlocks();
//        AchievementExtend.registerAchievements();
    }
    public static void registerAllRecipes(CraftingManager crafters){
        RecipeRegister recipeRegister = new RecipeRegister();
        Blocks.registerRecipes(recipeRegister);
        Items.registerRecipes(recipeRegister);

        RecipesArgs recipesArgs;
        for (RecipesArgs shapedRecipe : shapedRecipes) {
            recipesArgs = shapedRecipe;
            ShapedRecipes shapedRecipes = ((CraftingManagerInvoker) crafters).addRecipeP(recipesArgs.result, recipesArgs.include_in_lowest_crafting_difficulty_determination, recipesArgs.inputs);
            if (recipesArgs.isExtendsNBT()){
                shapedRecipes.func_92100_c();
            }
            if (recipesArgs.isSpecialized_difficulty()){
                shapedRecipes.setDifficulty(recipesArgs.difficulty);
            }
        }
        for (RecipesArgs args : shapelessRecipe) {
            recipesArgs = args;
            ShapelessRecipes shapelessRecipes = ((CraftingManagerInvoker) crafters).addShapelessRecipeP(recipesArgs.result, recipesArgs.include_in_lowest_crafting_difficulty_determination, recipesArgs.inputs);
            if (recipesArgs.isExtendsNBT()){
                shapelessRecipes.propagateTagCompound();
            }
            if (recipesArgs.isSpecialized_difficulty()){
                shapelessRecipes.setDifficulty(recipesArgs.difficulty);
            }
        }
    }
}
