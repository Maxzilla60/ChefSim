import java.util.ArrayList;
import java.util.List;

// Chef Recipe Maker
public class ChefRecipe {
    private Chef kitchen;
    private List<Method> methods;
    private boolean zeroBased; // TODO

    public ChefRecipe(String title) {
        this(title, false);
    }

    public ChefRecipe(String title, boolean zeroBased_flag) {
        this.kitchen = new Chef(title);
        this.methods = new ArrayList<Method>();
        this.zeroBased = zeroBased_flag;
    }

    public void initIngredient(Ingredient ingredient) {
        kitchen.initIngredient(ingredient);
    }

    public void initIngredient(int value, Measure measure, String name) {
        kitchen.initIngredient(value, measure, name);
    }

    @Override
    public String toString() {
        String recipeString = "";
        recipeString += kitchen.getIngredientsString() + "\n";
        recipeString += getMethodsString();
        return recipeString;
    }

    private String getMethodsString() {
        String methodsString = "";
        for (Method method : methods) {
            methodsString += method + " ";
        }
        return methodsString;
    }

    public void cook() throws IngredientNotFoundException, EndOfLoopNotFoundException, StartOfLoopNotFoundException {
        for (int i = 0; i < methods.size(); i++) {
            try {
                methods.get(i).exec();
            }
            catch (endLoopNotification e) {
                i = endLoopForVerb(e.verb, i);
            }
            catch (reloopNotification e) {
                i = reloopForVerb(e.verb, i);
            }
        }
    }

    // Methods:
    // -------

    public void takeIngredientFromRefrigerator(String ingredientName) {
        methods.add(new takeIngredientFromRefrigeratorMethod(kitchen, ingredientName));
    }

    public void putIngredientIntoMixingBowl(String ingredientName, int mixingBowlIndex) {
        methods.add(new putIngredientIntoMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
    }

    public void putIngredientIntoMixingBowl(String ingredientName) {
        putIngredientIntoMixingBowl(ingredientName, 0);
    }

	public void foldIngredientIntoMixingBowl(String ingredientName, int mixingBowlIndex) {
		methods.add(new foldIngredientIntoMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
	}

	public void foldIngredientIntoMixingBowl(String ingredientName) {
		foldIngredientIntoMixingBowl(ingredientName, 0);
	}

	public void addIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) {
		methods.add(new addIngredientToMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
	}

	public void addIngredientToMixingBowl(String ingredientName) {
		addIngredientToMixingBowl(ingredientName, 0);
	}

	public void removeIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) {
		methods.add(new removeIngredientToMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
	}

	public void removeIngredientToMixingBowl(String ingredientName) {
		removeIngredientToMixingBowl(ingredientName, 0);
	}

	public void combineIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) {
		methods.add(new combineIngredientToMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
	}

	public void combineIngredientToMixingBowl(String ingredientName) {
		combineIngredientToMixingBowl(ingredientName, 0);
	}

	public void devideIngredientToMixingBowl(String ingredientName, int mixingBowlIndex) {
		methods.add(new devideIngredientToMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
	}

	public void devideIngredientToMixingBowl(String ingredientName) {
		devideIngredientToMixingBowl(ingredientName, 0);
	}

    public void addDryIngredientsToMixingBowl(int mixingBowlIndex) {
        methods.add(new addDryIngredientsToMixingBowlMethod(kitchen, mixingBowlIndex));
    }

    public void liquefyIngredient(String ingredientName) throws IngredientNotFoundException {
        methods.add(new liquefyIngredientMethod(kitchen, ingredientName));
    }

    public void liquefyContentsOfTheMixingBowl(int mixingBowlIndex) {
        methods.add(new liquefyContentsOfTheMixingBowlMethod(kitchen, mixingBowlIndex));
    }

    public void liquefyContentsOfTheMixingBowl() {
        liquefyContentsOfTheMixingBowl(0);
    }

    public void stirTheMixingBowlForMinutes(int mixingBowlIndex, int minutes) {
        methods.add(new stirTheMixingBowlForMinutesMethod(kitchen, mixingBowlIndex, minutes));
    }

    public void stirTheMixingBowlForMinutes(int minutes) {
        stirTheMixingBowlForMinutes(0, minutes);
    }

    public void stirIngredientIntoMixingBowl(String ingredientName, int mixingBowlIndex) {
        methods.add(new stirIngredientIntoMixingBowlMethod(kitchen, ingredientName, mixingBowlIndex));
    }

    public void mixMixingBowlWell(int mixingBowlIndex) {
        methods.add(new mixMixingBowlWellMethod(kitchen, mixingBowlIndex));
    }

    public void mixMixingBowlWell() {
        mixMixingBowlWell(0);
    }

    public void cleanMixingBowl(int mixingBowlIndex) {
        methods.add(new cleanMixingBowlMethod(kitchen, mixingBowlIndex));
    }

    public void cleanMixingBowl() {
        cleanMixingBowl(0);
    }

    public void pourContentsOfMixingBowlIntoBakingDish(int mixingBowlIndex, int bakingDishIndex) {
        methods.add(new pourContentsOfMixingBowlIntoBakingDishMethod(kitchen, mixingBowlIndex, bakingDishIndex));
    }

    public void serves(int bakingDishesAmount) {
        methods.add(new servesMethod(kitchen, bakingDishesAmount));
    }

    // Looping:
    // ------

    public void verbIngredient(String verb, String ingredientName) {
        methods.add(new verbIngredient(kitchen, verb, ingredientName));
    }

    // TODO: make ingredientName optional
    public void verbIngredientUntilVerbed(String verb, String ingredientName) {
        methods.add(new verbIngredientUntilVerbed(kitchen, verb, ingredientName));
    }

    public int reloopForVerb(String verb, int currentIndex) throws StartOfLoopNotFoundException {
        for (int i = currentIndex; i >= 0; i--) {
            if (methods.get(i) instanceof verbIngredient && methods.get(i).getVerb().equals(verb)) {
                return i - 1;
            }
        }
        throw new StartOfLoopNotFoundException();
    }

    public int endLoopForVerb(String verb, int currentIndex) throws EndOfLoopNotFoundException {
        for (int i = currentIndex; i < methods.size(); i++) {
            if (methods.get(i) instanceof verbIngredientUntilVerbed && methods.get(i).getVerb().equals(verb)) {
                return i;
            }
        }
        throw new EndOfLoopNotFoundException();
    }
}