package mod.mitecreation.material;

import huix.glacier.api.extension.material.IEquipmentMaterial;
import net.minecraft.EnumQuality;

public enum EnumCreationMaterials implements IEquipmentMaterial {
    tungsten(32.0F, 35, 4.5F, EnumQuality.masterwork, "tungsten"),
    stone(2.0F, 0, 2.0F,EnumQuality.poor, "stone");

    public final float durability;
    public final int enchantability;
    public final float damage;
    public final EnumQuality max_quality;
    public final String name;

    EnumCreationMaterials(float durability, int enchantability, float damage,EnumQuality max_quality, String name) {
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
