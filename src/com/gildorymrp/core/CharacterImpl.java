package com.gildorymrp.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.classes.GildorymClassesPlugin;
import com.gildorymrp.api.plugin.classes.Class;
import com.gildorymrp.api.plugin.core.Alignment;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Feat;
import com.gildorymrp.api.plugin.core.Gender;
import com.gildorymrp.api.plugin.core.Race;
import com.gildorymrp.api.plugin.core.Skill;

public class CharacterImpl implements Character, ConfigurationSerializable {

	//The player the character is associated with
	private String ign;
	//The character and their IC details. Character card stuff.
	private String name;
	private Gender gender;
	private int age;
	private Race race;
	private String description;
	private boolean dead;
	//World data to save/restore upon switching character
	private Location location;
	private ItemStack[] inventoryContents;
	//Stats and other character data
	private int health;
	private int maxHealth;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private Alignment alignment;
	private int skillPoints;
	private Map<Skill, Integer> skills;
	private Set<Feat> feats;
	private int maxSkills;
	private int attackBonus;
	
	public CharacterImpl(Player player) {
		GildorymClassesPlugin classesPlugin = Gildorym.getClassesPlugin();
		this.ign = player.getName();
		this.name = "Unknown";
		this.gender = Gender.UNKNOWN;
		this.age = 0;
		this.race = Race.UNKNOWN;
		this.description = player.getName() + "'s character";
		this.dead = false;
		this.location = Bukkit.getServer().getWorlds().get(0).getSpawnLocation();
		this.inventoryContents = new ItemStack[36];
		this.health = classesPlugin.getHpBonus(classesPlugin.getClass(this)) * classesPlugin.getLevel(this);
		this.maxHealth = classesPlugin.getHpBonus(classesPlugin.getClass(this)) * classesPlugin.getLevel(this);
		this.rollStats(30);
		this.alignment = Alignment.TRUE_NEUTRAL;
		this.skillPoints = classesPlugin.maxSkills(this);
		this.skills = new HashMap<Skill, Integer>();
		this.feats = new HashSet<Feat>();
		this.maxSkills = this.skillPoints;
		this.attackBonus = classesPlugin.getAttackBonus(classesPlugin.getClass(this), classesPlugin.getLevel(this));
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public Player getPlayer() {
		return (Player) Bukkit.getOfflinePlayer(ign);
	}
	
	@Override
	public void setPlayer(Player player) {
		this.ign = player.getName();
	}
	
	@Override
	public Gender getGender() {
		return gender;
	}
	
	@Override
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public Race getRace() {
		return race;
	}
	
	@Override
	public void setRace(Race race) {
		switch (this.race) {
			case DROW: this.dexterity -= 2;
				this.intelligence -= 2;
				this.constitution += 2;
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
			case DROW: this.dexterity += 2;
				this.intelligence += 2;
				this.constitution -=2;
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
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description + " ";
	}
	
	@Override
	public void addDescription(String info) {
		this.description += info + " ";
	}
	
	@Override
	public Location getLocation() {
		return location;
	}
	
	@Override
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
	public ItemStack[] getInventoryContents() {
		return inventoryContents;
	}

	@Override
	public void setInventoryContents(ItemStack[] inventoryContents) {
		this.inventoryContents = inventoryContents;
	}

	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public int getMaxHealth() {
		return maxHealth;
	}
	
	@Override
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	@Override
	public int getStrength() {
		return strength;
	}
	
	@Override
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public int getDexterity() {
		return dexterity;
	}
	
	@Override
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	@Override
	public int getConstitution() {
		return constitution;
	}
	
	@Override
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	
	@Override
	public int getIntelligence() {
		return intelligence;
	}
	
	@Override
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	@Override
	public int getWisdom() {
		return wisdom;
	}
	
	@Override
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	
	@Override
	public int getCharisma() {
		return charisma;
	}
	
	@Override
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	
	@Override
	public Alignment getAlignment() {
		return alignment;
	}
	
	@Override
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	
	@Override
	public int getSkillPoints() {
		return skillPoints;
	}
	
	@Override
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}
	
	@Override
	public Map<Skill, Integer> getSkills() {
		return skills;
	}
	
	@Override
	public boolean addSkillPoints(Skill skill, int amount) {
		if (skill == null) {
			Bukkit.getLogger().severe("Attempting to add a null skill is a bad idea!");
			return false;
		}
	
		if (this.getSkillPoints() - amount < 0) {
			return false;
		}
	
		if (amount < 1 || amount > 50) {
			return false;
		}
	
		int currentSkillPoints;
	
		if (this.getSkills().get(skill) != null) {
			currentSkillPoints = this.getSkills().get(skill);
		} else {
			currentSkillPoints = 0;
		}
	
		int newSkillPoints = currentSkillPoints + amount;
		GildorymClassesPlugin classesPlugin = Gildorym.getClassesPlugin();
		Class clazz = classesPlugin.getClass(this);
	
		if (classesPlugin.isClassSkill(clazz, skill)) {
			if (newSkillPoints > classesPlugin.getMaxClassSkill(classesPlugin.getLevel(this))) {
				return false;
			}
		} else {
			if (newSkillPoints > classesPlugin.getMaxClassSkill(classesPlugin.getLevel(this)) / 2) {
				return false;
			}
		}
	
		int total = 0;
		for (int skillLevel : this.getSkills().values()) {
			total += skillLevel;
		}
	
		total -= currentSkillPoints;
		total += newSkillPoints;
	
		if (total > classesPlugin.maxSkills(this)) {
			return false;
		}
	
		this.setSkillPoints(this.getSkillPoints() - amount);
		this.getSkills().put(skill, newSkillPoints);
		return true;
	}
	
	@Override
	public int getMaxSkills() {
		return maxSkills;
	}
	
	@Override
	public void setMaxSkills(int maxSkills) {
		this.maxSkills = maxSkills;
	}
	
	@Override
	public Set<Feat> getFeats() {
		return feats;
	}
	
	@Override
	public int getAttackBonus() {
		return attackBonus;
	}
	
	@Override
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}
	
	//Other methods
	
	@Override
	public int getModifier(int stat) {
		return (int) Math.floor(stat / 2) - 5;
	}

	@Override
	public void rollStats(int countdown) {
		if (countdown == 0) {
			return;
		}
	
		this.setCharisma(this.rollStatsMath());
		this.setConstitution(this.rollStatsMath());
		this.setDexterity(this.rollStatsMath());
		this.setIntelligence(this.rollStatsMath());
		this.setStrength(this.rollStatsMath());
		this.setWisdom(this.rollStatsMath());
		int hold = 0;
		hold += this.getModifier(this.getCharisma()) + this.getModifier(this.getConstitution()) + this.getModifier(this.getDexterity()) + this.getModifier(this.getIntelligence()) + this.getModifier(this.getStrength()) + this.getModifier(this.getWisdom());
		if (hold < 1) {
			this.rollStats(countdown - 1);
		}
	}
	
	private int rollStatsMath() {
		List<Integer> rolls = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i <= 3; ++i) {
			rolls.add(random.nextInt(6) + 1);
		}
		Collections.sort(rolls);
		return rolls.get(0) + rolls.get(1) + rolls.get(2);
	}

	@Override
	public boolean isDead() {
		return dead;
	}

	@Override
	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> serialized = new HashMap<String, Object>();
		serialized.put("ign", ign);
		serialized.put("name", name);
		serialized.put("gender", gender);
		serialized.put("age", age);
		serialized.put("race", race);
		serialized.put("description", description);
		serialized.put("dead", dead);
		serialized.put("location", location);
		serialized.put("inventory-contents", inventoryContents);
		serialized.put("health", health);
		serialized.put("max-health", maxHealth);
		serialized.put("strength", strength);
		serialized.put("dexterity", dexterity);
		serialized.put("constitution", constitution);
		serialized.put("intelligence", intelligence);
		serialized.put("wisdom", wisdom);
		serialized.put("charisma", charisma);
		serialized.put("alignment", alignment);
		serialized.put("skill-points", skillPoints);
		serialized.put("skills", skills);
		serialized.put("feats", feats);
		serialized.put("max-skills", maxSkills);
		serialized.put("attack-bonus", attackBonus);
		return serialized;
	}
	
	@SuppressWarnings("unchecked")
	public static CharacterImpl deserialize(Map<String, Object> serialized) {
		CharacterImpl character = new CharacterImpl((Player) Bukkit.getOfflinePlayer((String) serialized.get("ign")));
		character.name = (String) serialized.get("name");
		character.gender = (Gender) serialized.get("gender");
		character.age = (Integer) serialized.get("age");
		character.race = (Race) serialized.get("race");
		character.description = (String) serialized.get("description");
		character.dead = (Boolean) serialized.get("dead");
		character.location = (Location) serialized.get("location");
		character.inventoryContents = (ItemStack[]) serialized.get("inventory-contents");
		character.health = (Integer) serialized.get("health");
		character.maxHealth = (Integer) serialized.get("max-health");
		character.strength = (Integer) serialized.get("strength");
		character.dexterity = (Integer) serialized.get("dexterity");
		character.constitution = (Integer) serialized.get("constitution");
		character.intelligence = (Integer) serialized.get("intelligence");
		character.wisdom = (Integer) serialized.get("wisdom");
		character.charisma = (Integer) serialized.get("charisma");
		character.alignment = (Alignment) serialized.get("alignment");
		character.skillPoints = (Integer) serialized.get("skill-points");
		character.skills = (Map<Skill, Integer>) serialized.get("skills");
		character.feats = (Set<Feat>) serialized.get("feats");
		character.maxSkills = (Integer) serialized.get("max-skills");
		character.attackBonus = (Integer) serialized.get("attack-bonus");
		return character;
	}

}
