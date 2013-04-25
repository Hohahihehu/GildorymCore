package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class Feat {

	public static final String DESCRIPTION = "Contact administrator immediately.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		return true;
	}
	
	public Boolean isFighterBonusFeat() {
		return false;
	}

}
