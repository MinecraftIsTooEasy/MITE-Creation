package mod.mitecreation.mixins.block.tileentity;

import net.minecraft.TileEntity;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = TileEntity.class)
public class TileEntityMixin {

    @Shadow
    protected World worldObj;
    @Shadow
    protected int xCoord;
    @Shadow
    protected int yCoord;
    @Shadow
    protected int zCoord;
    @Shadow
    protected void onInventoryChanged() {
    }
}
