package mod.mitecreation.mixin.world;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.WeightedRandomChestContent;
import net.minecraft.World;
import net.minecraft.WorldGenDungeons;
import net.minecraft.WorldGenerator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(WorldGenDungeons.class)
public abstract class WorldGenDungeonsMixin extends WorldGenerator {

    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] field_111189_a;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addLootCreation(CallbackInfo ci) {
        field_111189_a = WeightedRandomChestContent.func_92080_a(field_111189_a,
                new WeightedRandomChestContent(RegistryInit.coinRustedIron.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(RegistryInit.rawRustedIronNugget.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(RegistryInit.rustedIronNugget.itemID, 0, 1, 4, 5),
                new WeightedRandomChestContent(RegistryInit.ingotRustedIron.itemID, 0, 1, 2, 2)
        );
    }

    @Inject(
            method = "generate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/World;setBlock(IIIIII)Z",
                    ordinal = 0,
                    shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void MossyDeepslateBrickDungeonsInUnderworld(World par1World, Random par2Random, int par3, int par4, int par5, CallbackInfoReturnable<Boolean> cir, byte var6, int var7, int var8, int var9, int var10, int var11, int var12) {
        if (par1World.isUnderworld()) {
            par1World.setBlock(var10, var11, var12, mod.mitecreation.init.RegistryInit.deepStaleBrick.blockID, 1, 2);
            par1World.setBlock(var10, var11 + 5, var12, RegistryInit.deepStaleBrick.blockID, 0, 2);
            if (par2Random.nextInt(8) == 0) {
                par1World.setBlock(var10, var11, var12, RegistryInit.deepStaleBrick.blockID, 2, 2);
                par1World.setBlock(var10, var11 + 5, var12, RegistryInit.deepStaleBrick.blockID, 2, 2);
                par1World.setBlock(var10, var11, var12, RegistryInit.deepslateSilverFish.blockID, 2, 2);
                par1World.setBlock(var10, var11 + 5, var12, RegistryInit.deepslateSilverFish.blockID, 2, 2);
            }
            if (par2Random.nextInt(15) == 0) {
                par1World.setBlock(var10, var11, var12, RegistryInit.ancientRelict.blockID, 0, 2);
                par1World.setBlock(var10, var11 + 5, var12, RegistryInit.ancientRelict.blockID, 0, 2);
            }
        }
    }

    @Inject(
            method = "generate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/World;setBlock(IIIIII)Z",
                    ordinal = 1,
                    shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void deepslateBrickDungeonsInUnderworld(World par1World, Random par2Random, int par3, int par4, int par5, CallbackInfoReturnable<Boolean> cir, byte var6, int var7, int var8, int var9, int var10, int var11, int var12) {
        if (par1World.isUnderworld()) {
            par1World.setBlock(var10, var11, var12, RegistryInit.deepStaleBrick.blockID, 0, 2);
            if (par2Random.nextInt(8) == 0) {
                par1World.setBlock(var10, var11, var12, RegistryInit.deepStaleBrick.blockID, 2, 2);
            }
            if (par2Random.nextInt(15) == 0) {
                par1World.setBlock(var10, var11, var12, RegistryInit.ancientRelict.blockID, 0, 2);
            }
        }
    }

}