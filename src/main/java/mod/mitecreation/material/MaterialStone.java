package mod.mitecreation.material;

import huix.glacier.api.extension.material.*;

public class MaterialStone extends GlacierMaterial {
    public MaterialStone() {
        super(EnumCreationMaterials.stone);
    }

    @Override
    public float getDamageVsEntity() {
        return 2.0F;
    }

}
