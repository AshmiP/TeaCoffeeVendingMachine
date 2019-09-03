package com.yash.Beverages;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.TeaCoffeeVendingMachine.TeaCoffeeVendingMachineOrganizer;
import com.yash.containers.CoffeeContainer;
import com.yash.containers.MilkContainer;
import com.yash.containers.SugarContainer;
import com.yash.containers.TeaContainer;
import com.yash.containers.WaterContainer;
import com.yash.ingredient.Ingredient;

import exceptions.UnderflowException;
import exceptions.OverflowException;

@RunWith(value = MockitoJUnitRunner.class)
public class BeveragesTest {

	@InjectMocks
	private Beverages beverages;

	@Mock
	private TeaContainer teaContainerMock;

	@Mock
	private MilkContainer milkContainerMock;

	@Mock
	private WaterContainer waterContainerMock;

	@Mock
	private SugarContainer sugarContainerMock;

	@Mock
	private CoffeeContainer coffeeContainerMock;

	@Mock
	private Logger loggerMock ;

	@Test
	public void shouldResetAllContainersToMaximumQuantity() {

		when(teaContainerMock.resetContainerQuantity()).thenCallRealMethod();
		when(milkContainerMock.resetContainerQuantity()).thenCallRealMethod();
		when(waterContainerMock.resetContainerQuantity()).thenCallRealMethod();
		when(coffeeContainerMock.resetContainerQuantity()).thenCallRealMethod();
		when(sugarContainerMock.resetContainerQuantity()).thenCallRealMethod();

		beverages.resetAllContainers();
		verify(loggerMock).info("All Containers Reset...");
	}
 
	@Test
	public void shouldRefillTeaContainerOnGivingOne() {
		beverages.refillContainers(1);
		
		verify(loggerMock).info("Tea Container Refill done ...");

	}
	
	@Test
	public void shouldRefillCoffeeContainerOnGivingTwo() {
		beverages.refillContainers(2);
		
		verify(loggerMock).info("Coffee Container Refill done ...");

	}

	@Test
	public void shouldRefillSugarContainerOnGivingThree() {
		beverages.refillContainers(3);
		
		verify(loggerMock).info("Sugar Container Refill done ...");

	}
	
	@Test
	public void shouldRefillMilkContainerOnGivingFour() {
		beverages.refillContainers(4);
		
		verify(loggerMock).info("Milk Container Refill done ...");

	}
	
	@Test
	public void shouldRefillWaterContainerOnGivingFive() {
		beverages.refillContainers(5);
		
		verify(loggerMock).info("Water Container Refill done ...");

	}
	
	@Test
	public void shouldDisplayInvalidChoiceIfRefillForInvalidContainerIsGiven() {
		beverages.refillContainers(99);
		
		verify(loggerMock).info("Invalid Choice");

	}

	@Test(expected = OverflowException.class)
	public void shouldCheckForTeaContainerOverflowOnRefill() {

		when(teaContainerMock.getContainerQuantity()).thenReturn(400000);

		beverages.refillContainers(1);
	}

	@Test(expected = OverflowException.class)
	public void shouldCheckForCoffeeContainerOverflowOnRefill() {

		when(coffeeContainerMock.getContainerQuantity()).thenReturn(400000);

		beverages.refillContainers(2);
	}

	@Test(expected = OverflowException.class)
	public void shouldCheckForSugarContainerOverflowOnRefill() {

		when(sugarContainerMock.getContainerQuantity()).thenReturn(400000);

		beverages.refillContainers(3);
	}

	@Test(expected = OverflowException.class)
	public void shouldCheckForMilkContainerOverflowOnRefill() {

		when(milkContainerMock.getContainerQuantity()).thenReturn(400000);

		beverages.refillContainers(4);
	}

	@Test(expected = OverflowException.class)
	public void shouldCheckForWaterContainerOverflowOnRefill() {

		when(waterContainerMock.getContainerQuantity()).thenReturn(400000);

		beverages.refillContainers(5);
	}

	@Test
	public void shouldCheckContainersStatus() {

		beverages.containerStatus();

		verify(loggerMock).info("\t\t\tContainer Status ...");
	}

	@Test
	public void shouldCheckTotalSale() {

		beverages.totalSale();

		verify(loggerMock).info("\t\t\tTotal Sale ...");
	}

	@Test
	public void shouldMakeDrinkOfGivenNumberOfCups() {

		Map<String, Ingredient> drinkIngredients = new HashMap<String, Ingredient>();
		drinkIngredients.put("Tea", new Ingredient(5, 1));
		drinkIngredients.put("Milk", new Ingredient(40, 4));
		drinkIngredients.put("Water", new Ingredient(160, 5));
		drinkIngredients.put("Sugar", new Ingredient(15, 2));
		drinkIngredients.put("Coffee", new Ingredient(0, 0));

		when(waterContainerMock.getContainerQuantity()).thenReturn(500);
		when(teaContainerMock.getContainerQuantity()).thenReturn(100);
		when(milkContainerMock.getContainerQuantity()).thenReturn(100);
		when(sugarContainerMock.getContainerQuantity()).thenReturn(100);
		when(coffeeContainerMock.getContainerQuantity()).thenReturn(100);

		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
		assertEquals("1 cups Tea is served ", actual);
	}

	@Test(expected = UnderflowException.class)
	public void shouldThrowUnderflowExceptioIfContainerHasInsufficientQuantityToMakeRequiredNumberOfDrink() {

		Map<String, Ingredient> drinkIngredients = new HashMap<String, Ingredient>();
		drinkIngredients.put("Tea", new Ingredient(5, 1));
		drinkIngredients.put("Milk", new Ingredient(40, 4));
		drinkIngredients.put("Water", new Ingredient(160, 5));
		drinkIngredients.put("Sugar", new Ingredient(15, 2));
		drinkIngredients.put("Coffee", new Ingredient(0, 0));

		when(waterContainerMock.getContainerQuantity()).thenReturn(5);
		when(teaContainerMock.getContainerQuantity()).thenReturn(100);
		when(milkContainerMock.getContainerQuantity()).thenReturn(100);
		when(sugarContainerMock.getContainerQuantity()).thenReturn(100);
		when(coffeeContainerMock.getContainerQuantity()).thenReturn(100);

		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
		assertEquals("1 Tea is served ", actual);
	}

	@Test
	public void shouldCheckTotalReport() {

		beverages.totalReport();
		verify(loggerMock).info("Total report");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(expected = UnderflowException.class)
//	public void shouldThrowUnderflowExceptioIfTeaContainerHasInsufficientQuantityToMakeRequiredQuantityOfDrink() {
//		Map<String,Ingredient> drinkIngredients = new HashMap<String,Ingredient>();
//		drinkIngredients.put("Tea", new Ingredient(5, 1));
//		drinkIngredients.put("Milk", new Ingredient(40,4));
//		drinkIngredients.put("Water", new Ingredient(160,5));
//		drinkIngredients.put("Sugar", new Ingredient(15,2));
//		drinkIngredients.put("Coffee", new Ingredient(0,0));
//
//		 
//		Mockito.when(waterContainerMockMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(teaContainerMock.getContainerQuantity()).thenReturn(5);
//		Mockito.when(milkContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(sugarContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(coffeeContainerMock.getContainerQuantity()).thenReturn(100);
//	
//		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
//       // assertEquals("1 Tea is served ",actual);
//	}
//	
//	@Test(expected = UnderflowException.class)
//	public void shouldThrowUnderflowExceptioIfmilkContainerMockHasInsufficientQuantityToMakeRequiredQuantityOfDrink() {
//		Map<String,Ingredient> drinkIngredients = new HashMap<String,Ingredient>();
//		drinkIngredients.put("Tea", new Ingredient(5, 1));
//		drinkIngredients.put("Milk", new Ingredient(40,4));
//		drinkIngredients.put("Water", new Ingredient(160,5));
//		drinkIngredients.put("Sugar", new Ingredient(15,2));
//		drinkIngredients.put("Coffee", new Ingredient(0,0));
//
//		 
//		Mockito.when(waterContainerMockMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(teaContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(milkContainerMock.getContainerQuantity()).thenReturn(5);
//		Mockito.when(sugarContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(coffeeContainerMock.getContainerQuantity()).thenReturn(100);
//	
//		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
//       // assertEquals("1 Tea is served ",actual);
//	}
//
//	@Test(expected = UnderflowException.class)
//	public void shouldThrowUnderflowExceptioIfSugarContainerHasInsufficientQuantityToMakeRequiredQuantityOfDrink() {
//		Map<String,Ingredient> drinkIngredients = new HashMap<String,Ingredient>();
//		drinkIngredients.put("Tea", new Ingredient(5, 1));
//		drinkIngredients.put("Milk", new Ingredient(40,4));
//		drinkIngredients.put("Water", new Ingredient(160,5));
//		drinkIngredients.put("Sugar", new Ingredient(15,2));
//		drinkIngredients.put("Coffee", new Ingredient(0,0));
//
//		 
//		Mockito.when(waterContainerMockMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(teaContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(milkContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(sugarContainerMock.getContainerQuantity()).thenReturn(5);
//		Mockito.when(coffeeContainerMock.getContainerQuantity()).thenReturn(100);
//	
//		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
//       // assertEquals("1 Tea is served ",actual);
//	}
//	
//	@Test(expected = UnderflowException.class)
//	public void shouldThrowUnderflowExceptioIfCoffeeContainerHasInsufficientQuantityToMakeRequiredQuantityOfDrink() {
//		Map<String,Ingredient> drinkIngredients = new HashMap<String,Ingredient>();
//		drinkIngredients.put("Tea", new Ingredient(5, 1));
//		drinkIngredients.put("Milk", new Ingredient(40,4));
//		drinkIngredients.put("Water", new Ingredient(160,5));
//		drinkIngredients.put("Sugar", new Ingredient(15,2));
//		drinkIngredients.put("Coffee", new Ingredient(0,0));
//
//		 
//		Mockito.when(waterContainerMockMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(teaContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(milkContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(sugarContainerMock.getContainerQuantity()).thenReturn(100);
//		Mockito.when(coffeeContainerMock.getContainerQuantity()).thenReturn(5);
//	
//		String actual = beverages.makeDrinkOperation(drinkIngredients, 1, "Tea", 10);
//       // assertEquals("1 Tea is served ",actual);
//	}
}