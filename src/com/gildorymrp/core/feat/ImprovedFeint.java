package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedFeint extends ActiveFeat {
	
	public static final String DESCRIPTION = "As long as you do not move, you may now feint and attack in the same turn.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getIntelligence() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof CombatExpertise) {
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
