package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class BlindFight implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Allows you to reroll once if you miss due to blindness";
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
