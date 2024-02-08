package mod.mitecreation.mixin.block;

import mod.mitecreation.block.Blocks;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value=Block.class)
public class BlockMixin{
    @Shadow
    private String textureName;
    public Block setResourceLocation(String string) {
        return this.setTextureName(string);
    }
    @Shadow
    private Block setTextureName(String string) {
        return null;
    }
    @Redirect(method="<clinit>",at=@At(value="INVOKE",target="INVOKESTATIC net/minecraft/StatisticList.initBreakableStats()V"))
    private static void blocksInjector(CallbackInfo callbackInfo){
        StatisticList.initBreakableStats();
    }
    @Shadow
    @Final
    public Material blockMaterial;
    public Block block;

    @Shadow
    float blockHardness;
    @Shadow
    public final int dropBlockAsEntityItem(BlockBreakInfo info, int id_dropped, int subtype, int quantity, float chance) {
        return 1;
    }
    @Shadow
    private EntityItem dropBlockAsItem_do(BlockBreakInfo info, ItemStack item_stack) {
        return null;
    }
    @Shadow
    @Final
    private boolean has_item_subtypes;
    @Shadow
    @Final
    private int num_item_subtypes;
    @Shadow
    @Final
    private int[] item_subtypes;
    @Shadow
    @Final
    public List getItemStacks() {
        return null;
    }
    @Shadow
    public boolean isSolid(boolean[] is_solid, int metadata) {
        return true;
    }
    @Shadow
    @Final
    public boolean isSolid(int metadata) {
        return this.is_solid[metadata];
    }
    @Shadow
    public CreativeModeTab D() {
        return null;
    }
    @Shadow
    public boolean canSilkHarvest(int metadata) {
        return false;
    }
    @Shadow
    public boolean canBeCarried() {
        return true;
    }
    @Shadow
    public int getRenderType() {
        return 0;
    }

    @Shadow
    @Final
    public boolean is_normal_cube;
    @Shadow
    @Final
    public boolean renderAsNormalBlock() {
        return false;
    }
    @Shadow
    public boolean isValidMetadata(int metadata) {
        return false;
    }
    @Shadow
    @Final
    public boolean isAlwaysOpaqueStandardFormCube() {
        return false;
    }
    @Shadow
    @Final
    public boolean neverHidesAdjacentFaces() {
        return false;
    }
    @Shadow
    @Final
    public final boolean isAlwaysStandardFormCube() {
        return false;
    }
    @Shadow
    @Final
    public int blockID;
    @Shadow
    @Final
    private boolean[] use_neighbor_brightness;
    @Shadow
    private int max_stack_size = 4;
    @Shadow
    public boolean has_grass_top_icon;
    @Shadow
    private final boolean[] is_solid = new boolean[16];
    @Shadow
    @Final
    public boolean is_always_solid;
    @Shadow
    @Final
    public boolean is_never_solid;
    @Shadow
    @Final
    private boolean[] is_standard_form_cube;
    @Shadow
    @Final
    public boolean is_always_standard_form_cube;
    @Shadow
    @Final
    public boolean is_never_standard_form_cube;
    @Shadow
    @Final
    private boolean[] is_solid_and_standard_form_cube;
    @Shadow
    @Final
    public boolean is_always_solid_standard_form_cube;
    @Shadow
    @Final
    public boolean is_never_solid_standard_form_cube;
    @Shadow
    @Final
    public boolean is_always_opaque_standard_form_cube;
    @Shadow
    @Final
    public boolean is_never_opaque_standard_form_cube;
    @Shadow
    @Final
    public boolean is_always_solid_opaque_standard_form_cube;
    @Shadow
    @Final
    public boolean is_never_solid_opaque_standard_form_cube;
    @Shadow
    @Final
    public boolean never_hides_adjacent_faces;
    @Shadow
    @Final
    public boolean is_always_legal;
    @Shadow
    @Final
    public boolean is_always_immutable;

    @Shadow
    protected void dropXpOnBlockBreak(World par1World, int par2, int par3, int par4, int par5) {
    }

    @Shadow
    public boolean canDropExperienceOrbs() {
        return false;
    }

    @Shadow
    public ItemStack createStackedBlock(int metadata) {
        return null;
    }


    @Shadow protected Block setResistance(float par1){
        return null;
    };

    public String getItemDisplayName(ItemStack itemStack){
        return ("" + LocaleI18n.translateToLocal(itemStack.getItem().getUnlocalizedNameInefficiently(itemStack) + ".name")).trim();
    }

    public Block setBlockHardness(float resistance) {
        return this.setHardness(resistance);
    }

    public Block setExplosionResistance(float v) {
        return this.setResistance(v);
    }

    public Block setBlockLightLevel(float v){
        return this.setLightValue(v);
    }

    @Shadow
    public Block setHardness(float par1) {
        return null;
    }

    @Shadow
    public Block setLightValue(float exp) {
        return null;
    }

    @Shadow
    public Block setStepSound(StepSound par1StepSound) {
        return null;
    }

    public Block setStepSound_(StepSound stepSound) {
        return this.setStepSound(stepSound);
    }


}
