package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class Leadership extends PassiveFeat {
	
	public static String DESCRIPTION = "You can attract loyal companions and devoted followers, and subordinates who can assist you.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getGildorymClass().getLevel() >= 6) {
			return true;
		}
		return false;
	}

}
