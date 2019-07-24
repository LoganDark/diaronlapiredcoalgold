package net.logandark.mods.diaronlapiredcoalgold.properties;

import com.google.common.base.Optional;
import net.logandark.mods.diaronlapiredcoalgold.enums.EnumDiaronlapiredcoalgoldDrop;
import net.minecraft.block.properties.PropertyHelper;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;

public class PropertyDiaronlapiredcoalgoldOreDrop extends PropertyHelper<EnumDiaronlapiredcoalgoldDrop> {
	private static PropertyDiaronlapiredcoalgoldOreDrop INSTANCE;

	public static PropertyDiaronlapiredcoalgoldOreDrop getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PropertyDiaronlapiredcoalgoldOreDrop();
		}

		return INSTANCE;
	}

	private PropertyDiaronlapiredcoalgoldOreDrop() {
		super("dilrcgo_ore_drop", EnumDiaronlapiredcoalgoldDrop.class);
	}

	@Nonnull
	@Override
	public Collection<EnumDiaronlapiredcoalgoldDrop> getAllowedValues() {
		return Arrays.asList(EnumDiaronlapiredcoalgoldDrop.values());
	}

	@SuppressWarnings("Guava")
	@Nonnull
	@Override
	public Optional<EnumDiaronlapiredcoalgoldDrop> parseValue(@Nonnull String value) {
		return Optional.of(EnumDiaronlapiredcoalgoldDrop.valueOf(value.toUpperCase()));
	}

	@Nonnull
	@Override
	public String getName(@Nonnull EnumDiaronlapiredcoalgoldDrop value) {
		return value.name().toLowerCase();
	}
}
