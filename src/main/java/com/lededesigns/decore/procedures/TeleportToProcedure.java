package com.lededesigns.decore.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class TeleportToProcedure extends DecoreModElements.ModElement {
	public TeleportToProcedure(DecoreModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportTo!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			System.err.println("Failed to load dependency guistate for procedure TeleportTo!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TeleportTo!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TeleportTo!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportTo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double TeleportX = 0;
		double TeleportY = 0;
		double CurrentX = 0;
		double CurrentY = 0;
		double TeleportZ = 0;
		TeleportX = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:TeleX");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText()));
		TeleportZ = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:TeleZ");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText()));
		TeleportY = (double) 10;
		if (((x != (TeleportX)) && (z != (TeleportZ)))) {
			while ((!(world.canBlockSeeSky(new BlockPos((int) (TeleportX), (int) (TeleportY), (int) (TeleportZ)))))) {
				TeleportY = (double) ((TeleportY) + 1);
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate((TeleportX), (TeleportY), (TeleportZ));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation((TeleportX), (TeleportY), (TeleportZ), _ent.rotationYaw,
							_ent.rotationPitch, Collections.emptySet());
				}
			}
			System.out.println((("[") + "" + ((TeleportX)) + "" + (",") + "" + ((TeleportY)) + "" + (",") + "" + ((TeleportZ)) + "" + ("]")));
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
