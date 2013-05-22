package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class Cleave implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "If you drop a foe, you may make another attack in your turn, as long as you do not move.";
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
