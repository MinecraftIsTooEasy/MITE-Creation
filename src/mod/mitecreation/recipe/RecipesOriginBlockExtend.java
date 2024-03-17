package mod.mitecreation.recipe;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import mod.mitecreation.util.RecipeRegister;
import net.minecraft.ItemStack;

public class RecipesOriginBlockExtend {
    public static void registerRecipes(RecipeRegister register) {
        register.registerShapedRecipe(new ItemStack(Blocks.anvilTungsten),true,
                "AAA",
                " I ",
                "III",
                'A', Blocks.blockTungsten,
                'I', Items.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(Blocks.blockTungsten),true,
                "XXX",
                "XXX",
                "XXX",
                'X',Items.ingotTungsten);
//        register.registerShapedRecipe(new ItemStack(Blocks.fenceTungsten, 16),true,
//                "XXX",
//                "XXX",
//                'X', Items.ingotTungsten);
    }
}
