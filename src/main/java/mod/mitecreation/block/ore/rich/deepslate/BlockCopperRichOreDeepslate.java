package mod.mitecreation.block.ore.rich.deepslate;

import mod.mitecreation.block.ore.BlockRichOreDeepslate;
import net.minecraft.Icon;
import net.minecraft.IconRegister;
import net.minecraft.Material;

public class BlockCopperRichOreDeepslate extends BlockRichOreDeepslate {
    public static final String[] RICH_ORE_TEXTURE_TYPES = new String[]{"deepslate", "deepslate"};
    public static Icon[] RICH_ORE_ICONS;

    public BlockCopperRichOreDeepslate(int par1, Material vein_material, int min_harvest_level) {
        super(par1, vein_material, min_harvest_level);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= RICH_ORE_TEXTURE_TYPES.length) {
            par2 = 0;
        }
        return this.RICH_ORE_ICONS[par2];
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.RICH_ORE_ICONS = new Icon[RICH_ORE_TEXTURE_TYPES.length];

        for(int i = 0; i < this.RICH_ORE_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (RICH_ORE_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + RICH_ORE_TEXTURE_TYPES[i];
            }
            this.RICH_ORE_ICONS[i] = par1IconRegister.registerIcon(textureName);
        }

    }
}
