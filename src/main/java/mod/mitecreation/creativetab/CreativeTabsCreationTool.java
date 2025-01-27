package mod.mitecreation.creativetab;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.Item;

public class CreativeTabsCreationTool extends GlacierCreativeTabs {
    public CreativeTabsCreationTool() {
        super("creationTools");
    }

    @Override
    public Item getTabIconItem() {
        return CTRegistryInit.swordTungsten;
    }
}
