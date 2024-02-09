package mod.mitecreation.mixin.entity;

import net.minecraft.EntityBoneLord;
import net.minecraft.EntitySkeleton;
import net.minecraft.GenericAttributes;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityBoneLord.class)
public class EntityBoneLordMixin extends EntitySkeleton {
    public EntityBoneLordMixin(World par1World) {
        super(par1World);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.setEntityAttribute(GenericAttributes.followRange, 40.0);
        this.setEntityAttribute(GenericAttributes.movementSpeed, 0.25999999046325684);
        this.setEntityAttribute(GenericAttributes.attackDamage, 6.0);
        this.setEntityAttribute(GenericAttributes.maxHealth, 20.0);
    }
}
