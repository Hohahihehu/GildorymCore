package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class SpringAttack implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Move before and after melee attack";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getAttackBonus() >= 4) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof Mobility) {
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
