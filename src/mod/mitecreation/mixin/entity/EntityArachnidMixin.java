package mod.mitecreation.mixin.entity;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityArachnid.class)
public class EntityArachnidMixin extends EntityMonster {

    public EntityArachnidMixin(World par1World) {
        super(par1World);
    }
}
