package mod.mitecreation.client.gui;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.RegistryInit;

public class CreativeTabsCreationBlock extends GlacierCreativeTabs {
    public CreativeTabsCreationBlock() {
        super("CreationBlock");
    }

    @Override
    public int getTabIconItemIndex() {
        return RegistryInit.rustedIronBlock.blockID;
    }
}