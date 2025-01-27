package mod.mitecreation.client.event.listener;

import mod.mitecreation.init.CTRegistryInit;
import moddedmite.rustedironcore.api.event.events.OreGenerationRegisterEvent;
import moddedmite.rustedironcore.api.world.Dimension;
import moddedmite.rustedironcore.api.world.MinableWorldGen;

import java.util.function.Consumer;

public class CTOreGenerationRegistry implements Consumer<OreGenerationRegisterEvent> {
    @Override
    public void accept(OreGenerationRegisterEvent event) {
        MinableWorldGen deepGravelGen = new MinableWorldGen(CTRegistryInit.gravelDeepSlate.blockID, 32, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateIronGen = new MinableWorldGen(CTRegistryInit.oreIronDeepslate.blockID, 6, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateCopperGen = new MinableWorldGen(CTRegistryInit.oreCopperDeepslate.blockID, 6, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateSilverGen = new MinableWorldGen(CTRegistryInit.oreSilverDeepslate.blockID, 6, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateMithrilGen = new MinableWorldGen(CTRegistryInit.oreMithrilDeepslate.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateAdamantiteGen = new MinableWorldGen(CTRegistryInit.oreAdamantiumDeepslate.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 136)
                .setRandomVeinHeight((world, random, minableWorldGen) -> random.nextInt(136));
        MinableWorldGen deepslateGoldGen = new MinableWorldGen(CTRegistryInit.oreGoldDeepslate.blockID, 4, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateRedstoneGen = new MinableWorldGen(CTRegistryInit.oreRedstoneDeepslate.blockID, 5, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateDiamondGen = new MinableWorldGen(CTRegistryInit.oreDiamondDeepslate.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateLapisGen = new MinableWorldGen(CTRegistryInit.oreLapisDeepslate.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateSilverfishGen = new MinableWorldGen(CTRegistryInit.deepslateSilverFish.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);
        MinableWorldGen deepslateTungstenGen = new MinableWorldGen(CTRegistryInit.oreTungsten.blockID, 3, CTRegistryInit.deepSlate.blockID)
                .setMinVeinHeight((world, minableWorldGen) -> 0)
                .setMaxVeinHeight((world, minableWorldGen) -> 255)
                .setRandomVeinHeight(MinableWorldGen.Common);

        event.register(Dimension.UNDERWORLD, deepGravelGen, 20);
        event.register(Dimension.UNDERWORLD, deepslateIronGen, 60, true);
        event.register(Dimension.UNDERWORLD, deepslateGoldGen, 20, true);
        event.register(Dimension.UNDERWORLD, deepslateRedstoneGen, 10);
        event.register(Dimension.UNDERWORLD, deepslateDiamondGen, 5);
        event.register(Dimension.UNDERWORLD, deepslateLapisGen, 5);
        event.register(Dimension.UNDERWORLD, deepslateSilverfishGen, 50);
        event.register(Dimension.UNDERWORLD, deepslateCopperGen, 40, true);
        event.register(Dimension.UNDERWORLD, deepslateSilverGen, 10, true);
        event.register(Dimension.UNDERWORLD, deepslateMithrilGen, 10, true);
        event.register(Dimension.UNDERWORLD, deepslateAdamantiteGen, 5, true);
        event.register(Dimension.UNDERWORLD, deepslateTungstenGen, 15, true);
    }
}
