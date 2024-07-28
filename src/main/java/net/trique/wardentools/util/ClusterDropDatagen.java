package net.trique.wardentools.util;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.trique.wardentools.block.WardenBlocks;
import net.trique.wardentools.data.WardenItemTagProvider;

public class ClusterDropDatagen extends FabricBlockLootTableProvider {
    public ClusterDropDatagen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public LootTable.Builder createClusterDrops(Block block, Item item) {
        return dropsWithSilkTouch(block, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2)))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(WardenItemTagProvider.SCULKHYST_CLUSTER_MAX_HARVESTABLES) ))
                .alternatively(applyExplosionDecay(block,ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))))
        );
    }

    @Override
    public void generate() {
        addDrop(WardenBlocks.SCULKHYST_CLUSTER,createClusterDrops(WardenBlocks.SCULKHYST_CLUSTER, Items.ECHO_SHARD));
    }
}
