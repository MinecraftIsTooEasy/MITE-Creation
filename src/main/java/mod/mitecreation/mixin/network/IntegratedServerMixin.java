//package mod.mitecreation.mixin.network;
//
//import net.minecraft.IntegratedServer;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.Constant;
//import org.spongepowered.asm.mixin.injection.ModifyConstant;
//
//@Mixin(IntegratedServer.class)
//public class IntegratedServerMixin {
//    @ModifyConstant(method = "loadAllWorlds", constant = @Constant(intValue = 4))
//    protected int loadAllWorlds(int constant) {
//        return 256;
//    }
//}
