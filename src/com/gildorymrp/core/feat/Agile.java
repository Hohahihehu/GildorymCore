package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Agile extends PassiveFeat {
	
	public String DESCRIPTION = "+2 bonus on Balance and Escape Artist checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.BALANCE, 2);
		statBonuses.put(Skill.ESCAPE_ARTIST, 2);
		return statBonuses;
	}

}
