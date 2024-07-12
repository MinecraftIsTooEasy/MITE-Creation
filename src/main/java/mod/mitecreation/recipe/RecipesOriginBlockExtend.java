package mod.mitecreation.recipe;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Skill;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class RecipesOriginBlockExtend {

    public static void registerRecipes(RecipeRegistryEvent register) {
        //Tungsten Recipes
        register.registerShapedRecipe(new ItemStack(CreationBlock.anvilTungsten),true,
                "AAA",
                " I ",
                "III",
                'A', CreationBlock.blockTungsten,
                'I', CreationItem.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(CreationBlock.blockTungsten),true,
                "XXX",
                "XXX",
                "XXX",
                'X', CreationItem.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(CreationBlock.fenceTungsten, 16),true,
                "XXX",
                "XXX",
                'X', CreationItem.ingotTungsten);

        //Deepslate Recipes
        register.registerShapedRecipe(new ItemStack(CreationBlock.deepSlate, 2), true,
                "##",
                "##",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(CreationBlock.cobbleDeepStaleWall, 8), true,
                "###",
                "###",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(CreationBlock.cobbledDeepStaleSingleSlab, 6), true,
                "###",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(CreationBlock.deepStaleBrickWall, 8), true,
                "###",
                "###",
                '#', CreationBlock.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CreationBlock.deepStaleBrickSingleSlab, 6), true,
                "###",
                '#', CreationBlock.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CreationBlock.stairsCobbleDeepSlate, 4), true,
                "#  ",
                "## ",
                "###",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(CreationBlock.stairsCobbleDeepSlate, 4), true,
                "  #",
                " ##",
                "###",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(CreationBlock.stairsDeepSlateBrick, 4), true,
                "#  ",
                "## ",
                "###",
                '#', CreationBlock.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CreationBlock.stairsDeepSlateBrick, 4), true,
                "  #",
                " ##",
                "###",
                '#', CreationBlock.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(Block.furnaceIdle, 1), true,
                "###",
                "# #",
                "###",
                '#', CreationBlock.cobbleDeepStale);
        register.registerShapedRecipe(new ItemStack(Block.dispenser, 1), true,
                "###",
                "#*#",
                "#&#",
                '#', CreationBlock.cobbleDeepStale,
                '*', Item.bow,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.dropper, 1), true,
                "###",
                "# #",
                "#&#",
                '#', CreationBlock.cobbleDeepStale,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.pistonBase, 1), true,
                "PPP",
                "#I#",
                "#R#",
                'P', Block.planks,
                '#', CreationBlock.cobbleDeepStale,
                'I', Item.ingotIron,
                'R', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.stoneButton, 1), true,
                "#",
                '#', CreationBlock.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.pressurePlateStone, 1), true,
                "##",
                '#', CreationBlock.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.stoneSingleSlab, 1), true,
                "###",
                '#', CreationBlock.deepSlate);

    }
}
