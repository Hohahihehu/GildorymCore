package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedTwoWeaponFighting extends ActiveFeat {
	
	public static final String DESCRIPTION = "In addition to the single extra attack you get with an off-hand weapon, you get a second attack, albeit with a -5 penalty.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getDexterity() >= 17) {
			if (character.getAttackBonus() >= 6) {
				for (Feat feat : character.getFeats()) {
					if (feat instanceof TwoWeaponFighting) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
