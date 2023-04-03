package org.ratcm;

import org.ratcm.exceptions.RecipeException;

public class GWT_Scenarios {
	private CoffeeMaker cm;
	private Recipe r1, r2, r3, r4;
	private int monnaieObtenue, editedChocolateQuantity;
	private String deletedRecipeName, recipeNameForCoffee, editedRecipeName;

	public GWT_Scenarios() {
		cm = new CoffeeMaker();

		recipeNameForCoffee = "Coffee";
		editedChocolateQuantity = 500;

		// Set up for r1
		r1 = new Recipe();
		r1.setName(recipeNameForCoffee);
		r1.setAmtChocolate(0);
		r1.setAmtCoffee(3);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setPrice(50);

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate(20);
		r2.setAmtCoffee(3);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setPrice(75);

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate(0);
		r3.setAmtCoffee(3);
		r3.setAmtMilk(3);
		r3.setAmtSugar(1);
		r3.setPrice(100);

		// Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate(4);
		r4.setAmtCoffee(0);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setPrice(65);
	}

	private void givenACoffeeMachineWithCoffeeRecipe(){
		cm.addRecipe(r1);
	}

	private void givenACoffeeMachineWithEmptyRecipeBook(){
		;
	}

	private void givenACoffeeMachineWithThreeRecipe() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
	}

	private void whenACoffeeIsOrderedWith75Cts() {
		monnaieObtenue = cm.makeCoffee(0, 75);
	}

	private void whenTheFirstRecipeIsDeleted() {
		deletedRecipeName = cm.deleteRecipe(0);
	}

	private void whenTheRecipeInTheMiddleIsDeletedIsDeleted() {
		deletedRecipeName = cm.deleteRecipe(1);
	}

	private void whenTheIndexOfTheRecipeToBeDeletedIsOutOfTheRecipeBook() {
		deletedRecipeName = cm.deleteRecipe(Integer.MAX_VALUE);
	}

	private void whenTryingToEditARecipeAtFirstPosition() {
		editedRecipeName = cm.editRecipe(0, r4);
	}

	private void whenTheQuantityOfChocolateIsEdited() {
		Recipe newRecipe = cm.getRecipes()[0];
		newRecipe.setAmtChocolate(editedChocolateQuantity);
		cm.editRecipe(0, newRecipe);
	}

	private void thenLaMonnaieObtenueEstDe25() {
		assert (monnaieObtenue == 25);
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisNull() {
		assert (deletedRecipeName == null);
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisCoffee() {
		assert (deletedRecipeName.equals(r1.getName()));
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisMocha() {
		assert (deletedRecipeName.equals(r2.getName()));
		System.out.println("Test passed");
	}

	private void thenIndexOutOfBoundExceptionIsRaised() {
		System.out.println("Test passed");
	}

	private void thenEditedRecipeNameIsNull() {
		assert (editedRecipeName == null);
		System.out.println("Test passed");
	}

	private void thenEditedRecipeNameIsUnchanged() {
		assert (cm.getRecipes()[0].getName().equals(recipeNameForCoffee));
		System.out.println("Test passed");
	}

	private void thenTheQuantityOfChocolateIsIndeedEdited() {
		assert(cm.getRecipes()[0].getAmtChocolate() == editedChocolateQuantity);
		System.out.println("Test passed");
	}

	public static void main(String[] args) {
		GWT_Scenarios t = new GWT_Scenarios();

		// example of GWT
		// t.givenACoffeeMachineWithCoffeeRecipe();
		// t.whenACoffeeIsOrderedWith75Cts();
		//t.thenLaMonnaieObtenueEstDe25();

		// scenario 1 for delete
		// t.givenACoffeeMachineWithEmptyRecipeBook();
		// t.whenTheFirstRecipeIsDeleted();
		// t.thenTheDeletedRecipeNameisNull();

		// scenario 2 for delete
		// t.givenACoffeeMachineWithCoffeeRecipe();
		// t.whenTheFirstRecipeIsDeleted();
		// t.thenTheDeletedRecipeNameisCoffee();

		// scenario 3 for delete
		// t.givenACoffeeMachineWithThreeRecipe();
		// t.whenTheRecipeInTheMiddleIsDeletedIsDeleted();
		// t.thenTheDeletedRecipeNameisMocha();

		// scenario 4 for delete
		// t.givenACoffeeMachineWithThreeRecipe();
		// try {
		//	t.whenTheIndexOfTheRecipeToBeDeletedIsOutOfTheRecipeBook();
		//	System.out.println("Test failed");
		// } catch (IndexOutOfBoundsException e) {
		//	t.thenIndexOutOfBoundExceptionIsRaised();
		// }

		// scenario 1 for edit
		// t.givenACoffeeMachineWithEmptyRecipeBook();
		// t.whenTryingToEditARecipeAtFirstPosition();
		// t.thenEditedRecipeNameIsNull();

		// scenario 2 for edit
		// t.givenACoffeeMachineWithThreeRecipe();
		// t.whenTryingToEditARecipeAtFirstPosition();
		// t.thenEditedRecipeNameIsUnchanged();

		// scenario 3 for edit
		t.givenACoffeeMachineWithCoffeeRecipe();
		t.whenTheQuantityOfChocolateIsEdited();
		t.thenTheQuantityOfChocolateIsIndeedEdited();
	}

}
