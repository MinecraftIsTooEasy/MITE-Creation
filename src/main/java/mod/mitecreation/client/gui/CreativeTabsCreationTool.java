package mod.mitecreation.client.gui;

import huix.glacier.api.extension.creativetab.GlacierCreativeTabs;
import mod.mitecreation.init.RegistryInit;
import net.minecraft.Item;

public class CreativeTabsCreationTool extends GlacierCreativeTabs {
    public CreativeTabsCreationTool() {
        super("CreationTool");
    }

    @Override
    public Item getTabIconItem() {
        return RegistryInit.swordTungsten;
    }
}
