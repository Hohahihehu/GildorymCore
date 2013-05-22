package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class SelfSufficient implements PassiveFeat {

	@Override
	public String getDescription() {
		return "+2 bonus on Heal and Survival checks";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		return true;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.HEAL, 2);
		statBonuses.put(Skill.SURVIVAL, 2);
		return statBonuses;
	}

}
