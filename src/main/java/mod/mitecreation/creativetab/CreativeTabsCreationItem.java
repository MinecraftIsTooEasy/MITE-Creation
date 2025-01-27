package mod.mitecreation.creativetab;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Item;

public class CreativeTabsCreationItem extends GlacierCreativeTabs {
    public CreativeTabsCreationItem() {
        super("creationItems");
    }

    @Override
    public Item getTabIconItem() {
        return CTRegistryInit.coinIron;
    }
}
