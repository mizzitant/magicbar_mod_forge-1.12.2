package net.docmanna.minecraft.magicbar;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItem extends Item {
    public ModItem(String itemName)
    {
        this.setUnlocalizedName(itemName);
        this.setTextureName(Main.MODID + ":" + itemName);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

}
