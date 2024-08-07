package mod.mitecreation.mixins.world;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;
import net.minecraft.Debug;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(WorldGenDungeons.class)
public class WorldGenDungeonsMixin extends WorldGenerator {

    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] field_111189_a;
    @Mutable
    @Final
    @Shadow
    private static WeightedRandomChestContent[] chest_contents_for_underworld;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addLootCreation(CallbackInfo ci) {
        field_111189_a = WeightedRandomChestContent.func_92080_a(field_111189_a,
                new WeightedRandomChestContent(CreationItem.coinRustedIron.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(CreationItem.rawRustedIronNugget.itemID, 0, 1, 4, 10),
                new WeightedRandomChestContent(CreationItem.rustedIronNugget.itemID, 0, 1, 4, 5),
                new WeightedRandomChestContent(CreationItem.ingotRustedIron.itemID, 0, 1, 2, 2)
        );
//        chest_contents_for_underworld = WeightedRandomChestContent.func_92080_a(chest_contents_for_underworld,
//        );
    }


    @Overwrite
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        int var12;
        int var11;
        int var10;
        int var6 = 3;
        int var7 = par2Random.nextInt(2) + 2;
        int var8 = par2Random.nextInt(2) + 2;
        int var9 = 0;
        for (var10 = par3 - var7 - 1; var10 <= par3 + var7 + 1; ++var10) {
            for (var11 = par4 - 1; var11 <= par4 + var6 + 1; ++var11) {
                for (var12 = par5 - var8 - 1; var12 <= par5 + var8 + 1; ++var12) {
                    Material var13 = par1World.getBlockMaterial(var10, var11, var12);
                    if (var11 == par4 - 1 && !var13.isSolid()) {
                        return false;
                    }
                    if (var11 == par4 + var6 + 1) {
                        if (!var13.isSolid()) {
                            return false;
                        }
                        Block block = par1World.getBlock(var10, var11, var12);
                        if (block instanceof BlockFalling) {
                            return false;
                        }
                    }
                    if (var10 != par3 - var7 - 1 && var10 != par3 + var7 + 1 && var12 != par5 - var8 - 1 && var12 != par5 + var8 + 1 || var11 != par4 || !par1World.isAirBlock(var10, var11, var12) || !par1World.isAirBlock(var10, var11 + 1, var12))
                        continue;
                    ++var9;
                }
            }
        }
        if (var9 >= 1 && var9 <= 5) {
            for (var10 = par3 - var7 - 1; var10 <= par3 + var7 + 1; ++var10) {
                for (var11 = par4 + var6; var11 >= par4 - 1; --var11) {
                    for (var12 = par5 - var8 - 1; var12 <= par5 + var8 + 1; ++var12) {
                        if (var10 != par3 - var7 - 1 && var11 != par4 - 1 && var12 != par5 - var8 - 1 && var10 != par3 + var7 + 1 && var11 != par4 + var6 + 1 && var12 != par5 + var8 + 1) {
                            par1World.setBlockToAir(var10, var11, var12);
                            continue;
                        }
                        if (var11 >= 0 && !par1World.getBlockMaterial(var10, var11 - 1, var12).isSolid()) {
                            par1World.setBlockToAir(var10, var11, var12);
                            continue;
                        }
                        if (!par1World.getBlockMaterial(var10, var11, var12).isSolid()) continue;
                        if (var11 == par4 - 1 && par2Random.nextInt(4) != 0) {
                            if (par1World.isUnderworld()) {
                                par1World.setBlock(var10, var11, var12, CreationBlock.deepStaleBrick.blockID, 1, 2);
                                continue;
                            } else {
                                par1World.setBlock(var10, var11, var12, Block.cobblestoneMossy.blockID, 0, 2);
                                continue;
                            }
                        }
                        if (par1World.isUnderworld()) {
                            par1World.setBlock(var10, var11, var12, CreationBlock.deepStaleBrick.blockID, 0, 2);
                        } else {
                            par1World.setBlock(var10, var11, var12, Block.cobblestone.blockID, 0, 2);
                        }
                    }
                }
            }
            block6:
            for (var10 = 0; var10 < 2; ++var10) {
                for (var11 = 0; var11 < 3; ++var11) {
                    int var14;
                    var12 = par3 + par2Random.nextInt(var7 * 2 + 1) - var7;
                    if (!par1World.isAirBlock(var12, par4, var14 = par5 + par2Random.nextInt(var8 * 2 + 1) - var8))
                        continue;
                    int var15 = 0;
                    EnumDirection direction = null;
                    if (par1World.getBlockMaterial(var12 - 1, par4, var14).isSolid()) {
                        ++var15;
                        direction = EnumDirection.EAST;
                    }
                    if (par1World.getBlockMaterial(var12 + 1, par4, var14).isSolid()) {
                        ++var15;
                        direction = EnumDirection.WEST;
                    }
                    if (par1World.getBlockMaterial(var12, par4, var14 - 1).isSolid()) {
                        ++var15;
                        direction = EnumDirection.SOUTH;
                    }
                    if (par1World.getBlockMaterial(var12, par4, var14 + 1).isSolid()) {
                        ++var15;
                        direction = EnumDirection.NORTH;
                    }
                    if (var15 != 1) continue;
                    par1World.setBlock(var12, par4, var14, Block.chest.blockID, Block.chest.getMetadataForDirectionFacing(0, direction), 2);
                    WeightedRandomChestContent[] var16 = WeightedRandomChestContent.func_92080_a(WorldGenDungeons.getChestContentsForWorld(par1World), Item.enchantedBook.func_92114_b(par2Random));
                    TileEntityChest var17 = (TileEntityChest) par1World.getBlockTileEntity(var12, par4, var14);
                    if (var17 == null) continue block6;
                    WeightedRandomChestContent.generateChestContents(par1World, par4, par2Random, var16, var17, 8, null);
                    continue block6;
                }
            }
            if (!par1World.isOverworld()) {
                Debug.println("Dungeon at " + StringHelper.getCoordsAsString(par3, par4, par5));
            }
            par1World.setBlock(par3, par4, par5, Block.mobSpawner.blockID, 0, 2);
            TileEntityMobSpawner var18 = (TileEntityMobSpawner) par1World.getBlockTileEntity(par3, par4, par5);
            if (var18 != null) {
                var18.getSpawnerLogic().setMobID(this.pickMobSpawner(par1World, par2Random, par4));
            } else {
                System.err.println("Failed to fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
            }
            return true;
        }
        return false;
    }

    @Shadow
    public final String pickMobSpawner(World world, Random par1Random, int y) {
        if (world.isUnderworld()) {
            return par1Random.nextInt(6) == 0 ? "LongdeadGuardian" : "Longdead";
        }
        int danger = par1Random.nextInt(2) == 0 ? par1Random.nextInt(4) : (int)Math.max(1.0f - (float)y / 64.0f, 0.0f) * 4 + par1Random.nextInt(3) - par1Random.nextInt(3);
        if (danger < 0) {
            danger = par1Random.nextInt(4);
        }
        switch (danger) {
            case 0: {
                return "Zombie";
            }
            case 1: {
                return "Ghoul";
            }
            case 2: {
                return "Skeleton";
            }
            case 3: {
                return "Spider";
            }
            case 4: {
                return "Wight";
            }
            case 5: {
                return "DemonSpider";
            }
        }
        return "Hellhound";
    }
}