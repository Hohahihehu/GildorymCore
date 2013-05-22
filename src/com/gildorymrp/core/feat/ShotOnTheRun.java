package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ShotOnTheRun implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Move before and after ranged attack";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 13) {
			if (character.getAttackBonus() >= 4) {
				for (Feat feat1 : character.getFeats()) {
					if (feat1 instanceof Mobility) {
						for (Feat feat2 : character.getFeats()) {
							if (feat2 instanceof PointBlankShot) {
								return true;
							}
						}
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
