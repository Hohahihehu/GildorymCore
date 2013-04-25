package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class DeftHands extends PassiveFeat {
	
	public static final String DESCRIPTION = "+2 bonus on Sleight of hand and Use rope checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.SLEIGHT_OF_HAND, 2);
		statBonuses.put(Skill.USE_ROPE, 2);
		return statBonuses;
	}

}
