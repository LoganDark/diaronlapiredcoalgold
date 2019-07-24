package net.logandark.mods.diaronlapiredcoalgold.subscribers;

import net.logandark.mods.diaronlapiredcoalgold.blocks.BlockDiaronlapiredcoalgoldOre;
import net.logandark.mods.diaronlapiredcoalgold.enums.EnumDiaronlapiredcoalgoldOreDrop;
import net.logandark.mods.diaronlapiredcoalgold.properties.PropertyDiaronlapiredcoalgoldOreDrop;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DiaronlapiredcoalgoldSideChanger {
	@SubscribeEvent
	static void onLeftClick(PlayerInteractEvent.LeftClickBlock event) {
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);

		if (state.getBlock() == BlockDiaronlapiredcoalgoldOre.getInstance()) {
			EnumDiaronlapiredcoalgoldOreDrop oreDrop = EnumDiaronlapiredcoalgoldOreDrop.fromFacing(event.getFace());

			if (state.getValue(PropertyDiaronlapiredcoalgoldOreDrop.getInstance()) != oreDrop) {
				world.setBlockState(pos, state.withProperty(PropertyDiaronlapiredcoalgoldOreDrop.getInstance(), oreDrop));
			}
		}
	}
}
