package com.yash.MyTeaCoffeeVendingMachine;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.yash.Beverages.BeverageRecipe;
import com.yash.Beverages.Beverages;
import com.yash.TeaCoffeeVendingMachine.TeaCoffeeVendingMachineOrganizer;
import com.yash.customInputScanner.CustomInputScanner;
import com.yash.ingredient.Ingredient;

import exceptions.OverflowException;
import exceptions.UnderflowException;

@RunWith(value = MockitoJUnitRunner.class)
public class TeaCoffeeVendingMachineOrganizerTest {

	@InjectMocks
	private TeaCoffeeVendingMachineOrganizer organizer;

	@Mock
	private CustomInputScanner mockScanner;

	@Mock
	private Beverages beverageMock;

	@Mock
	private BeverageRecipe beverageRecipeMock;

	@Mock
	private Logger loggerMock;

	@Test
	public void shouldMakeTeaWhenGivenChoiceOne() {

		Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>() {
			{
				put("Tea", new Ingredient(5, 1));
				put("Milk", new Ingredient(40, 4));
				put("Water", new Ingredient(60, 5));
				put("Sugar", new Ingredient(15, 2));
				put("Coffee", new Ingredient(0, 0));

			}
		}; 

		when(mockScanner.getInput("menu choice")).thenReturn(1).thenReturn(0);
		when(mockScanner.getInput("teaQuantity")).thenReturn(2);
		when(beverageRecipeMock.teaRecipe()).thenReturn(ingredients);
		when(beverageMock.makeDrinkOperation(ingredients, 2, "Tea", 10)).thenReturn("2 cup tea served");

		organizer.menuOperations();
		beverageMock.makeDrinkOperation(ingredients, 2, "Tea", 10);
		
		verify(beverageMock).makeDrinkOperation(ingredients, 2, "Tea", 10);

	}

	@Test
	public void shouldMakeBlackTeaWhenGivenChoiceTwo() {

		Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>() {
			{
				put("Tea", new Ingredient(3, 0));
				put("Water", new Ingredient(100, 12));
				put("Sugar", new Ingredient(15, 2));
				put("Milk", new Ingredient(0, 0));
				put("Coffee", new Ingredient(0, 0));

			}
		};

		when(mockScanner.getInput("menu choice")).thenReturn(2).thenReturn(0);
		when(mockScanner.getInput("blackTeaQuantity")).thenReturn(2);
		when(beverageRecipeMock.blackTeaRecipe()).thenReturn(ingredients);
		when(beverageMock.makeDrinkOperation(ingredients, 2, "Black Tea", 10)).thenReturn("2 cup black tea served");

		organizer.menuOperations();
		beverageMock.makeDrinkOperation(ingredients, 2, "Black Tea", 10);

		verify(beverageMock).makeDrinkOperation(ingredients, 2, "Black Tea", 10);

	}

	@Test
	public void shouldMakeCoffeeWhenGivenChoiceThree() {

		Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>() {
			{
				put("Coffee", new Ingredient(4, 1));
				put("Milk", new Ingredient(80, 8));
				put("Water", new Ingredient(20, 3));
				put("Sugar", new Ingredient(15, 2));
				put("Tea", new Ingredient(0, 0));
			}
		};

		when(mockScanner.getInput("menu choice")).thenReturn(3).thenReturn(0);
		when(mockScanner.getInput("coffeeQuantity")).thenReturn(2);
		when(beverageRecipeMock.blackTeaRecipe()).thenReturn(ingredients);
		when(beverageMock.makeDrinkOperation(ingredients, 2, "Coffee", 10)).thenReturn("2 cup coffee served");

		organizer.menuOperations();
		beverageMock.makeDrinkOperation(ingredients, 2, "Coffee", 10);

		verify(beverageMock).makeDrinkOperation(ingredients, 2, "Coffee", 10);

	}

	@Test
	public void shouldMakeBlackCoffeeWhenGivenChoiceFour() {

		Map<String, Ingredient> ingredients = new HashMap<String, Ingredient>() {
			{
				put("Coffee", new Ingredient(3, 0));
				put("Water", new Ingredient(20, 3));
				put("Sugar", new Ingredient(15, 2));
				put("Milk", new Ingredient(0, 0));
				put("Tea", new Ingredient(0, 0));

			}
		};

		when(mockScanner.getInput("menu choice")).thenReturn(4).thenReturn(0);
		when(mockScanner.getInput("blackCoffeeQuantity")).thenReturn(2);
		when(beverageRecipeMock.blackTeaRecipe()).thenReturn(ingredients);
		when(beverageMock.makeDrinkOperation(ingredients, 2, "Black Coffee", 10))
				.thenReturn("2 cup black coffee served");

		organizer.menuOperations();
		beverageMock.makeDrinkOperation(ingredients, 2, "Black Coffee", 10);

		verify(beverageMock).makeDrinkOperation(ingredients, 2, "Black Coffee", 10);

	}

	@Test
	public void shouldThrowUnderflowExceptionWhileMakingDueToInsufficientContainerQuantitytOnChoiceOne() {

		when(mockScanner.getInput("menu choice")).thenReturn(1).thenReturn(0);
		when(mockScanner.getInput("teaQuantity")).thenReturn(5000);
		when(beverageMock.makeDrinkOperation(anyMap(), anyInt(), anyString(), anyInt())).thenThrow(new UnderflowException("Tea Container Empty"));
        
		organizer.menuOperations();		
	}
	
	 
	@Test
	public void shouldThrowUnderflowExceptionWhileMakingBlackTeaDueToInsufficientContainerQuantitytOnChoiceTwo() {
	
		when(mockScanner.getInput("menu choice")).thenReturn(2).thenReturn(0);
		when(mockScanner.getInput("blackTeaQuantity")).thenReturn(5000);
		when(beverageMock.makeDrinkOperation(anyMap(), anyInt(), anyString(), anyInt())).thenThrow(new UnderflowException("Tea Container Empty"));
        
		organizer.menuOperations();		
	}

	@Test
	public void shouldThrowUnderflowExceptionWhileMakingCoffeeDueToInsufficientContainerQuantitytOnChoiceThree() {
	
		when(mockScanner.getInput("menu choice")).thenReturn(3).thenReturn(0);
		when(mockScanner.getInput("coffeeQuantity")).thenReturn(5000);
		when(beverageMock.makeDrinkOperation(anyMap(), anyInt(), anyString(), anyInt())).thenThrow(new UnderflowException("Tea Container Empty"));
        
		organizer.menuOperations();		
	}
	
	@Test 
	public void shouldThrowUnderflowExceptionWhileMakingBlackCoffeeDueToInsufficientContainerQuantitytOnChoiceFour() {
	
		when(mockScanner.getInput("menu choice")).thenReturn(4).thenReturn(0);
		when(mockScanner.getInput("teaQuantity")).thenReturn(5000);
		when(beverageMock.makeDrinkOperation(anyMap(), anyInt(), anyString(), anyInt())).thenThrow(new UnderflowException("Tea Container Empty"));
        
		organizer.menuOperations();		
	}
	
	@Test
	public void shouldRefillContainersSuccessfully() {
		when(mockScanner.getInput("menu choice")).thenReturn(5).thenReturn(0);
		when(mockScanner.getInput("refill")).thenReturn(1);

		organizer.menuOperations();
		beverageMock.refillContainers(1);

		verify(beverageMock).refillContainers(1);

	}

	@Test
	public void shouldCheckIfContainersAreOverflowing() {

		when(mockScanner.getInput("menu choice")).thenReturn(5).thenReturn(0);
		when(mockScanner.getInput("refill")).thenReturn(1);
		when(beverageMock.refillContainers(anyInt())).thenThrow(new OverflowException("Container Overflowing !!!!!!"));
		
		organizer.menuOperations();


	}
	
	@Test
	public void shouldCheckTotalSale() {
		when(mockScanner.getInput("menu choice")).thenReturn(6).thenReturn(0);

		organizer.menuOperations();

		verify(beverageMock).totalSale();

	}

	@Test
	public void shouldCheckContainerStatus() {
		when(mockScanner.getInput("menu choice")).thenReturn(7).thenReturn(0);

		organizer.menuOperations();

		verify(beverageMock).containerStatus();

	}

	@Test
	public void shouldCheckResetAllContainers() {
		when(mockScanner.getInput("menu choice")).thenReturn(8).thenReturn(0);

		organizer.menuOperations();

		verify(beverageMock).resetAllContainers();

	}

	@Test
	public void shouldCheckTotalReport() {
		when(mockScanner.getInput("menu choice")).thenReturn(9).thenReturn(0);

		organizer.menuOperations();

		verify(beverageMock).totalReport();

	} 
	
	@Test
	public void shouldCheckWhenInvalidChoiceIsGiven() {
		when(mockScanner.getInput("menu choice")).thenReturn(100).thenReturn(0);

		organizer.menuOperations();


	}
	


}
