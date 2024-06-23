package mod.mitecreation.block;

import net.minecraft.*;

public class BlockDeepStaleBrick extends Block implements IBlockWithSubtypes{
    public static final String[] DEEPSTALE_BRICK_TYPES = new String[]{"default", "mossy", "cracked", "chiseled"};
    public static final String[] DEEPSTALE_BRICK_TEXTURE_TYPES = new String[]{null, "mossy", "cracked", "carved"};
    public static Icon[] DEEPSTALE_BRICK_ICONS;
    public BlockSubtypes subtypes = new BlockSubtypes(new String[] {"default", "mossy", "cracked", "chiseled"});

    public BlockDeepStaleBrick(int par1) {
        super(par1, Material.stone, new BlockConstants());
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public Icon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= DEEPSTALE_BRICK_TEXTURE_TYPES.length) {
            par2 = 0;
        }

        return this.DEEPSTALE_BRICK_ICONS[par2];
    }

    public String getMetadataNotes() {
        return "0=Regular, 1=Mossy, 2=Cracked, 3=Chiseled";
    }

    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 4;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 3;
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.DEEPSTALE_BRICK_ICONS = new Icon[DEEPSTALE_BRICK_TEXTURE_TYPES.length];

        for(int i = 0; i < this.DEEPSTALE_BRICK_ICONS.length; ++i) {
            String textureName = this.getTextureName();
            if (DEEPSTALE_BRICK_TEXTURE_TYPES[i] != null) {
                textureName = textureName + "_" + DEEPSTALE_BRICK_TEXTURE_TYPES[i];
            }

            this.DEEPSTALE_BRICK_ICONS[i] = par1IconRegister.registerIcon(textureName);
        }

    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return info.wasExploded() ? this.dropBlockAsEntityItem(info, CreationBlock.cobbleDeepStale) : super.dropBlockAsEntityItem(info);
    }

    @Override
    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    @Override
    public String[] getNames() {
        return this.subtypes.getNames();
    }
}
