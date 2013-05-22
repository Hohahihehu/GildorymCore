package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class WhirlwindAttack implements ActiveFeat {

	@Override
	public String getDescription() {
		return "One melee attack against every opponent with reach";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getDexterity() >= 13) {
			if (character.getAttackBonus() >= 4) {
				for (Feat feat1 : character.getFeats()) {
					if (feat1 instanceof CombatExpertise) {
						for (Feat feat2 : character.getFeats()) {
							if (feat2 instanceof Dodge) {
								for (Feat feat3 : character.getFeats()) {
									if (feat3 instanceof Mobility) {
										for (Feat feat4 : character.getFeats()) {
											if (feat4 instanceof SpringAttack) {
												return true;
											}
										}
									}
								}
							}
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
