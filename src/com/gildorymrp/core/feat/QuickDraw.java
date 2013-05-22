package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class QuickDraw implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Draw weapon as free action";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getAttackBonus() >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
