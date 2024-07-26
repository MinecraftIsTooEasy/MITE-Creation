package mod.mitecreation.block;

import mod.mitecreation.item.CreationItem;
import mod.mitecreation.materil.CreationMaterial;
import mod.rustedironcore.api.block.DoorBlock;
import mod.rustedironcore.api.block.PaneBlock;
import mod.rustedironcore.api.block.StairsBlock;
import mod.rustedironcore.api.block.WallBlock;
import net.minecraft.*;
import net.xiaoyu233.fml.api.block.AnvilBlock;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import static mod.mitecreation.MITECreationMod.CreationNameSpace;

public class CreationBlock extends Block {
    public static final Block rustedIronBlock;
    public static final BlockAnvil anvilRustedIron;
    public static final Block oreTungsten;
    public static final Block blockTungsten;
    public static final Block fenceTungsten;
    public static final Block doorTungsten;
    public static final BlockAnvil anvilTungsten;
    public static final BlockDeepStaleBrick deepStaleBrick;
    public static final BLockDeepSlateMagma deepStaleMagma;
    public static final Block cobbleDeepStale;
    public static final Block stairsCobbleDeepSlate;
    public static final Block stairsDeepSlateBrick;
    public static final BlockSandGravel gravelSand;
    public static final BlockDeepSlateGravel gravelDeepSlate;
    public static final Block cobbleDeepStaleWall;
    public static final Block deepStaleBrickWall;
    public static final Block deepSlate;
    public static final BlockCobbleDeepSlateSlabGroup cobbledDeepStaleSingleSlab;
    public static final BlockDeepSlateDoubleSlab cobbledDeepStaleDoubleSlab;
    public static final BlockDeepSlateBrickSlabGroup deepStaleBrickSingleSlab;
    public static final BlockDeepSlateDoubleSlab deepStaleBrickDoubleSlab;
    public static final BlockAncientRelict ancientRelict;
    public static final Block creationWorkBench;


    protected CreationBlock(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    public static void registerBlocks(ItemRegistryEvent registryEvent) {
        registryEvent.registerItemBlock(CreationNameSpace, "rusted_iron_block", rustedIronBlock);
        registryEvent.registerAnvil(CreationNameSpace, "rusted_iron_anvil", anvilRustedIron);
        anvilRustedIron.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerAnvil(CreationNameSpace, "tungsten_anvil", anvilTungsten);
        anvilTungsten.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerItemBlock(CreationNameSpace, "tungsten_ore", oreTungsten);
        registryEvent.registerItemBlock(CreationNameSpace, "block/tungsten_block", blockTungsten);
        registryEvent.registerItemBlock(CreationNameSpace, "bars/tungsten_bars", fenceTungsten);
        registryEvent.registerItemBlock(CreationNameSpace, "door/door_tungsten", doorTungsten);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate_brick", deepStaleBrick);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate_brick_magma", deepStaleMagma);
        registryEvent.registerItemBlock(CreationNameSpace, "cobble_deepslate", cobbleDeepStale);
        registryEvent.registerItemBlock(CreationNameSpace, "cobble_deepslate_stairs", stairsCobbleDeepSlate);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate_brick_stairs", stairsDeepSlateBrick);
        registryEvent.registerItemBlock(CreationNameSpace, "cobble_deepslate_wall", cobbleDeepStaleWall);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate_brick_wall", deepStaleBrickWall);
        registryEvent.registerItemBlock(CreationNameSpace, "sand_gravel", gravelSand);
        registryEvent.registerItemBlock(CreationNameSpace, "deepsltae_gravel", gravelDeepSlate);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate", deepSlate);
        registryEvent.registerItemBlock(CreationNameSpace, "cobbledDeepslateSlab", cobbledDeepStaleSingleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "cobbledDeepslateSlab", cobbledDeepStaleDoubleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslateBrickSlab", deepStaleBrickSingleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslateBrickSlab", deepStaleBrickDoubleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "ancient_relict", ancientRelict);
        registryEvent.registerItemBlock(CreationNameSpace, "work_bench", creationWorkBench);


//        registryEvent.registerItemBlock(CreationNameSpace, "deepsltae_slab", cobbledDeepStaleSingleSlab);
//        registryEvent.registerItemBlock(CreationNameSpace, "deepsltae_slab", cobbledDeepStaleDoubleSlab);
    }

    static {
        rustedIronBlock = new BlockOreStorage(IdUtil.getNextBlockID(), Material.rusted_iron);

        anvilRustedIron = new AnvilBlock(IdUtil.getNextBlockID(), Material.rusted_iron);

        oreTungsten = (new BlockOre(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4))
                .setHardness(3.25F).setResistance(15.0F);

        blockTungsten = (new BlockOreStorage(IdUtil.getNextBlockID(), CreationMaterial.tungsten))
                .setStepSound(Block.soundMetalFootstep);

        fenceTungsten = (new PaneBlock(IdUtil.getNextBlockID(), "bars/tungsten_bars", "bars/tungsten_bars", CreationMaterial.tungsten, false))
                .setStepSound(Block.soundMetalFootstep).setResistance(24.0F).setHardness(12.8F).setMinHarvestLevel(4);

        doorTungsten = (DoorBlock)(new DoorBlock(IdUtil.getNextBlockID(), CreationMaterial.tungsten))
                .setStepSound(Block.soundMetalFootstep).setMinHarvestLevel(4);

        anvilTungsten = new AnvilBlock(IdUtil.getNextBlockID(), CreationMaterial.tungsten);

        deepStaleBrick = (BlockDeepStaleBrick) (new BlockDeepStaleBrick(IdUtil.getNextBlockID()))
                .setHardness(1.8F).setResistance(15.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("deepStaleBrick").setTextureName("deepstale_brick");

        deepStaleMagma = (BLockDeepSlateMagma) (new BLockDeepSlateMagma(IdUtil.getNextBlockID()))
                .setHardness(1.8F).setResistance(15.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("deepStaleMagma").setTextureName("deepslatemagma");

        cobbleDeepStale = (new CreationBlock(IdUtil.getNextBlockID(), Material.stone, new BlockConstants()))
                .setHardness(2.5F).setResistance(15.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("cobbleDeepStale").setCreativeTab(CreativeTabs.tabBlock).setTextureName("cobbledeepstale");

        stairsCobbleDeepSlate = (new StairsBlock(IdUtil.getNextBlockID(), cobbleDeepStale, 0)).setUnlocalizedName("stairsDeepSlate");

        stairsDeepSlateBrick = (new StairsBlock(IdUtil.getNextBlockID(), deepStaleBrick, 0)).setUnlocalizedName("stairsDeepSlateBrick");

        cobbleDeepStaleWall = new WallBlock(IdUtil.getNextBlockID(), cobbleDeepStale).setHardness(2.5F).setResistance(15.0F)
                .setUnlocalizedName("cobbleDeepSlateWall");

        deepStaleBrickWall = new WallBlock(IdUtil.getNextBlockID(), deepStaleBrick).setHardness(1.8F).setResistance(15.0F)
                .setUnlocalizedName("deepSlateBrickWall");

        gravelSand = (BlockSandGravel) (new BlockSandGravel(IdUtil.getNextBlockID())).setHardness(0.6F)
                .setStepSound(soundSandFootstep).setUnlocalizedName("gravelSand").setCreativeTab(CreativeTabs.tabBlock)
                .setTextureName("gravelSand");

        gravelDeepSlate = (BlockDeepSlateGravel) (new BlockDeepSlateGravel(IdUtil.getNextBlockID())).setHardness(0.8F)
                .setStepSound(soundSandFootstep).setUnlocalizedName("gravelDeepSlate").setCreativeTab(CreativeTabs.tabBlock)
                .setTextureName("gravelDeepSlate");

        deepSlate = (new BlockDeepSlate(3348))
                .setHardness(3.0F).setResistance(15.0F).setStepSound(soundStoneFootstep).setUnlocalizedName("deepSlate").setTextureName("deepSlate");

        cobbledDeepStaleSingleSlab = (BlockCobbleDeepSlateSlabGroup) (new BlockCobbleDeepSlateSlabGroup(IdUtil.getNextBlockID(), Material.stone))
                .setStepSound(soundStoneFootstep);

        cobbledDeepStaleDoubleSlab = (BlockDeepSlateDoubleSlab) (new BlockDeepSlateDoubleSlab(IdUtil.getNextBlockID(), cobbledDeepStaleSingleSlab))
                .setStepSound(soundStoneFootstep);

        deepStaleBrickSingleSlab = (BlockDeepSlateBrickSlabGroup) (new BlockDeepSlateBrickSlabGroup(IdUtil.getNextBlockID(), Material.stone))
                .setStepSound(soundStoneFootstep);

        deepStaleBrickDoubleSlab = (BlockDeepSlateDoubleSlab) (new BlockDeepSlateDoubleSlab(IdUtil.getNextBlockID(), deepStaleBrickSingleSlab))
                .setStepSound(soundStoneFootstep);

        ancientRelict = (BlockAncientRelict) new BlockAncientRelict(IdUtil.getNextBlockID()).setHardness(2.5F).setCreativeTab(CreativeTabs.tabBlock)
                .setStepSound(soundStoneFootstep).setUnlocalizedName("ancientRelict");

        creationWorkBench = new CreationWorkbench(IdUtil.getNextBlockID());
    }

}
