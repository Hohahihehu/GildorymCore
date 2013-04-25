package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedShieldBash extends ActiveFeat {
	
	public static final String DESCRIPTION = "When you perform a shield bash, you may still apply the shield's shield bonus to your AC.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof ShieldProficiency) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
