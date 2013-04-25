package com.gildorymrp.core.feat;

public class ImprovedUnarmedStrike extends PassiveFeat {
	
	public static final String DESCRIPTION = "You are considered to be armed even when unarmed, that is you do not provoke attacks of opportunity from armed opponents that you attack while unarmed.";
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
