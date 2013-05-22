package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class GreaterWeaponSpecialisation implements PassiveFeat {
	
	@Override
	public String getDescription() {
		return "You gain a +2 bonus on all damage rolls you make using the selected weapon.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		for (Feat feat1 : character.getFeats()) {
			if (feat1 instanceof GreaterWeaponFocus) {
				for (Feat feat2 : character.getFeats()) {
					if (feat2 instanceof WeaponSpecialisation) {
						return true;
					}
				}
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
