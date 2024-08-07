package huix.faustpotion.game_objects.item

import huix.faustpotion.game_objects.material.FPMaterialsKt
import huix.faustspotion.injected_interfaces.IIItemRegistryEvent
import net.minecraft.CreativeTabs
import net.minecraft.Material
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent

class FPItemsKt {
    companion object {
        val gold_pan_empty = GoldPanItemKt(Material.clay, null)
        val gold_pan_sand = GoldPanItemKt(Material.clay, Material.sand)
        val gold_pan_gravel = GoldPanItemKt(Material.clay, FPMaterialsKt.gravel)
        val gold_pan_clay = GoldPanItemKt(Material.clay, Material.clay)
        val gold_pan_dirt = GoldPanItemKt(Material.clay, Material.dirt)

        val bake_clay = FPClayItemKt().setXPReward(2).setCraftingDifficultyAsComponent(4.0F)
        val clay_brick = FPClayItemKt().setXPReward(0).setCraftingDifficultyAsComponent(1.0F)

        fun registerItemsForFP(registry: ItemRegistryEvent) {
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "MITE Creation", "gold_pan_empty", gold_pan_empty, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "MITE Creation", "gold_pan_sand", gold_pan_sand, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "MITE Creation", "gold_pan_gravel", gold_pan_gravel, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "MITE Creation", "gold_pan_clay", gold_pan_clay, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "MITE Creation", "gold_pan_dirt", gold_pan_dirt, CreativeTabs.tabMaterials)

            registry.register( "MITE Creation", "bake_clay", bake_clay, CreativeTabs.tabMaterials)
            registry.register( "MITE Creation", "clay_brick", clay_brick, CreativeTabs.tabMaterials)

        }
    }
}