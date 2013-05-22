package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class CombatExpertise implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You may take up to 5 points off your attack and put them onto your AC";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getIntelligence() >= 13) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
