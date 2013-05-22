package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedOverrun implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "When you attempt to overrun an opponent, the target may not choose to avoid you. You also gain a +4 bonus to your Strength check to knock down your opponent.";
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
