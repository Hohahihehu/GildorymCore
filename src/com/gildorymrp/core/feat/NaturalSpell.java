package com.gildorymrp.core.feat;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class NaturalSpell implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Cast spells while in wild shape";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getWisdom() >= 13) {
			if (Gildorym.getClassesPlugin().getLevel(character, Class.DRUID) >= 5) { //Ability to use Wild Shape
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

}
