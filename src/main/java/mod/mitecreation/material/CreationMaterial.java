package mod.mitecreation.material;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.MapColor;
import net.minecraft.Material;
import net.minecraft.Minecraft;

public class CreationMaterial extends Material {

    public static final CreationMaterial tungsten;
    public static final CreationMaterial stone;

    static {
        Class<EnumEquipmentMaterial> enumEquipmentMaterialClass = EnumEquipmentMaterial.class;
        tungsten = (CreationMaterial) new CreationMaterial(EnumEquipmentMaterials.tungsten).setRequiresTool().setMetal(true).setMinHarvestLevel(4);
        stone = (CreationMaterial) new CreationMaterial(EnumEquipmentMaterials.stone).setRequiresTool().setRockyMineral().setMetal(false).setMinHarvestLevel(2);
    }

    public CreationMaterial(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    public CreationMaterial(String name, MapColor map_color) {
        super(name, map_color);
    }

    public CreationMaterial(String name) {
        super(name);
    }

    public String getName() {
        return super.name;
    }

    public float getDurability() {
        return super.durability;
    }

    public float getDamageVsEntity() {
        if (this == tungsten){
            return 4.5F;
        } else if (this == emerald) {
            return 0.0F;
        } else {
            Minecraft.setErrorMessage("getDamageVsEntity: unhandled material " + this.name);
            return 0.0F;
        }
    }
}
