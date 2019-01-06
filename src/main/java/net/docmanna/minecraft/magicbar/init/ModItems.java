package net.docmanna.minecraft.magicbar.init;

import net.docmanna.minecraft.magicbar.MagicBarMod;
import net.docmanna.minecraft.magicbar.items.ItemBasic;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid=MagicBarMod.MODID)
public class ModItems {
	static Item itemBar;

	public static void init() {
		itemBar = new ItemBasic("magicbar");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(itemBar);
	}
}
