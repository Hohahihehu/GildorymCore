package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class AnimalAffinity extends PassiveFeat {
	
public String DESCRIPTION = "+2 bonus on Handle Animal and Ride checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.HANDLE_ANIMAL, 2);
		statBonuses.put(Skill.RIDE, 2);
		return statBonuses;
	}

}
