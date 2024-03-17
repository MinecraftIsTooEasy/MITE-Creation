//package mod.mitecreation.mixin.block;
//
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Implements;
//import org.spongepowered.asm.mixin.Interface;
//import org.spongepowered.asm.mixin.Mixin;
//
//@Mixin(BlockGoldOre.class)
//@Implements(@Interface(iface = IBlockWithSubtypes.class,prefix = "vw$"))
//public class BlockGoldOreMixin extends BlockOre implements IBlockWithSubtypes {
//
//    public int richOrPoor;
//
//    private BlockSubtypes subtypes = new BlockSubtypes(new String[]{"gold_ore_poor", "gold_ore_normal", "gold_ore_rich", "gold_ore_poor_deepslate", "gold_ore_normal_deepslate", "gold_ore_rich_deepslate", "gold_ore_poor_netherrack", "gold_ore_normal_netherrack", "gold_ore_normal_netherrack"});
//
//    public BlockGoldOreMixin(int par1, Material vein_material, int min_harvest_level) {
//        super(par1, vein_material, min_harvest_level);
//    }
//
//    public String getMetadataNotes() {
//        return "0=Gold Ore Poor Stone, 1=Gold Ore Normal Stone, 2=Gold Ore Rich Stone, 3=Gold Ore Poor Deepslate, 4=Gold Ore Normal Deepslate, 5=Gold Ore Rich Deepslate, 6=Gold Ore Poor Netherrack, 7=Gold Ore Normal Netherrack, 8=Gold Ore Rich Netherrack";
//    }
//
//    public boolean isValidMetadata(int metadata) {
//        return metadata >= 0 && metadata < 9;
//    }
//
////    public int getBlockSubtypeUnchecked(int metadata) {
////        return BitHelper.isBitSet(metadata, 2) ? 1 : 0;
////    }
////
////    public int getItemSubtype(int metadata) {
////        return this.getBlockSubtype(metadata) == 1 ? 2 : 0;
////    }
//
//    private static boolean isGoldOreNetherrack(Block block, int metadata) {
//        return block == oreGold && block.getBlockSubtype(metadata) >= 6;
//    }
//
//    public void a(mt par1IconRegister) {
//        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures()));
//    }
//
//    public IIcon a(int side, int metadata) {
//        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
//    }
//
//    public String[] getTextures() {
//        return this.subtypes.getTextures();
//    }
//
//    public String[] getNames() {
//        return this.subtypes.getNames();
//    }
//
////    public int getMetadataForPlacement(World world, int x, int y, int z, ItemStack item_stack, Entity entity, EnumFace face, float offset_x, float offset_y, float offset_z) {
////        return item_stack.getItemSubtype() | 1;
////    }
//    public float getBlockHardness(int metadata) {
//        switch (metadata) {
//            case 0:
//                return super.getBlockHardness(metadata) * 0.7f;
//            case 1:
//                return super.getBlockHardness(metadata);
//            case 2:
//                return super.getBlockHardness(metadata) * 1.4f;
//            case 3:
//                return super.getBlockHardness(metadata) * 0.7f * 1.25f;
//            case 4:
//                return super.getBlockHardness(metadata) * 1.25f;
//            case 5:
//                return super.getBlockHardness(metadata) * 1.4f * 1.25f;
//        }
//        return super.getBlockHardness(metadata);
//    }
//}
