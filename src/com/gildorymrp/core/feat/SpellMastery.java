package com.gildorymrp.core.feat;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;

public class SpellMastery implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Can prepare some spells without spellbook";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (Gildorym.getClassesPlugin().getLevel(character, Class.WIZARD) >= 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return false;
	}

}
