package com.yash.containers;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeContainerTest {

	private CoffeeContainer coffeeContainer = new CoffeeContainer(20);

	@Test
	public void shouldCheckGetQuantity() {
		
		Integer actual = coffeeContainer.getContainerQuantity();
		
		assertEquals(20, actual.intValue());
	}

	@Test
	public void shouldUpdateContainerQuantityByGettingConsumedQuantity() {
		
		Integer actual = coffeeContainer.updateContainerQuantity(3);
		
		assertEquals(17, actual.intValue());
	}

	@Test
	public void shouldFillContainerToFullCapacityByGettingCurrentQuantity() {
		
		Integer actual = coffeeContainer.refillContainerQuantity(1980);
		
		assertEquals(2000, actual.intValue());
	}

	@Test
	public void shouldResetContainerQuantityToFullCapacity() {
		
		Integer actual = coffeeContainer.resetContainerQuantity();
		
		assertEquals(2000, actual.intValue());

	}

	@Test
	public void shouldCheckContainerCapacity() {
		
		Integer actual = coffeeContainer.getCapacity();
		
		assertEquals(2000, actual.intValue());
	}

}
