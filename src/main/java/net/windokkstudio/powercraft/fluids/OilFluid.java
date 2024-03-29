
package net.windokkstudio.powercraft.fluids;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.windokkstudio.powercraft.init.PowercraftBlocks;
import net.windokkstudio.powercraft.init.PowercraftFluidTypes;
import net.windokkstudio.powercraft.init.PowercraftFluids;
import net.windokkstudio.powercraft.init.PowercraftItems;

public abstract class OilFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> PowercraftFluidTypes.OIL_TYPE.get(), () -> PowercraftFluids.OIL.get(), () -> PowercraftFluids.FLOWING_OIL.get()).explosionResistance(100f).tickRate(25)
			.bucket(() -> PowercraftItems.OIL_BUCKET.get()).block(() -> (LiquidBlock) PowercraftBlocks.OIL.get());

	private OilFluid() {
		super(PROPERTIES);
	}

	public static class Source extends OilFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends OilFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}

