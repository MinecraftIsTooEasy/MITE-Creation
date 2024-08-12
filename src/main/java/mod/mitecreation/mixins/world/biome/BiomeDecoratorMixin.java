package mod.mitecreation.mixins.world.biome;

import mod.mitecreation.block.CreationBlock;
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

    @Inject(method = "<init>", at = @At("TAIL"))
    public void creationBiomeDecorator(BiomeGenBase par1BiomeGenBase, CallbackInfo ci) {
//        if (this.currentWorld.isUnderworld()) {
        if (par1BiomeGenBase.biomeID == 26) {
//            this.gravelGen = new WorldGenMinable(Block.gravel.blockID, 32, CreationBlock.deepSlate.blockID);
            this.coalGen = new WorldGenMinable(CreationBlock.oreCoalDeepslate.blockID, 16, CreationBlock.deepSlate.blockID);
            this.copperGen = new WorldGenMinable(CreationBlock.oreCopperDeepslate.blockID, 6, CreationBlock.deepSlate.blockID);
            this.silverGen = new WorldGenMinable(CreationBlock.oreSilverDeepslate.blockID, 6, CreationBlock.deepSlate.blockID);
            this.goldGen = new WorldGenMinable(CreationBlock.oreGoldDeepslate.blockID, 4, CreationBlock.deepSlate.blockID);
            this.ironGen = new WorldGenMinable(CreationBlock.oreIronDeepslate.blockID, 6, CreationBlock.deepSlate.blockID);
            this.mithrilGen = new WorldGenMinable(CreationBlock.oreMithrilDeepslate.blockID, 3, CreationBlock.deepSlate.blockID);
            this.adamantiteGen = new WorldGenMinable(CreationBlock.oreAdamantiumDeepslate.blockID, 3, CreationBlock.deepSlate.blockID);
            this.redstoneGen = new WorldGenMinable(CreationBlock.oreRedstoneDeepslate.blockID, 5, CreationBlock.deepSlate.blockID);
            this.diamondGen = new WorldGenMinable(CreationBlock.oreDiamondDeepslate.blockID, 3, CreationBlock.deepSlate.blockID);
            this.lapisGen = new WorldGenMinable(CreationBlock.oreLapisDeepslate.blockID, 3, CreationBlock.deepSlate.blockID);
//            this.silverfishGen = new WorldGenMinable(Block.silverfish.blockID, 3, CreationBlock.deepSlate.blockID);
            this.tungstenGen = new WorldGenMinable(CreationBlock.oreTungstenDeepslate.blockID, 3, CreationBlock.deepSlate.blockID);

        }
//        this.tungstenGen = new WorldGenMinable(CreationBlock.oreTungsten.blockID, 3);
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
