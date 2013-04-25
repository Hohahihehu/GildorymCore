package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedOverrun extends ActiveFeat {
	
	public static final String DESCRIPTION = "When you attempt to overrun an opponent, the target may not choose to avoid you. You also gain a +4 bonus to your Strength check to knock down your opponent.";
	
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
