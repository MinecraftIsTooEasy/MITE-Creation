package mod.mitecreation.client.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.client.audio.CTSounds;
import mod.mitecreation.client.event.command.CommandCTDimensionTP;
import mod.mitecreation.client.event.command.CommandCTProtection;
import mod.mitecreation.client.render.RenderCTDevilBat;
import mod.mitecreation.client.render.RenderCTSpiderQueen;
import mod.mitecreation.client.render.RenderCTSpirit;
import mod.mitecreation.entity.EntityCTDevilBat;
import mod.mitecreation.entity.EntityCTSpiderQueen;
import mod.mitecreation.entity.EntityCTSpirit;
import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.recipe.CTFurnaceRecipesExtend;
import mod.mitecreation.recipe.CTRecipes;
import net.minecraft.ChatMessageComponent;
import net.minecraft.EnumChatFormatting;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CreationFishEvents {

//    @Subscribe
//    public void onItemRegister(ItemRegistryEvent event) {
//        CreationItem.itemRegister(event);
//        CreationBlock.registerBlocks(event);
//    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event) {
        CTFurnaceRecipesExtend.furnaceRecipeRegister();
        CTRecipes.registerRecipes(event);
    }

    @Subscribe
    public void onCommandRegister(CommandRegisterEvent event) {
        event.register(new CommandCTProtection());
        event.register(new CommandCTDimensionTP());
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        event.register(EntityCTSpirit.class, CreationModInit.NAMESPACE, "Spirit", IdUtil.getNextEntityID(), 0xFFFFFFF, 0xFFAD0000);
        event.register(EntityCTSpiderQueen.class, CreationModInit.NAMESPACE, "SpiderQueen", IdUtil.getNextEntityID(), 11013646, 0xFFAD1245);
        event.register(EntityCTDevilBat.class, CreationModInit.NAMESPACE, "DevilBat", IdUtil.getNextEntityID(), 0x020000, 0x300000);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        event.register(EntityCTSpiderQueen.class, new RenderCTSpiderQueen(1.5F));
        event.register(EntityCTSpirit.class, new RenderCTSpirit());
        event.register(EntityCTDevilBat.class, new RenderCTDevilBat());
    }

    @Subscribe
    public void onSoundsRegister(SoundsRegisterEvent event) {
//        event.register("records/imported/eutopia");
        event.registerSound(CTSounds.spiritHit);
        event.registerSound(CTSounds.spiritDeath);
        event.registerSound(CTSounds.spiritIdle);
        event.registerSound(CTSounds.spiritScream);
        event.registerSound(CTSounds.spiritStare);
        event.registerSound(CTSounds.deepslateStep, 6);
        event.registerSound(CTSounds.deepslateDig, 4);
        event.registerSound(CTSounds.deepslatePlace, 6);
        event.registerSound(CTSounds.deepslateBricksStep, 5);
        event.registerSound(CTSounds.deepslateBricksPlace, 6);
    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[" + CreationModInit.NAME + "] ").appendComponent(ChatMessageComponent.createFromTranslationKey( CreationModInit.NAMESPACE + " Successfully Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(CreationModInit.VERSION)));
    }

}
