package mod.mitecreation.mixins.fml;

import mod.mitecreation.injected_interfaces.IIItemRegistryEvent;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;
import net.xiaoyu233.fml.api.item.IItem;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemRegistryEvent.class)
public class ItemRegistryEventMixin implements IIItemRegistryEvent {

    @Unique
    @Override
    public Item registerWithoutResource(String namespace, String unlocalized_name, Item item, CreativeTabs tab) {
        item.setUnlocalizedName(unlocalized_name);
        ((IItem) item).setNamespace(namespace);
        item.setCreativeTab(tab);
        return item;
    }
}
