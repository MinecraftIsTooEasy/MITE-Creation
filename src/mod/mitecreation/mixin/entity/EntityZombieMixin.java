package mod.mitecreation.mixin.entity;

import mod.mitecreation.item.Items;
import net.minecraft.EntityZombie;
import net.minecraft.Item;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityZombie.class)
public class EntityZombieMixin {
    @Shadow
    Item[] rare_drops_standard;

    public EntityZombieMixin() {
        super();
        this.rare_drops_standard = new Item[]{Item.copperNugget, Item.silverNugget, Item.goldNugget, Items.rustedIronNugget};
    }
}
