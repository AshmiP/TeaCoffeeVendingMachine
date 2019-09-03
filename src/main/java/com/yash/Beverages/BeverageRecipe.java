package com.yash.Beverages;

import java.util.HashMap;
import java.util.Map;

import com.yash.ingredient.Ingredient;

public class BeverageRecipe {

	public Map<String, Ingredient> teaRecipe() {

		Map<String, Ingredient> teaIngredients = new HashMap<String, Ingredient>();
		teaIngredients.put("Tea", new Ingredient(5, 1));
		teaIngredients.put("Milk", new Ingredient(40, 4));
		teaIngredients.put("Water", new Ingredient(60, 5));
		teaIngredients.put("Sugar", new Ingredient(15, 2));
		teaIngredients.put("Coffee", new Ingredient(0, 0));

		return teaIngredients;
	}

	public Map<String, Ingredient> blackTeaRecipe() {

		Map<String, Ingredient> blackTeaIngredients = new HashMap<String, Ingredient>();
		blackTeaIngredients.put("Tea", new Ingredient(3, 0));
		blackTeaIngredients.put("Water", new Ingredient(100, 12));
		blackTeaIngredients.put("Sugar", new Ingredient(15, 2));
		blackTeaIngredients.put("Milk", new Ingredient(0, 0));
		blackTeaIngredients.put("Coffee", new Ingredient(0, 0));

		return blackTeaIngredients;

	}

	public Map<String, Ingredient> coffeeRecipe() {

		Map<String, Ingredient> coffeeIngredients = new HashMap<String, Ingredient>();
		coffeeIngredients.put("Coffee", new Ingredient(4, 1));
		coffeeIngredients.put("Milk", new Ingredient(80, 8));
		coffeeIngredients.put("Water", new Ingredient(20, 3));
		coffeeIngredients.put("Sugar", new Ingredient(15, 2));
		coffeeIngredients.put("Tea", new Ingredient(0, 0));

		return coffeeIngredients;
	}

	public Map<String, Ingredient> blackCoffeeRecipe() {

		Map<String, Ingredient> blackcoffeeIngredients = new HashMap<String, Ingredient>();
		blackcoffeeIngredients.put("Coffee", new Ingredient(3, 0));
		blackcoffeeIngredients.put("Water", new Ingredient(20, 3));
		blackcoffeeIngredients.put("Sugar", new Ingredient(15, 2));
		blackcoffeeIngredients.put("Milk", new Ingredient(0, 0));
		blackcoffeeIngredients.put("Tea", new Ingredient(0, 0));

		return blackcoffeeIngredients;
	}

}
