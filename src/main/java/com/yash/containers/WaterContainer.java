package com.yash.containers;

import com.yash.ingredient.Ingredient;

public class WaterContainer implements Container {

	private Ingredient water;
	private final Integer capacity = 10000;
	private Integer quantity;

	public Integer getCapacity() {
		return capacity;
	}

	public WaterContainer(Integer quantity) {
		super();
		this.quantity = quantity;
	}

	public Integer getContainerQuantity() {

		return this.quantity;
	}

	public Integer updateContainerQuantity(Integer consumedWater) {
		this.quantity -= consumedWater;
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
