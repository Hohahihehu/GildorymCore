package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class ImprovedTurning implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You turn or rebuke creatures as if you were one level higher than you are in the class that grants you the ability.";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		return true;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

}
