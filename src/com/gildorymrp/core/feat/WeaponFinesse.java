package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class WeaponFinesse implements ActiveFeat {

	@Override
	public String getDescription() {
		return "Use Dex modifier instead of Str modifier on attack rolls with light melee weapons";
	}

	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getAttackBonus() >= 1) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof SimpleWeaponProficiency || feat instanceof MartialWeaponProficiency || feat instanceof ExoticWeaponProficiency) {
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
