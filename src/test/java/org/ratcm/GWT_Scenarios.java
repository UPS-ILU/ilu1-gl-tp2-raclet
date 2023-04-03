package org.ratcm;

import org.ratcm.exceptions.RecipeException;

public class GWT_Scenarios {
	private CoffeeMaker cm;
	private Recipe r1, r2, r3;
	private int monnaieObtenue;
	private String deletedRecipeName, recipeNameForCoffee;

	public GWT_Scenarios() {
		cm = new CoffeeMaker();

		recipeNameForCoffee = "Coffee";

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

	private void thenLaMonnaieObtenueEstDe25() {
		assert (monnaieObtenue == 25);
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisNull() {
		assert (deletedRecipeName == null);
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisCoffee() {
		assert (deletedRecipeName.equals(recipeNameForCoffee));
		System.out.println("Test passed");
	}

	private void thenTheDeletedRecipeNameisMocha() {
		assert (deletedRecipeName.equals("Mocha"));
		System.out.println("Test passed");
	}

	private void thenIndexOutOfBoundExceptionIsRaised() {
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
		t.givenACoffeeMachineWithThreeRecipe();
		try {
			t.whenTheIndexOfTheRecipeToBeDeletedIsOutOfTheRecipeBook();
			System.out.println("Test failed");
		} catch (IndexOutOfBoundsException e) {
			t.thenIndexOutOfBoundExceptionIsRaised();
		}
	}

}
