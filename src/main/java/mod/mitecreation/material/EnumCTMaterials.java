package mod.mitecreation.material;

import huix.glacier.api.extension.material.IEquipmentMaterial;
import net.minecraft.EnumQuality;

public enum EnumCTMaterials implements IEquipmentMaterial {
    tungsten(32.0F, 35, 4.5F, EnumQuality.masterwork, "tungsten"),
    stone(2.0F, 0, 2.0F,EnumQuality.poor, "stone"),
    peachWood(0.5F, 20, 0.5F, EnumQuality.fine, "peachWood");

    public final float durability;
    public final int enchantability;
    public final float damage;
    public final EnumQuality max_quality;
    public final String name;

    EnumCTMaterials(float durability, int enchantability, float damage, EnumQuality max_quality, String name) {
        this.durability = durability;
        this.enchantability = enchantability;
        this.damage = damage;
        this.max_quality = max_quality;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getDurability() {
        return this.durability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public EnumQuality getMaxQuality() {
        return this.max_quality;
    }

    @Override
    public float getDamageVsEntity() {
        return this.damage;
    }
}
