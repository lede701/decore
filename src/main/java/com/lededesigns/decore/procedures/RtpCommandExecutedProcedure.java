package com.lededesigns.decore.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collections;

import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class RtpCommandExecutedProcedure extends DecoreModElements.ModElement {
	public RtpCommandExecutedProcedure(DecoreModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RtpCommandExecuted!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure RtpCommandExecuted!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure RtpCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RtpCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean ProcessRandom = false;
		double NewX = 0;
		double NewY = 0;
		double NewZ = 0;
		double Range = 0;
		double LowRange = 0;
		Range = (double) 10000;
		LowRange = (double) ((Range) / 2);
		ProcessRandom = (boolean) (true);
		while ((ProcessRandom)) {
			NewX = (double) (x + (Math.round(((Range) * Math.random())) - (LowRange)));
			NewZ = (double) (z + (Math.round(((Range) * Math.random())) - (LowRange)));
			NewY = (double) 20;
			while ((!(world.canBlockSeeSky(new BlockPos((int) (NewX), (int) (NewY), (int) (NewZ)))))) {
				NewY = (double) ((NewY) + 1);
			}
			NewY = (double) ((NewY) + 1);
			if ((world.isAirBlock(new BlockPos((int) (NewX), (int) (NewY), (int) (NewZ))))) {
				ProcessRandom = (boolean) (false);
			}
		}
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((NewX), (NewY), (NewZ));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((NewX), (NewY), (NewZ), _ent.rotationYaw, _ent.rotationPitch,
						Collections.emptySet());
			}
		}
		System.out.println((("[x:") + "" + ((NewX)) + "" + (", y:") + "" + ((NewY)) + "" + (", z:") + "" + ((NewZ)) + "" + ("]")));
	}
}
