package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedGrapple implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You gain +4 to your Grapple checks, and may grapple without being hit with a counter-attack.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof ImprovedUnarmedStrike) {
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
