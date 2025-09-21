package mod.mitecreation.event.listener;

import mod.mitecreation.init.CTRegistryInit;
import moddedmite.rustedironcore.api.event.listener.ILootTableRegisterListener;
import net.minecraft.WeightedRandomChestContent;

import java.util.List;

public class CTLootTableRegistry implements ILootTableRegisterListener {
    @Override
    public void onDungeonOverworldRegister(List<WeightedRandomChestContent> original) {
        original.add(new WeightedRandomChestContent(CTRegistryInit.coinRustedIron.itemID, 0, 1, 4, 10));
        original.add(new WeightedRandomChestContent(CTRegistryInit.rawRustedIronNugget.itemID, 0, 1, 4, 10));
        original.add(new WeightedRandomChestContent(CTRegistryInit.rustedIronNugget.itemID, 0, 1, 4, 5));
        original.add(new WeightedRandomChestContent(CTRegistryInit.ingotRustedIron.itemID, 0, 1, 2, 2));
    }
}
