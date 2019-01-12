package net.docmanna.minecraft.magicbar.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModItems.itemBar,
				new ItemStack(ModItems.itemMagicWand, 1), 1.5f);
		GameRegistry.addSmelting(ModBlocks.blockMagicBar,
				new ItemStack(ModItems.itemBar, 2), 0.2f);
	}
}
