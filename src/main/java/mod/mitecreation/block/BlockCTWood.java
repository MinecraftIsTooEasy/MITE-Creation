package mod.mitecreation.block;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;

public class BlockCTWood extends BlockWood {
    private BlockSubtypes subtypes = new BlockSubtypes(new String[]{"peach"});

    public BlockCTWood(int par1) {
        super(par1);
        this.setCreativeTab(CTRegistryInit.tabCreationBlock);
    }

    public boolean isValidMetadata(int metadata) {
        return metadata == 0;
    }

    public int getBlockSubtypeUnchecked(int metadata) {
        return metadata & 1;
    }

//    public void registerIcons(IconRegister par1IconRegister) {
//        par1IconRegister.registerIcon(MITECreationModInit.RESOURCEID + "wood_peach");
//    }
    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures(), this.getTextureName() + "_"));
    }

    public Icon getIcon(int side, int metadata) {
        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
    }

//    public Icon getIcon(int side, int metadata) {
//        return this.subtypes.getIcon(0);
//    }

    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    public String[] getNames() {
        return this.subtypes.getNames();
    }
}
