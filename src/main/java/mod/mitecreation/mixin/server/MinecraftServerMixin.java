//package mod.mitecreation.mixin.server;
//
//import net.minecraft.*;
//import net.minecraft.server.MinecraftServer;
//import org.spongepowered.asm.mixin.*;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Constant;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.ModifyConstant;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.io.File;
//
//@Mixin(MinecraftServer.class)
//public class MinecraftServerMixin {
//    @Shadow public WorldServer[] worldServers;
//
//    @Mutable
//    @Shadow @Final public static int num_world_servers;
//
//    @Inject(method = "getWorldIndexForDimensionId", at = @At("HEAD"), cancellable = true)
//    private static void getWorldIndexForDimensionId(int dimension_id, CallbackInfoReturnable<Integer> cir) {
//        if (dimension_id == 9) {
//            cir.setReturnValue(9);
//        }
//    }
//
//    @Inject(method = "getWorldDimensionIdFromIndex", at = @At("HEAD"), cancellable = true)
//    private static void getWorldDimensionIdFromIndex(int index, CallbackInfoReturnable<Integer> cir) {
//        if (index == 9) {
//            cir.setReturnValue(9);
//        }
//    }
//
//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void modifyWorldServerNum(File par1File, CallbackInfo ci) {
//        num_world_servers = 256;
//    }
//
//    @ModifyConstant(method = "loadAllWorlds", constant = @Constant(intValue = 4))
//    protected int loadAllWorlds(int constant) {
//        return 256;
//    }
//
//    @Overwrite
//    public WorldServer worldServerForDimension(int par1) {
//        return this.worldServers[256];
//    }
//}
