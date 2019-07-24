package net.logandark.mods.diaronlapiredcoalgold.subscribers;

import net.logandark.mods.diaronlapiredcoalgold.Constants;
import net.logandark.mods.diaronlapiredcoalgold.blocks.BlockDiaronlapiredcoalgoldOre;
import net.logandark.mods.diaronlapiredcoalgold.generators.GeneratorDiaronlapiredcoalgoldOre;
import net.logandark.mods.diaronlapiredcoalgold.items.ItemBlockDiaronlapiredcoalgoldOre;
import net.logandark.mods.diaronlapiredcoalgold.items.ItemDiaronlapiredcoalgoldIngot;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Constants.modid)
public class Registry {
	private static final ArrayList<Block> blocks = new ArrayList<>();
	private static final ArrayList<Item> items = new ArrayList<>();

	private static void addBlocks() {
		blocks.add(BlockDiaronlapiredcoalgoldOre.getInstance());
	}

	private static void addItems() {
		items.add(ItemBlockDiaronlapiredcoalgoldOre.getInstance());
		items.add(ItemDiaronlapiredcoalgoldIngot.getInstance());
	}

	@SubscribeEvent
	static void registerBlocks(RegistryEvent.Register<Block> event) {
		addBlocks();

		blocks.forEach((Block block) -> event.getRegistry().register(block));
	}

	@SubscribeEvent
	static void registerItems(RegistryEvent.Register<Item> event) {
		addItems();

		items.forEach((Item item) -> event.getRegistry().register(item));

		doPreinitStuff();
	}

	@SubscribeEvent
	static void registerModels(ModelRegistryEvent event) {
		items.forEach((Item item) -> {
			ResourceLocation resourceLocation = Objects.requireNonNull(item.getRegistryName());
			ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, "inventory");

			ModelLoader.setCustomModelResourceLocation(item, 0, modelResourceLocation);
		});
	}

	private static void doPreinitStuff() {
		registerRecipes();
		registerWorldGenerators();
	}

	private static void registerRecipes() {
		GameRegistry.addSmelting(
			BlockDiaronlapiredcoalgoldOre.getInstance(),
			new ItemStack(ItemDiaronlapiredcoalgoldIngot.getInstance()),
			0
		);
	}

	private static void registerWorldGenerators() {
		GameRegistry.registerWorldGenerator(GeneratorDiaronlapiredcoalgoldOre.getInstance(), 0);
	}
}
