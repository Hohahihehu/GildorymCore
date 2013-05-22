package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedDisarm implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You gain a +4 bonus when attempting to disarm an opponent and they cannot counter-disarm you.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getIntelligence() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof CombatExpertise) {
					return true;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
