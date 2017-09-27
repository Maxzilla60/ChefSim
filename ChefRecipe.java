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
}