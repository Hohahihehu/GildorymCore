package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class StunningFist implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Stun opponent with unarmed strike";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 13) {
			if (character.getWisdom() >= 13) {
				if (character.getAttackBonus() >= 8) {
					for (Feat feat : character.getFeats()) {
						if (feat instanceof ImprovedUnarmedStrike) {
							return true;
						}
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
