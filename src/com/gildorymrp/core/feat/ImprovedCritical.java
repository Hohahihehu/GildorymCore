package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class ImprovedCritical implements PassiveFeat {

	@Override
	public String getDescription() {
		return "When using a weapon you choose, your threat range is doubled.";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getAttackBonus() >= 8) {
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
