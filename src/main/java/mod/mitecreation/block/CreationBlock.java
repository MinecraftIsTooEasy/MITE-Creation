package mod.mitecreation.block;

import mod.mitecreation.block.ore.normal.*;
import mod.mitecreation.materil.CreationMaterial;
import mod.rustedironcore.api.block.DoorBlock;
import mod.rustedironcore.api.block.PaneBlock;
import mod.rustedironcore.api.block.StairsBlock;
import mod.rustedironcore.api.block.WallBlock;
import net.minecraft.*;
import net.xiaoyu233.fml.api.block.AnvilBlock;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
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
//    public static final Block oreIronPoor;
//    public static final Block oreCoalPoor;
//    public static final Block oreLapisPoor;
//    public static final Block oreDiamondPoor;
//    public static final Block oreEmeraldPoor;
//    public static final Block oreNetherQuartzPoor;
//    public static final Block oreCopperPoor;
//    public static final Block oreSilverPoor;
//    public static final Block oreMithrilPoor;
//    public static final Block oreAdamantiumPoor;
//    public static final Block oreTungstenPoor;
//    public static final Block oreIronPoorDeepslate;
//    public static final Block oreCoalPoorDeepslate;
//    public static final Block oreLapisPoorDeepslate;
//    public static final Block oreDiamondPoorDeepslate;
//    public static final Block oreEmeraldPoorDeepslate;
//    public static final Block oreCopperPoorDeepslate;
//    public static final Block oreSilverPoorDeepslate;
//    public static final Block oreMithrilPoorDeepslate;
//    public static final Block oreAdamantiumPoorDeepslate;
//    public static final Block oreTungstenPoorDeepslate;
//    public static final Block oreIronRich;
//    public static final Block oreCoalRich;
//    public static final Block oreLapisRich;
//    public static final Block oreDiamondRich;
//    public static final Block oreEmeraldRich;
//    public static final Block oreNetherQuartzRich;
//    public static final Block oreCopperRich;
//    public static final Block oreSilverRich;
//    public static final Block oreMithrilRich;
//    public static final Block oreAdamantiumRich;
//    public static final Block oreTungstenRich;
//    public static final Block oreIronRichDeepslate;
//    public static final Block oreCoalRichDeepslate;
//    public static final Block oreLapisRichDeepslate;
//    public static final Block oreDiamondRichDeepslate;
//    public static final Block oreEmeraldRichDeepslate;
//    public static final Block oreCopperRichDeepslate;
//    public static final Block oreSilverRichDeepslate;
//    public static final Block oreMithrilRichDeepslate;
//    public static final Block oreAdamantiumRichDeepslate;
//    public static final Block oreTungstenRichDeepslate;
    public static final Block oreIronDeepslate;
    public static final Block oreCoalDeepslate;
    public static final Block oreLapisDeepslate;
    public static final Block oreDiamondDeepslate;
    public static final Block oreEmeraldDeepslate;
    public static final Block oreCopperDeepslate;
    public static final Block oreSilverDeepslate;
    public static final Block oreMithrilDeepslate;
    public static final Block oreAdamantiumDeepslate;
    public static final Block oreTungstenDeepslate;
    public static final Block oreGoldDeepslate;
    public static final Block oreRedstoneDeepslate;

    protected CreationBlock(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    public static void registerBlocks(ItemRegistryEvent registryEvent) {
        registryEvent.registerItemBlock(CreationNameSpace, "rusted_iron_block", rustedIronBlock);
        registryEvent.registerAnvil(CreationNameSpace, "rusted_iron_anvil", anvilRustedIron);
        anvilRustedIron.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerAnvil(CreationNameSpace, "tungsten_anvil", anvilTungsten);
        anvilTungsten.stepSound = Block.soundAnvilFootstep;
        registryEvent.registerItemBlock(CreationNameSpace, "ore/tungsten_ore", oreTungsten);
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
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate_gravel", gravelDeepSlate);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslate", deepSlate);
        registryEvent.registerItemBlock(CreationNameSpace, "cobbledDeepslateSlab", cobbledDeepStaleSingleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "cobbledDeepslateSlab", cobbledDeepStaleDoubleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslateBrickSlab", deepStaleBrickSingleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "deepslateBrickSlab", deepStaleBrickDoubleSlab);
        registryEvent.registerItemBlock(CreationNameSpace, "ancient_relict", ancientRelict);
        registryEvent.registerItemBlock(CreationNameSpace, "work_bench", creationWorkBench);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/iron_ore_poor", oreIronPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/coal_ore_poor", oreCoalPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/lapis_ore_poor", oreLapisPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/diamond_ore_poor", oreDiamondPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/emerald_ore_poor", oreEmeraldPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/quartz_ore_poor", oreNetherQuartzPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/copper_ore_poor", oreCopperPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/silver_ore_poor", oreSilverPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/mithril_ore_poor", oreMithrilPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/adamantium_ore_poor", oreAdamantiumPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/tungsten_ore_poor", oreTungstenPoor);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/iron_ore_poor", oreIronPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/coal_ore_poor", oreCoalPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/lapis_ore_poor", oreLapisPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/diamond_ore_poor", oreDiamondPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/emerald_ore_poor", oreEmeraldPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/copper_ore_poor", oreCopperPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/silver_ore_poor", oreSilverPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/mithril_ore_poor", oreMithrilPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/adamantium_ore_poor", oreAdamantiumPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/poor/tungsten_ore_poor", oreTungstenPoorDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/iron_ore_rich", oreIronRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/coal_ore_rich", oreCoalRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/lapis_ore_rich", oreLapisRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/diamond_ore_rich", oreDiamondRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/emerald_ore_rich", oreEmeraldRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/quartz_ore_rich", oreNetherQuartzRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/copper_ore_rich", oreCopperRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/silver_ore_rich", oreSilverRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/mithril_ore_rich", oreMithrilRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/adamantium_ore_rich", oreAdamantiumRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/tungsten_ore_rich", oreTungstenRich);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/iron_ore_rich", oreIronRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/coal_ore_rich", oreCoalRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/lapis_ore_rich", oreLapisRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/diamond_ore_rich", oreDiamondRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/emerald_ore_rich", oreEmeraldRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/copper_ore_rich", oreCopperRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/silver_ore_rich", oreSilverRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/mithril_ore_rich", oreMithrilRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/adamantium_ore_rich", oreAdamantiumRichDeepslate);
//        registryEvent.registerItemBlock(CreationNameSpace, "ore/rich/tungsten_ore_rich", oreTungstenRichDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/iron_ore_normal", oreIronDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/coal_ore_normal", oreCoalDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/lapis_ore_normal", oreLapisDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/diamond_ore_normal", oreDiamondDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/emerald_ore_normal", oreEmeraldDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/copper_ore_normal", oreCopperDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/silver_ore_normal", oreSilverDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/mithril_ore_normal", oreMithrilDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/adamantium_ore_normal", oreAdamantiumDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/tungsten_ore_normal", oreTungstenDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/gold_ore_normal", oreGoldDeepslate);
        registryEvent.registerItemBlock(CreationNameSpace, "ore/normal/redstone_ore_normal", oreRedstoneDeepslate);
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

        doorTungsten = (new DoorBlock(IdUtil.getNextBlockID(), CreationMaterial.tungsten))
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

//        oreIronPoor = (new BlockIronPoorOre(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreIron").setTextureName("iron_ore");
//
//        oreCoalPoor = (new BlockCoalPoorOre(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCoal").setTextureName("coal_ore");
//
//        oreLapisPoor = (new BlockLapisPoorOre(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreLapisPoor").setTextureName("lapis_ore");
//
//        oreDiamondPoor = (new BlockDiamondPoorOre(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");
//
//        oreEmeraldPoor = (new BlockEmeraldPoorOre(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");
//
//        oreNetherQuartzPoor = (new BlockNetherQuartzPoorOre(IdUtil.getNextBlockID(), Material.quartz, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("netherquartz").setTextureName("quartz_ore");
//
//        oreCopperPoor = (new BlockCopperPoorOre(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCopper").setTextureName("copper_ore");
//
//        oreSilverPoor = (new BlockSilverPoorOre(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreSilver").setTextureName("silver_ore");
//
//        oreMithrilPoor = (new BlockMithrilPoorOre(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore");
//
//        oreAdamantiumPoor = (new BlockAdamantiumPoorOre(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore");
//
//        oreTungstenPoor = (new BlockTungstenPoorOre(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4)).setHardness(3.25F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore");
//
//        oreIronPoorDeepslate = (new BlockIronPoorOreDeepslate(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreIron").setTextureName("iron_ore");
//
//        oreCoalPoorDeepslate = (new BlockCoalPoorOreDeepslate(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCoal").setTextureName("coal_ore");
//
//        oreLapisPoorDeepslate = (new BlockLapisPoorOreDeepslate(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreLapisPoor").setTextureName("lapis_ore");
//
//        oreDiamondPoorDeepslate = (new BlockDiamondPoorOreDeepslate(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");
//
//        oreEmeraldPoorDeepslate = (new BlockEmeraldPoorOreDeepslate(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");
//
//        oreCopperPoorDeepslate = (new BlockCopperPoorOreDeepslate(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCopper").setTextureName("copper_ore");
//
//        oreSilverPoorDeepslate = (new BlockSilverPoorOreDeepslate(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreSilver").setTextureName("silver_ore");
//
//        oreMithrilPoorDeepslate = (new BlockMithrilPoorOreDeepslate(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore");
//
//        oreAdamantiumPoorDeepslate = (new BlockAdamantiumPoorOreDeepslate(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore");
//
//        oreTungstenPoorDeepslate = (new BlockTungstenPoorOreDeepslate(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4)).setHardness(3.25F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore");
//
//        oreIronRich = (new BlockIronRichOre(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreIron").setTextureName("iron_ore");
//
//        oreCoalRich = (new BlockCoalRichOre(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCoal").setTextureName("coal_ore");
//
//        oreLapisRich = (new BlockLapisRichOre(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreLapis").setTextureName("lapis_ore");
//
//        oreDiamondRich = (new BlockDiamondRichOre(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");
//
//        oreEmeraldRich = (new BlockEmeraldRichOre(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");
//
//        oreNetherQuartzRich = (new BlockNetherQuartzRichOre(IdUtil.getNextBlockID(), Material.quartz, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("netherquartz").setTextureName("quartz_ore");
//
//        oreCopperRich = (new BlockCopperRichOre(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCopper").setTextureName("copper_ore");
//
//        oreSilverRich = (new BlockSilverRichOre(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreSilver").setTextureName("silver_ore");
//
//        oreMithrilRich = (new BlockMithrilRichOre(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore");
//
//        oreAdamantiumRich = (new BlockAdamantiumRichOre(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore");
//
//        oreTungstenRich = (new BlockTungstenRichOre(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4)).setHardness(3.25F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore");
//
//        oreIronRichDeepslate = (new BlockIronRichOreDeepslate(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreIron").setTextureName("iron_ore");
//
//        oreCoalRichDeepslate = (new BlockCoalRichOreDeepslate(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCoal").setTextureName("coal_ore");
//
//        oreLapisRichDeepslate = (new BlockLapisRichOreDeepslate(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreLapis").setTextureName("lapis_ore");
//
//        oreDiamondRichDeepslate = (new BlockDiamondRichOreDeepslate(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");
//
//        oreEmeraldRichDeepslate = (new BlockEmeraldRichOreDeepslate(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");
//
//        oreCopperRichDeepslate = (new BlockCopperRichOreDeepslate(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreCopper").setTextureName("copper_ore");
//
//        oreSilverRichDeepslate = (new BlockSilverRichOreDeepslate(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreSilver").setTextureName("silver_ore");
//
//        oreMithrilRichDeepslate = (new BlockMithrilRichOreDeepslate(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore");
//
//        oreAdamantiumRichDeepslate = (new BlockAdamantiumRichOreDeepslate(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore");
//
//        oreTungstenRichDeepslate = (new BlockTungstenRichOreDeepslate(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4)).setHardness(3.25F).setStepSound(soundStoneFootstep)
//                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore");
//
        oreIronDeepslate = (new BlockIronOreDeepslate(IdUtil.getNextBlockID(), Material.iron, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreIron").setTextureName("iron_ore");

        oreCoalDeepslate = (new BlockCoalOreDeepslate(IdUtil.getNextBlockID(), Material.coal, 2)).setHardness(1.2F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreCoal").setTextureName("coal_ore");

        oreLapisDeepslate = (new BlockLapisOreDeepslate(IdUtil.getNextBlockID(), Material.lapis_lazuli, 2)).setHardness(3.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreLapis").setTextureName("lapis_ore");

        oreDiamondDeepslate = (new BlockDiamondOreDeepslate(IdUtil.getNextBlockID(), Material.diamond, 4)).setHardness(3.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreDiamond").setTextureName("diamond_ore");

        oreEmeraldDeepslate = (new BlockEmeraldOreDeepslate(IdUtil.getNextBlockID(), Material.emerald, 3)).setHardness(3.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreEmerald").setTextureName("emerald_ore");

        oreCopperDeepslate = (new BlockCopperOreDeepslate(IdUtil.getNextBlockID(), Material.copper, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreCopper").setTextureName("copper_ore");

        oreSilverDeepslate = (new BlockSilverOreDeepslate(IdUtil.getNextBlockID(), Material.silver, 2)).setHardness(2.5F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreSilver").setTextureName("silver_ore");

        oreMithrilDeepslate = (new BlockMithrilOreDeepslate(IdUtil.getNextBlockID(), Material.mithril, 3)).setHardness(3.5F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreMithril").setTextureName("mithril_ore");

        oreAdamantiumDeepslate = (new BlockAdamantiumOreDeepslate(IdUtil.getNextBlockID(), Material.adamantium, 4)).setHardness(4.0F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreAdamantium").setTextureName("adamantium_ore");

        oreTungstenDeepslate = (new BlockTungstenOreDeepslate(IdUtil.getNextBlockID(), CreationMaterial.tungsten, 4)).setHardness(3.25F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreTungsten").setTextureName("tungsten_ore");

        oreGoldDeepslate = (new BlockGoldOreDeepslate(IdUtil.getNextBlockID(), Material.gold, 2)).setHardness(2.4F).setStepSound(soundStoneFootstep)
                .setUnlocalizedName("oreGold").setTextureName("gold_ore");

        oreRedstoneDeepslate = (new BlockRedstoneOreDeepslate(IdUtil.getNextBlockID(), false)).setHardness(3.0F).setResistance(5.0F).setStepSound(soundStoneFootstep)
                .setCreativeTab(CreativeTabs.tabBlock).setUnlocalizedName("oreRedstone").setTextureName("redstone_ore");

    }
}
