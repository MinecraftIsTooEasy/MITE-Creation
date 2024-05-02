package mod.mitecreation.mixin.world;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(WorldGenDungeons.class)
public class WorldGenDungeonsMixin extends WorldGenerator {
    @Shadow
    public boolean generate(World world, Random random, int i, int i1, int i2) {
        return false;
    }

    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] field_111189_a;
    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] chest_contents_for_underworld;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addITFLoot(CallbackInfo ci) {
        field_111189_a = WeightedRandomChestContent.func_92080_a(field_111189_a,
                new WeightedRandomChestContent(Items.coinRustedIron.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(Items.rawRustedIronNugget.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(Items.rustedIronNugget.itemID, 0, 1, 4, 5),
                new WeightedRandomChestContent(Items.ingotRustedIron.itemID, 0, 1, 2, 2)
        );
//        chest_contents_for_underworld = WeightedRandomChestContent.func_92080_a(chest_contents_for_underworld,
//        );
    }
}