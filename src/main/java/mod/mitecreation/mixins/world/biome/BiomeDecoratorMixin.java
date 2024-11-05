package mod.mitecreation.mixins.world.biome;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.BiomeDecorator;
import net.minecraft.BiomeGenBase;
import net.minecraft.World;
import net.minecraft.WorldGenMinable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BiomeDecorator.class)
public abstract class BiomeDecoratorMixin {
    @Shadow
    protected WorldGenMinable dirtGen;
    @Shadow
    protected WorldGenMinable gravelGen;
    @Shadow
    protected WorldGenMinable coalGen;
    @Shadow
    protected WorldGenMinable ironGen;
    @Shadow
    protected WorldGenMinable copperGen;
    @Shadow
    protected WorldGenMinable silverGen;
    @Shadow
    protected WorldGenMinable mithrilGen;
    @Shadow
    protected WorldGenMinable adamantiteGen;
    @Shadow
    protected WorldGenMinable goldGen;
    @Shadow
    protected WorldGenMinable redstoneGen;
    @Shadow
    protected WorldGenMinable diamondGen;
    @Shadow
    protected WorldGenMinable lapisGen;
    @Shadow
    protected WorldGenMinable silverfishGen;
    @Shadow
    protected World currentWorld;

    @Unique
    private WorldGenMinable tungstenGen;


    @Inject(method = "<init>", at = @At("RETURN"))
    public void creationBiomeDecorator(BiomeGenBase par1BiomeGenBase, CallbackInfo ci) {
//        if (currentWorld.isUnderworld()) {
        if (par1BiomeGenBase.biomeID == 26) {
            this.gravelGen = new WorldGenMinable(RegistryInit.gravelDeepSlate.blockID, 32, RegistryInit.deepSlate.blockID);
            this.copperGen = new WorldGenMinable(RegistryInit.oreCopperDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
            this.silverGen = new WorldGenMinable(RegistryInit.oreSilverDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
            this.goldGen = new WorldGenMinable(RegistryInit.oreGoldDeepslate.blockID, 4, RegistryInit.deepSlate.blockID);
            this.ironGen = new WorldGenMinable(RegistryInit.oreIronDeepslate.blockID, 6, RegistryInit.deepSlate.blockID);
            this.mithrilGen = new WorldGenMinable(RegistryInit.oreMithrilDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
            this.adamantiteGen = new WorldGenMinable(RegistryInit.oreAdamantiumDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
            this.redstoneGen = new WorldGenMinable(RegistryInit.oreRedstoneDeepslate.blockID, 5, RegistryInit.deepSlate.blockID);
            this.diamondGen = new WorldGenMinable(RegistryInit.oreDiamondDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
            this.lapisGen = new WorldGenMinable(RegistryInit.oreLapisDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
//            this.silverfishGen = new WorldGenMinable(Block.silverfish.blockID, 3, RegistryInit.deepSlate.blockID);
            this.tungstenGen = new WorldGenMinable(RegistryInit.oreTungstenDeepslate.blockID, 3, RegistryInit.deepSlate.blockID);
        }
//        this.tungstenGen = new WorldGenMinable(RegistryInit.oreTungsten.blockID, 3);
    }


    @Inject(method = "generateOres", at = @At("HEAD"))
    private void creationGenerateOres(CallbackInfo ci) {
        if (this.currentWorld.isUnderworld()) {
            genMinable(15, this.tungstenGen, true);
        }
    }

    @Shadow
    protected abstract void genMinable(int frequency, WorldGenMinable world_gen_minable, boolean vein_size_increases_with_depth);
}
