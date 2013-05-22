package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class GreatCleave implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "If you use Cleave to drop an enemy, you may use Cleave again. There is no limit on how many times you can use this.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getStrength() >= 13 && character.getAttackBonus() >= 4) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof Cleave) {
					return true;
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
