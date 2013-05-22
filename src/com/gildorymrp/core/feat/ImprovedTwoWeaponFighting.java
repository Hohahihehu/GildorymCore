package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedTwoWeaponFighting implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "In addition to the single extra attack you get with an off-hand weapon, you get a second attack, albeit with a -5 penalty.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 17) {
			if (character.getAttackBonus() >= 6) {
				for (Feat feat : character.getFeats()) {
					if (feat instanceof TwoWeaponFighting) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
