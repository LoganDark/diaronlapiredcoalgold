package net.logandark.mods.diaronlapiredcoalgold.blocks;

import net.logandark.mods.diaronlapiredcoalgold.Constants;
import net.logandark.mods.diaronlapiredcoalgold.enums.EnumDiaronlapiredcoalgoldOreDrop;
import net.logandark.mods.diaronlapiredcoalgold.properties.PropertyDiaronlapiredcoalgoldOreDrop;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockDiaronlapiredcoalgoldOre extends BlockOre {
	private static BlockDiaronlapiredcoalgoldOre INSTANCE;

	public static BlockDiaronlapiredcoalgoldOre getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BlockDiaronlapiredcoalgoldOre();
		}

		return INSTANCE;
	}

	private BlockDiaronlapiredcoalgoldOre() {
		super();
		setHardness(3F);
		setResistance(5F);
		setSoundType(SoundType.STONE);
		setTranslationKey(Constants.modid + ".diaronlapiredcoalgold_ore");
		setRegistryName(new ResourceLocation(Constants.modid, "diaronlapiredcoalgold_ore"));
		setDefaultState(getBlockState().getBaseState().withProperty(PropertyDiaronlapiredcoalgoldOreDrop.getInstance(), EnumDiaronlapiredcoalgoldOreDrop.DROP_NONE));
	}

	@Nonnull
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, PropertyDiaronlapiredcoalgoldOreDrop.getInstance());
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance()).ordinal();
	}

	@SuppressWarnings("deprecation")
	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(PropertyDiaronlapiredcoalgoldOreDrop.getInstance(), EnumDiaronlapiredcoalgoldOreDrop.values()[meta]);
	}

	@Nonnull
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance()).item;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance()).damage;
	}

	@Override
	public int quantityDropped(@Nonnull Random random) {
		return 1;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, @Nonnull Random random) {
		int bonusMultiplier = quantityDroppedWithBonus(fortune, random);

		switch (state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance())) {
			case DROP_LAPIS:
				return (4 + random.nextInt(5)) * bonusMultiplier;
			case DROP_REDSTONE:
				return 4 + random.nextInt(2) + random.nextInt(fortune + 1);
			case DROP_IRON:
			case DROP_GOLD:
				return 1;
		}

		return bonusMultiplier;
	}

	@Override
	public int getExpDrop(@Nonnull IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();

		return MathHelper.getInt(rand, 3, 7);
	}
}
