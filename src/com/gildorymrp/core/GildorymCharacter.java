package com.gildorymrp.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gildorymrp.core.feat.Feat;

public class GildorymCharacter implements Serializable {

	//Metadata and stuff
	private static final long serialVersionUID = 7975882369108014391L;
	//The player the character is associated with
	private String ign;
	//The character and their IC details. Character card stuff.
	private String name;
	private Gender gender;
	private Integer age;
	private Race race;
	private String description;
	//World data to save/restore upon switching character
	private Location location;
	private Set<ItemStack> inventoryContents;
	//Stats and other character data
	private Integer health;
	private Integer maxHealth;
	private Integer strength;
	private Integer dexterity;
	private Integer constitution;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	private Alignment alignment;
	private GildorymClass gildorymClass;
	private GildorymProfession gildorymProfession;
	private Integer skillPoints;
	private Integer money;
	private Map<Skill, Integer> skills;
	private Set<Feat> feats;
	private Integer maxSkills;
	private Integer attackBonus;
	
	//Getters and setters
	
	/**
	 * Gets the name of the player who owns this character.
	 * @return the ign
	 */
	public String getIgn() {
		return ign;
	}
	
	/**
	 * Sets the ign of the player playing this character.
	 * @param ign the ign to set
	 */
	public void setIgn(String ign) {
		this.ign = ign;
	}

	/**
	* Gets the player playing as this character.
	* @return the player or null if the player is offline
	*/
	public Player getPlayer() {
		return Bukkit.getServer().getPlayer(ign);
	}
	
	/**
	 * Sets the player playing this character.
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.ign = Bukkit.getServer().getPlayer(ign).getName();
	}
	
	/**
	* Gets the name of this character.
	* @return the name
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Sets the name of this character.
	* @param name the name to set
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Gets the gender of this character.
	* @return the gender
	*/
	public Gender getGender() {
		return gender;
	}

	/**
	* Gets the gender of this character.
	* @param gender the gender to set
	*/
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	* Gets the age of this character.
	* @return the age
	*/
	public Integer getAge() {
		return age;
	}
	
	/**
	* Sets the age of this character.
	* @param age the age to set
	*/
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	* Gets the race of this character.
	* @return the race
	*/
	public Race getRace() {
		return race;
	}

	/**
	* Sets the race of this character.
	* @param race the race to set
	*/
	public void setRace(Race race) {
		switch (this.race) {
			case DWARF: this.constitution -= 2;
				this.charisma += 2;
				break;
			case ELF: this.dexterity -= 2;
				this.constitution += 2;
				break;
			case GNOME: this.constitution -= 2;
				this.strength += 2;
				break;
			case HALFORC: this.strength -= 2;
				this.intelligence += 2;
				this.charisma += 2;
				break;
			case HALFLING: this.dexterity -= 2;
				this.strength += 2;
				break;
			default:
				break;
		}
		
		this.race = race;
		
		switch (this.race) {
			case DWARF: this.constitution += 2;
				this.charisma -= 2;
				break;
			case ELF: this.dexterity += 2;
				this.constitution -= 2;
				break;
			case GNOME: this.constitution += 2;
				this.strength -= 2;
				break;
			case HALFORC: this.strength += 2;
				this.intelligence -= 2;
				this.charisma -= 2;
				break;
			case HALFLING: this.dexterity += 2;
				this.strength -= 2;
				break;
			default:
				break;
		}
	}

	/**
	* Gets the description of this character.
	* @return the description
	*/
	public String getDescription() {
		return description;
	}
	
	/**
	* Sets the desciption of this character.
	* @param description the description to set
	*/
	public void setDescription(String description) {
		this.description = description + " ";
	}
	
	/**
	* Adds information to the descripion of this character.
	* @param info the information to add to the description
	*/
	public void addDescription(String info) {
		this.description += info + " ";
	}
	
	/**
	* Gets the location of this character.
	* @return the location
	*/
	public Location getLocation() {
		return location;
	}

	/**
	* Sets the location of this character.
	* @param location the location to set
	*/
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the inventory contents of this character.
	 * @return the inventoryContents
	 */
	public Set<ItemStack> getInventoryContents() {
		return inventoryContents;
	}

	/**
	 * Sets the inventory contents of this character.
	 * @param inventoryContents the inventoryContents to set
	 */
	public void setInventoryContents(Set<ItemStack> inventoryContents) {
		this.inventoryContents = inventoryContents;
	}

	/**
	* Gets the health of this character.
	* @return the health
	*/
	public Integer getHealth() {
		return health;
	}
	
	/**
	* Sets the health of this character.
	* @param health the health to set
	*/
	public void setHealth(Integer health) {
		this.health = health;
	}
	
	/**
	* Gets the maximum health of this character.
	* @return the maxHealth
	*/
	public Integer getMaxHealth() {
		return maxHealth;
	}
	
	/**
	* Sets the maximum health of this character.
	* @param maxHealth the maxHealth to set
	*/
	public void setMaxHealth(Integer maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	* Gets the strength of this character.
	* @return the strength
	*/
	public Integer getStrength() {
		return strength;
	}
	
	/**
	* Sets the strength of this character.
	* @param strength the strength to set
	*/
	public void setStrength(Integer strength) {
		this.strength = strength;
	}
	
	/**
	* Gets the dexterity of this character.
	* @return the dexterity
	*/
	public Integer getDexterity() {
		return dexterity;
	}
	
	/**
	* Sets the dexterity of this character.
	* @param dexterity the dexterity to set
	*/
	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}
	
	/**
	* Gets the constitution of this character.
	* @return the constitution
	*/
	public Integer getConstitution() {
		return constitution;
	}
	
	/**
	* Sets the constitution of this character.
	* @param constitution the constitution to set
	*/
	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}
	
	/**
	* Gets the intelligence of this character.
	* @return the intelligence
	*/
	public Integer getIntelligence() {
		return intelligence;
	}
	
	/**
	* Sets the intelligence of this character.
	* @param intelligence the intelligence to set
	*/
	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}
	
	/**
	* Gets the wisdom of this character.
	* @return the wisdom
	*/
	public Integer getWisdom() {
		return wisdom;
	}
	
	/**
	* Sets the wisdom of this character.
	* @param wisdom the wisdom to set
	*/
	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}
	
	/**
	* Gets the charisma of this character.
	* @return the charisma
	*/
	public Integer getCharisma() {
		return charisma;
	}
	
	/**
	* Sets the charisma of this character.
	* @param charisma the charisma to set
	*/
	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}
	
	/**
	* Gets the alignment of this character.
	* @return the alignment
	*/
	public Alignment getAlignment() {
		return alignment;
	}
	
	/**
	* Sets the alignment of this character.
	* @param alignment the alignment to set
	*/
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
	/**
	* Gets the class of this character.
	* @return the character class
	*/
	public GildorymClass getGildorymClass() {
		return gildorymClass;
	}
	
	/**
	* Sets the class of this character.
	* @param gildorymClass the class to set
	*/
	public void setGildorymClass(GildorymClass gildorymClass) {
		this.gildorymClass = gildorymClass;
	}
	
	/**
	* Gets the profession of this character.
	* @return the profession
	*/
	public GildorymProfession getGildorymProfession() {
		return gildorymProfession;
	}
	
	/**
	* Sets the profession of this character.
	* @param gildorymProfession the profession to set
	*/
	public void setGildorymProfession(GildorymProfession gildorymProfession) {
		this.gildorymProfession = gildorymProfession;
	}
	
	/**
	* Gets the amount of skill points of this character.
	* @return the skillPoints
	*/
	public Integer getSkillPoints() {
		return skillPoints;
	}
	
	/**
	* Sets the amount of skill points of this character.
	* @param skillPoints the skillPoints to set
	*/
	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}
	
	/**
	* Gets the amount of money owned by this character.
	* @return the money
	*/
	public Integer getMoney() {
		return money;
	}
	
	/**
	* Sets the amount of money owned by this character.
	* @param money the money to set
	*/
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	/**
	* Gets the skills of this character.
	* @return the skills
	*/
	public Map<Skill, Integer> getSkills() {
		return skills;
	}
	
	/**
	* Adds an amount of skill points to a particular skill and returns whether successful.
	* @param skill the skill to assign points to
	* @param amount the amount of points to assign
	* @return whether successful
	*/
	public Boolean addSkillPoint(Skill skill, Integer amount) {
		if (skill == null || amount == null) {
			Bukkit.getLogger().severe("Attempting to add a null amount or skill point is a bad idea!");
			return false;
		}
	
		if (this.skillPoints - amount < 0) {
			return false;
		}
	
		if (amount < 1 || amount > 50) {
			return false;
		}
	
		Integer currentSkillPoints;
	
		if (this.skills.get(skill) != null) {
			currentSkillPoints = this.skills.get(skill);
		} else {
			currentSkillPoints = 0;
		}
	
		Integer newSkillPoints = currentSkillPoints + amount;
	
		if (this.gildorymClass.isClassSkill(skill)) {
			if (newSkillPoints > this.gildorymClass.getMaxClassSkill(this.gildorymClass.getLevel())) {
				return false;
			}
		} else {
			if (newSkillPoints > this.gildorymClass.getMaxClassSkill(this.gildorymClass.getLevel()) / 2) {
				return false;
			}
		}
	
		Integer total = 0;
		for (Integer skillLevel : skills.values()) {
			total += skillLevel;
		}
	
		total -= currentSkillPoints;
		total += newSkillPoints;
	
		if (total > this.gildorymClass.maxSkills(this.gildorymClass.getLevel(), this.getModifier(this.intelligence), (this.race == Race.HUMAN))) {
			return false;
		}
	
		this.skillPoints -= amount;
		this.skills.put(skill, newSkillPoints);
		return true;
	}
	
	/**
	* Gets the maximum amount of skills this character may have.
	* @return the maxSkills
	*/
	public Integer getMaxSkills() {
		return maxSkills;
	}
	
	/**
	* Sets the maximum amount of skills this character may have.
	* @param maxSkills the maxSkills to set
	*/
	public void setMaxSkills(Integer maxSkills) {
		this.maxSkills = maxSkills;
	}
	
	/**
	* Gets the feats of this character.
	* @return the feats
	*/
	public Set<Feat> getFeats() {
		return feats;
	}
	
	/**
	* Gets the attack bonus of this character.
	* @return the attackBonus
	*/
	public Integer getAttackBonus() {
		return attackBonus;
	}
	
	/**
	* Sets the attack bonus of this character.
	* @param attackBonus the attackBonus to set
	*/
	public void setAttackBonus(Integer attackBonus) {
		this.attackBonus = attackBonus;
	}
	
	//Other methods
	
	/**
	* Gets the modifier on a particular stat.
	* @param stat the stat (must not be less than one)
	* @return the modifier
	*/
	public Integer getModifier(Integer stat) {
		return (int) Math.floor(stat / 2) - 5;
	}

	/**
	* Recursively rolls the stats of this character.
	* @param countdown the amount of times to roll stats before settling
	*/
	public void rollStats(Integer countdown) {
		if (countdown == 0) {
			return;
		}
	
		this.charisma = this.rollStatsMath();
		this.constitution = this.rollStatsMath();
		this.dexterity = this.rollStatsMath();
		this.intelligence = this.rollStatsMath();
		this.strength = this.rollStatsMath();
		this.wisdom = this.rollStatsMath();
		Integer hold = 0;
		hold += this.getModifier(this.charisma) + this.getModifier(this.constitution) + this.getModifier(this.dexterity) + this.getModifier(this.intelligence) + this.getModifier(this.strength) + this.getModifier(this.wisdom);
		
		if (hold < 1) {
			this.rollStats(countdown - 1);
		}
	}

	/**
	* Does the math to get the value of a stat.
	* @return the stat
	*/
	private Integer rollStatsMath() {
		List<Integer> rolls = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i <= 3; ++i) {
			rolls.add(random.nextInt(6) + 1);
		}
		Collections.sort(rolls);
		return rolls.get(0) + rolls.get(1) + rolls.get(2);
	}

}
