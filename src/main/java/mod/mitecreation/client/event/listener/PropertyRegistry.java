package mod.mitecreation.client.event.listener;

import mod.mitecreation.item.CreationItem;
import mod.mitecreation.material.CreationMaterial;
import moddedmite.rustedironcore.property.MaterialProperties;
import net.minecraft.Material;

public class PropertyRegistry implements Runnable {
    @Override
    public void run() {
        MaterialProperties.RepairItem.register(Material.rusted_iron, CreationItem.rustedIronNugget);
        MaterialProperties.RepairItem.register(CreationMaterial.tungsten, CreationItem.tungstenNugget);

        MaterialProperties.HarvestEfficiency.register(CreationMaterial.tungsten, 2.25F);

        MaterialProperties.PeerCoin.register(Material.rusted_iron, CreationItem.coinRustedIron);
        MaterialProperties.PeerCoinXP.register(Material.rusted_iron, 2);
        MaterialProperties.PeerCoin.register(Material.iron, CreationItem.coinIron);
        MaterialProperties.PeerCoinXP.register(Material.iron, 200);
        MaterialProperties.PeerCoin.register(CreationMaterial.tungsten, CreationItem.coinTungsten);
        MaterialProperties.PeerCoinXP.register(CreationMaterial.tungsten, 1250);

        MaterialProperties.BucketMeltingChance.register(Material.rusted_iron, 0.24F);
        MaterialProperties.BucketMeltingChance.register(CreationMaterial.tungsten, 0.04F);
    }
}
