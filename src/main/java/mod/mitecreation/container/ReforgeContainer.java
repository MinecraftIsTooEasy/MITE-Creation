package mod.mitecreation.container;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.Container;
import net.minecraft.EntityPlayer;
import net.minecraft.Slot;

public class ReforgeContainer extends Container {

    private final ReforgeTileEntity reforgeTile;

    public ReforgeContainer(EntityPlayer player, ReforgeTileEntity reforgeTile) {
        super(player);
        this.reforgeTile = reforgeTile;
        this.addSlotToContainer(new Slot(reforgeTile, 0, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 1, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 2, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 3, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 4, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 5, 56, 17));
        this.addSlotToContainer(new Slot(reforgeTile, 6, 56, 17));


        int i;
        for (int j = 0; j < 3; ++j)
        {
            for (i = 0; i < 9; ++i)
            {
                this.addSlotToContainer(new Slot(player.inventory, i + j * 9 + 9, 8 + i * 18, 84 + j * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.reforgeTile.isUseableByPlayer(entityPlayer);
    }
}
