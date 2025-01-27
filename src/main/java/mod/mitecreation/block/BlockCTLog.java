package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

public class BlockCTLog extends BlockLog {
    private BlockSubtypes subtypes = new BlockSubtypes(new String[]{"peach", "peach", "peach", "peach"});
    private Icon[] end_icons;

    public BlockCTLog(int par1) {
        super(par1);
        this.setCreativeTab(CTRegistryInit.tabCreationBlock);
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        int var7 = 4;
        int var8 = var7 + 1;
        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    for (int var11 = -var7; var11 <= var7; ++var11) {
                        int var13;
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);
                        if (var12 != CTRegistryInit.peachLeaves.blockID || ((var13 = par1World.getBlockMetadata(par2 + var9, par3 + var10, par4 + var11)) & 8) != 0) continue;
                        par1World.setBlockMetadataWithNotify(par2 + var9, par3 + var10, par4 + var11, var13 | 8, 4);
                    }
                }
            }
        }
    }

    @Override
    protected Icon getSideIcon(int par1) {
        return this.subtypes.getIcon(par1);
    }

    @Override
    protected Icon getEndIcon(int par1) {
        return this.end_icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures(), this.getTextureName() + "_"));
        this.end_icons = this.registerIcons(par1IconRegister, this.getTextures(), this.getTextureName() + "_", "_top");
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.wasExploded()) {
            return this.dropBlockAsEntityItem(info, Item.stick.itemID, 0, 1, 1.5f);
        }
        return super.dropBlockAsEntityItem(info);
    }

    @Override
    public String getNameDisambiguationForReferenceFile(int metadata) {
        return "creation_log";
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
