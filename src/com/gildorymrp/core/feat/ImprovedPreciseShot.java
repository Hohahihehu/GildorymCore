package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class ImprovedPreciseShot implements PassiveFeat {

	@Override
	public String getDescription() {
		return "Your ranged attacks ignore anything less than total concealment.In addition, your ranged weapons automatically strike grappling opponents.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
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
	
	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		return statBonuses;
	}

}
