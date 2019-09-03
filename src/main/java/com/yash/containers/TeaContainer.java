package com.yash.containers;

import com.yash.ingredient.Ingredient;

public class TeaContainer implements Container {

	private Ingredient teaPowder;
	private final Integer capacity = 2000;
	private Integer quantity;

	public Integer getCapacity() {
		return capacity;
	}

	public TeaContainer(Integer quantity) {
		super();
		this.quantity = quantity;
	}

	public Integer getContainerQuantity() {
		return this.quantity;
	}

	public Integer updateContainerQuantity(Integer consumedTea) {
		this.quantity -= consumedTea;
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
