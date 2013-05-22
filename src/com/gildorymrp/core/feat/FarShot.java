package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class FarShot implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "Ranged attacks go twice as far";
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
