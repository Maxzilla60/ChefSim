interface MethodExecutable {
    public void exec() throws IngredientNotFoundException;
}
public abstract class Method implements MethodExecutable {
    protected Chef kitchen;
}
class takeIngredientFromRefrigeratorMethod extends Method {
    private final String ingredientName;

    public takeIngredientFromRefrigeratorMethod(Chef kitchen, String ingredientName) {
        this.kitchen = kitchen;
        this.ingredientName = ingredientName;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.takeIngredientFromRefrigerator(ingredientName);
    }
}
class putIngredientIntoMixingBowlMethod extends Method {
    private final String ingredientName;
    private final int mixingBowlIndex;

    public putIngredientIntoMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
        this.kitchen = kitchen;
        this.ingredientName = ingredientName;
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.putIngredientIntoMixingBowl(ingredientName, mixingBowlIndex);
    }
}