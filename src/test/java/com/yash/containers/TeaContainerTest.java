package com.yash.containers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TeaContainerTest {

	private TeaContainer teaContainer = new TeaContainer(20);

	@Test
	public void shouldCheckGetQuantity() {
		
		Integer actual = teaContainer.getContainerQuantity();
		
		assertEquals(20, actual.intValue());
	}

	@Test
	public void shouldUpdateContainerQuantityByGettingConsumedQuantity() {
		
		Integer actual = teaContainer.updateContainerQuantity(3);
		
		assertEquals(17, actual.intValue());
	}

	@Test
	public void shouldFillContainerToFullCapacityByGettingCurrentQuantity() {
		
		Integer actual = teaContainer.refillContainerQuantity(1980);
		
		assertEquals(2000, actual.intValue());
	}

	@Test
	public void shouldResetContainerQuantityToFullCapacity() {
		
		Integer actual = teaContainer.resetContainerQuantity();
		
		assertEquals(2000, actual.intValue());

	}

	@Test
	public void shouldCheckContainerCapacity() {
		
		Integer actual = teaContainer.getCapacity();
		
		assertEquals(2000, actual.intValue());
	}

}
