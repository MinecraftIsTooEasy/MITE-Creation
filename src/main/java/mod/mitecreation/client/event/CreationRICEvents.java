package mod.mitecreation.client.event;

import mod.mitecreation.client.event.listener.*;
import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.handler.GravelDropHandler;
import moddedmite.rustedironcore.api.event.listener.IArrowRegisterListener;
import net.minecraft.Material;

import java.util.function.Consumer;

public class CreationRICEvents extends Handlers {
    public static void register() {
        FurnaceUpdate.register(new CTFurnaceListener());
        BeaconUpdate.register(new CTBeaconListener());
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.CopperEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.SilverEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.GoldEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.MithrilEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.AdamantiumEntry);
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.CopperEntry.weight()), info -> CTRegistryInit.rawCopperNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.SilverEntry.weight()), info -> CTRegistryInit.rawSilverNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.GoldEntry.weight()), info -> CTRegistryInit.rawGoldNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.MithrilEntry.weight()), info -> CTRegistryInit.rawMithrilNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.AdamantiumEntry.weight()), info -> CTRegistryInit.rawAdamantiumNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((float) (GravelDropHandler.MithrilEntry.weight() * 1.25), info -> CTRegistryInit.rawTungstenNugget.itemID));
        ArrowRegister.register(new IArrowRegisterListener() {
            @Override
            public void onRegister(Consumer<Material> registry) {
                registry.accept(CTMaterials.tungsten);
            }
        });
        PropertiesRegistry.register(new CTPropertyRegistry());
        OreGeneration.register(new CTOreGenerationRegistry());
        LootTable.register(new CTLootTableRegistry());
        Combat.register(new CTCombatListener());
        ArmorModel.register(new CTArmorModelListener());
        PlayerAttribute.register(new CTPlayerAttributeListener());
        BiomeGenerate.register(new CTBiomeGenerateListener());
    }
}
