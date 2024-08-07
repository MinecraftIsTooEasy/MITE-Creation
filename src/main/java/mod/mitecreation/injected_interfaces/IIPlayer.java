package mod.mitecreation.injected_interfaces;

import mod.mitecreation.tileentity.ReforgeTileEntity;

public interface IIPlayer {

    default void displayReforgeGui(int x, int y, int z, ReforgeTileEntity tileEntity){}

}
