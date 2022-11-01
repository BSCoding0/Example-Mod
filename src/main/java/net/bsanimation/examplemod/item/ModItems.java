package net.bsanimation.examplemod.item;

import net.bsanimation.examplemod.ExampleMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_SIGMIUM = registerItem("raw_sigmium",
            new Item(new FabricItemSettings().group(ModItemGroup.SIGMIUM)));
    public static final Item SIGMIUM = registerItem("sigmium",
            new Item(new FabricItemSettings().group(ModItemGroup.SIGMIUM)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExampleMod.LOGGER.debug("Registering Mod Items for" + ExampleMod.MOD_ID);
    }
}
