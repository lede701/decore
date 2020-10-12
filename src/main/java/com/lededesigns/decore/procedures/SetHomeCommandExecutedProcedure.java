package com.lededesigns.decore.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class SetHomeCommandExecutedProcedure extends DecoreModElements.ModElement {
	public SetHomeCommandExecutedProcedure(DecoreModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SetHomeCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SetHomeCommandExecuted!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SetHomeCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SetHomeCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		entity.getPersistentData().putDouble("PlayerHomeX", x);
		entity.getPersistentData().putDouble("PlayerHomeY", y);
		entity.getPersistentData().putDouble("PlayerHomeZ", z);
	}
}
