package org.ratcm;

public class CoffeeMaker {
	/** Array of recipes in coffee maker */
	private RecipeBook recipeBook;
	/** Inventory of the coffee maker */
	private Inventory inventory;

	/**
	 * Constructor for the coffee maker
	 *
	 */
	public CoffeeMaker() {
		recipeBook = new RecipeBook();
		inventory = new Inventory();
	}

	/**
	 * Returns true if the recipe is added to the list of recipes in the CoffeeMaker
	 * and false otherwise.
	 *
	 * @param r
	 * @return boolean
	 */
	public boolean addRecipe(Recipe r) {
		return recipeBook.addRecipe(r);
	}

	/**
	 * Returns the name of the successfully deleted recipe or null if the recipe
	 * cannot be deleted.
	 *
	 * @param recipeToDelete
	 * @return String
	 */
	public String deleteRecipe(int recipeToDelete) {
		return recipeBook.deleteRecipe(recipeToDelete);
	}

	/**
	 * Returns the name of the successfully edited recipe or null if the recipe
	 * cannot be edited.
	 *
	 * @param recipeToEdit
	 * @param r
	 * @return String
	 */
	public String editRecipe(int recipeToEdit, Recipe r) {
		return recipeBook.editRecipe(recipeToEdit, r);
	}

	/**
	 * Returns true if inventory was successfully added
	 *
	 * @param coffeeQty
	 * @param milkQty
	 * @param sugarQty
	 * @param chocolateQty
	 * @return true when all amounts have been updated with a positive or null value
	 */
	public boolean addInventory(int coffeeQty, int milkQty, int sugarQty, int chocolateQty) {
		inventory.setCoffee(coffeeQty);
		inventory.setMilk(milkQty);
		inventory.setSugar(sugarQty);
		inventory.setChocolate(chocolateQty);
		return true;
	}

	/**
	 * Returns the inventory of the coffee maker
	 *
	 * @return Inventory
	 */
	public String checkInventory() {
		return inventory.toString();
	}

	/**
	 * Returns the change of a user's beverage purchase, or the user's money if the
	 * beverage cannot be made
	 *
	 * @param recipeNb
	 * @param amtPaid
	 * @return int
	 */
	public int makeCoffee(int recipeNb, int amtPaid) {
		int change = 0;
		int beveragePrice;
		Recipe recipeToPurchase = getRecipes()[recipeNb];

		if (recipeToPurchase != null) {
			beveragePrice = recipeToPurchase.getPrice();
		} else {
			beveragePrice = 0;
		}

		if ((recipeToPurchase != null)
				&& (beveragePrice <= amtPaid)
				&& (inventory.useIngredients(recipeToPurchase))) {
			change = amtPaid - beveragePrice;
		} else {
			change = amtPaid;
		}

		return change;
	}

	/**
	 * Returns the list of Recipes in the RecipeBook.
	 *
	 * @return Recipe []
	 */
	public Recipe[] getRecipes() {
		return recipeBook.getRecipes();
	}
}
