package com.gildorymrp.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.event.classes.GildorymClassLevelChangeEvent;
import com.gildorymrp.api.plugin.classes.GildorymClassesPlugin;

public class GildorymClassLevelChangeListener implements Listener {
	
	@EventHandler
	public void onGildorymClassLevelChange(GildorymClassLevelChangeEvent event) {
		Character chara = event.getCharacter();
		GildorymClassesPlugin plugin = Gildorym.getClassesPlugin();
		
		chara.setMaxHealth(plugin.getHpBonus(plugin.getClass(chara)) * plugin.getLevel(chara));
	}

}
