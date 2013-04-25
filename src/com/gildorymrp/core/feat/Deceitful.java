package com.gildorymrp.core.feat;

import java.util.HashMap;
import java.util.Map;

import com.gildorymrp.core.Skill;

public class Deceitful extends PassiveFeat {
	
	public static final String DESCRIPTION = "+2 bonus on Disguise and Forgery checks";
	
	public Map<Skill, Integer> getStatBonuses() {
		Map<Skill, Integer> statBonuses = new HashMap<Skill, Integer>();
		statBonuses.put(Skill.DISGUISE, 2);
		statBonuses.put(Skill.FORGERY, 2);
		return statBonuses;
	}

}
