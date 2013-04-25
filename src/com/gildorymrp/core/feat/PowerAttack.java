package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class PowerAttack extends ActiveFeat {
	
	public static final String DESCRIPTION = "On your action, before making attack rolls for a round, you may choose to subtract a number from all melee attack rolls and add the same number to all melee damage rolls. This number may not exceed your base attack bonus. The penalty on attacks and bonus on damage apply until your next turn.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getStrength() >= 13) {
			return true;
		}
		return false;
	}
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
