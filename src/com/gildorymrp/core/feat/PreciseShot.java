package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class PreciseShot implements PassiveFeat {

	@Override
	public String getDescription() {
		return "You can shoot or thrown ranged weapons at an opponent engaged in melee without taking the standard -4 penalty on your attack roll.";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof PointBlankShot) {
				return true;
			}
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
