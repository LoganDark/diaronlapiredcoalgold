package net.logandark.mods.diaronlapiredcoalgold.generators;

import net.logandark.mods.diaronlapiredcoalgold.blocks.BlockDiaronlapiredcoalgoldOre;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class GeneratorDiaronlapiredcoalgoldOre implements IWorldGenerator {
	private static GeneratorDiaronlapiredcoalgoldOre INSTANCE;

	public static GeneratorDiaronlapiredcoalgoldOre getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GeneratorDiaronlapiredcoalgoldOre();
		}

		return INSTANCE;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimensionType() != DimensionType.OVERWORLD)
			return;

		WorldGenMinable oreGen = new WorldGenMinable(BlockDiaronlapiredcoalgoldOre.getInstance().getDefaultState(), 8, BlockMatcher.forBlock(Blocks.STONE));

		for (int i = 0; i < 20; i++) {
			oreGen.generate(
				world,
				random,
				new BlockPos(
					chunkX * 16 + random.nextInt(16),
					random.nextInt(255),
					chunkZ * 16 + random.nextInt(16)
				)
			);
		}
	}
}
