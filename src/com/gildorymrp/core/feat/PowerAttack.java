package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class PowerAttack implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "On your action, before making attack rolls for a round, you may choose to subtract a number from all melee attack rolls and add the same number to all melee damage rolls. This number may not exceed your base attack bonus. The penalty on attacks and bonus on damage apply until your next turn.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getStrength() >= 13) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
