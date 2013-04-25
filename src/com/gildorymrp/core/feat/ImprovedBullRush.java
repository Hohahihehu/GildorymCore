package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedBullRush extends ActiveFeat {
	
	public static final String DESCRIPTION = "You gain a +4 bonus to any attempt to push back a foe in combat.";
	
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
