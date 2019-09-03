package com.yash.Beverages;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import com.yash.containers.CoffeeContainer;
import com.yash.containers.MilkContainer;
import com.yash.containers.SugarContainer;
import com.yash.containers.TeaContainer;
import com.yash.containers.WaterContainer;
import com.yash.ingredient.Ingredient;

import exceptions.OverflowException;
import exceptions.UnderflowException;

public class Beverages {
	private TeaContainer teaContainer = new TeaContainer(2000);
	private MilkContainer milkContainer = new MilkContainer(10000);
	private WaterContainer waterContainer = new WaterContainer(15000);
	private SugarContainer sugarContainer = new SugarContainer(8000);
	private CoffeeContainer coffeeContainer = new CoffeeContainer(2000);
	private Logger logger = Logger.getLogger(Beverages.class.getName());

	private HashMap<String, Integer> refillMap = new HashMap<String, Integer>() {
		{
			put("Tea", 0);
			put("Milk", 0);
			put("Coffee", 0);
			put("Sugar", 0);
			put("Water", 0);

		}
	};

	private HashMap<String, Integer> wasteMap = new HashMap<String, Integer>() {
		{
			put("Tea", 0);
			put("Milk", 0);
			put("Coffee", 0);
			put("Sugar", 0);
			put("Water", 0);

		}
	};

	private HashMap<String, Integer> totalSaleMap = new HashMap<String, Integer>() {
		{
			put("Tea", 0);
			put("Black Tea", 0);
			put("Coffee", 0);
			put("Black Coffee", 0);
		}
	};

	public Beverages() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B[30m");
	}

	private Map<String, Integer> getContainerQuantities() {
		Map<String, Integer> containerQuantities = new HashMap<String, Integer>();
		containerQuantities.put("Tea", teaContainer.getContainerQuantity());
		containerQuantities.put("Milk", milkContainer.getContainerQuantity());
		containerQuantities.put("Water", waterContainer.getContainerQuantity());
		containerQuantities.put("Sugar", sugarContainer.getContainerQuantity());
		containerQuantities.put("Coffee", coffeeContainer.getContainerQuantity());
		return containerQuantities;

	}

	public String makeDrinkOperation(Map<String, Ingredient> drinkIngredients, Integer cup, String drinkName,
			Integer drinkPrice) {
		Map<String, Integer> containersQuantity = getContainerQuantities();

		drinkIngredients.forEach((ingredient, quantity) -> {
			if ((drinkIngredients.get(ingredient).consumed + drinkIngredients.get(ingredient).wasted)
					* cup > containersQuantity.get(ingredient).intValue()) {
				throw new UnderflowException(ingredient + " Container has insufficient quantity Refill !!");
			}

		}); 

		drinkIngredients.forEach((ingredient, quantity) -> {
			wasteMap.put(ingredient, (drinkIngredients.get(ingredient).wasted + wasteMap.get(ingredient)) * cup);
		});

		totalSaleMap.put(drinkName, totalSaleMap.get(drinkName) + (drinkPrice * cup));
		
		coffeeContainer.updateContainerQuantity(
				(drinkIngredients.get("Coffee").consumed + drinkIngredients.get("Coffee").wasted) * cup);
		teaContainer.updateContainerQuantity(
				(drinkIngredients.get("Tea").consumed + drinkIngredients.get("Tea").wasted) * cup);
		sugarContainer.updateContainerQuantity(
				(drinkIngredients.get("Sugar").consumed + drinkIngredients.get("Sugar").wasted) * cup);
		waterContainer.updateContainerQuantity(
				(drinkIngredients.get("Water").consumed + drinkIngredients.get("Water").wasted) * cup);
		milkContainer.updateContainerQuantity(
				(drinkIngredients.get("Milk").consumed + drinkIngredients.get("Milk").wasted) * cup);

		return cup + " cups " + drinkName + " is served ";

	}

	public void resetAllContainers() {
		teaContainer.resetContainerQuantity();
		milkContainer.resetContainerQuantity();
		waterContainer.resetContainerQuantity();
		sugarContainer.resetContainerQuantity();
		coffeeContainer.resetContainerQuantity();
		logger.info("All Containers Reset...");
	} 

	public String refillContainers(Integer choice) {
		switch (choice) {

		case 1:
 
			if (teaContainer.getContainerQuantity() > teaContainer.getCapacity())
				throw new OverflowException("Tea Container Overflowing !!!!");
			teaContainer.refillContainerQuantity(teaContainer.getCapacity() - teaContainer.getContainerQuantity());
			refillMap.put("Tea", refillMap.get("Tea") + 1);
			logger.info("Tea Container Refill done ...");

			break;
		case 2:

			if (coffeeContainer.getContainerQuantity() > coffeeContainer.getCapacity())
				throw new OverflowException("Coffee Container Overflowing !!!!");
			coffeeContainer
					.refillContainerQuantity(coffeeContainer.getCapacity() - coffeeContainer.getContainerQuantity());
			refillMap.put("Coffee", refillMap.get("Coffee") + 1);
			logger.info("Coffee Container Refill done ...");


			break;

		case 3:

			if (sugarContainer.getContainerQuantity() > sugarContainer.getCapacity())
				throw new OverflowException("Sugar Container Overflowing !!!!");

			sugarContainer
					.refillContainerQuantity(sugarContainer.getCapacity() - sugarContainer.getContainerQuantity());
			refillMap.put("Sugar", refillMap.get("Sugar") + 1);
			logger.info("Sugar Container Refill done ...");

			break;

		case 4:

			if (milkContainer.getContainerQuantity() > milkContainer.getCapacity())
				throw new OverflowException("Milk Container Overflowing !!!!");

			milkContainer.refillContainerQuantity(milkContainer.getCapacity() - milkContainer.getContainerQuantity());
			refillMap.put("Milk", refillMap.get("Milk") + 1);
			logger.info("Milk Container Refill done ...");

			break;
		case 5:

			if (waterContainer.getContainerQuantity() > waterContainer.getCapacity())
				throw new OverflowException("Water Container Overflowing !!!!");

			waterContainer.refillContainerQuantity(waterContainer.getCapacity() - waterContainer.getContainerQuantity());
			refillMap.put("Water", refillMap.get("Water") + 1);
			logger.info("Water Container Refill done ...");

			break;
			
			
		default:
			logger.info("Invalid Choice");
			break;
			
		}

		return "Refill done ...";
	}

	public void totalReport() {
		totalSale();
		logger.info("\n:::::::::::::::::::::::::::::::CONTAINER REPORT :::::::::::::::::::::::::::::::::::::::");
		logger.info("\t\t\tCONTAINER \t\t  REFILL COUNT \t      WASTAGEgm/ml\t QUANTITYgm/ml");
		logger.info("\t\t\t--------- \t\t  ------------ \t      ------------\t -------------");
		refillMap.forEach((container, refillCount) -> {
			logger.info("\t\t\t" + container + "\t\t\t\t" + refillMap.get(container).intValue() + "\t\t "
					+ wasteMap.get(container).intValue() + "\t\t   " + getContainerQuantities().get(container));
		});
       logger.info("Total report");
	}

	public void containerStatus() {
		logger.info(":::::::::::::::::::::::::::::::CONTAINER STATUS:::::::::::::::::::::::::::::::::::::::");
		logger.info("\t\t\tTea Container     | " + teaContainer.getContainerQuantity() + "gm");
		logger.info("\t\t\tMilk Container    | " + milkContainer.getContainerQuantity() + "ml");
		logger.info("\t\t\tWater Container   | " + waterContainer.getContainerQuantity() + "ml");
		logger.info("\t\t\tSugar Container   | " + sugarContainer.getContainerQuantity() + "gm");
		logger.info("\t\t\tCoffee Conatainer | " + coffeeContainer.getContainerQuantity() + "gm");
		logger.info("\t\t\tContainer Status ...");
	}

	public void totalSale() {
		logger.info(":::::::::::::::::::::::::::::::TOTAL SALE REPORT:::::::::::::::::::::::::::::::::::::::");
		
		logger.info("\t\t\tSALE\t\t\t CUPS\t\t\t  COST");
		logger.info("\t\t\t----\t\t\t ----\t\t\t  ----");

		logger.info("\t\t\tTea           |   \t  " + totalSaleMap.get("Tea") / 10 +"\t\t\t   " + totalSaleMap.get("Tea")+ " Rs");
		logger.info("\t\t\tBlack Tea     |   \t  " + totalSaleMap.get("Black Tea") / 5 +"\t\t\t   " + totalSaleMap.get("Black Tea") + " Rs");
		logger.info("\t\t\tCoffee        |   \t  " + totalSaleMap.get("Coffee") / 15 +"\t\t\t   " + totalSaleMap.get("Coffee") + " Rs");
		logger.info("\t\t\tBlack Coffee  |   \t  " + totalSaleMap.get("Black Coffee") / 10 +"\t\t\t   " + totalSaleMap.get("Black Coffee") + " Rs");
		logger.info("________________________________________________________________________________");
		
		logger.info("\t\t\tTotal         | " + (totalSaleMap.get("Tea") + totalSaleMap.get("Black Tea")
				+ totalSaleMap.get("Coffee") + totalSaleMap.get("Black Coffee") + " Rs"));

		logger.info("\t\t\tTotal Sale ...");
	}

}