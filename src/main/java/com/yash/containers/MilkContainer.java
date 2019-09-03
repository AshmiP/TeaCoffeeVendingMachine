package com.yash.containers;

import com.yash.ingredient.Ingredient;

public class MilkContainer implements Container {

	private Ingredient milk;
	private final Integer capacity = 10000;
	private Integer quantity;

	public MilkContainer(Integer quantity) {
		super();
		this.quantity = quantity;

	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getContainerQuantity() {
		return this.quantity;
	}

	public Integer updateContainerQuantity(Integer consumedMilk) {
		this.quantity -= consumedMilk;
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
