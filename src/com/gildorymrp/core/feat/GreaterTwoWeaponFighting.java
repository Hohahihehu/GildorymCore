package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class GreaterTwoWeaponFighting implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You may make a third attack with your offhand weapon at -10 penalty to hit.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 19 && character.getAttackBonus() >= 11) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof ImprovedTwoWeaponFighting) {
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

}
