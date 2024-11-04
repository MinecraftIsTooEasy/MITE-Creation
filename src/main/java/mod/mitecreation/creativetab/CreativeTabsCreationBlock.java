package mod.mitecreation.creativetab;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.RegistryInit;

public class CreativeTabsCreationBlock extends GlacierCreativeTabs {
    public CreativeTabsCreationBlock() {
        super("creationBlocks");
    }

    @Override
    public int getTabIconItemIndex() {
        return RegistryInit.rustedIronBlock.blockID;
    }
}