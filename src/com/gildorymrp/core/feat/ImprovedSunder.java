package com.gildorymrp.core.feat;

import com.gildorymrp.api.plugin.core.ActiveFeat;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;

public class ImprovedSunder implements ActiveFeat {
	
	@Override
	public String getDescription() {
		return "When you strike at an object held or carried by an opponent such as a weapon or shield, you do not provoke an attack of opportunity. YOu also gain a +4 bonus on any attack roll madeto attack an object held or carried by another character.";
	}
	
	@Override
	public boolean hasPrerequisites(Character character) {
		if (character.getStrength() >= 13) {
			for (Feat feat : character.getFeats()) {
				if (feat instanceof PowerAttack) {
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
