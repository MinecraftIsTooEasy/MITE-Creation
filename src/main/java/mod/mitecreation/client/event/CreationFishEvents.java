package mod.mitecreation.client.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.client.event.command.CommandProtection;
import mod.mitecreation.client.render.RenderDevilBat;
import mod.mitecreation.client.render.RenderSpiderQueen;
import mod.mitecreation.client.render.RenderSpirit;
import mod.mitecreation.entity.EntityDevilBat;
import mod.mitecreation.entity.EntitySpiderQueen;
import mod.mitecreation.entity.EntitySpirit;
import mod.mitecreation.recipe.FurnaceRecipesExtend;
import mod.mitecreation.recipe.RecipesMITECreation;
import mod.mitecreation.util.Constant;
import net.minecraft.ChatMessageComponent;
import net.minecraft.EnumChatFormatting;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CreationFishEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
//        CreationItem.itemRegister(event);
//        CreationBlock.registerBlocks(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event) {
        FurnaceRecipesExtend.furnaceRecipeRegister();
        RecipesMITECreation.registerRecipes(event);
    }

    @Subscribe
    public void onCommandRegister(CommandRegisterEvent event) {
        event.register(new CommandProtection());
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        event.register(EntitySpirit.class, Constant.CreationNameSpace, "Spirit", IdUtil.getNextEntityID(), 0xFFFFFFF, 0xFFAD0000);
        event.register(EntitySpiderQueen.class, Constant.CreationNameSpace, "SpiderQueen", IdUtil.getNextEntityID(), 11013646, 0xFFAD1245);
        event.register(EntityDevilBat.class, Constant.CreationNameSpace, "DevilBat", IdUtil.getNextEntityID(), 0x020000, 0x300000);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        event.register(EntitySpiderQueen.class, new RenderSpiderQueen(1.5F));
        event.register(EntitySpirit.class, new RenderSpirit());
        event.register(EntityDevilBat.class, new RenderDevilBat());
    }

    @Subscribe
    public void onSoundsRegister(SoundsRegisterEvent event) {
//        event.register("records/imported/eutopia.ogg");
        event.register("sound/imported/mob/spirit/hit.ogg");
        event.register("sound/imported/mob/spirit/death.ogg");
        event.register("sound/imported/mob/spirit/idle.ogg");
        event.register("sound/imported/mob/spirit/scream.ogg");
        event.register("sound/imported/mob/spirit/stare.ogg");
        event.register("sound/step/deepslate1.ogg");
        event.register("sound/step/deepslate2.ogg");
        event.register("sound/step/deepslate3.ogg");
        event.register("sound/step/deepslate4.ogg");
        event.register("sound/step/deepslate5.ogg");
        event.register("sound/step/deepslate6.ogg");
        event.register("sound/step/deepslate6.ogg");
        event.register("sound/dig/deepslate1.ogg");
        event.register("sound/dig/deepslate2.ogg");
        event.register("sound/dig/deepslate3.ogg");
        event.register("sound/dig/deepslate4.ogg");
        event.register("sound/place/deepslate1.ogg");
        event.register("sound/place/deepslate2.ogg");
        event.register("sound/place/deepslate3.ogg");
        event.register("sound/place/deepslate4.ogg");
        event.register("sound/place/deepslate5.ogg");
        event.register("sound/place/deepslate6.ogg");
        event.register("sound/place/deepslate6.ogg");
        event.register("sound/step/deepslate_bricks1.ogg");
        event.register("sound/step/deepslate_bricks2.ogg");
        event.register("sound/step/deepslate_bricks3.ogg");
        event.register("sound/step/deepslate_bricks4.ogg");
        event.register("sound/step/deepslate_bricks5.ogg");
        event.register("sound/place/deepslate_bricks1.ogg");
        event.register("sound/place/deepslate_bricks2.ogg");
        event.register("sound/place/deepslate_bricks3.ogg");
        event.register("sound/place/deepslate_bricks4.ogg");
        event.register("sound/place/deepslate_bricks5.ogg");
        event.register("sound/place/deepslate_bricks6.ogg");
        event.register("sound/place/deepslate_bricks6.ogg");
    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Client] ").appendComponent(ChatMessageComponent.createFromTranslationKey( Constant.CreationModName + "Successfully Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Constant.modVerStr)));
    }

}
