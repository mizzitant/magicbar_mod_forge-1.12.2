package net.docmanna.minecraft.magicbar.init;

import net.docmanna.minecraft.magicbar.MagicBarMod;
import net.docmanna.minecraft.magicbar.items.BasicItem;
import net.docmanna.minecraft.magicbar.items.MagicFoodItem;
import net.docmanna.minecraft.magicbar.items.MagicWandItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MagicBarMod.MODID)
public class ModItems {
	static Item itemBar;
	static MagicWandItem itemMagicWand;
	static MagicFoodItem itemMagicFood;

	public static void init() {
		itemBar = new BasicItem("magicbar");
		itemBar.setCreativeTab(CreativeTabs.MISC);
		itemBar.setMaxStackSize(32);

		itemMagicWand = new MagicWandItem("magicwand");
		itemMagicWand.setCreativeTab(CreativeTabs.MISC);
		itemMagicWand.setMaxStackSize(32);

		itemMagicFood = new MagicFoodItem("magicapple", 5, 0.3f, false);
		itemMagicFood.setAlwaysEdible();
		itemMagicFood.setCreativeTab(CreativeTabs.FOOD);
	}

	@SubscribeEvent
	// RegistryEvents: These events are fired right after preinitialization
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(itemBar, itemMagicWand, itemMagicFood);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(itemBar);
		registerRender(itemMagicWand);
		registerRender(itemMagicFood);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
