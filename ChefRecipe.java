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

    public void cook() throws IngredientNotFoundException {
        for (int i = 0; i < methods.size(); i++) {
            methods.get(i).exec();
        }
    }

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

    public void startLoop(String verb, String ingredientName) {
        methods.add(new loopStartMethod(kitchen, verb, ingredientName));
    }
}