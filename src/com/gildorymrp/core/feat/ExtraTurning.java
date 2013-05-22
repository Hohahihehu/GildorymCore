package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class ExtraTurning implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "You gain the ability to use each of your turn or rebuke abilities four more times than normal.";
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
