package mod.mitecreation.materil;

import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.MapColor;
import net.minecraft.Material;
import net.minecraft.Minecraft;

public class Materials extends Material {

    public static final Materials tungsten;
    public static final Materials stone;

    static {
        Class<EnumEquipmentMaterial> enumEquipmentMaterialClass = EnumEquipmentMaterial.class;
        tungsten = (Materials) new Materials(EnumEquipmentMaterials.tungsten).setRequiresTool().setMetal(true).setMinHarvestLevel(4);
        stone = (Materials) new Materials(EnumEquipmentMaterials.stone).setRequiresTool().setRockyMineral().setMetal(false).setMinHarvestLevel(2);
    }

    public Materials(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
    }

    public Materials(String name, MapColor map_color) {
        super(name, map_color);
    }

    public Materials(String name) {
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
