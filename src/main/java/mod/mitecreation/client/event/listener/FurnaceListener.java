package mod.mitecreation.client.event.listener;

import mod.mitecreation.item.CreationItem;
import moddedmite.rustedironcore.api.event.listener.IFurnaceUpdateListener;
import net.minecraft.TileEntityFurnace;

public class FurnaceListener implements IFurnaceUpdateListener {

    @Override
    public int onFurnaceCookTimeIncreaseModify(TileEntityFurnace tileEntityFurnace, int original) {
        int item_id = (tileEntityFurnace.getInputItemStack()).itemID;
        int heat_level = tileEntityFurnace.heat_level;
        int speed_bonus = 1;
        if (heat_level == 2 && item_id == CreationItem.rawGoldNugget.itemID ||
                heat_level == 2 && item_id == CreationItem.rawCopperNugget.itemID ||
                heat_level == 2 && item_id == CreationItem.rawSilverNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 3 && item_id == CreationItem.rawGoldNugget.itemID ||
                heat_level == 3 && item_id == CreationItem.rawCopperNugget.itemID ||
                heat_level == 3 && item_id == CreationItem.rawSilverNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 4 && item_id == CreationItem.rawGoldNugget.itemID ||
                heat_level == 4 && item_id == CreationItem.rawCopperNugget.itemID ||
                heat_level == 2 && item_id == CreationItem.rawSilverNugget.itemID)
            speed_bonus = 8;

        if (heat_level == 5 && item_id == CreationItem.rawGoldNugget.itemID ||
                heat_level == 5 && item_id == CreationItem.rawCopperNugget.itemID ||
                heat_level == 5 && item_id == CreationItem.rawSilverNugget.itemID)
            speed_bonus = 16;


        if (heat_level == 3 && item_id == CreationItem.rawRustedIronNugget.itemID ||
                heat_level == 3 && item_id == CreationItem.rustedIronNugget.itemID ||
                heat_level == 3 && item_id == CreationItem.rawAncientMetalNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 4 && item_id == CreationItem.rawRustedIronNugget.itemID ||
                heat_level == 4 && item_id == CreationItem.rustedIronNugget.itemID ||
                heat_level == 4 && item_id == CreationItem.rawAncientMetalNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 5 && item_id == CreationItem.rawRustedIronNugget.itemID ||
                heat_level == 5 && item_id == CreationItem.rustedIronNugget.itemID ||
                heat_level == 5 && item_id == CreationItem.rawAncientMetalNugget.itemID)
            speed_bonus = 8;


        if (heat_level == 4 && item_id == CreationItem.rawMithrilNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 5 && item_id == CreationItem.rawMithrilNugget.itemID)
            speed_bonus = 4;


        if (heat_level == 5 && item_id == CreationItem.rawAdamantiumNugget.itemID)
            speed_bonus = 2;
        original *= speed_bonus;
        return original;
    }

}
