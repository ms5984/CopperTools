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

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * Main plugin class.
 *
 * @author ms5984
 */
public final class CopperTools extends JavaPlugin {

    /**
     * Represents a few different text presentations.
     */
    public enum Colors {
        /**
         * Used for text on heavily copper-based tools.
         */
        COPPER("#B87333"),
        /**
         * Used for text on alloyed tools.
         */
        ALLOY("#D39C6E"),
        ;

        /**
         * The hex color as a TextColor.
         */
        public final TextColor textColor;

        Colors(String color) {
            this.textColor = TextColor.fromHexString(color);
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        for (CopperItem copperItem : CopperItem.values()) {
            getServer().addRecipe(copperItem.getRecipe());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            for (CopperItem copperItem : CopperItem.values()) {
                player.getInventory().addItem(copperItem.getItem());
            }
            return true;
        }
        return false;
    }
}
