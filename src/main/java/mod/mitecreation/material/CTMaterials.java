package mod.mitecreation.material;

import net.minecraft.Material;

public abstract class CTMaterials {
    public static Material tungsten = new MaterialCTTungsten().setMetal(true).setMinHarvestLevel(4);
    public static Material stone = new MaterialCTStone().setRockyMineral().setMetal(false).setMinHarvestLevel(2);
    public static Material peachWood = new MaterialCTPeachWood().setMetal(false).setMinHarvestLevel(0);
}
