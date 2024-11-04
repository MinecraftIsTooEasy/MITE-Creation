package mod.mitecreation.client.event.listener;

import mod.mitecreation.init.RegistryInit;
import mod.mitecreation.material.CreationMaterials;
import moddedmite.rustedironcore.property.MaterialProperties;
import net.minecraft.Material;

public class PropertyRegistry implements Runnable {
    @Override
    public void run() {
        MaterialProperties.RepairItem.register(Material.rusted_iron, RegistryInit.rustedIronNugget);
        MaterialProperties.RepairItem.register(CreationMaterials.tungsten, RegistryInit.tungstenNugget);

        MaterialProperties.HarvestEfficiency.register(CreationMaterials.tungsten, 2.25F);

        MaterialProperties.PeerCoin.register(Material.rusted_iron, RegistryInit.coinRustedIron);
        MaterialProperties.PeerCoinXP.register(Material.rusted_iron, 2);
        MaterialProperties.PeerCoin.register(Material.iron, RegistryInit.coinIron);
        MaterialProperties.PeerCoinXP.register(Material.iron, 200);
        MaterialProperties.PeerCoin.register(CreationMaterials.tungsten, RegistryInit.coinTungsten);
        MaterialProperties.PeerCoinXP.register(CreationMaterials.tungsten, 1250);

        MaterialProperties.BucketMeltingChance.register(Material.rusted_iron, 0.24F);
        MaterialProperties.BucketMeltingChance.register(CreationMaterials.tungsten, 0.04F);
    }
}
