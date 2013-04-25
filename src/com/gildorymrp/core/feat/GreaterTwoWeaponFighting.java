package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class GreaterTwoWeaponFighting extends ActiveFeat {
	
	public static final String DESCRIPTION = "You may make a third attack with your offhand weapon at -10 penalty to hit.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getDexterity() >= 19 && character.getAttackBonus() >= 11) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof ImprovedTwoWeaponFighting) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean isFighterBonusFeat() {
		return true;
	}

}
