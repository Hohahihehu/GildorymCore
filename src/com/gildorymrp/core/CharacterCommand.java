package com.gildorymrp.core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gildorymrp.api.Gildorym;
import com.gildorymrp.api.plugin.classes.GildorymClassesPlugin;
import com.gildorymrp.api.plugin.core.Alignment;
import com.gildorymrp.api.plugin.core.Character;
import com.gildorymrp.api.plugin.core.Gender;
import com.gildorymrp.api.plugin.core.Race;
import com.gildorymrp.api.plugin.deities.GildorymDeitiesPlugin;
import com.gildorymrp.api.plugin.professions.GildorymProfessionsPlugin;

public class CharacterCommand implements CommandExecutor {
	
	private GildorymCore plugin;
	
	public CharacterCommand(GildorymCore plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("new")) {
				plugin.setActiveCharacter((Player) sender, new CharacterImpl((Player) sender));
				sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Created a new character. Make sure to set up your character information!");
			} else if (args[0].equalsIgnoreCase("card")) {
				Player player = (Player) sender;
				if (args.length >= 2) {
					if (plugin.getServer().getPlayer(args[1]) != null) {
						player = plugin.getServer().getPlayer(args[1]);
					}
				}
				Character character = plugin.getActiveCharacter(player);
				GildorymClassesPlugin classesPlugin = Gildorym.getClassesPlugin();
				GildorymProfessionsPlugin professionsPlugin = Gildorym.getProfessionsPlugin();
				GildorymDeitiesPlugin deitiesPlugin = Gildorym.getDeitiesPlugin();
				sender.sendMessage(GildorymCore.PREFIX + ChatColor.YELLOW + character.getName() + "'s character card");
				sender.sendMessage(ChatColor.DARK_RED + "Age: " + ChatColor.GOLD +  character.getAge());
				sender.sendMessage(ChatColor.DARK_RED + "Gender: " + ChatColor.GOLD + character.getGender().toString());
				sender.sendMessage(ChatColor.DARK_RED + "Race: " + ChatColor.GOLD + character.getRace().toString());
				if (classesPlugin != null) {
					sender.sendMessage(ChatColor.DARK_RED + "Class: " + ChatColor.GOLD + "Lv" + classesPlugin.getLevel(character) + " " + classesPlugin.getClass(character).toString());
				}
				if (professionsPlugin != null) {
					sender.sendMessage(ChatColor.DARK_RED + "Profession: " + ChatColor.GOLD + professionsPlugin.getProfession(character));
				}
				sender.sendMessage(ChatColor.DARK_RED + "Alignment: " + ChatColor.GOLD + character.getAlignment().toString());
				if (deitiesPlugin != null) {
					sender.sendMessage(ChatColor.DARK_RED + "Preferred deity: " + ChatColor.GOLD + deitiesPlugin.getPreferredDeity(character).getName());
				}
				sender.sendMessage(ChatColor.DARK_RED + "Description: " + ChatColor.GOLD + character.getDescription());
			} else if (args[0].equalsIgnoreCase("switch")) {
				if (args.length >= 2) {
					boolean found = false;
					for (Character character : plugin.getCharacters((Player) sender)) {
						if (character.getName().toUpperCase().startsWith(args[1].toUpperCase())) {
							plugin.setActiveCharacter((Player) sender, character);
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Switched character to " + character.getName());
							found = true;
							break;
						}
					}
					if (!found) {
						sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "You do not have a character by that name");
					}
				} else {
					sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " switch [character name]");
				}
			} else if (args[0].equalsIgnoreCase("set")) {
				if (args.length >= 2) {
					Character character = plugin.getActiveCharacter((Player) sender);
					if (args[1].equalsIgnoreCase("name")) {
						if (args.length >= 3) {
							String name = "";
							for (int i = 2; i <= args.length - 1; i++) {
								name += args[i] + " ";
							}
							character.setName(name);
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's name to " + name);
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set name [name]");
						}
					} else if (args[1].equalsIgnoreCase("age")) {
						if (args.length >= 3) {
							try {
								character.setAge(Integer.parseInt(args[3]));
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's age to " + args[3]);
							} catch (NumberFormatException exception) {
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Age must be an integer");
							}
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set age [age]");
						}
					} else if (args[1].equalsIgnoreCase("gender")) {
						if (args.length >= 3) {
							try {
								character.setGender(Gender.valueOf(args[2].toUpperCase()));
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's gender to " + args[2].toUpperCase());
							} catch (IllegalArgumentException exception) {
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Gender must be either male or female");
							}
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set gender [gender]");
						}
					} else if (args[1].equalsIgnoreCase("race")) {
						if (args.length >= 3) {
							try {
								character.setRace(Race.valueOf(args[2].toUpperCase()));
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's race to " + args[2].toUpperCase());
							} catch (IllegalArgumentException exception) {
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Race must be one of the following: ");
								for (Race race : Race.values()) {
									sender.sendMessage(ChatColor.RED + race.toString());
								}
							}
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set race [race]");
						}
					} else if (args[1].equalsIgnoreCase("alignment")) {
						if (args.length >= 3) {
							try {
								character.setAlignment(Alignment.valueOf(args[2].toUpperCase()));
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's alignment to " + args[2].toUpperCase());
							} catch (IllegalArgumentException exception) {
								sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Alignment must be one of the following: ");
								for (Alignment alignment : Alignment.values()) {
									sender.sendMessage(ChatColor.RED + alignment.toString());
								}
							}
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set alignment [alignment]");
						}
					} else if (args[1].equalsIgnoreCase("description")) {
						if (args.length >= 3) {
							String description = "";
							for (int i = 2; i <= args.length - 1; i++) {
								description += args[i] + " ";
							}
							character.setDescription(description);
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Set character's description to " + description);
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Extend it by using /character extenddescription [info]");
						} else {
							sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set description [description]");
						}
					} else {
						sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set [name|age|gender|race|alignment|description]");
					}
				} else {
					sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " set [name|age|gender|race|alignment|description]");
				}
			} else if (args[0].equalsIgnoreCase("extenddescription")) {
				Character character = plugin.getActiveCharacter((Player) sender);
				if (args.length >= 2) {
					String description = "";
					for (int i = 1; i <= args.length; i++) {
						description += args[i] + " ";
					}
					character.addDescription(description);
					sender.sendMessage(GildorymCore.PREFIX + ChatColor.GREEN + "Description extended");
				} else {
					sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " extenddescription [info]");
				}
			} else {
				sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " [new|switch|card|set|extenddescription]");
			}
		} else {
			sender.sendMessage(GildorymCore.PREFIX + ChatColor.RED + "Usage: /" + label + " [new|switch|card|set|extenddescription]");
		}
		return true;
	}

}
