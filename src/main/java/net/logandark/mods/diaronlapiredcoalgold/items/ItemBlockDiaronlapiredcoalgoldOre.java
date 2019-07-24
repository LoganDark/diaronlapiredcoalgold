package net.logandark.mods.diaronlapiredcoalgold.items;

import net.logandark.mods.diaronlapiredcoalgold.blocks.BlockDiaronlapiredcoalgoldOre;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class ItemBlockDiaronlapiredcoalgoldOre extends ItemBlock {
	private static ItemBlockDiaronlapiredcoalgoldOre INSTANCE;

	public static ItemBlockDiaronlapiredcoalgoldOre getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ItemBlockDiaronlapiredcoalgoldOre();
		}

		return INSTANCE;
	}

	private ItemBlockDiaronlapiredcoalgoldOre() {
		super(BlockDiaronlapiredcoalgoldOre.getInstance());
		setRegistryName(Objects.requireNonNull(block.getRegistryName()));
	}
}
