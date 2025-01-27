package mod.mitecreation.material;

import huix.glacier.api.extension.material.GlacierMaterial;

public class MaterialCTStone extends GlacierMaterial {
    public MaterialCTStone() {
        super(EnumCTMaterials.stone);
    }

    @Override
    public float getDamageVsEntity() {
        return 2.0F;
    }

}
