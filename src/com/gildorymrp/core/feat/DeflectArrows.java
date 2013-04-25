package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class DeflectArrows extends ActiveFeat {
	
	public static final String DESCRIPTION = "You can grab one arrow with your fist per round.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getDexterity() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof ImprovedUnarmedStrike) {
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
