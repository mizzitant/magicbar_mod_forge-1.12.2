package net.docmanna.minecraft.magicbar;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "magicbar";
    public static final String VERSION = "1.0";
   
    //public static Item magicOreItem;
    public static Block magicOreBlock;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	// System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    	//magicOreItem = new ModItem("magicOre");
        //GameRegistry.registerItem(magicOreItem, "magicOre");

        //magicOreBlock = new ModBlock(Material.rock, "magicOre", magicOreItem);
        magicOreBlock = new ModBlock(Material.rock, "magicOre", null);
        GameRegistry.registerBlock(magicOreBlock, "magicOreBlock");

        GameRegistry.registerWorldGenerator(new ModWorldGenerator(magicOreBlock, 6), 0);
        
        Block luckyBlock = new ModBlock(Material.rock, "luckyBlock", null);
        GameRegistry.registerBlock(luckyBlock, "luckyBlock");

        Block harry = new ModBlock(Material.rock, "harry", null);
        GameRegistry.registerBlock(harry, "harry");
        
        Block potterScar = new ModBlock(Material.rock, "potterScar", null);
        GameRegistry.registerBlock(potterScar, "potterScar");
    }

}


