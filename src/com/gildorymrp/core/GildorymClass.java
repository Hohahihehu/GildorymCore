package com.gildorymrp.core;

import java.util.Map;

public class GildorymClass {

	private String name;
	private Integer hpBonus;
	private Map<Integer, Skill> skills;
	private Integer level;
	private Integer maxLevel;
	public Integer classSkillModifier;

	public GildorymClass() {
		this.level = 1;
		this.hpBonus = 4;
		this.classSkillModifier = 2;
	}

	/**
	* @return the name
	*/
	public String getName() {
		return name;
	}

	/**
	* @param name the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* @return the hpBonus
	*/
	public Integer getHpBonus() {
		return hpBonus;
	}

	/**
	* @param hpBonus the hpBonus to set
	*/
	public void setHpBonus(Integer hpBonus) {
		this.hpBonus = hpBonus;
	}

	/**
	* @return the skills
	*/
	public Map<Integer, Skill> getSkills() {
		return skills;
	}

	/**
	* @return the level
	*/
	public Integer getLevel() {
		return level;
	}

	/**
	* @param level the level to set
	*/
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	* @return the maxLevel
	*/
	public Integer getMaxLevel() {
		return maxLevel;
	}

	/**
	* @param maxLevel the maxLevel to set
	*/
	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	/**
	* @param level the level
	* @return the good save bonus
	*/
	public Integer getBaseSaveBonusGood(Integer level) {
		return 2 + (int) Math.floor(level / 2);
	}

	/**
	* @param level the level
	* @return the poor save bonus
	*/
	public Integer getBaseSaveBonusPoor(Integer level) {
		return (int) Math.floor(level / 3);
	}

	/**
	* @param level the level
	* @return the good attack bonus
	*/
	public Integer getBaseAttackBonusGood(Integer level) {
		return level;
	}

	/**
	* @param level the level
	* @return the average attack bonus
	*/
	public Integer getBaseAttackBonusAverage(Integer level) {
		return (int) Math.floor(level * 0.75);
	}

	/**
	* @param level the level
	* @return the poor attack bonus
	*/
	public Integer getBaseAttackBonusPoor(Integer level) {
		return (int) Math.floor(level * 0.5);
	}

	/**
	* @param level the level
	* @return the max class skill
	*/
	public Integer getMaxClassSkill(Integer level) {
		return 3 + level;
	}

	/**
	* @param level the level
	* @return the max cross class skill
	*/
	public Integer getMaxCrossClassSkill(Integer level) {
		return (int) Math.floor(this.getMaxClassSkill(level) / 2);
	}

	public Integer getAttackBonus() {
		return this.getBaseAttackBonusPoor(this.getLevel());
	}

	public Integer getFortititudeSave() {
		return this.getBaseSaveBonusPoor(this.getLevel());
	}

	public Integer getReflexSave() {
		return this.getBaseSaveBonusPoor(this.getLevel());
	}

	public Integer getWillSave() {
		return this.getBaseSaveBonusPoor(this.getLevel());
	}

	public Integer maxSkills(Integer level, Integer intelligenceModifier, Boolean isHuman) {
		Integer maxSkills = (classSkillModifier + intelligenceModifier) * 4 + (level - 1) * (classSkillModifier + intelligenceModifier);
		if (isHuman) {
			maxSkills += 4;
			maxSkills += (level - 1);
		}
		return maxSkills;
	}

	public Boolean isClassSkill(Skill skill) {
		return false;
	}

}
