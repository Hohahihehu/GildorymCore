package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class SnatchArrows implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Catch a deflected ranged attack";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 15) {
			for (Feat feat1 : character.getFeats()) {
				if (feat1 instanceof DeflectArrows) {
					for (Feat feat2 : character.getFeats()) {
						if (feat2 instanceof ImprovedUnarmedStrike) {
							return true;
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
