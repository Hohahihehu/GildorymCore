package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedTrip extends ActiveFeat {
	
	public static final String DESCRIPTION = "You do not provoke an attack of opportunity when you attempt to attack while unarmed. You also gain a +4 bonus on your Strength check to trip your opponent. If you successfully trip your opponent, you may immediately make another attack without taking another turn.";
	
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
