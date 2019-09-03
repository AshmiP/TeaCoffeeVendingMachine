package com.yash.containers;

import static org.junit.Assert.*;

import org.junit.Test;

public class MilkContainerTest {

	private MilkContainer milkContainer = new MilkContainer(20);

	@Test
	public void shouldCheckGetQuantity() {
		
		Integer actual = milkContainer.getContainerQuantity();
		
		assertEquals(20, actual.intValue());
	}

	@Test
	public void shouldUpdateContainerQuantityByGettingConsumedQuantity() {
		
		Integer actual = milkContainer.updateContainerQuantity(3);
		
		assertEquals(17, actual.intValue());
	}

	@Test
	public void shouldFillContainerToFullCapacityByGettingCurrentQuantity() {
		
		Integer actual = milkContainer.refillContainerQuantity(1980);
		
		assertEquals(2000, actual.intValue());
	}

	@Test
	public void shouldResetContainerQuantityToFullCapacity() {
		
		Integer actual = milkContainer.resetContainerQuantity();
		
		assertEquals(10000, actual.intValue());

	}

	@Test
	public void shouldCheckContainerCapacity() {
		
		Integer actual = milkContainer.getCapacity();
		
		assertEquals(10000, actual.intValue());
	}

}
