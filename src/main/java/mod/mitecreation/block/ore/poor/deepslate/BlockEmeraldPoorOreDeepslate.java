package mod.mitecreation.block.ore.poor.deepslate;

import mod.mitecreation.block.ore.BlockPoorOre;
import mod.mitecreation.block.ore.BlockPoorOreDeepslate;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockEmeraldPoorOreDeepslate extends BlockPoorOreDeepslate {
    public static final String[] POOR_ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] POOR_ORE_ICONS;

    public BlockEmeraldPoorOreDeepslate(int par1, Material vein_material, int min_harvest_level) {
        super(par1, vein_material, min_harvest_level);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= POOR_ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }
        return this.POOR_ORE_ICONS[par2];
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.POOR_ORE_ICONS = new Icon[POOR_ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.POOR_ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (POOR_ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + POOR_ORE_TEXTURE_TYPES[i];
            }
            this.POOR_ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
        }

    }
}
