package com.gildorymrp.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gildorymrp.api.plugin.core.Character;;

public class SaveDataManager {
	
	public static void loadData(GildorymCore plugin) {
		File playerDataDirectory = new File(plugin.getDataFolder() + File.separator + "player-data");
		if (playerDataDirectory.exists()) {
			for (File file : playerDataDirectory.listFiles()) {
				YamlConfiguration playerSave = new YamlConfiguration();
				try {
					playerSave.load(file);
				} catch (FileNotFoundException exception) {
					plugin.getLogger().severe("Failed to load player data from " + file.getPath() + ": the file did not exist.");
					exception.printStackTrace();
				} catch (IOException exception) {
					plugin.getLogger().severe("Failed to load player data from " + file.getPath() + ": encountered I/O exception.");
					exception.printStackTrace();
				} catch (InvalidConfigurationException exception) {
					plugin.getLogger().severe("Failed to load player data from " + file.getPath() + ": file was invalid.");
					exception.printStackTrace();
				}
			}
		}
	}
	
	public static void saveData(GildorymCore plugin) {
		for (String player : plugin.getCharacters().keySet()) {
			File playerSaveFile = new File(plugin.getDataFolder().getPath() + File.separator + player);
			YamlConfiguration playerSave = new YamlConfiguration();
			for (Character character : plugin.getCharacters().get(player)) {
				playerSave.set(character.getName(), ((CharacterImpl) character).serialize());
			}
			try {
				playerSave.save(playerSaveFile);
			} catch (IOException exception) {
				plugin.getLogger().severe("Failed to save characters for " + player + ": I/O exception");
				exception.printStackTrace();
			}
		}
	}

}
