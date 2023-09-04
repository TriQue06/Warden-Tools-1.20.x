package net.trique.wardentools.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.item.custom.WardenTemplateItem;


public class WardenItems {

    public static final Item WARDEN_SHOVEL = registerItem("warden_shovel",
            new ShovelItem(WardenToolMaterials.WARDEN, 1.5f, -3.0f,(new FabricItemSettings().fireproof())));

    public static final Item WARDEN_PICKAXE = registerItem("warden_pickaxe",
            new PickaxeItem(WardenToolMaterials.WARDEN, 1, -2.8f,(new FabricItemSettings().fireproof())));

    public static final Item WARDEN_AXE = registerItem("warden_axe",
            new AxeItem(WardenToolMaterials.WARDEN, 5.0f, -3f,(new FabricItemSettings().fireproof())));

    public static final Item WARDEN_HOE = registerItem("warden_hoe",
            new HoeItem(WardenToolMaterials.WARDEN, -4, 0.0f,(new FabricItemSettings().fireproof())));

    public static final Item WARDEN_SWORD = registerItem("warden_sword",
            new SwordItem(WardenToolMaterials.WARDEN, 3, -2.4f,(new FabricItemSettings().fireproof())));

    public static final Item WARDEN_HELMET = registerItem("warden_helmet",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));

    public static final Item WARDEN_CHESTPLATE = registerItem("warden_chestplate",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));

    public static final Item WARDEN_LEGGINGS = registerItem("warden_leggings",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));

    public static final Item WARDEN_BOOTS = registerItem("warden_boots",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    public static final Item ECHO_INGOT = registerItem("echo_ingot",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item ECHO_STAFF = registerItem("echo_staff",
            new EchoStaff(new FabricItemSettings().fireproof().maxDamage(32)));

    public static final Item ECHO_APPLE = registerItem("echo_apple",
            new Item(new FabricItemSettings().fireproof().food(EchoApple.ECHO_APPLE)));

    public static final Item WARDEN_SOUL = registerItem("warden_soul",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item WARDEN_UPGRADE_SMITHING_TEMPLATE;
    static {
        WARDEN_UPGRADE_SMITHING_TEMPLATE = registerItem((String)"warden_upgrade_smithing_template", (Item)WardenTemplateItem.createWardenUpgrade());
    }

    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WardenTools.MOD_ID, name), item);
    }

    public static void registerWardenItems() {
        WardenTools.LOGGER.info("Registering Warden Items for " + WardenTools.MOD_ID);
    }
}
