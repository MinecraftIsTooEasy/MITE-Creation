package mod.mitecreation.mixin.entity;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityArachnid.class)
public class EntityArachnidMixin extends EntityMob {

    public EntityArachnidMixin(World par1World) {
        super(par1World);
    }
}
