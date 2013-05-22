package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.PassiveFeat;
import com.gildorymrp.api.plugin.core.Skill;

public class WeaponSpecialisation implements PassiveFeat {

	@Override
	public String getDescription() {
		return "You gain a +2 bonus on all the damage rolls you make using a selected weapon";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (Gildorym.getClassesPlugin().getClass(character) == Class.FIGHTER && Gildorym.getClassesPlugin().getLevel(character) >= 4) {
			for (Feat feat1 : character.getFeats()) {
				if (feat1 instanceof SimpleWeaponProficiency || feat1 instanceof MartialWeaponProficiency || feat1 instanceof ExoticWeaponProficiency) {
					for (Feat feat2 : character.getFeats()) {
						if (feat2 instanceof WeaponFocus) {
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

	@Override
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		return statBonuses;
	}

}
