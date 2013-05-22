package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class PointBlankShot implements ActiveFeat {

	@Override
	public String getDescription() {
		return "You get a +1 bonus on attack and damage rolls with ranged weapons at ranges up to 30 feet";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		return true;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
