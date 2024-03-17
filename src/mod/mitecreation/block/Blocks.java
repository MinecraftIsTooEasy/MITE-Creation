package mod.mitecreation.block;

import mod.mitecreation.materil.Materials;
import mod.mitecreation.util.Util;
import net.minecraft.*;

import static mod.mitecreation.util.Util.getNextBlockID;
import static net.xiaoyu233.fml.util.ReflectHelper.createInstance;

public class Blocks extends Block {
    public static Block rustedIronBlock = new BlockOreStorage(getNextBlockID(), Material.rusted_iron);
    public static BlockAnvil anvilRustedIron = new BlockAnvils(getNextBlockID(), Material.rusted_iron);
//    public static final Block oreTungsten = new BlockOre(getNextBlockID(), Materials.tungsten, 3).setHardness(3.5F).setExplosionResistance(30.0f);
    public static final Block blockTungsten = new BlockOreStorage(getNextBlockID(), Materials.tungsten);
//    public static final Block fenceTungsten = createInstance(BlockPane.class, new Class[]{int.class, String.class, String.class, Material.class, boolean.class}
//            , getNextBlockID(), "bars/tungsten_bars", "bars/tungsten_bars", Materials.tungsten, false).setStepSound_(soundMetalFootstep).setExplosionResistance(96.0f).setBlockHardness(51.2F);
//    public static final Block doorTungsten = createInstance(BlockDoor.class, new Class[]{int.class, Material.class}
//            , getNextBlockID(), Materials.tungsten).setStepSound_(soundMetalFootstep);
    public static final BlockAnvil anvilTungsten = createInstance(BlockAnvil.class, new Class[]{int.class, Material.class}, getNextBlockID(), Materials.tungsten);

    protected Blocks(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    private static void registerAnvil(String resourceLocation, BlockAnvil block){
        block.setUnlocalizedName(resourceLocation);
//        block.setResourceLocation(resourceLocation);
        Item item = new ItemAnvilBlock(block).setUnlocalizedName(resourceLocation);
        Item.itemsList[Util.getNextItemID()] = item;
        item.setMaxStackSize(block.getItemStackLimit());
    }
    private static void registerItemBlock(String resourceLocation, Block block){
        block.setUnlocalizedName(resourceLocation);
//        block.setResourceLocation(resourceLocation);
        Item item = new ItemBlock(block).setUnlocalizedName(resourceLocation);
        item.setMaxStackSize(block.getItemStackLimit());
        Item.itemsList[Util.getNextItemID()] = item;
    }

    public static void registerBlocks() {
        registerItemBlock("rusted_iron_block", rustedIronBlock);
        registerAnvil("rusted_iron_anvil", anvilRustedIron);
        anvilRustedIron.stepSound = Block.soundAnvilFootstep;
//        registerItemBlock("ore/tungsten_ore", oreTungsten);
        registerItemBlock("block/tungsten_block", blockTungsten);
//        registerItemBlock("bars/tungsten_bars", fenceTungsten);
//        registerItemBlock("door/door_tungsten", doorTungsten);
        registerAnvil("tungsten_anvil", anvilTungsten);
        anvilTungsten.stepSound = Block.soundAnvilFootstep;
    }
}
