package mod.mitecreation.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.block.Blocks;
import mod.mitecreation.entity.EntitySpiderQueen;
import mod.mitecreation.entity.EntitySpirit;
import mod.mitecreation.item.Items;
import mod.mitecreation.recipe.FurnaceRecipesExtend;
import mod.mitecreation.recipe.RecipesOriginBlockExtend;
import mod.mitecreation.recipe.RecipesOriginItemExtend;
import mod.mitecreation.render.RenderSpiderQueen;
import mod.mitecreation.render.RenderSpirit;
import mod.mitecreation.util.Util;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.*;

public class CreationEvents {

    @Subscribe
    public void onItemRegister(ItemRegistryEvent event){
        Items.itemRegister(event);
        Blocks.registerBlocks(event);
    }

    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event){
        RecipesOriginItemExtend.registerRecipes(event);
        RecipesOriginBlockExtend.registerRecipes(event);
        FurnaceRecipesExtend.furnaceRecipeRegister(event);
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event){
        event.register(EntitySpirit.class, "EntitySpirit", 541, 0xFFFFFFF, 0xFFAD0000);
        event.register(EntitySpiderQueen.class, "EntitySpiderQueen", 542, 11013646, 0xFFAD1245);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        event.register(EntitySpiderQueen.class, new RenderSpiderQueen(1.45F));
        event.register(EntitySpirit.class, new RenderSpirit());
    }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        event.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[Client] ").appendComponent(ChatMessageComponent.createFromTranslationKey("MITE Creation Successful Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(Util.modVerStr)));
    }
}
