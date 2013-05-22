package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class Leadership implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "You can attract loyal companions and devoted followers, and subordinates who can assist you.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (Gildorym.getClassesPlugin().getLevel(character) >= 6) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		return statBonuses;
	}

}
