package mod.mitecreation.item;

import net.minecraft.*;

import java.util.Random;

public class ItemCTSnowBerryBowl extends ItemBowl {
    private final Random random = new Random();

    public ItemCTSnowBerryBowl(int id, Material contents, String texture) {
        super(id, contents, texture);
    }

    @Override
    public void onItemUseFinish(ItemStack item_stack, World world, EntityPlayer player) {
        if (player.onServer()) {
            switch (random.nextInt(7)) {
                case 0 -> player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 0));
                case 1 -> player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 200, 0));
                case 2 -> player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 0));
                case 3 -> player.addPotionEffect(new PotionEffect(Potion.poison.id, 200, 0));
                case 4 -> player.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 0));
                case 5 -> player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 200, 0));
                case 6 -> player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 0));
            }
            player.addFoodValue(this);
            if (this.isEatable(item_stack)) {
                world.playSoundAtEntity(player, "random.burp", 0.5f, player.rand.nextFloat() * 0.1f + 0.9f);
            }
        }
        super.onItemUseFinish(item_stack, world, player);
    }
}
