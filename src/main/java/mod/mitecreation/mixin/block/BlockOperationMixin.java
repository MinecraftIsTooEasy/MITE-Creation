package mod.mitecreation.mixin.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockOperation.class)
public class BlockOperationMixin {
    @Shadow @Final public EnumBlockOperation type;
    @Shadow @Final public int x;
    @Shadow @Final public int y;
    @Shadow @Final public int z;
    @Shadow @Final public Object object;

    @Inject(method = "perform", at = @At("HEAD"))
    public void perform(WorldServer world, CallbackInfo ci) {
        Block block = world.getBlock(this.x, this.y, this.z);
         if (this.type == EnumBlockOperation.spawn_silverfish && block == RegistryInit.deepslateSilverFish) {
            world.watchAnimal(-1, this.x, this.y, this.z, -2);
            int metadata = world.getBlockMetadata(this.x, this.y, this.z);
            world.destroyBlock((new BlockBreakInfo(world, this.x, this.y, this.z)).setSilverfish((EntityPlayer)this.object), false);
            BlockSilverfish.spawnSilverfishEntity(world, this.x, this.y, this.z, metadata, (EntityPlayer)this.object);
        }

    }
}
