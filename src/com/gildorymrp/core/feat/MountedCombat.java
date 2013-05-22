package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class MountedCombat implements PassiveFeat {

	@Override
	public String getDescription() {
		return "Negate hits on mount with ride check";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getSkills().get(Skill.RIDE) >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		return statBonuses;
	}

}
