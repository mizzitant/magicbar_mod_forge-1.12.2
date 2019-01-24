package net.docmanna.minecraft.magicbar.blocks;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.docmanna.minecraft.magicbar.MagicBarMod;
import net.docmanna.minecraft.magicbar.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends BasicBlock {

	Item itemToDrop;
	int minDropAmount;
	int maxDropAmount;

	private static final Logger logger = LogManager.getLogger(MagicBarMod.MODID);

	public MagicBlock(String name, Material material) {
		this(name, material, null, 1, 1);
	}

	public MagicBlock(String name, Material material, Item itemToDrop, int minDropAmount, int maxDropAmount) {
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
		if (fortune > 0
				&& Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;

			if (i < 0)
				i = 0;

			return quantityDropped(random) * (i + 1);
		} else
			return quantityDropped(random);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		logger.info("[onBlockAdded]: Koordinates of Block: " + "X: " + x + ", Y: " + y + ", Z: " + z);

		//Block block = new Block().
/*		for(int i = x; i < x+10; i++) {
			worldIn.setBlockState(new BlockPos(i, y, z), ModBlocks.blockMagicBar.getDefaultState());
			worldIn.setBlockToAir(new BlockPos(i, y, z));
		}

		for(int i = y; i < y+10; i++) {
			worldIn.setBlockState(new BlockPos(x, i, z), ModBlocks.blockMagicBar.getDefaultState());
			worldIn.setBlockToAir(new BlockPos(i, y, z));
		} //*/
	} //*/

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		logger.info("[onBlockClicked]: Koordinates of Block: " + "X: " + x + ", Y: " + y + ", Z: " + z);

		for(int i = x+1; i < x+10; i++) {
			worldIn.setBlockState(new BlockPos(i, y, z), ModBlocks.blockMagicBar.getDefaultState());
			worldIn.setBlockToAir(new BlockPos(i, y, z));
		}

		for(int i = y+1; i < y+10; i++) {
			worldIn.setBlockState(new BlockPos(x, i, z), ModBlocks.blockMagicBar.getDefaultState());
			worldIn.setBlockToAir(new BlockPos(x, i, z));
		}

		for(int i = z+1; i < z+10; i++) {
			worldIn.setBlockState(new BlockPos(x, y, i), ModBlocks.blockMagicBar.getDefaultState());
			worldIn.setBlockToAir(new BlockPos(x, y, i));
		}

	}

	@Override
	// Control right click behavior
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		logger.info("[onBlockActivated]: Begin", "Begin");

		//if(state.getBlock() == Blocks.GRASS) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			logger.info("[onBlockActivated]: Koordinates of Block: " + "X: " + x + ", Y: " + y + ", Z: " + z);

			for(int i = x+1; i < x+10; i++) {
				worldIn.setBlockState(new BlockPos(i, y, z), ModBlocks.blockMagicBar.getDefaultState());
				//worldIn.setBlockToAir(new BlockPos(i, y, z));
			}

			for(int i = y+1; i < y+9; i++) {
				worldIn.setBlockState(new BlockPos(x, i, z), Blocks.BEDROCK.getDefaultState());
				//worldIn.setBlockToAir(new BlockPos(x, i, z));
			}
			worldIn.setBlockState(new BlockPos(x, y+10, z), ModBlocks.blockMagicBar.getDefaultState());

			for(int i = z+1; i < z+10; i++) {
				worldIn.setBlockState(new BlockPos(x, y, i), Blocks.GRASS.getDefaultState());
				//worldIn.setBlockToAir(new BlockPos(x, y, i));
			}
			worldIn.setBlockState(new BlockPos(x, y, z+9), ModBlocks.blockMagicBar.getDefaultState());

			return true;
		//}

		// Now the fun part: the tunnel
		/*
		The Location class has a method that returns a direction vector

		Code:

			Location loc = playerIn.getLocation();
			Vector facing = loc.getDirection();

		Some more code:

			TNTPrimed tnt = player.getEyeLocation().getWorld().spawn(
		                	player.getEyeLocation(), TNTPrimed.class);
    	Vector direction = player.getEyeLocation().getDirection().multiply(2.5);
  		tnt.setVelocity(direction);
*/
		//return false;
	}

//	@SubscribeEvent
//	public static void onPlayerInteract(PlayerInteractEvent event) {
//		if (EtFuturum.enableGrassPath)
//			if (event.getEntityPlayer() != null) {
//				World world = event.getEntityPlayer().getEntityWorld();
//				if (event.action == Action.RIGHT_CLICK_BLOCK)
//					if (world.getBlock(event.x, event.y, event.z) == Blocks.grass) {
//						ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
//						if (stack != null && (stack.getItem() instanceof ItemSpade || isTinkersShovel(stack))) {
//							world.setBlock(event.x, event.y, event.z, ModBlocks.grass_path);
//							event.entityPlayer.swingItem();
//							stack.damageItem(1, event.entityPlayer);
//							world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F,
//									Block.soundTypeGravel.getStepResourcePath(), 1.0F, 0.8F);
//						}
//					}
//			}
//	}

} // end of class
