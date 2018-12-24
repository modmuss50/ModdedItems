package me.modmuss50.moddeditems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModdedItems implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		FabricItemGroupBuilder.create(new Identifier("fabric", "modded")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
			if(!Registry.ITEM.getId(item).getNamespace().equals("minecraft")){
				itemStacks.add(new ItemStack(item));
			}
		})).icon(() -> new ItemStack(Blocks.TNT)).build();
	}
}
