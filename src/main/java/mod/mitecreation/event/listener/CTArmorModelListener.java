package mod.mitecreation.event.listener;

import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.api.event.listener.IArmorModelListener;
import net.minecraft.ItemArmor;
import net.minecraft.ResourceLocation;

public class CTArmorModelListener implements IArmorModelListener {
    public ResourceLocation getArmorTexture(ItemArmor itemArmor, int slotIndex) {
        String resourcePath = String.format("textures/models/armor/%s_layer_%d%s.png", itemArmor.getTextureFilenamePrefix(), slotIndex == 2 ? 2 : 1, "");
        if (itemArmor.getArmorMaterial() == CTMaterials.tungsten)
            return new ResourceLocation(CreationModInit.ID, resourcePath);
        return null;
    }
}
