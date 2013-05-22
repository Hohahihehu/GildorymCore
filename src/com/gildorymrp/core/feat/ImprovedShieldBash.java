package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedShieldBash implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "When you perform a shield bash, you may still apply the shield's shield bonus to your AC.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		for (Feat feat : character.getFeats()) {
			if (feat instanceof ShieldProficiency) {
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
