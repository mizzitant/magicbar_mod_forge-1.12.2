package net.docmanna.minecraft.magicbar.world;

import java.util.Random;

import com.google.common.base.Predicate;

import net.docmanna.minecraft.magicbar.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.WorldWorkerManager.IWorker;
import net.minecraftforge.fml.common.IWorldGenerator;

public class MagicBlockGen implements IWorldGenerator, IWorker {

	@Override
	public boolean hasWork() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		// Depending on the dimension we generate differently
		//
		// Nether: -1 (Ores mostly replace Netherrack)
	    // Overworld: 0 (Ores mostly replace Stone)
	    // The End: 1 (No ores normally spawn but you should probably replace Endstone)
		switch (world.provider.getDimension()) {

		case -1: // Nether dimension: -1
			break;
		case 0: // Overworld dimension: 0
			runGenerator(ModBlocks.blockMagicBar.getDefaultState(), 7, 10, 12, 50, BlockMatcher.forBlock(Blocks.STONE),
					world, random, chunkX, chunkZ);
			break;
		case 1: // End dimension: 1
			runGenerator(Blocks.BRICK_BLOCK.getDefaultState(), 7, 10, 0, 255, BlockMatcher.forBlock(Blocks.END_STONE),
					world, random, chunkX, chunkZ);
			break;
		// Everything else
		default:
			break;
		}
	}

	/**
	 * 
	 * * choose the position based on the pseudo-random number generator (based on
	 *   the world seed)
	 * * pass the position to the oreGenerator, this will automatically generate an
	 *   ore vein at the position.
	 */
	private void runGenerator(IBlockState blockToGen, int blockAmount, int chancesToSpawn, int minHeight, int maxHeight,
			Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z) {
		// check parameters
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
		int heightdiff = maxHeight - minHeight +1;

		for (int i=0; i<chancesToSpawn; i++) {
			int x = chunk_X * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunk_Z * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
