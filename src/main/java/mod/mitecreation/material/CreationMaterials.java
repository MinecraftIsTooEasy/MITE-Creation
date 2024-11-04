package mod.mitecreation.material;

import net.minecraft.Material;

public abstract class CreationMaterials {
    public static Material tungsten = new MaterialTungsten().setMetal(true).setMinHarvestLevel(4);
    public static Material stone = new MaterialStone().setRockyMineral().setMetal(false).setMinHarvestLevel(2);
}
