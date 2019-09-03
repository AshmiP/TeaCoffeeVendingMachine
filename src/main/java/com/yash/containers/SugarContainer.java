package com.yash.containers;

import com.yash.ingredient.Ingredient;

public class SugarContainer implements Container {

	private Ingredient sugar;
	private final Integer capacity = 8000;
	private Integer quantity;

	public SugarContainer(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public Integer getContainerQuantity() {
		return this.quantity;
	}

	public Integer updateContainerQuantity(Integer consumedSugar) {
		this.quantity -= consumedSugar;
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
