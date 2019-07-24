package net.logandark.mods.diaronlapiredcoalgold.enums;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public enum EnumDiaronlapiredcoalgoldOreDrop {
	DROP_NONE(null, null, 0),
	DROP_LAPIS(EnumFacing.DOWN, Items.DYE, EnumDyeColor.BLUE.getDyeDamage()),
	DROP_REDSTONE(EnumFacing.UP, Items.REDSTONE, 0),
	DROP_IRON(EnumFacing.SOUTH, Item.getItemFromBlock(Blocks.IRON_ORE), 0),
	DROP_DIAMOND(EnumFacing.NORTH, Items.DIAMOND, 0),
	DROP_GOLD(EnumFacing.WEST, Item.getItemFromBlock(Blocks.GOLD_ORE), 0),
	DROP_COAL(EnumFacing.EAST, Items.COAL, 0);

	final EnumFacing facing;
	public final Item item;
	public final int damage;

	EnumDiaronlapiredcoalgoldOreDrop(EnumFacing facing, Item item, int damage) {
		this.facing = facing;
		this.item = item;
		this.damage = damage;
	}

	public static EnumDiaronlapiredcoalgoldOreDrop fromFacing(EnumFacing from) {
		for (EnumDiaronlapiredcoalgoldOreDrop oreDrop : EnumDiaronlapiredcoalgoldOreDrop.values()) {
			if (oreDrop.facing == from) {
				return oreDrop;
			}
		}

		throw new NullPointerException("couldn't find EnumDiaronlapiredcoalgoldOreDrop for side");
	}
}
