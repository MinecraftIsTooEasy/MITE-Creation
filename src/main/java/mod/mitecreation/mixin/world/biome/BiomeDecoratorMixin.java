package mod.mitecreation.mixin.world.biome;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeDecorator.class)
public abstract class BiomeDecoratorMixin {
    @Shadow
    protected World currentWorld;

    @Unique
    protected WorldGenMinable deepGravelGen = new WorldGenMinable(RegistryInit.gravelDeepSlate.blockID, 32, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateIronGen = new WorldGenMinable(RegistryInit.oreIronDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateCopperGen = new WorldGenMinable(RegistryInit.oreCopperDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateSilverGen = new WorldGenMinable(RegistryInit.oreSilverDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateMithrilGen = new WorldGenMinable(RegistryInit.oreMithrilDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateAdamantiteGen = new WorldGenMinable(RegistryInit.oreAdamantiumDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateGoldGen = new WorldGenMinable(RegistryInit.oreGoldDeepslate.blockID, 4, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateRedstoneGen = new WorldGenMinable(RegistryInit.oreRedstoneDeepslate.blockID, 5, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateDiamondGen = new WorldGenMinable(RegistryInit.oreDiamondDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateLapisGen = new WorldGenMinable(RegistryInit.oreLapisDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
    @Unique
    protected WorldGenMinable deepslateSilverfishGen = new WorldGenMinable(RegistryInit.deepslateSilverFish.blockID, 3, RegistryInit.deepSlate.blockID);
    @Unique
    private WorldGenMinable deepslateTungstenGen = new WorldGenMinable(RegistryInit.oreTungstenDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);

    @Inject(method = "generateOres", at = @At("HEAD"))
    private void creationGenerateOres(CallbackInfo ci) {
        if (this.currentWorld.isUnderworld()) {
            genMinable(50, this.deepGravelGen);
            genMinable(40, this.deepslateCopperGen, true);
            genMinable(10, this.deepslateSilverGen, true);
            genMinable(20, this.deepslateGoldGen, true);
            genMinable(60, this.deepslateIronGen, true);
            genMinable(15, this.deepslateTungstenGen, true);
            genMinable(10, this.deepslateMithrilGen, true);
            genMinable(5, this.deepslateAdamantiteGen, true);
            genMinable(10, this.deepslateRedstoneGen);
            genMinable(5, this.deepslateDiamondGen);
            genMinable(5, this.deepslateLapisGen);
            if (this.currentWorld.underworld_y_offset != 0) {
                genMinable(50, this.deepslateSilverfishGen);
            }
        }
    }

    @Shadow
    protected abstract void genMinable(int frequency, WorldGenMinable world_gen_minable, boolean vein_size_increases_with_depth);
    @Shadow
    protected abstract void genMinable(int frequency, WorldGenMinable world_gen_minable);
}
