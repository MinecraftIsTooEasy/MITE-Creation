package mod.mitecreation.injected_interfaces;

import net.minecraft.CreativeTabs;
import net.minecraft.Item;

public interface IIItemRegistryEvent {

    default Item registerWithoutResource(String namespace, String unlocalized_name, Item item, CreativeTabs tab) {
        return item;
    }
}
