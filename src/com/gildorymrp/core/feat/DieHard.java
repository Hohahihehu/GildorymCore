package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class DieHard extends ActiveFeat {
	
	public static final String DESCRIPTION = "When put into the Dying state, you can still act.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof Endurance) {
				return true;
			}
		}
		return false;
	}

}
