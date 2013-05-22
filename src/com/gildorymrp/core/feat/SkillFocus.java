package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class SkillFocus implements PassiveFeat {
	
	private Skill skill;
	
	public SkillFocus(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String getDescription() {
		return "+3 bonus on " + skill.toString() + "checks";
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
		statBonuses.put(skill, 3);
		return statBonuses;
	}

}
