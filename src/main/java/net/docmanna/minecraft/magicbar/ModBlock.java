package net.docmanna.minecraft.magicbar;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModBlock extends Block
{
	private Item toDrop;

    public ModBlock(Material material, String blockName, Item toDrop)
    {
        super(material);
        this.setUnlocalizedName(blockName);
        // Texture Name muss der Konvention [Mod ID]:[Blockname] folgen
        this.setBlockTextureName(Main.MODID + ":" + blockName);
        // Block im Kreativ Modus verfuegbar machen
        this.setCreativeTab(CreativeTabs.tabBlock);
        // Iron Ore has a hardness of 3.0F, while Obsidian has a hardness of
        // 50.0F.
        this.setHardness(1.0F);
        /* @param level Harvest level:
         *     Wood:    0
         *     Stone:   1
         *     Iron:    2
         *     Diamond: 3
         *     Gold:    0
         */
        this.setHarvestLevel("pickaxe", 0);
        this.toDrop = toDrop;
    }

    @Override
    public Item getItemDropped(int i, Random random, int j)
    {
        if(toDrop != null)
        {
            return toDrop;
        }
        else return Item.getItemFromBlock(this);
    }
}