package com.gildorymrp.core.feat;

import com.gildorymrp.core.GildorymCharacter;

public class ImprovedPreciseShot extends PassiveFeat {
	
	public static final String DESCRIPTION = "Your ranged attacks ignore anything less than total concealment.In addition, your ranged weapons automatically strike grappling opponents.";
	
	public Boolean hasPrerequisites(GildorymCharacter character) {
		if (character.getDexterity() >= 19) {
			if (character.getAttackBonus() >= 11) {
				for (Feat feat1 : character.getFeats()) {
					if (feat1 instanceof PointBlankShot) {
						for (Feat feat2 : character.getFeats()) {
							if (feat2 instanceof PreciseShot) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public Boolean isFighterBonusFeat() {
		return true;
	}

}
