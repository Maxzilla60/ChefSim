import java.util.*;

class Stack {
	protected List<Ingredient> ingredients;

	public Stack() {
		this.ingredients = new ArrayList<Ingredient>();
	}

	@Override
	public String toString() {
		String ingredientsString = "";
		for (Ingredient ingredient : this.ingredients) {
			ingredientsString += ingredient + "\n";
		}
		return ingredientsString;
	}

	public Ingredient search(String name) throws IngredientNotFoundException {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getName().equals(name)) {
				return ingredient;
			}
		}
		throw new IngredientNotFoundException();
	}

	public void add(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public int getDryIngredientsTotalValue() {
		int totalValue = 0;
		for (Ingredient ingredient : ingredients) {
			if (ingredient.isDry()) {
				totalValue += ingredient.getValue();
			}
		}
		return totalValue;
	}
}

class BakingDish {
	protected List<SimpleIngredient> ingredients;

	public BakingDish() {
		this.ingredients = new ArrayList<SimpleIngredient>();
	}

	@Override
	public String toString() {
		String ingredientsString = "";
		for (int i = getTopIngredientIndex(); i >= 0; i--) {
			ingredientsString += ingredients.get(i)._debugString() + "\n";
		}
		return ingredientsString;
	}

	public void pourContentsOf(BakingDish dish) {
		for (SimpleIngredient ingredient : dish.ingredients) {
			ingredients.add(ingredient);
		}
	}

	protected int getTopIngredientIndex() {
		return ingredients.size() - 1;
	}

	public void serve() {
		for (int i = ingredients.size() - 1; i >= 0; i--) {
			System.out.print(ingredients.get(i));
		}
	}
}
class MixingBowl extends BakingDish {

	public MixingBowl() {
		super();
	}

	public int getAmountOfIngredients() {
		return ingredients.size();
	}

	public boolean isEmpty() {
		return getAmountOfIngredients() <= 0;
	}

	public void add(SimpleIngredient simpleIngredient) {
		ingredients.add(simpleIngredient);
	}

	public void add(Ingredient ingredient) {
		SimpleIngredient simpleIngredient = new SimpleIngredient(ingredient);
		add(simpleIngredient);
	}

	public void add(int ingredientValue) {
		SimpleIngredient simpleIngredient = new SimpleIngredient(ingredientValue);
		add(simpleIngredient);
	}

	public void removeLastIngredient() {
		ingredients.remove(getTopIngredientIndex());
	}

	private SimpleIngredient getTopIngredient() {
		return ingredients.get(getTopIngredientIndex());
	}

	public int getTopIngredientValue() {
		return getTopIngredient().getValue();
	}

	public void liquefyAllIngredients() {
		for (SimpleIngredient ingredient : ingredients) {
			ingredient.liquefy();
		}
	}

	public void stir(int minutes) {
		if (isEmpty() || minutes <= 0) {
			return;
		}
		int newIndexForTopIngredient = getTopIngredientIndex() - minutes;
		if (newIndexForTopIngredient < 0) newIndexForTopIngredient = 0;

		List<SimpleIngredient> newIngredientsList = new ArrayList<SimpleIngredient>();
		int newIngredientsListIndex = 0;
		for (int i = 0; i < getTopIngredientIndex(); i++) {
			if (newIngredientsListIndex == newIndexForTopIngredient) {
				newIngredientsList.add(getTopIngredient());
			}
			newIngredientsList.add(ingredients.get(i));
			newIngredientsListIndex++;
		}
		ingredients = newIngredientsList;
	}

	public void mixWell() {
		long seed = System.nanoTime();
		Collections.shuffle(ingredients, new Random(seed));
	}

	public void clean() {
		ingredients.clear();
	}
}