package net.trique.wardentools.item;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.item.*;
import net.minecraft.item.ArmorItem.Type;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;

public class WardenArmorMaterials{
    public static void initialize(){}

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable){
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(WardenTools.MOD_ID,id),"",dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(WardenTools.MOD_ID, id),material);
        return RegistryEntry.of(material);
    }

    public static final RegistryEntry<ArmorMaterial> WARDEN = registerMaterial("warden",
            Map.of(
                    Type.HELMET,4,
                    Type.CHESTPLATE, 7,
                    Type.LEGGINGS, 9,
                    Type.BOOTS,4
            ),15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            () -> Ingredient.ofItems(WardenItems.ECHO_INGOT),3.0f,0.1f,false);

}