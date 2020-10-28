package com.lededesigns.decore.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class HomeWandRightClickedInAirProcedure extends DecoreModElements.ModElement {
	public HomeWandRightClickedInAirProcedure(DecoreModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HomeWandRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HomeWandRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HomeWandRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HomeWandRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		boolean IsHomeSet = false;
		IsHomeSet = (boolean) (entity.getPersistentData().getBoolean("SetPlayerHome"));
		if (((entity.isSneaking()) || (!(IsHomeSet)))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				SetHomeCommandExecutedProcedure.executeProcedure($_dependencies);
			}
			entity.getPersistentData().putBoolean("SetPlayerHome", (true));
		} else {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				HomeCommandExecutedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
