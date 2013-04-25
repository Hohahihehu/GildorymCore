package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class CombatExpertise extends ActiveFeat {
	
	public static final String DESCRIPTION = "You may take up to 5 points off your attack and put them onto your AC";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getIntelligence() >= 13) {
			return true;
		}
		return false;
	}

	public Boolean isFighterBonusFeat() {
		return true;
	}

}
