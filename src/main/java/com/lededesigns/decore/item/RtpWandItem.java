
package com.lededesigns.decore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import com.lededesigns.decore.procedures.RtpCommandExecutedProcedure;
import com.lededesigns.decore.itemgroup.DEToolsItemGroup;
import com.lededesigns.decore.DecoreModElements;

@DecoreModElements.ModElement.Tag
public class RtpWandItem extends DecoreModElements.ModElement {
	@ObjectHolder("decore:rtp_wand")
	public static final Item block = null;
	public RtpWandItem(DecoreModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DEToolsItemGroup.tab).maxStackSize(1));
			setRegistryName("rtp_wand");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RtpCommandExecutedProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
