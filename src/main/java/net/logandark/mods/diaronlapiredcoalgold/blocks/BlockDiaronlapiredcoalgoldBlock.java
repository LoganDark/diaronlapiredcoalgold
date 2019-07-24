package net.logandark.mods.diaronlapiredcoalgold.blocks;

import net.logandark.mods.diaronlapiredcoalgold.Constants;
import net.logandark.mods.diaronlapiredcoalgold.enums.EnumDiaronlapiredcoalgoldDrop;
import net.logandark.mods.diaronlapiredcoalgold.interfaces.IDiaronlapiredcoalgoldSidedDrops;
import net.logandark.mods.diaronlapiredcoalgold.properties.PropertyDiaronlapiredcoalgoldOreDrop;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockDiaronlapiredcoalgoldBlock extends Block implements IDiaronlapiredcoalgoldSidedDrops {
	private static BlockDiaronlapiredcoalgoldBlock INSTANCE;

	public static BlockDiaronlapiredcoalgoldBlock getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BlockDiaronlapiredcoalgoldBlock();
		}

		return INSTANCE;
	}

	private BlockDiaronlapiredcoalgoldBlock() {
		super(Material.IRON);
		setHardness(5F);
		setResistance(10F);
		setSoundType(SoundType.METAL);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setTranslationKey(Constants.modid + ".diaronlapiredcoalgold_block");
		setRegistryName(Constants.modid, "diaronlapiredcoalgold_block");
		setDefaultState(getBlockState().getBaseState().withProperty(PropertyDiaronlapiredcoalgoldOreDrop.getInstance(), EnumDiaronlapiredcoalgoldDrop.DROP_NONE));
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
		return getDefaultState().withProperty(PropertyDiaronlapiredcoalgoldOreDrop.getInstance(), EnumDiaronlapiredcoalgoldDrop.values()[meta]);
	}

	@Nonnull
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance()).blockDrop);
	}
}
