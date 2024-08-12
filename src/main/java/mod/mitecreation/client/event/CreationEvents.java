package mod.mitecreation.client.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.MITECreationMod;
import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.client.event.command.CommandProtection;
import mod.mitecreation.client.render.RenderDevilBat;
import mod.mitecreation.client.render.RenderSpiderQueen;
import mod.mitecreation.client.render.RenderSpirit;
import mod.mitecreation.entity.EntityDevilBat;
import mod.mitecreation.entity.EntitySpiderQueen;
import mod.mitecreation.entity.EntitySpirit;
import mod.mitecreation.recipe.FurnaceRecipesExtend;
import mod.mitecreation.recipe.RecipesMITECreation;
import mod.mitecreation.item.CreationItem;
import mod.mitecreation.util.Util;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CreationEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        CreationItem.itemRegister(event);
        CreationBlock.registerBlocks(event);
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
        event.register(EntitySpirit.class, MITECreationMod.CreationNameSpace, "Spirit", IdUtil.getNextEntityID(), 0xFFFFFFF, 0xFFAD0000);
        event.register(EntitySpiderQueen.class, MITECreationMod.CreationNameSpace, "SpiderQueen", IdUtil.getNextEntityID(), 11013646, 0xFFAD1245);
        event.register(EntityDevilBat.class, MITECreationMod.CreationNameSpace, "DevilBat", IdUtil.getNextEntityID(), 0x020000, 0x300000);
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
    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Client] ").appendComponent(ChatMessageComponent.createFromTranslationKey("MITE Creation Successful Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Util.modVerStr)));
    }
}
