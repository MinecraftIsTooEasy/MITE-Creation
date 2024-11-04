package mod.mitecreation.item;

import mod.mitecreation.material.CreationMaterials;
import mod.mitecreation.material.MaterialTungsten;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.ItemFishingRod;
import net.minecraft.Material;

public class CreationItemFishingRod extends ItemFishingRod {
    public CreationItemFishingRod(int par1, Material hook_material) {
        super(par1, hook_material);
    }

    private Icon castIcon;
    private final Icon[] uncastIcons = new Icon[2];

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.castIcon = par1IconRegister.registerIcon("fishing_rod_cast");
        for (int i = 0; i < this.uncastIcons.length; ++i) {
            this.uncastIcons[i] = par1IconRegister.registerIcon("fishing_rods/" + this.getMaterialByOrdinal(i).name + "_uncast");
        }
    }

    @Override
    public Icon getIconFromSubtype(int par1) {
        return this.uncastIcons[this.getMaterialOrdinal()];
    }

    private int getMaterialOrdinal() {
        if (this.getHookMaterial() == Material.rusted_iron) {
            return 0;
        }
        if (this.getHookMaterial() == CreationMaterials.tungsten) {
            return 1;
        }
        return -1;
    }

    private Material getMaterialByOrdinal(int ordinal) {
        return switch (ordinal) {
            case 0 -> Material.rusted_iron;
            case 1 -> CreationMaterials.tungsten;
            default -> Material.flint;
        };
    }

    @Override
    public Icon func_94597_g() {
        return this.castIcon;
    }
}
