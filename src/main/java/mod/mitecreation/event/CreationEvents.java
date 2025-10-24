package mod.mitecreation.event;

import com.google.common.eventbus.Subscribe;
import mod.mitecreation.client.audio.CTSounds;
import mod.mitecreation.event.command.CommandCTDimensionTP;
import mod.mitecreation.event.command.CommandCTProtection;
import mod.mitecreation.client.render.RenderCTDevilBat;
import mod.mitecreation.client.render.RenderCTSpiderQueen;
import mod.mitecreation.client.render.RenderCTSpirit;
import mod.mitecreation.entity.EntityCTDevilBat;
import mod.mitecreation.entity.EntityCTSpiderQueen;
import mod.mitecreation.entity.EntityCTSpirit;
import mod.mitecreation.event.listener.*;
import mod.mitecreation.event.listener.compat.CTHandpanRecipes;
import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.init.CreationModInit;
import mod.mitecreation.material.CTMaterials;
import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.handler.GravelDropHandler;
import moddedmite.rustedironcore.api.event.listener.IArrowRegisterListener;
import moddedmite.rustedironcore.api.event.listener.IPlayerEventListener;
import net.minecraft.*;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class CreationEvents extends Handlers {

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

    public static void register() {
        FurnaceUpdate.register(new CTFurnaceListener());
        BeaconUpdate.register(new CTBeaconListener());
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.CopperEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.SilverEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.GoldEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.MithrilEntry);
        GravelDrop.unregisterGravelLootEntry(GravelDropHandler.AdamantiumEntry);
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.CopperEntry.weight()), info -> CTRegistryInit.rawCopperNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.SilverEntry.weight()), info -> CTRegistryInit.rawSilverNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.GoldEntry.weight()), info -> CTRegistryInit.rawGoldNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.MithrilEntry.weight()), info -> CTRegistryInit.rawMithrilNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((GravelDropHandler.AdamantiumEntry.weight()), info -> CTRegistryInit.rawAdamantiumNugget.itemID));
        GravelDrop.registerGravelLootEntry(new GravelDropHandler.GravelLootEntry((float) (GravelDropHandler.MithrilEntry.weight() * 1.25), info -> CTRegistryInit.rawTungstenNugget.itemID));
        ArrowRegister.register(new IArrowRegisterListener() {
            @Override
            public void onRegister(Consumer<Material> registry) {
                registry.accept(CTMaterials.tungsten);
            }
        });
        PropertiesRegistry.register(new CTPropertyRegistry());
        OreGeneration.register(new CTOreGenerationRegistry());
        LootTable.register(new CTLootTableRegistry());
        Combat.register(new CTCombatListener());
        ArmorModel.register(new CTArmorModelListener());
        PlayerAttribute.register(new CTPlayerAttributeListener());
        BiomeGenerate.register(new CTBiomeGenerateListener());
        Structure.register(new CTStructureRegister());
        StructureNBT.register(new CTStructureNBTRegister());
        Achievement.register(new CTAchievementListener());
        PlayerEvent.register(new IPlayerEventListener() {
            @Override
            public void onPlayerLoggedIn(moddedmite.rustedironcore.api.event.events.PlayerLoggedInEvent event) {
                event.player().sendChatToPlayer(ChatMessageComponent.createFromText("[" + CreationModInit.NAMESPACE + "] ").appendComponent(ChatMessageComponent.createFromTranslationKey( CreationModInit.NAMESPACE + " Successfully Load,Version: ").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromText(CreationModInit.VERSION)));
            }
        });
        registerHandpanRecipesCompat();
    }

    private static void registerHandpanRecipesCompat() {
        if (FishModLoader.hasMod("miterenewed")) {
            try {
                Class<?> eventClass = Class.forName("com.github.jeffyjamzhd.renewed.api.event.HandpanRegisterEvent");
                Class<?> listenerClass = Class.forName("com.github.jeffyjamzhd.renewed.api.event.listener.HandpanRegisterListener");
                Method registerMethod = eventClass.getMethod("register", listenerClass);
                Object recipeInstance = new CTHandpanRecipes();
                registerMethod.invoke(null, recipeInstance);
            } catch (ClassNotFoundException e) {
                CreationModInit.LOGGER.error("Handpan API class not found: {}", e.getMessage(), e);
            } catch (NoSuchMethodException e) {
                CreationModInit.LOGGER.error("Method 'register(HandpanRegisterListener)' not found. API may have changed.", e);
            } catch (Exception e) {
                CreationModInit.LOGGER.error("Failed to register handpan recipes:", e);
            }
        }
    }
}
