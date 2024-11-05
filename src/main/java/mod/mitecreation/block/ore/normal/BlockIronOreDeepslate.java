package mod.mitecreation.block.ore.normal;

import mod.mitecreation.block.ore.BlockOreDeepslate;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockIronOreDeepslate extends BlockOreDeepslate {
    public static final String[] ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] ORE_ICONS;

    public BlockIronOreDeepslate(int par1, Material vein_material, int min_harvest_level) {
        super(par1, vein_material, min_harvest_level);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }
        return this.ORE_ICONS[par2];
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.ORE_ICONS = new Icon[ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + ORE_TEXTURE_TYPES[i];
            }
            this.ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
        }

    }
}
