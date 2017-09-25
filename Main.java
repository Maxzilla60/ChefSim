public class Main {
	public static void main(String[] args) {
		try {
			Chef chef = new Chef("Testing Toast");

			chef.initIngredient(25, Measure.L, "Honey");
			chef.initIngredient(70, Measure.CUP, "Coffee");
			chef.initIngredient(10, Measure.G, "Cheetos");
			chef.initIngredient(9, Measure.KG, "Chicken");

			//chef.takeIngredientFromRefrigerator("Cheetos");

			chef.putIngredientIntoMixingBowl("Chicken");
			//chef.putIngredientIntoMixingBowl("Cheetos", 4);
			chef.putIngredientIntoMixingBowl("Honey");
			chef.putIngredientIntoMixingBowl("Coffee");
			chef.putIngredientIntoMixingBowl("Cheetos");
			//chef._printMixingBowls();

			//chef.foldIngredientIntoMixingBowl("Chicken");

			//chef.addIngredientToMixingBowl("Cheetos");
			//chef.removeIngredientToMixingBowl("Chicken");

			//chef.addDryIngredientsToMixingBowl();

			//chef.liquefyIngredient("Chicken");

			//chef.liquefyContentsOfTheMixingBowl();

			//chef.stirTheMixingBowlForMinutes(1);

			//chef.mixMixingBowlWell();

			chef._printIngredients();
			chef._printMixingBowls();
		} catch (IngredientNotFoundException e) {
			e.printStackTrace();
		}
	}
}
