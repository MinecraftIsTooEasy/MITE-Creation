package mod.mitecreation.recipe;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class RecipesBlockExtend {

    public static void registerRecipes(RecipeRegistryEvent register) {
//        shapedRecipe(register);
//    }
//
//    public static void shapedRecipe(RecipeRegistryEvent register) {
        //Tungsten Recipes
        register.registerShapedRecipe(new ItemStack(RegistryInit.anvilTungsten), true,
                "AAA",
                " I ",
                "III",
                'A', RegistryInit.blockTungsten,
                'I', RegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(RegistryInit.blockTungsten), true,
                "XXX",
                "XXX",
                "XXX",
                'X', RegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(RegistryInit.fenceTungsten, 16), true,
                "XXX",
                "XXX",
                'X', RegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(RegistryInit.chestTungsten, 1), true,
                "XXX",
                "X X",
                "XXX",
                'X', RegistryInit.ingotTungsten);

        //Deepslate Recipes
        register.registerShapedRecipe(new ItemStack(RegistryInit.deepSlate, 2), true,
                "##",
                "##",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(RegistryInit.cobbleDeepStaleWall, 8), true,
                "###",
                "###",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(RegistryInit.cobbledDeepStaleSingleSlab, 6), true,
                "###",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(RegistryInit.deepStaleBrickWall, 8), true,
                "###",
                "###",
                '#', RegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(RegistryInit.deepStaleBrickSingleSlab, 6), true,
                "###",
                '#', RegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(RegistryInit.stairsCobbleDeepSlate, 4), true,
                "#  ",
                "## ",
                "###",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(RegistryInit.stairsCobbleDeepSlate, 4), true,
                "  #",
                " ##",
                "###",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(RegistryInit.stairsDeepSlateBrick, 4), true,
                "#  ",
                "## ",
                "###",
                '#', RegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(RegistryInit.stairsDeepSlateBrick, 4), true,
                "  #",
                " ##",
                "###",
                '#', RegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(Block.furnaceIdle, 1), true,
                "###",
                "# #",
                "###",
                '#', RegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(Block.dispenser, 1), true,
                "###",
                "#*#",
                "#&#",
                '#', RegistryInit.cobbledDeepStale,
                '*', Item.bow,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.dropper, 1), true,
                "###",
                "# #",
                "#&#",
                '#', RegistryInit.cobbledDeepStale,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.pistonBase, 1), true,
                "PPP",
                "#I#",
                "#R#",
                'P', Block.planks,
                '#', RegistryInit.cobbledDeepStale,
                'I', Item.ingotIron,
                'R', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.stoneButton, 1), true,
                "#",
                '#', RegistryInit.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.pressurePlateStone, 1), true,
                "##",
                '#', RegistryInit.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.stoneSingleSlab, 1), true,
                "###",
                '#', RegistryInit.deepSlate);

        RegistryInit.tungstenWorkBench.registerSimpleRecipe(register);
    }
}
