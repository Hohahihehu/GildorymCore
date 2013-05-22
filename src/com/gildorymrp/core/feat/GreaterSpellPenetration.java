package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class GreaterSpellPenetration implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "+4 to caster level checks to defeat spell resistance";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof SpellPenetration) {
				return true;
			}
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
