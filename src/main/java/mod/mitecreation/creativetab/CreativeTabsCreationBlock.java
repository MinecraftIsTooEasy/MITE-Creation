package mod.mitecreation.creativetab;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.CTRegistryInit;

public class CreativeTabsCreationBlock extends GlacierCreativeTabs {
    public CreativeTabsCreationBlock() {
        super("creationBlocks");
    }

    @Override
    public int getTabIconItemIndex() {
        return CTRegistryInit.rustedIronBlock.blockID;
    }
}