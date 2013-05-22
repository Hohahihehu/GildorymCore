package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ManyShot implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Shoot two or more arrows simultaneously";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 17) {
			if (character.getAttackBonus() >= 6) {
				for (Feat feat : character.getFeats()) {
					if (feat instanceof RapidShot) {
						return true;
					}
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
