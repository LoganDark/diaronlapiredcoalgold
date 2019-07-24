package net.logandark.mods.diaronlapiredcoalgold.enums;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public enum EnumDiaronlapiredcoalgoldDrop {
	DROP_NONE(null, null, 0, null),
	DROP_LAPIS(EnumFacing.DOWN, Items.DYE, EnumDyeColor.BLUE.getDyeDamage(), Blocks.LAPIS_BLOCK),
	DROP_REDSTONE(EnumFacing.UP, Items.REDSTONE, 0, Blocks.REDSTONE_BLOCK),
	DROP_IRON(EnumFacing.SOUTH, Item.getItemFromBlock(Blocks.IRON_ORE), 0, Blocks.IRON_BLOCK),
	DROP_DIAMOND(EnumFacing.NORTH, Items.DIAMOND, 0, Blocks.DIAMOND_BLOCK),
	DROP_GOLD(EnumFacing.WEST, Item.getItemFromBlock(Blocks.GOLD_ORE), 0, Blocks.GOLD_BLOCK),
	DROP_COAL(EnumFacing.EAST, Items.COAL, 0, Blocks.COAL_BLOCK);

	final EnumFacing facing;
	public final Item itemDrop;
	public final int itemDamage;
	public final Block blockDrop;

	EnumDiaronlapiredcoalgoldDrop(EnumFacing facing, Item itemDrop, int itemDamage, Block blockDrop) {
		this.facing = facing;
		this.itemDrop = itemDrop;
		this.itemDamage = itemDamage;
		this.blockDrop = blockDrop;
	}

	public static EnumDiaronlapiredcoalgoldDrop fromFacing(EnumFacing from) {
		for (EnumDiaronlapiredcoalgoldDrop oreDrop : EnumDiaronlapiredcoalgoldDrop.values()) {
			if (oreDrop.facing == from) {
				return oreDrop;
			}
		}

		throw new NullPointerException("couldn't find EnumDiaronlapiredcoalgoldOreDrop for side");
	}
}
