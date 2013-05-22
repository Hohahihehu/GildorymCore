package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class CombatReflexes implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "You may make one additional attack of opportunity per dexterity modifier per round.";
	}
	
	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		return true;
	}

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		return statBonuses;
	}

}
