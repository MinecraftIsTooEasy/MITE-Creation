//package mod.mitecreation.mixin.block;
//
//import net.minecraft.*;
//import mod.mitecreation.materil.Materials;
//import org.spongepowered.asm.mixin.*;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Constant;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.ModifyConstant;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import java.util.Random;
//
//@Mixin(BlockWorkbench.class)
//public abstract class BlockWorkbenchMixin extends Block {
//
//    protected Icon[] front_icons = new Icon[16];
//
//    protected Icon[] side_icons = new Icon[16];
//
//    private final Random random = new Random();
//
//    @Shadow
//    @Mutable
//    @Final
//    private static Material[] tool_materials;
//
//    protected BlockWorkbenchMixin(int par1, Material par2Material, BlockConstants constants) {
//        super(par1, par2Material, constants);
//    }
//
//    @Inject(method = {"<init>(I)V"}, at = {@At("RETURN")})
//    private void injectInit(int par1, CallbackInfo callbackInfo) {
//        setMinHarvestLevel(1);
//    }
//
//    @Overwrite
//    public boolean isPortable(World world, EntityLivingBase entity_living_base, int x, int y, int z) {
//        if (world == null) {
//            return true;
//        } else {
//            return world.getBlockMetadata(x, y, z) > 3 && world.getBlockMetadata(x, y, z) < 13;
//        }
//
//    }
//
//    protected void dropXpOnBlockBreak(World par1World, int par2, int par3, int par4, int par5) {
//    }
//
//    @Inject(method = {"<clinit>()V"}, at = {@At("RETURN")})
//    private static void injectClinit(CallbackInfo callback) {
//        tool_materials = new Material[]{
//                Material.flint, Material.copper, Material.silver, Material.gold, Material.iron, Material.ancient_metal,
//                Materials.tungsten, Material.mithril, Material.adamantium, Material.obsidian};
//    }
//
//    @ModifyConstant(method = "getIcon", constant = @Constant(intValue = 10))
//    private int modify(int constant) {
//        return 12;
//    }
//
//    @ModifyConstant(method = "getIcon", constant = @Constant(intValue = 11))
//    private int modify_1(int constant) {
//        return 13;
//    }
//
//    @ModifyConstant(method = "getToolMaterial", constant = @Constant(intValue = 10))
//    private static int modify_2(int constant) {
//        return 12;
//    }
//
//    @ModifyConstant(method = "getToolMaterial", constant = @Constant(intValue = 8))
//    private static int modify_3(int constant) {
//        return 10;
//    }
//
//    @ModifyConstant(method = "isValidMetadata", constant = @Constant(intValue = 15))
//    private int modify_4(int constant) {
//        return 16;
//    }
//
//    @Inject(method = "registerIcons", at = @At("TAIL"))
//    private void inject(IconRegister par1IconRegister, CallbackInfo ci) {
//        int i = this.front_icons.length - 3;
//        this.front_icons[i] = par1IconRegister.registerIcon("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/front");
//        this.side_icons[i] = par1IconRegister.registerIcon("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/side");
//    }
//}
