package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class ImprovedUnarmedStrike implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "You are considered to be armed even when unarmed, that is you do not provoke attacks of opportunity from armed opponents that you attack while unarmed.";
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
