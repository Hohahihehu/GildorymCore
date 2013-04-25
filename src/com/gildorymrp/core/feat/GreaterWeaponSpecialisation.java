package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class GreaterWeaponSpecialisation extends PassiveFeat {
	
	public static final String DESCRIPTION = "You gain a +2 bonus on all damage rolls you make using the selected weapon.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		for (Feat feat1 : character.getFeats()) {
			if (feat1 instanceof GreaterWeaponFocus) {
				for (Feat feat2 : character.getFeats()) {
					if (feat2 instanceof WeaponSpecialisation) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
