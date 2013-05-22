package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedTrip implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You do not provoke an attack of opportunity when you attempt to attack while unarmed. You also gain a +4 bonus on your Strength check to trip your opponent. If you successfully trip your opponent, you may immediately make another attack without taking another turn.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getIntelligence() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof CombatExpertise) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
