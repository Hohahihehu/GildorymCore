package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class GreatCleave extends ActiveFeat {
	
	public static final String DESCRIPTION = "If you use Cleave to drop an enemy, you may use Cleave again. There is no limit on how many times you can use this.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getStrength() >= 13 && character.getAttackBonus() >= 4) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof Cleave) {
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
