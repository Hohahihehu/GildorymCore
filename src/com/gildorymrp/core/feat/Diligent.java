package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class Diligent implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "+2 bonus on Appraise and Decipher script checks";
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
		statBonuses.put(Skill.APPRAISE, 2);
		statBonuses.put(Skill.DECIPHER_SCRIPT, 2);
		return statBonuses;
	}

}
