package net.docmanna.minecraft.magicbar.items;

import net.minecraft.item.Item;

public class BasicItem extends Item {

	public BasicItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
	}

/*	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
	    IBlockState iblockstate = worldIn.getBlockState(pos);
	    Block block = iblockstate.getBlock();

	    // snow layer stuff we don't care about
	    if (!block.isReplaceable(worldIn, pos))
	    {
	        pos = pos.offset(facing);
	    }
	    BlockPos clickedBlock = new BlockPos(hitX, hitY, hitZ);
	    worldIn.setBlockState(clickedBlock, Blocks.WATER.getDefaultState());
	    return EnumActionResult.SUCCESS;
	}
*/
}
