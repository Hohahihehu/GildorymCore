package com.gildorymrp.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.GildorymCorePlugin;

public class GildorymCore extends JavaPlugin implements GildorymCorePlugin {
	
	private Map<String, Character> activeCharacters = new HashMap<String, Character>();
	private Map<String, Set<Character>> characters = new HashMap<String, Set<Character>>();
	
	@Override
	public void onEnable() {
		Gildorym.registerCorePlugin(this);
		SaveDataManager.loadData(this);
		this.registerListeners(new GildorymClassLevelChangeListener());
	}
	
	@Override
	public void onDisable() {
		SaveDataManager.saveData(this);
	}
	
	private void registerListeners(Listener... listeners) {
		for (Listener listener : listeners) {
			this.getServer().getPluginManager().registerEvents(listener, this);
		}
	}

	@Override
	public Character getActiveCharacter(Player player) {
		return activeCharacters.get(player.getName());
	}

	@Override
	public Set<Character> getCharacters(Player player) {
		if (characters.get(player.getName()) == null) {
			characters.put(player.getName(), new HashSet<Character>());
		}
		return characters.get(player.getName());
	}

	@Override
	public void setActiveCharacter(Player player, Character character) {
		if (this.getActiveCharacter(player) != null) {
			character.setPlayer(null);
			character.setInventoryContents(player.getInventory().getContents());
			character.setLocation(player.getLocation());
		}
		if (!this.getCharacters(player).contains(character)) {
			this.getCharacters(player).add(character);
		}
		this.activeCharacters.put(player.getName(), character);
		player.getInventory().setContents(character.getInventoryContents());
		player.teleport(character.getLocation());
	}
	
	protected Map<String, Set<Character>> getCharacters() {
		return characters;
	}

}
