package mod.mitecreation.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.MITECreationMod;
import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.entity.*;
import mod.mitecreation.event.command.*;
import mod.mitecreation.item.CreationItem;
import mod.mitecreation.recipe.*;
import mod.mitecreation.render.*;
import mod.mitecreation.util.Util;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CreationEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event){
        CreationItem.itemRegister(event);
        CreationBlock.registerBlocks(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event){
        RecipesOriginItemExtend.registerRecipes(event);
        RecipesOriginBlockExtend.registerRecipes(event);
        FurnaceRecipesExtend.furnaceRecipeRegister(event);
    }

    @Subscribe
    public void onCommandRegister(CommandRegisterEvent event) {
        event.register(new CommandProtection());
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event){
        event.register(EntitySpirit.class, MITECreationMod.CreationNameSpace, "EntitySpirit", IdUtil.getNextEntityID(), 0xFFFFFFF, 0xFFAD0000);
        event.register(EntitySpiderQueen.class, MITECreationMod.CreationNameSpace, "EntitySpiderQueen", IdUtil.getNextEntityID(), 11013646, 0xFFAD1245);
        event.register(EntityDevilBat.class, MITECreationMod.CreationNameSpace, "EntityDevilBat", IdUtil.getNextEntityID(), 0xFFFFFF, 0xFFFFFF);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        event.register(EntitySpiderQueen.class, new RenderSpiderQueen(1.5F));
        event.register(EntitySpirit.class, new RenderSpirit());
        event.register(EntityDevilBat.class, new RenderDevilBat());
    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Client] ").appendComponent(ChatMessageComponent.createFromTranslationKey("MITE Creation Successful Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Util.modVerStr)));
    }
}
