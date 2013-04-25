package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedDisarm extends ActiveFeat {
	
	public static final String DESCRIPTION = "You gain a +4 bonus when attempting to disarm an opponent and they cannot counter-disarm you.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getIntelligence() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof CombatExpertise) {
					return true;
				}
			}
			return true;
		}
		return false;
	}

	public Boolean isFighterBonusFeat() {
		return true;
	}

}
