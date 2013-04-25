package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Acrobatics extends PassiveFeat {
	
	public static final String DESCRIPTION = "+2 bonus on Jump and Tumble checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.JUMP, 2);
		statBonuses.put(Skill.TUMBLE, 2);
		return statBonuses;
	}

}
