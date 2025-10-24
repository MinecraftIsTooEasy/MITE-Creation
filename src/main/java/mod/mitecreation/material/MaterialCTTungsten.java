package mod.mitecreation.material;

import huix.glacier.api.extension.material.*;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Item;
import net.minecraft.ItemCoin;
import net.minecraft.ItemIngot;
import net.minecraft.ItemNugget;

public class MaterialCTTungsten extends GlacierMaterial implements
        IArmorMaterial, IArrowMaterial, ICoinMaterial, IComboMaterial, IToolMaterial, IRepairableMaterial, IBucketMaterial {
    public MaterialCTTungsten() {
        super(EnumCTMaterials.tungsten);
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
        return 1250;
    }

    @Override
    public ItemCoin getForInstance() {
        return CTRegistryInit.coinTungsten;
    }

    @Override
    public Item getNuggetPeer() {
        return CTRegistryInit.tungstenNugget;
    }

    @Override
    public ItemNugget getNugget() {
        return CTRegistryInit.tungstenNugget;
    }

    @Override
    public ItemIngot getIngot() {
        return (ItemIngot) CTRegistryInit.ingotTungsten;
    }

    @Override
    public float getHarvestEfficiency() {
        return 2.5F;
    }

    @Override
    public Item getRepairItem() {
        return CTRegistryInit.tungstenNugget;
    }

    @Override
    public float getMeltingChance() {
        return 0.04F;
    }
}
