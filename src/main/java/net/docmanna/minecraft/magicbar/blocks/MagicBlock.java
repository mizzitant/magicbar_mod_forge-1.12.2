package net.docmanna.minecraft.magicbar.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class MagicBlock extends BasicBlock {

	Item itemToDrop;
	int minDropAmount;
	int maxDropAmount;

	
	public MagicBlock(String name, Material material) {
		this(name, material, null, 1, 1);
	}

	public MagicBlock(String name, Material material, Item itemToDrop,
			int minDropAmount, int maxDropAmount) {
		super(name, material);
		this.itemToDrop = itemToDrop;
		this.minDropAmount = minDropAmount;
		this.maxDropAmount = maxDropAmount;
	}

	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int integer) {
		return itemToDrop == null ? Item.getItemFromBlock(this) : itemToDrop;
	}

	
	@Override
	public int quantityDropped(Random random) {
		if (minDropAmount > maxDropAmount)
			minDropAmount = maxDropAmount;

		return minDropAmount + random.nextInt(maxDropAmount - minDropAmount + 1);
	}

	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		// calculate a multiplier for the quantityDropped
		if (fortune > 0 &&
				 Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0)
				i = 0;

			return quantityDropped(random) * (i + 1);
		} else
			return quantityDropped(random);
	}

} // end of class
