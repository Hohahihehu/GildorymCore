package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class WidenSpell implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "WIP feat";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

}
