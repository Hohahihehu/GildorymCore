package com.gildorymrp.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.event.classes.GildorymClassLevelChangeEvent;

public class GildorymClassLevelChangeListener implements Listener {
	
	@EventHandler
	public void onGildorymClassLevelChange(GildorymClassLevelChangeEvent event) {
		event.getCharacter().setMaxHealth(Gildorym.getClassesPlugin().getHpBonus(Gildorym.getClassesPlugin().getClass(event.getCharacter())) * Gildorym.getClassesPlugin().getLevel(event.getCharacter()));
	}

}
