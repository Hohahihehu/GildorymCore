package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedBullRush implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You gain a +4 bonus to any attempt to push back a foe in combat.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getStrength() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof PowerAttack) {
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
