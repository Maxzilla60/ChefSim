import java.util.ArrayList;
import java.util.List;

// Chef Recipe Maker
public class ChefRecipe {
    private Chef kitchen;
    private List<Method> methods;
    private boolean zeroBased;

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
        methods.add(new putIngredientIntoMixingBowlMethod(kitchen, ingredientName, 0));
    }
}