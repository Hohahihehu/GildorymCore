package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedSunder extends ActiveFeat {
	
	public static final String DESCRIPTION = "When you strike at an object held or carried by an opponent such as a weapon or shield, you do not provoke an attack of opportunity. YOu also gain a +4 bonus on any attack roll madeto attack an object held or carried by another character.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getStrength() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof PowerAttack) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
