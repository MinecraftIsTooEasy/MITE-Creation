package mod.mitecreation.mixin.world;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(WorldGenDungeons.class)
public class WorldGenDungeonsMixin extends WorldGenerator {
    private static final WeightedRandomChestContent[] field_111189_a = new WeightedRandomChestContent[]{
            new WeightedRandomChestContent(Item.bread.itemID, 0, 1, 1, 10),
            new WeightedRandomChestContent(Item.carrot.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.potato.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.onion.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.wheat.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.appleGold.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.coinCopper.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.coinSilver.itemID, 0, 1, 2, 2),
            new WeightedRandomChestContent(Item.coinGold.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Items.rawRustedIronNugget.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Items.rustedIronNugget.itemID, 0, 1, 4, 5),
            new WeightedRandomChestContent(Items.ingotRustedIron.itemID, 0, 1, 2, 2),
            new WeightedRandomChestContent(Item.saddle.itemID, 0, 1, 1, 10),
            new WeightedRandomChestContent(Item.gunpowder.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.silk.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.bowlEmpty.itemID, 0, 1, 1, 3),
            new WeightedRandomChestContent(Item.bucketCopperEmpty.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.bucketIronEmpty.itemID, 0, 1, 1, 3),
            new WeightedRandomChestContent(Item.record13.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.recordCat.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.nameTag.itemID, 0, 1, 1, 10),
            new WeightedRandomChestContent(Item.horseArmorGold.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.horseArmorCopper.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.horseArmorIron.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.shearsRustedIron.itemID, 0, 1, 1, 3),
            new WeightedRandomChestContent(Item.fishingRodFlint.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.fishingRodCopper.itemID, 0, 1, 1, 3),
            new WeightedRandomChestContent(Item.fishingRodIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.shovelWood.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.shovelRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.shovelCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.hoeRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.hoeCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.mattockRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.mattockCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.daggerRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.daggerCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.daggerSilver.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.swordRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.swordCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.battleAxeRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.battleAxeCopper.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.warHammerRustedIron.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.warHammerCopper.itemID, 0, 1, 1, 1),
    };
    private static final WeightedRandomChestContent[] chest_contents_for_underworld = new WeightedRandomChestContent[]{
            new WeightedRandomChestContent(Item.ancientMetalNugget.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.ingotAncientMetal.itemID, 0, 1, 5, 10),
            new WeightedRandomChestContent(Item.gunpowder.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.silk.itemID, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.bowlEmpty.itemID, 0, 1, 1, 3),
            new WeightedRandomChestContent(Item.bucketAncientMetalEmpty.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.coinAncientMetal.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.recordUnderworld.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.recordDescent.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.recordWanderer.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.recordLegends.itemID, 0, 1, 1, 5),
            new WeightedRandomChestContent(Item.nameTag.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.horseArmorAncientMetal.itemID, 0, 1, 1, 1),
            new WeightedRandomChestContent(Item.fishingRodAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.pickaxeAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.shovelAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.daggerAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.swordAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.bowAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.bootsChainAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.legsChainAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.plateChainAncientMetal.itemID, 0, 1, 1, 2),
            new WeightedRandomChestContent(Item.helmetChainAncientMetal.itemID, 0, 1, 1, 2)
    };

    @Shadow
    public boolean generate(World world, Random random, int i, int i1, int i2) {
        return false;
    }


}