package com.lededesigns.decore.procedures;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class HomeCommandExecutedProcedure extends DecoreModElements.ModElement {
	public HomeCommandExecutedProcedure(DecoreModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HomeCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double HomeX = 0;
		double HomeY = 0;
		double HomeZ = 0;
		HomeX = (double) (entity.getPersistentData().getDouble("PlayerHomeX"));
		HomeY = (double) (entity.getPersistentData().getDouble("PlayerHomeY"));
		HomeZ = (double) (entity.getPersistentData().getDouble("PlayerHomeZ"));
		if ((((HomeX) != 0) && (((HomeY) != 0) && ((HomeZ) != 0)))) {
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((HomeX), (HomeY), (HomeZ));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((HomeX), (HomeY), (HomeZ), _ent.rotationYaw, _ent.rotationPitch,
							Collections.emptySet());
				}
			}
		}
	}
}
