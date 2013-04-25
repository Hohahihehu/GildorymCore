package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Athletic extends PassiveFeat {
	
public String DESCRIPTION = "+2 bonus on Climb and Swim checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.CLIMB, 2);
		statBonuses.put(Skill.SWIM, 2);
		return statBonuses;
	}

}
