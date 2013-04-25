package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Diligent extends PassiveFeat {
	
	public static final String DESCRIPTION = "+2 bonus on Appraise and Decipher script checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.APPRAISE, 2);
		statBonuses.put(Skill.DECIPHER_SCRIPT, 2);
		return statBonuses;
	}

}
