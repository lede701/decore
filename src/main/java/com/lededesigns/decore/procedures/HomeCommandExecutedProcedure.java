package com.lededesigns.decore.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
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
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					DimensionType destinationType = DimensionType.OVERWORLD;
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
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
