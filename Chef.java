import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Chef "engine"
public class Chef {
	private String title;
	private Stack ingredients;
	private List<BakingDish> dishes;
	private List<MixingBowl> bowls;

	public Chef(String title) {
		this.title = title;
		this.ingredients = new Stack();
		this.dishes = new ArrayList<BakingDish>();
		this.bowls = new ArrayList<MixingBowl>();
	}

	public void initIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

	public void initIngredient(int value, Measure measure, String name) /*throws InvalidMeasureException*/ {
		if (measure.isAny()) {
			initIngredient(new Ingredient(value, measure, name));
		}
		else if (measure.isDry()) {
			initIngredient(new DryIngredient(value, measure, name));
		}
		else if (measure.isLiquid()) {
			initIngredient(new LiquidIngredient(value, measure, name));
		}
		/*else {
			throw new InvalidMeasureException();
		}*/
	}

	// Methods:
	// ---

	public void takeIngredientFromRefrigerator(String ingredientName) throws IngredientNotFoundException {
		Ingredient ingredient = ingredients.search(ingredientName);

		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();

		ingredient.setValue(value);
	}

	public void putIngredientIntoMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);
		bowls.get(mixingBowlIndex).add(ingredient);
	}

	public void foldIngredientIntoMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);

		// TODO: Put logic in MixingBowl?
		int topValue = bowls.get(mixingBowlIndex).getTopIngredientValue();
		ingredient.setValue(topValue);
		bowls.get(mixingBowlIndex).removeLastIngredient();
	}

	public void addIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);

		int topValue = bowls.get(mixingBowlIndex).getTopIngredientValue();
		int sum = topValue + ingredient.getValue();
		bowls.get(mixingBowlIndex).add(sum);
	}

	public void removeIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);

		int topValue = bowls.get(mixingBowlIndex).getTopIngredientValue();
		int difference = topValue - ingredient.getValue();
		bowls.get(mixingBowlIndex).add(difference);
	}

	public void combineIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);

		int topValue = bowls.get(mixingBowlIndex).getTopIngredientValue();
		int product = ingredient.getValue() * topValue;
		bowls.get(mixingBowlIndex).add(product);
	}

	public void devideIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) throws IngredientNotFoundException {
		checkMixingBowl(mixingBowlIndex);
		Ingredient ingredient = ingredients.search(ingredientName);

		int topValue = bowls.get(mixingBowlIndex).getTopIngredientValue();
		int quotient = ingredient.getValue() / topValue;
		bowls.get(mixingBowlIndex).add(quotient);
	}

	public void addDryIngredientsToMixingBowl(int mixingBowlIndex) {
		checkMixingBowl(mixingBowlIndex);

		// TODO: Put logic in MixingBowl?
		int totalDryValue = getDryIngredientsTotalValue();
		bowls.get(mixingBowlIndex).add(new SimpleIngredient(totalDryValue, IngredientType.DRY));
	}

	public void liquefyIngredient(String ingredientName) throws IngredientNotFoundException {
		Ingredient ingredient = ingredients.search(ingredientName);
		ingredient.liquefy();
	}

	public void liquefyContentsOfTheMixingBowl(int mixingBowlIndex) {
		checkMixingBowl(mixingBowlIndex);

		bowls.get(mixingBowlIndex).liquefyAllIngredients();
	}

	public void stirTheMixingBowlForMinutes(int mixingBowlIndex, int minutes) {
		checkMixingBowl(mixingBowlIndex);
		// TODO: Check minutes > 0?
		bowls.get(mixingBowlIndex).stir(minutes);
	}

	public void mixMixingBowlWell(int mixingBowlIndex) {
		checkMixingBowl(mixingBowlIndex);

		bowls.get(mixingBowlIndex).mixWell();
	}

	public void cleanMixingBowl(int mixingBowlIndex) {
		checkMixingBowl(mixingBowlIndex);

		bowls.get(mixingBowlIndex).clean();
	}

	public void pourContentsOfMixingBowlIntoBakingDish(int mixingBowlIndex, int bakingDishIndex) {
		checkMixingBowl(mixingBowlIndex);
		checkBakingDish(bakingDishIndex);

		dishes.get(bakingDishIndex).pourContentsOf(bowls.get(mixingBowlIndex));
	}

	// Private
	// ---

	// TODO: mixingBowlIndex - 1
	private void checkMixingBowl(int mixingBowlIndex) {
		if (!mixingBowlExists(mixingBowlIndex)) {
			createMixingBowl(mixingBowlIndex);
		}
	}

	private void createMixingBowl(int mixingBowlIndex) {
		while (bowls.size() - 1 < mixingBowlIndex) {
			bowls.add(new MixingBowl());
		}
	}

	private boolean mixingBowlExists(int mixingBowlIndex) {
		return mixingBowlIndex < bowls.size();
	}

	// TODO: bakingDishIndex - 1
	private void checkBakingDish(int bakingDishIndex) {
		if (!bakingDishExists(bakingDishIndex)) {
			createBakingDish(bakingDishIndex);
		}
	}

	private void createBakingDish(int bakingDishIndex) {
		while (dishes.size() - 1 < bakingDishIndex) {
			dishes.add(new BakingDish());
		}
	}

	private boolean bakingDishExists(int bakingDishIndex) {
		return bakingDishIndex < dishes.size();
	}

	private String getIngredientsString() {
		return "Ingredients.\n" + ingredients;
	}

	private int getDryIngredientsTotalValue() {
		return ingredients.getDryIngredientsTotalValue();
	}

	// Debug
	//	---

	public void _printIngredients() {
		System.out.println("Ingredients:\n-------------");
		System.out.print(ingredients);
		System.out.println("-------------");
	}

	public void _printMixingBowls() {
		System.out.println("Mixing bowls:\n-------------");
		for (int i = 0; i < bowls.size(); i++) {
			System.out.println("Mixing Bowl " + i + ":");
			System.out.println(bowls.get(i));
		}
		System.out.println("-------------");
	}

	public void _printBakingDishes() {
		System.out.println("Baking dishes:\n-------------");
		for (int i = 0; i < dishes.size(); i++) {
			System.out.println("Baking dish " + i + ":");
			System.out.println(dishes.get(i));
		}
		System.out.println("-------------");
	}

	public void serves(int bakingDishesAmount) {
		for (int i = 0; i < bakingDishesAmount; i++) {
			dishes.get(i).serve();
		}
	}
}