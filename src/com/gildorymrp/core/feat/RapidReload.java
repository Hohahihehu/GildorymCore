package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class RapidReload implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Reload crossbow more quickly";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof SimpleWeaponProficiency) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isFighterBonusFeat() {
		return true;
	}

}
