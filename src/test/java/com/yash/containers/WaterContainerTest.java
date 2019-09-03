package com.yash.containers;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaterContainerTest {

	private WaterContainer waterContainer = new WaterContainer(20);

	@Test
	public void shouldCheckGetQuantity() {
		
		Integer actual = waterContainer.getContainerQuantity();
		
		assertEquals(20, actual.intValue());
	}

	@Test
	public void shouldUpdateContainerQuantityByGettingConsumedQuantity() {
		
		Integer actual = waterContainer.updateContainerQuantity(3);
		
		assertEquals(17, actual.intValue());
	}

	@Test
	public void shouldFillContainerToFullCapacityByGettingCurrentQuantity() {
		
		Integer actual = waterContainer.refillContainerQuantity(1980);
		
		assertEquals(2000, actual.intValue());
	}

	@Test
	public void shouldResetContainerQuantityToFullCapacity() {
		
		Integer actual = waterContainer.resetContainerQuantity();
		
		assertEquals(10000, actual.intValue());

	}

	@Test
	public void shouldCheckContainerCapacity() {
		
		Integer actual = waterContainer.getCapacity();
		
		assertEquals(10000, actual.intValue());
	}

}
