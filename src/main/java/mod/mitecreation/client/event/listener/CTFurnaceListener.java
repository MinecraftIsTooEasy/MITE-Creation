package mod.mitecreation.client.event.listener;

import mod.mitecreation.init.CTRegistryInit;
import moddedmite.rustedironcore.api.event.listener.IFurnaceUpdateListener;
import net.minecraft.TileEntityFurnace;

public class CTFurnaceListener implements IFurnaceUpdateListener {

    @Override
    public int onFurnaceCookTimeIncreaseModify(TileEntityFurnace tileEntityFurnace, int original) {
        int item_id = (tileEntityFurnace.getInputItemStack()).itemID;
        int heat_level = tileEntityFurnace.heat_level;
        int speed_bonus = 1;
        if (heat_level == 2 && item_id == CTRegistryInit.rawGoldNugget.itemID ||
                heat_level == 2 && item_id == CTRegistryInit.rawCopperNugget.itemID ||
                heat_level == 2 && item_id == CTRegistryInit.rawSilverNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 3 && item_id == CTRegistryInit.rawGoldNugget.itemID ||
                heat_level == 3 && item_id == CTRegistryInit.rawCopperNugget.itemID ||
                heat_level == 3 && item_id == CTRegistryInit.rawSilverNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 4 && item_id == CTRegistryInit.rawGoldNugget.itemID ||
                heat_level == 4 && item_id == CTRegistryInit.rawCopperNugget.itemID ||
                heat_level == 4 && item_id == CTRegistryInit.rawSilverNugget.itemID)
            speed_bonus = 8;

        if (heat_level == 5 && item_id == CTRegistryInit.rawGoldNugget.itemID ||
                heat_level == 5 && item_id == CTRegistryInit.rawCopperNugget.itemID ||
                heat_level == 5 && item_id == CTRegistryInit.rawSilverNugget.itemID)
            speed_bonus = 16;


        if (heat_level == 3 && item_id == CTRegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 3 && item_id == CTRegistryInit.rustedIronNugget.itemID ||
                heat_level == 3 && item_id == CTRegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 4 && item_id == CTRegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 4 && item_id == CTRegistryInit.rustedIronNugget.itemID ||
                heat_level == 4 && item_id == CTRegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 5 && item_id == CTRegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 5 && item_id == CTRegistryInit.rustedIronNugget.itemID ||
                heat_level == 5 && item_id == CTRegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 8;


        if (heat_level == 4 && item_id == CTRegistryInit.rawMithrilNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 5 && item_id == CTRegistryInit.rawMithrilNugget.itemID)
            speed_bonus = 4;


        if (heat_level == 5 && item_id == CTRegistryInit.rawAdamantiumNugget.itemID)
            speed_bonus = 2;
        original *= speed_bonus;
        return original;
    }

}
