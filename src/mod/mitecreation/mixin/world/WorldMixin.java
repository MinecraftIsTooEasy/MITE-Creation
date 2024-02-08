package mod.mitecreation.mixin.world;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;

@Mixin(value= World.class)
public abstract class WorldMixin {
    @Inject(method="setBlock",at=@At("INVOKE"))
    public final void poorOrRichInjector(int n, int n2, int n3, int n4, int n5, int n6, CallbackInfoReturnable callbackInfo){
        int i = new Random().nextInt(2);
        int i2 = new Random().nextInt(2);
        if(getBlock(n,n2,n3) instanceof BlockOre){
            ((BlockOre)getBlock(n,n2,n3)).richOrPoor = (i + i2);
            ((BlockOre)getBlock(n,n2,n3)).setResourceLocation(getBlock(n,n2,n3).getUnlocalizedName());
        }
    }
    @Shadow
    public final Block getBlock(int n, int n2, int n3){
        return null;
    }
}
