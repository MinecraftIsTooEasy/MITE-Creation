package mod.mitecreation.block;

import mod.mitecreation.block.api.BlockAnvils;
import mod.mitecreation.block.api.BlockDoors;
import mod.mitecreation.block.api.BlockPanes;
import mod.mitecreation.materil.Materials;
import net.minecraft.*;
import net.xiaoyu233.fml.api.block.AnvilBlock;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.util.IdUtil;

public class Blocks extends Block {
    public static Block rustedIronBlock = new BlockOreStorage(IdUtil.getNextBlockID(), Material.rusted_iron);

    public static BlockAnvil anvilRustedIron = new BlockAnvils(IdUtil.getNextBlockID(), Material.rusted_iron);

    public static final Block oreTungsten = (new BlockOre(IdUtil.getNextBlockID(), Materials.tungsten, 4)).setHardness(3.5F).setResistance(30.0F);

    public static final Block blockTungsten = (new BlockOreStorage(IdUtil.getNextBlockID(), Materials.tungsten)).setStepSound(Block.soundMetalFootstep);

    public static final Block fenceTungsten = (new BlockPanes(IdUtil.getNextBlockID(), "bars/tungsten_bars", "bars/tungsten_bars", Materials.tungsten, false)).setStepSound(Block.soundMetalFootstep).setResistance(96.0F).setHardness(51.2F).setMinHarvestLevel(5);

    public static final Block doorTungsten = (new BlockDoors(IdUtil.getNextBlockID(), Materials.tungsten)).setStepSound(Block.soundMetalFootstep).setMinHarvestLevel(5);

    public static final BlockAnvil anvilTungsten = new AnvilBlock(IdUtil.getNextBlockID(), Materials.tungsten);

    protected Blocks(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    public static void registerBlocks(ItemRegistryEvent registryEvent) {
        registryEvent.registerItemBlock(rustedIronBlock, "rusted_iron_block");
        registryEvent.registerAnvil(anvilRustedIron, "rusted_iron_anvil");
        anvilRustedIron.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerAnvil(anvilTungsten, "tungsten_anvil");
        anvilTungsten.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerItemBlock(oreTungsten, "ore/tungsten_ore");
        registryEvent.registerItemBlock(blockTungsten, "block/tungsten_block");
        registryEvent.registerItemBlock(fenceTungsten, "bars/tungsten_bars");
        registryEvent.registerItemBlock(doorTungsten, "door/door_tungsten");
    }

}
