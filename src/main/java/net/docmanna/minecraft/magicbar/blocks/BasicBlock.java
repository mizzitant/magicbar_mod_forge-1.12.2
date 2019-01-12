package net.docmanna.minecraft.magicbar.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {
	
	public BasicBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
	}
}
