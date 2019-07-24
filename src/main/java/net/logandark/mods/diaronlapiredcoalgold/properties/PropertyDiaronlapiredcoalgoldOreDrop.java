package net.logandark.mods.diaronlapiredcoalgold.properties;

import com.google.common.base.Optional;
import net.logandark.mods.diaronlapiredcoalgold.enums.EnumDiaronlapiredcoalgoldOreDrop;
import net.minecraft.block.properties.PropertyHelper;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;

public class PropertyDiaronlapiredcoalgoldOreDrop extends PropertyHelper<EnumDiaronlapiredcoalgoldOreDrop> {
	private static PropertyDiaronlapiredcoalgoldOreDrop INSTANCE;

	public static PropertyDiaronlapiredcoalgoldOreDrop getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PropertyDiaronlapiredcoalgoldOreDrop();
		}

		return INSTANCE;
	}

	private PropertyDiaronlapiredcoalgoldOreDrop() {
		super("dilrcgo_ore_drop", EnumDiaronlapiredcoalgoldOreDrop.class);
	}

	@Nonnull
	@Override
	public Collection<EnumDiaronlapiredcoalgoldOreDrop> getAllowedValues() {
		return Arrays.asList(EnumDiaronlapiredcoalgoldOreDrop.values());
	}

	@SuppressWarnings("Guava")
	@Nonnull
	@Override
	public Optional<EnumDiaronlapiredcoalgoldOreDrop> parseValue(@Nonnull String value) {
		return Optional.of(EnumDiaronlapiredcoalgoldOreDrop.valueOf(value.toUpperCase()));
	}

	@Nonnull
	@Override
	public String getName(@Nonnull EnumDiaronlapiredcoalgoldOreDrop value) {
		return value.name().toLowerCase();
	}
}
