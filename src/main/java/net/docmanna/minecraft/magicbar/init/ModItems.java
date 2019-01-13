package net.docmanna.minecraft.magicbar.init;

import net.docmanna.minecraft.magicbar.MagicBarMod;
import net.docmanna.minecraft.magicbar.items.BasicItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MagicBarMod.MODID)
public class ModItems {
	static Item itemBar;
	static Item itemMagicWand;

	public static void init() {
		itemBar = new BasicItem("magicbar");
		itemBar.setCreativeTab(CreativeTabs.MISC);
		itemBar.setMaxStackSize(32);

		itemMagicWand = new BasicItem("magicwand");
		itemMagicWand.setCreativeTab(CreativeTabs.MISC);
		itemMagicWand.setMaxStackSize(32);

	}

	@SubscribeEvent
	// RegistryEvents: These events are fired right after preinitialization
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(itemBar, itemMagicWand);
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(itemBar);
		registerRender(itemMagicWand);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
