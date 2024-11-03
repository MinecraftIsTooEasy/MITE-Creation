package mod.mitecreation.client.gui;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.RegistryInit;
import net.minecraft.Item;

public class CreativeTabsCreationItem extends GlacierCreativeTabs {
    public CreativeTabsCreationItem() {
        super("CreationItem");
    }

    @Override
    public Item getTabIconItem() {
        return RegistryInit.coinIron;
    }
}
