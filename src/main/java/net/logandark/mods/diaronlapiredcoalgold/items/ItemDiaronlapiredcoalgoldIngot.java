package net.logandark.mods.diaronlapiredcoalgold.items;

import net.logandark.mods.diaronlapiredcoalgold.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemDiaronlapiredcoalgoldIngot extends Item {
	private static ItemDiaronlapiredcoalgoldIngot INSTANCE;

	public static ItemDiaronlapiredcoalgoldIngot getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ItemDiaronlapiredcoalgoldIngot();
		}

		return INSTANCE;
	}

	private ItemDiaronlapiredcoalgoldIngot() {
		super();

		setTranslationKey(Constants.modid + ".diaronlapiredcoalgold_ingot");
		setRegistryName(new ResourceLocation(Constants.modid, "diaronlapiredcoalgold_ingot"));
		setCreativeTab(CreativeTabs.MATERIALS);
	}
}
