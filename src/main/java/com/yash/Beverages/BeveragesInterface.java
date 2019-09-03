package com.yash.Beverages;

import java.util.Map;

import com.yash.ingredient.Ingredient;

public interface BeveragesInterface {

	public void resetAllContainers();

	public void refillContainers(Integer choice);

	public void containerStatus();

	public void totalSale();

	public String makeDrinkOperation(Map<String, Ingredient> drinkIngredients, Integer cup, String drinkName,
			Integer drinkPrice);

}
