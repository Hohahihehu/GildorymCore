package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Alertness extends PassiveFeat {
	
public String DESCRIPTION = "+2 bonus on Listen and Spot checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.LISTEN, 2);
		statBonuses.put(Skill.SPOT, 2);
		return statBonuses;
	}

}
