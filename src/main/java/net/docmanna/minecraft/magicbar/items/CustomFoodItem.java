package net.docmanna.minecraft.magicbar.items;

import net.minecraft.item.ItemFood;

public class CustomFoodItem extends ItemFood {

	public CustomFoodItem(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
