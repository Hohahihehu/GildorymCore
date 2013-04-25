package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class Dodge extends ActiveFeat {
	
	public static final String DESCRIPTION = "You may get a +1 to your AC against all of one opponent's attacks.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getDexterity() >= 13) {
			return true;
		}
		return false;
	}

	public Boolean isFighterBonusFeat() {
		return true;
	}

}
