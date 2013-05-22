package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class RapidShot implements ActiveFeat {

	@Override
	public String getDescription() {
		return "One extra ranged attack each round";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof PointBlankShot) {
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
