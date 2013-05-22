package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class WeaponFocus implements PassiveFeat {

	@Override
	public String getDescription() {
		return "You gain a +1 bonus on all attack rolls you make using the selected weapon";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getAttackBonus() >= 1) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof SimpleWeaponProficiency || feat instanceof MartialWeaponProficiency || feat instanceof ExoticWeaponProficiency) {
					return true;
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
