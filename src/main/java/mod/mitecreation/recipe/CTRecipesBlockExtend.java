package mod.mitecreation.recipe;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;

public class CTRecipesBlockExtend {

    public static void registerRecipes(RecipeRegistryEvent register) {
//Tungsten Recipes
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.anvilTungsten), true,
                "AAA",
                " I ",
                "III",
                'A', CTRegistryInit.blockTungsten,
                'I', CTRegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.blockTungsten), true,
                "XXX",
                "XXX",
                "XXX",
                'X', CTRegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.fenceTungsten, 16), true,
                "XXX",
                "XXX",
                'X', CTRegistryInit.ingotTungsten);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.chestTungsten, 1), true,
                "XXX",
                "X X",
                "XXX",
                'X', CTRegistryInit.ingotTungsten);
        CTRegistryInit.tungstenWorkBench.registerSimpleRecipe(register);

//Deepslate Recipes
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.deepSlate, 2), true,
                "##",
                "##",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.cobbleDeepStaleWall, 8), true,
                "###",
                "###",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.cobbledDeepStaleSingleSlab, 6), true,
                "###",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.deepStaleBrickWall, 8), true,
                "###",
                "###",
                '#', CTRegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.deepStaleBrickSingleSlab, 6), true,
                "###",
                '#', CTRegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.stairsCobbleDeepSlate, 4), true,
                "#  ",
                "## ",
                "###",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.stairsCobbleDeepSlate, 4), true,
                "  #",
                " ##",
                "###",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.stairsDeepSlateBrick, 4), true,
                "#  ",
                "## ",
                "###",
                '#', CTRegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.stairsDeepSlateBrick, 4), true,
                "  #",
                " ##",
                "###",
                '#', CTRegistryInit.deepStaleBrick);
        register.registerShapedRecipe(new ItemStack(Block.furnaceIdle, 1), true,
                "###",
                "# #",
                "###",
                '#', CTRegistryInit.cobbledDeepStale);
        register.registerShapedRecipe(new ItemStack(Block.dispenser, 1), true,
                "###",
                "#*#",
                "#&#",
                '#', CTRegistryInit.cobbledDeepStale,
                '*', Item.bow,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.dropper, 1), true,
                "###",
                "# #",
                "#&#",
                '#', CTRegistryInit.cobbledDeepStale,
                '&', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.pistonBase, 1), true,
                "PPP",
                "#I#",
                "#R#",
                'P', Block.planks,
                '#', CTRegistryInit.cobbledDeepStale,
                'I', Item.ingotIron,
                'R', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.pistonBase, 1), true,
                "PPP",
                "#I#",
                "#R#",
                'P', CTRegistryInit.peachPlanks,
                '#', CTRegistryInit.cobbledDeepStale,
                'I', Item.ingotIron,
                'R', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.stoneButton, 1), true,
                "#",
                '#', CTRegistryInit.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.pressurePlateStone, 1), true,
                "##",
                '#', CTRegistryInit.deepSlate);
        register.registerShapedRecipe(new ItemStack(Block.stoneSingleSlab, 1), true,
                "###",
                '#', CTRegistryInit.deepSlate);

//Peach Wood Recipe
        register.registerShapedRecipe(new ItemStack(Block.fenceGate, 1), true,
                "#W#",
                "#W#",
                '#', Item.stick,
                'W', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Block.jukebox, 1), true,
                "###",
                "#X#",
                "###",
                '#', CTRegistryInit.peachPlanks,
                'X', Item.diamond);
        register.registerShapedRecipe(new ItemStack(Block.music, 1), true,
                "###",
                "#X#",
                "###",
                '#',
                CTRegistryInit.peachPlanks,
                'X', Item.redstone);
        register.registerShapedRecipe(new ItemStack(Block.bookShelf, 1), true,
                "###",
                "XXX",
                "###",
                '#', CTRegistryInit.peachPlanks,
                'X', Item.book);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.peachPlanksSingleSlab, 6, 0), true,
                "###",
                '#', new ItemStack(CTRegistryInit.peachPlanks, 1, 0));
        register.registerShapedRecipe(new ItemStack(Block.trapdoor, 2), true,
                "###",
                "###",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Item.sign, 1), true,
                "#",
                "/",
                '#', CTRegistryInit.peachPlanksSingleSlab,
                '/', Item.stick);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.peachPlanks, 4, 0), true,
                "#",
                '#', new ItemStack(CTRegistryInit.peachWood, 1, 0));
        register.registerShapedRecipe(new ItemStack(Item.stick, 4), true,
                "#",
                "#",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Item.bowlEmpty, 4), true,
                "# #",
                " # ",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.stairsPeachPlanks, 4), true,
                "#  ",
                "## ",
                "###",
                '#', new ItemStack(CTRegistryInit.peachPlanks, 1, 0));
        register.registerShapedRecipe(new ItemStack(Block.tripWireSource, 2), true,
                "I",
                "S",
                "#",
                '#', CTRegistryInit.peachPlanks,
                'S', Item.stick,
                'I', Item.ingotIron);
        register.registerShapedRecipe(new ItemStack(Block.woodenButton, 1), true,
                "#",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Block.pressurePlatePlanks, 1), true,
                "##",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Item.bed, 1), true,
                "###",
                "XXX",
                '#', Block.cloth,
                'X', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(Block.chest, 1), true,
                "###",
                "# #",
                "###",
                '#', CTRegistryInit.peachPlanks);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.swordPeachWood, 1), true,
                "#",
                "#",
                "X",
                '#', CTRegistryInit.peachPlanks,
                'X', Item.stick);
        register.registerShapedRecipe(new ItemStack(CTRegistryInit.shovelPeachWood, 1), true,
                "#",
                "X",
                "X",
                '#', CTRegistryInit.peachPlanks,
                'X', Item.stick);
    }
}
