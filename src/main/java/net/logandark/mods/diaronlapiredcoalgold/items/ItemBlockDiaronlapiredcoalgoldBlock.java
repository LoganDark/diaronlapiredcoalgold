package net.logandark.mods.diaronlapiredcoalgold.items;

import net.logandark.mods.diaronlapiredcoalgold.blocks.BlockDiaronlapiredcoalgoldBlock;
import net.minecraft.item.ItemBlock;

import java.util.Objects;

public class ItemBlockDiaronlapiredcoalgoldBlock extends ItemBlock {
	private static ItemBlockDiaronlapiredcoalgoldBlock INSTANCE;

	public static ItemBlockDiaronlapiredcoalgoldBlock getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ItemBlockDiaronlapiredcoalgoldBlock();
		}

		return INSTANCE;
	}

	private ItemBlockDiaronlapiredcoalgoldBlock() {
		super(BlockDiaronlapiredcoalgoldBlock.getInstance());
		setRegistryName(Objects.requireNonNull(block.getRegistryName()));
	}
}
