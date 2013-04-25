package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class Cleave extends ActiveFeat {
	
	public static final String DESCRIPTION = "If you drop a foe, you may make another attack in your turn, as long as you do not move.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getStrength() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof PowerAttack) {
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
