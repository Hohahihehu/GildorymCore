package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedFeint implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "As long as you do not move, you may now feint and attack in the same turn.";
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
