package com.yash.TeaCoffeeVendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.yash.Beverages.BeverageRecipe;
import com.yash.Beverages.Beverages;
import com.yash.customInputScanner.CustomInputScanner;
import com.yash.ingredient.Ingredient;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class TeaCoffeeVendingMachineOrganizer {
	private CustomInputScanner customInputScanner = new CustomInputScanner();
	private Logger logger = Logger.getLogger(TeaCoffeeVendingMachineOrganizer.class.getName());
	private Beverages beverages = new Beverages();

	public TeaCoffeeVendingMachineOrganizer() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");
	}

	public Integer menuOptions() {
		logger.info("\n\n\n:::::::::::::::::::::::=====TEA COFFEE VENDING MACHINE======:::::::::::::::::::::::::");
		logger.info("\t\t\t1.Tea");
		logger.info("\t\t\t2.Black Tea");
		logger.info("\t\t\t3.Coffee");
		logger.info("\t\t\t4.Black Coffee");
		logger.info("\t\t\t5.Refill Container");
		logger.info("\t\t\t6.Check Total Sale");
		logger.info("\t\t\t7.Container Status");
		logger.info("\t\t\t8.Reset Container");
		logger.info("\t\t\t9.Total Report");
		logger.info("\t\t\t0.Exit Tea Coffee Vending machine");
		logger.info("\t\t\tSelect your choice : ");
		return customInputScanner.getInput("menu choice");
	}

	public void menuOperations() {
		Integer choice = 0;
		BeverageRecipe beverageRecepie = new BeverageRecipe();
		Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>();
		do {
			
				switch (choice = menuOptions()) {
				case 1:
 
					try {
						ingredients = beverageRecepie.teaRecipe();
						logger.info("\t\tEnter number of cups :");
						logger.info("\t\t" + beverages.makeDrinkOperation(ingredients,
								customInputScanner.getInput("teaQuantity"), "Tea", 10));
					} catch (UnderflowException e) {
						logger.warning("\t\t" + e.getMessage() + "!!!!");
					}
					break;

				case 2:
					
					try {
						ingredients = beverageRecepie.blackTeaRecipe();
						logger.info("\t\tEnter number of cups :");
						logger.info("\t\t" + beverages.makeDrinkOperation(ingredients,
								customInputScanner.getInput("blackTeaQuantity"), "Black Tea", 5));
					} catch (UnderflowException e) {
						logger.warning("\t\t" + e.getMessage() + "!!!!");
					}
					break;
 
				case 3:
					try {
						ingredients = beverageRecepie.coffeeRecipe();
						logger.info("\t\tEnter number of cups :");
						logger.info("\t\t" + beverages.makeDrinkOperation(ingredients,
								customInputScanner.getInput("coffeeQuantity"), "Coffee", 15));
					} catch (UnderflowException e) {
						logger.warning("\t\t" + e.getMessage() + "!!!!");
					}
					break;
 
				case 4:
					try {
						ingredients = beverageRecepie.blackCoffeeRecipe();
						logger.info("\t\tEnter number of cups :");
						logger.info("\t\t" + beverages.makeDrinkOperation(ingredients,
								customInputScanner.getInput("blackCoffeeQuantity"), "Black Coffee", 10));
					} catch (UnderflowException e) {
						logger.warning("\t\t" + e.getMessage() + "!!!!");
					}
					break;
 
				case 5:
				 	try {
						refillMenu();
						beverages.refillContainers(customInputScanner.getInput("refillQuantity"));
						logger.info("\t\tREFILL DONE......");
					} catch (OverflowException e) {
						logger.warning("\t\t" + e.getMessage() + "!!!!");
					}
					break;
				case 6:
					beverages.totalSale();
					break;
				case 7:
					beverages.containerStatus();
					break;

				case 8:
					beverages.resetAllContainers();
					break;

				case 9:
					beverages.totalReport();
					break;
 
				
				case 0:
					choice = 0;
					break;

				default: 
					break;
				}
			
		} while (choice != 0);

	}

	public void refillMenu() {
		logger.info(":::::::::::::::::::::::::::::::CONTAINER REFILL:::::::::::::::::::::::::::::::::::::::");
		logger.info("\t\t\t1.Tea");
		logger.info("\t\t\t2.Coffee");
		logger.info("\t\t\t3.Sugar");
		logger.info("\t\t\t4.Milk");
		logger.info("\t\t\t5.Water");
		logger.info("\t\t\tEnter choice");
	}

}
