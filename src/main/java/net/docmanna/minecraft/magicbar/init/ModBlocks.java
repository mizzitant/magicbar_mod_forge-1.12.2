package net.docmanna.minecraft.magicbar.init;

import net.docmanna.minecraft.magicbar.MagicBarMod;
import net.docmanna.minecraft.magicbar.blocks.MagicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MagicBarMod.MODID)
public class ModBlocks {

	static Block magicBarBlock;

	public static void init() {
		magicBarBlock = new MagicBlock("magicbar_block", Material.ROCK,
				ModItems.itemBar, 1, 5);
		
		magicBarBlock
		.setCreativeTab(CreativeTabs.BUILDING_BLOCKS)
		.setHardness(1.5f)
		.setLightLevel(8/15f);
		// tool classes: “pickaxe”, “shovel”, “axe”
	    // levels :	0=wood or gold, 1=stone, 2=iron, 3=diamond
		magicBarBlock.setHarvestLevel("pickaxe", 2);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(magicBarBlock);
	}

	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(
				new ItemBlock(magicBarBlock)
				.setRegistryName(magicBarBlock.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(magicBarBlock));
	}

	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
