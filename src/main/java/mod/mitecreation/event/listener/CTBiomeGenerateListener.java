package mod.mitecreation.event.listener;

import mod.mitecreation.world.biome.CTBiomes;
import moddedmite.rustedironcore.api.event.listener.IBiomeGenerateListener;
import net.minecraft.BiomeGenBase;
import net.minecraft.GenLayer;

import java.util.List;

public class CTBiomeGenerateListener implements IBiomeGenerateListener {
//    @Override
//    public int onLayerHills(GenLayer genLayer, int original) {
//        if (original == BiomeGenBase.forestHills.biomeID) {
//            return CTBiomes.TAOYUAN.biomeID;
//        }
//        if (original == BiomeGenBase.forest.biomeID) {
//            return CTBiomes.TAOYUAN.biomeID;
//        }
//        return original;
//    }

    @Override
    public void onInitialBiomesModify(List<BiomeGenBase> list) {
        list.add(CTBiomes.TAOYUAN);
    }

    @Override
    public void onStrongholdAllowedRegister(List<BiomeGenBase> original) {
        original.add(CTBiomes.TAOYUAN);
    }

    @Override
    public void onVillageAllowedRegister(List<BiomeGenBase> original) {
        original.add(CTBiomes.TAOYUAN);
    }

    @Override
    public void onUnderworldBiomesRegister(List<BiomeGenBase> original) {
        original.add(CTBiomes.UNDERGARDEN);
        original.add(CTBiomes.FAULT);
//        original.add(CTBiomes.STONES);
    }
}