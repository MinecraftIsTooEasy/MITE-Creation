package mod.mitecreation.client.event.listener;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.property.ItemProperties;
import moddedmite.rustedironcore.property.MaterialProperties;
import net.minecraft.Material;

public class CTPropertyRegistry implements Runnable {
    @Override
    public void run() {
        MaterialProperties.RepairItem.register(Material.rusted_iron, CTRegistryInit.rustedIronNugget);
        MaterialProperties.RepairItem.register(CTMaterials.tungsten, CTRegistryInit.tungstenNugget);

        MaterialProperties.HarvestEfficiency.register(CTMaterials.tungsten, 2.25F);

        MaterialProperties.PeerCoin.register(Material.rusted_iron, CTRegistryInit.coinRustedIron);
        MaterialProperties.PeerCoinXP.register(Material.rusted_iron, 2);
        MaterialProperties.PeerCoin.register(Material.iron, CTRegistryInit.coinIron);
        MaterialProperties.PeerCoinXP.register(Material.iron, 200);
        MaterialProperties.PeerCoin.register(CTMaterials.tungsten, CTRegistryInit.coinTungsten);
        MaterialProperties.PeerCoinXP.register(CTMaterials.tungsten, 1250);

        MaterialProperties.BucketMeltingChance.register(Material.rusted_iron, 0.24F);
        MaterialProperties.BucketMeltingChance.register(CTMaterials.tungsten, 0.04F);

        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawCopperNugget, 1);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawSilverNugget, 1);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawGoldNugget, 1);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawRustedIronNugget, 2);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rustedIronNugget, 2);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawAncientMetalNugget, 2);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawMithrilNugget, 3);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawTungstenNugget, 3);
        ItemProperties.HeatLevelRequired.register(CTRegistryInit.rawAdamantiumNugget, 4);
    }
}
