package huix.faustpotion.game_objects.item

import huix.faustpotion.game_objects.material.FPMaterialsKt
import net.minecraft.*
import net.xiaoyu233.fml.reload.utils.IdUtil
import java.util.*

class GoldPanItemKt(private val goldpan_material: Material, private val contents_material: Material?) :
    ItemVessel(IdUtil.getNextItemID(), goldpan_material, contents_material, 8, 16,
        8, "gold_pan/" + (if (contents_material == null) "empty"
        else (if (contents_material === Material.sand) "sand"
        else (if (contents_material === FPMaterialsKt.gravel) "gravel"
        else (if (contents_material === Material.clay) "clay"
        else "dirt"))))
    ) {
//        constructor(vessel_material: Material, contents_material: Material?, unlocalized_name: String) : this(vessel_material, contents_material) {
//            this.setUnlocalizedName(unlocalized_name)
//        }


    override fun getItemInUseAction(item_stack: ItemStack?, player: EntityPlayer?): EnumItemInUseAction {
        return EnumItemInUseAction.BOW;
    }

    override fun onItemRightClick(player: EntityPlayer, partial_tick: Float, ctrl_is_down: Boolean): Boolean {
        val rc = player.getSelectedObject(partial_tick, false)
        if (rc != null && rc.isBlock) {
            val block = rc.blockHit
            val material = (if (rc.getBlockHitMaterial().isLiquid()) rc.getBlockHitMaterial() else rc.getNeighborOfBlockHitMaterial())
            if (this.contains(null)) {
                if (block === Block.sand || block === Block.gravel || block === Block.dirt || block === Block.blockClay || block === Block.glass) {
                    player.setHeldItemInUse()
                    return true
                }
            } else {
                if (material == Material.water) {
                    player.setHeldItemInUse()
                    return true
                }
            }
        }
        return false
    }

    override fun onItemUseFinish(item_stack: ItemStack, world: World, player: EntityPlayer) {
        val rc = player.getSelectedObject(1.0F, false)
        if (rc != null && rc.isBlock) {
            if (player.inCreativeMode() && !player.canMineAndEditBlock(rc.block_hit_x, rc.block_hit_y, rc.block_hit_z)) {
                return;
            } else {
                if (player.onServer()) {
                    if (this.contains(null)) {
                        val block = rc.blockHit
                        if (block === Block.sand || block === Block.gravel || block === Block.dirt || block === Block.blockClay) {
                            player.convertOneOfHeldItem(ItemStack(this.getPeerForContents(block.blockMaterial)))
                            rc.world.setBlockToAir(rc.block_hit_x, rc.block_hit_y, rc.block_hit_z)
                        } else if (block === Block.grass) {
                            player.convertOneOfHeldItem(ItemStack(this.getPeerForContents(Material.dirt)))
                            rc.world.setBlockToAir(rc.block_hit_x, rc.block_hit_y, rc.block_hit_z)
                        }
                    } else {
                        val rand: Random = world.rand
                        var dropItem : Item? = null;
                        if (this.contains(FPMaterialsKt.gravel)) {
                            if (rand.nextInt(10) > 2) {
                                super.onItemUseFinish(item_stack, world, player)
                                return
                            } else if (rand.nextInt(2) > 0) {
                                if (rand.nextInt(16) == 0) {
                                    dropItem = flint
                                }
                            } else if (rand.nextInt(3) > 0) {
                                dropItem = copperNugget
                            } else if (rand.nextInt(3) > 0) {
                                dropItem = silverNugget
                            } else if (rand.nextInt(3) > 0) {
                                dropItem = goldNugget
                            } else if (rand.nextInt(3) > 0) {
                                dropItem = mithrilNugget
                            } else {
                                dropItem = adamantiumNugget
                            }
                        } else if (this.contains(Material.sand)) {
                            dropItem = if (rand.nextInt(20) > 2) {
                                super.onItemUseFinish(item_stack, world, player)
                                return
                            } else if (rand.nextInt(4) > 0) {
                                shardGlass
                            } else if (rand.nextInt(4) > 0) {
                                shardObsidian
                            } else if (rand.nextInt(4) > 0) {
                                shardNetherQuartz
                            } else if (rand.nextInt(4) > 0) {
                                shardEmerald
                            } else {
                                shardDiamond
                            }
                        } else if (this.contains(Material.sand)) {
                            if (rand.nextInt(5) > 2) {
                                super.onItemUseFinish(item_stack, world, player)
                                return
                            } else {
                                dropItem = clay
                            }
                        }


                        if (dropItem != null) {
                            player.inventory.addItemStackToInventory(ItemStack(dropItem));
                        }
                    }
                }
            }
        }
        super.onItemUseFinish(item_stack, world, player)
    }



    override fun getMaxItemUseDuration(par1ItemStack: ItemStack?): Int {
        return 72
    }

    override fun getPeerForContents(material: Material?): ItemVessel {
        return this.getPeer(goldpan_material, material)
    }

    override fun getPeerForVesselMaterial(material: Material): ItemVessel {
        return this.getPeer(material, contents_material)
    }


    private fun getPeer(vessel_material: Material, contents: Material?): ItemVessel {
        return when(contents) {
            null -> FPItemsKt.gold_pan_empty
            Material.sand -> FPItemsKt.gold_pan_sand
            FPMaterialsKt.gravel -> FPItemsKt.gold_pan_gravel
            Material.clay -> FPItemsKt.gold_pan_clay
            else -> FPItemsKt.gold_pan_dirt
        }
    }

}