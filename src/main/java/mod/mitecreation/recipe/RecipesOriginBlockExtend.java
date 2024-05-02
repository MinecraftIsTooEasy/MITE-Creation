package mod.mitecreation.recipe;

import mod.mitecreation.block.Blocks;
import mod.mitecreation.item.Items;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class RecipesOriginBlockExtend {

    public static void registerRecipes(RecipeRegistryEvent register) {
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
        register.registerShapedRecipe(new ItemStack(Blocks.fenceTungsten, 16),true,
                "XXX",
                "XXX",
                'X', Items.ingotTungsten);
    }
}
