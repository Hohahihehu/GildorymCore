package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedGrapple extends ActiveFeat {
	
	public static final String DESCRIPTION = "You gain +4 to your Grapple checks, and may grapple without being hit with a counter-attack.";
	
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
