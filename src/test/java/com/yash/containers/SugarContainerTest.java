package com.yash.containers;

import static org.junit.Assert.*;

import org.junit.Test;

public class SugarContainerTest {

	private SugarContainer sugarContainer = new SugarContainer(20);

	@Test
	public void shouldCheckGetQuantity() {
		
		Integer actual = sugarContainer.getContainerQuantity();
		
		assertEquals(20, actual.intValue());
	}

	@Test
	public void shouldUpdateContainerQuantityByGettingConsumedQuantity() {
		Integer actual = sugarContainer.updateContainerQuantity(3);
		assertEquals(17, actual.intValue());
	}

	@Test
	public void shouldFillContainerToFullCapacityByGettingCurrentQuantity() {
		Integer actual = sugarContainer.refillContainerQuantity(1980);
		assertEquals(2000, actual.intValue());
	}

	@Test
	public void shouldResetContainerQuantityToFullCapacity() {
		Integer actual = sugarContainer.resetContainerQuantity();
		assertEquals(8000, actual.intValue());

	}

	@Test
	public void shouldCheckContainerCapacity() {
		Integer actual = sugarContainer.getCapacity();
		assertEquals(8000, actual.intValue());
	}

}
