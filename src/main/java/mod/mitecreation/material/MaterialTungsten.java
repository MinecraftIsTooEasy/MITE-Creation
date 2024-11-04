package mod.mitecreation.material;

import huix.glacier.api.extension.material.GlacierMaterial;
import huix.glacier.api.extension.material.*;
import net.minecraft.*;
import mod.mitecreation.init.RegistryInit;

public class MaterialTungsten extends GlacierMaterial implements
        IArmorMaterial, IArrowMaterial, ICoinMaterial, IComboMaterial, IToolMaterial, IRepairableMaterial {
    public MaterialTungsten() {
        super(EnumCreationMaterials.tungsten);
    }

    @Override
    public float getDamageVsEntity() {
        return 4.5F;
    }

    @Override
    public int getProtection() {
        return 9;
    }

    @Override
    public float getChanceOfRecovery() {
        return 0.8F;
    }

    @Override
    public int getExperienceValue() {
        return 6000;
    }

    @Override
    public ItemCoin getForInstance() {
        return RegistryInit.coinTungsten;
    }

    @Override
    public Item getNuggetPeer() {
        return RegistryInit.tungstenNugget;
    }

    @Override
    public ItemNugget getNugget() {
        return RegistryInit.tungstenNugget;
    }

    @Override
    public ItemIngot getIngot() {
        return (ItemIngot) RegistryInit.ingotTungsten;
    }

    @Override
    public float getHarvestEfficiency() {
        return 2.5F;
    }

    @Override
    public Item getRepairItem() {
        return RegistryInit.tungstenNugget;
    }
}
