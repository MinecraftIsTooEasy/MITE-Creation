//package mod.mitecreation.mixin.world.chunk;
//
//import mod.mitecreation.world.dimesion.WorldProviderRedSky;
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Mixin(AnvilSaveHandler.class)
//public class AnvilSaveHandlerMixin extends SaveHandler {
//    public AnvilSaveHandlerMixin(File par1File, String par2Str, boolean par3) {
//        super(par1File, par2Str, par3);
//    }
//
//    @Inject(method = "getChunkLoader", at = @At("HEAD"), cancellable = true)
//    public void getChunkLoader(WorldProvider par1WorldProvider, CallbackInfoReturnable<IChunkLoader> cir) {
//        File var2 = this.getWorldDirectory();
//        File var3;
//        if (par1WorldProvider instanceof WorldProviderRedSky) {
//            var3 = new File(var2, "DIM_9");
//            var3.mkdirs();
//            cir.setReturnValue(new AnvilChunkLoader(var3));
//        }
//    }
//
////    @Override
////    public void checkSessionLock() throws MinecraftException
////    {
////        try
////        {
////            File var1 = new File(this.getWorldDirectory(), "session.lock");
////            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
////
////            try
////            {
//////                if (var2.readLong() != this.initializationTime)
//////                {
////                    Minecraft.setErrorMessage("checkSessionLock: aborting world save due to session lock");
////                    throw new MinecraftException("The save is being accessed from another location, aborting");
//////                }
////            }
////            finally
////            {
////                var2.close();
////            }
////        }
////        catch (IOException var7)
////        {
////            throw new MinecraftException("Failed to check session lock, aborting");
////        }
////    }
//}
