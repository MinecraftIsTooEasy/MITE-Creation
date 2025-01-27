package mod.mitecreation.material;

import huix.glacier.api.extension.material.*;

public class MaterialCTPeachWood extends GlacierMaterial implements IToolMaterial {
    public MaterialCTPeachWood() {
        super(EnumCTMaterials.peachWood);
    }

    @Override
    public float getDamageVsEntity() {
        return 0.0F;
    }

    @Override
    public float getHarvestEfficiency() {
        return 0.5F;
    }
}
