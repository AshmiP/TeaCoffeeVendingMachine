package com.yash.containers;

import com.yash.ingredient.Ingredient;

public class CoffeeContainer implements Container {

	private Ingredient coffeeBeans;
	private final Integer capacity = 2000;
	private Integer quantity;

	public Integer getCapacity() {
		return capacity;
	}

	public CoffeeContainer(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getContainerQuantity() {

		return this.quantity;
	}

	public Integer updateContainerQuantity(Integer consumedCoffee) {
		this.quantity -= consumedCoffee;
		return this.quantity;

	}

	public Integer refillContainerQuantity(Integer requiredFill) {
		this.quantity += requiredFill;
		return this.quantity;
	}

	public Integer resetContainerQuantity() {
		this.quantity = this.capacity;
		return this.quantity;
	}

}
