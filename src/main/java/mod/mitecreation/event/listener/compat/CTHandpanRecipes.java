package mod.mitecreation.event.listener.compat;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Block;
import net.minecraft.Item;

public class CTHandpanRecipes implements com.github.jeffyjamzhd.renewed.api.event.listener.HandpanRegisterListener {
    @Override
    public void register(com.github.jeffyjamzhd.renewed.item.recipe.HandpanRecipeProcessor registry) {
        //subtype1: Sinew, 2: String
        registry.registerHandpanRecipe(
                CTRegistryInit.gravelDeepSlate, 15, 150, 1,
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(CTRegistryInit.gravelDeepSlate, .3F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.chipFlint, .3F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.shardObsidian, .45F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(CTRegistryInit.rawCopperNugget, .1F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.flint, .05F)
        );

        registry.registerHandpanRecipe(
                CTRegistryInit.gravelSand, 10, 120, 1,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.gravelSand, .33F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.reed, .1F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardGlass, .1F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardEmerald, .04F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawGoldNugget, .3F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawSilverNugget, .13F)
        );

        registry.registerHandpanRecipe(
                CTRegistryInit.gravelDeepSlate, 20, 200, 2,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.gravelDeepSlate, .2F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawCopperNugget, .3F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawSilverNugget, .15F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.goldNugget, .07F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardDiamond, .055F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardObsidian, .43F)
        );

        registry.registerHandpanRecipe(
                CTRegistryInit.gravelSand, 10, 120, 2,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.gravelSand, .2F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.reed, .02F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardGlass, .05F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardEmerald, .09F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawGoldNugget, .4F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawSilverNugget, .25F)
        );


        //Overwrite renewed origin recipe
        registry.registerHandpanRecipe(
                Block.gravel, 10, 120, 1,
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Block.gravel, .5F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.chipFlint, .33F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.shardObsidian, .25F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(CTRegistryInit.rawCopperNugget, .08F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.flint, .05F)
        );

        registry.registerHandpanRecipe(
                Block.dirt, 5, 160, 1,
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Block.dirt, .5F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.wormRaw, .3F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(Item.bone, .05F),
                new com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput(CTRegistryInit.rawCopperNugget, .05F)
        );

        registry.registerHandpanRecipe(
                Block.gravel, 15, 160, 2,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Block.gravel, .33F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawCopperNugget, .5F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawSilverNugget, .25F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.goldNugget, .075F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardDiamond, .02F)
        );

        registry.registerHandpanRecipe(
                Block.dirt, 10, 220, 2,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Block.dirt, .33F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.wormRaw, .5F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.seeds, .75F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.pumpkinSeeds, .1F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.bone, .075F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawCopperNugget, .1F)
        );

        registry.registerHandpanRecipe(
                Block.sand, 10, 120, 2,
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Block.sand, .33F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.reed, .2F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardGlass, .33F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(Item.shardEmerald, .04F),
                com.github.jeffyjamzhd.renewed.item.recipe.HandpanOutput.of(CTRegistryInit.rawCopperNugget, .1F)
        );
    }
}
