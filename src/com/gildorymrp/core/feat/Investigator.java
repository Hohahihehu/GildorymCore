package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Investigator extends PassiveFeat {
	
	public static final String DESCRIPTION = "+2 bonus on Gather Information and Search checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.GATHER_INFORMATION, 2);
		statBonuses.put(Skill.SEARCH, 2);
		return statBonuses;
	}

}
