/*
 *   Copyright 2022 ms5984 <https://github.com/ms5984>
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.github.ms5984.learnspigotsmp.coppertools;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * New uses for copper.
 * <p>
 * Specifies item base material, item generation, recipe and applied name
 * (if applicable).
 *
 * @author ms5984
 */
public enum CopperItem {
    /**
     * A modified golden axe.
     * <p>
     * Possesses Durability 1 silently.
     */
    AXE(Component.text("Copper Axe").color(CopperTools.Colors.COPPER.textColor), Material.GOLDEN_AXE) {
        @Override
        public ItemStack getItem() {
            final ItemStack axe = new ItemStack(baseMat);
            final ItemMeta itemMeta = axe.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            axe.setItemMeta(itemMeta);
            axe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return axe;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape("CC ", "CS ", " S ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('S', Material.STICK);
        }
    },
    /**
     * A modified empty bucket.
     * <p>
     * Possesses Mending 1 silently (just for color effect).
     */
    BUCKET(Component.text("Alloy Bucket").color(CopperTools.Colors.ALLOY.textColor), Material.BUCKET) {
        @Override
        public ItemStack getItem() {
            final ItemStack alloyBucket = new ItemStack(baseMat);
            final ItemMeta itemMeta = alloyBucket.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.MENDING, 1, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            alloyBucket.setItemMeta(itemMeta);
            alloyBucket.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return alloyBucket;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape("C C", " I ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('I', Material.IRON_INGOT);
        }
    },
    /**
     * An alternate clock recipe.
     */
    CLOCK(null, Material.CLOCK) {
        @Override
        public ItemStack getItem() {
            return new ItemStack(Material.CLOCK);
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape(" I ", "IRI", " I ")
                    .setIngredient(
                            'I',
                            new RecipeChoice.ExactChoice(
                                    new ItemStack(Material.COPPER_INGOT),
                                    new ItemStack(Material.GOLD_INGOT)
                            )
                    )
                    .setIngredient('R', Material.REDSTONE);
        }
    },
    /**
     * An alternate compass recipe.
     */
    COMPASS(null, Material.COMPASS) {
        @Override
        public ItemStack getItem() {
            return new ItemStack(Material.COMPASS);
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape(" I ", "CRC", " C ")
                    .setIngredient('I', Material.IRON_INGOT)
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('R', Material.REDSTONE);
        }
    },
    /**
     * A modified golden hoe.
     * <p>
     * Possesses Durability 2 silently.
     */
    HOE(Component.text("Copper Hoe").color(CopperTools.Colors.COPPER.textColor), Material.GOLDEN_HOE) {
        @Override
        public ItemStack getItem() {
            final ItemStack hoe = new ItemStack(baseMat);
            final ItemMeta itemMeta = hoe.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            hoe.setItemMeta(itemMeta);
            hoe.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return hoe;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape("CC ", " S ", " S ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('S', Material.STICK);
        }
    },
    /**
     * A modified golden pickaxe.
     * <p>
     * Possesses Durability 2 silently.
     */
    PICKAXE(Component.text("Copper Pickaxe").color(CopperTools.Colors.COPPER.textColor), Material.GOLDEN_PICKAXE) {
        @Override
        public ItemStack getItem() {
            final ItemStack pick = new ItemStack(baseMat);
            final ItemMeta itemMeta = pick.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            pick.setItemMeta(itemMeta);
            pick.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return pick;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape("CCC", " S ", " S ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('S', Material.STICK);
        }
    },
    /**
     * A modified set of shears.
     * <p>
     * Possesses Durability 1 silently.
     */
    SHEARS(Component.text("Alloy Shears").color(CopperTools.Colors.ALLOY.textColor), Material.SHEARS) {
        @Override
        public ItemStack getItem() {
            final ItemStack shears = new ItemStack(baseMat);
            final ItemMeta itemMeta = shears.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            shears.setItemMeta(itemMeta);
            shears.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return shears;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape(" C", "S ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('S', Material.SHEARS);
        }
    },
    /**
     * A modified golden shovel.
     * <p>
     * Possesses Durability 2 silently.
     */
    SHOVEL(Component.text("Copper Shovel").color(CopperTools.Colors.COPPER.textColor), Material.GOLDEN_SHOVEL) {
        @Override
        public ItemStack getItem() {
            final ItemStack shovel = new ItemStack(baseMat);
            final ItemMeta itemMeta = shovel.getItemMeta();
            itemMeta.displayName(customName);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
            itemMeta.getPersistentDataContainer().set(flag(), PersistentDataType.BYTE, (byte) 1);
            shovel.setItemMeta(itemMeta);
            shovel.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            return shovel;
        }

        @Override
        public Recipe getRecipe() {
            return new ShapedRecipe(namespacedKey(), getItem())
                    .shape(" C ", " S ", " S ")
                    .setIngredient('C', Material.COPPER_INGOT)
                    .setIngredient('S', Material.STICK);
        }
    },
    ;

    // lazy-caches flag key (see static method CopperItem#flag)
    private static final AtomicReference<NamespacedKey> KEY = new AtomicReference<>();
    /**
     * A custom display name for the item.
     */
    public final @Nullable Component customName;
    /**
     * The base material of the item.
     */
    public final Material baseMat;

    CopperItem(@Nullable Component customName, Material baseMat) {
        this.customName = customName;
        this.baseMat = baseMat;
    }

    /**
     * Get the applicable namespaced key for the item.
     *
     * @return a namespaced key object
     */
    public NamespacedKey namespacedKey() {
        return new NamespacedKey(JavaPlugin.getPlugin(CopperTools.class), name());
    }

    /**
     * Generate a new stack of this item.
     *
     * @return a new ItemStack
     */
    public abstract ItemStack getItem();

    /**
     * Get the recipe for this item.
     *
     * @return a recipe object
     */
    public abstract Recipe getRecipe();

    /**
     * Test if the provided item has our PDC flag.
     *
     * @param item an item
     * @return true only if {@code item} has our flag
     */
    public static boolean hasFlag(ItemStack item) {
        if (item == null) return false;
        final Byte aByte;
        try {
            aByte = item.getItemMeta().getPersistentDataContainer().get(flag(), PersistentDataType.BYTE);
        } catch (IllegalArgumentException ignored) {
            return false;
        }
        return aByte != null && aByte == 1;
    }

    // produces + caches the key used for flagging items
    static NamespacedKey flag() {
        return KEY.updateAndGet(f -> f != null ? f : new NamespacedKey(JavaPlugin.getPlugin(CopperTools.class), "flag"));
    }
}
