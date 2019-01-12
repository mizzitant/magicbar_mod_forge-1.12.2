package net.docmanna.minecraft.magicbar;

import org.apache.logging.log4j.Logger;

import net.docmanna.minecraft.magicbar.init.ModBlocks;
import net.docmanna.minecraft.magicbar.init.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MagicBarMod.MODID, name = MagicBarMod.NAME, version = MagicBarMod.VERSION)
public class MagicBarMod {
	public static final String MODID = "magicbar";
	public static final String NAME = "Magic Bar Mod";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.12]";

	private static Logger logger;

	// Make Forge assign the instance of the MagicBarMod class it is using to
	// this variable.
	@Instance
	public static MagicBarMod instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		logger.info(MODID + ":preInit");
		ModItems.init();
		ModBlocks.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// some example code
		// logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		logger.info(MODID, ":init");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info(MODID, ":postInit");
		System.out.println(MODID + ":postInit");
	}
}
