interface MethodExecutable {
    public void exec() throws IngredientNotFoundException;
}
public abstract class Method implements MethodExecutable {
    protected Chef kitchen;
	// TODO: Put ingredientName & mixingBowlIndex here?
	
	protected Method(Chef kitchen) {
		this.kitchen = kitchen;
	}
}
class takeIngredientFromRefrigeratorMethod extends Method {
    private final String ingredientName;

    public takeIngredientFromRefrigeratorMethod(Chef kitchen, String ingredientName) {
        super(kitchen);
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
        super(kitchen);
        this.ingredientName = ingredientName;
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.putIngredientIntoMixingBowl(ingredientName, mixingBowlIndex);
    }
}
class foldIngredientIntoMixingBowlMethod extends Method {
	private final String ingredientName;
	private final int mixingBowlIndex;
	
	public foldIngredientIntoMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
		super(kitchen);
		this.ingredientName = ingredientName;
		this.mixingBowlIndex = mixingBowlIndex;
	}
	
	public void exec() {
		kitchen.foldIngredientIntoMixingBowl(ingredientName, mixingBowlIndex);
	}
}
class addIngredientToMixingBowlMethod extends Method {
	private final String ingredientName;
	private final int mixingBowlIndex;
	
	public addIngredientToMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
		super(kitchen);
		this.ingredientName = ingredientName;
		this.mixingBowlIndex = mixingBowlIndex;
	}
	
	public void exec() {
		kitchen.addIngredientToMixingBowl(ingredientName, mixingBowlIndex);
	}
}
class removeIngredientToMixingBowlMethod extends Method {
	private final String ingredientName;
	private final int mixingBowlIndex;
	
	public removeIngredientToMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
		super(kitchen);
		this.ingredientName = ingredientName;
		this.mixingBowlIndex = mixingBowlIndex;
	}
	
	public void exec() {
		kitchen.removeIngredientToMixingBowl(ingredientName, mixingBowlIndex);
	}
}
class combineIngredientToMixingBowlMethod extends Method {
	private final String ingredientName;
	private final int mixingBowlIndex;
	
	public combineIngredientToMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
		super(kitchen);
		this.ingredientName = ingredientName;
		this.mixingBowlIndex = mixingBowlIndex;
	}
	
	public void exec() {
		kitchen.combineIngredientToMixingBowl(ingredientName, mixingBowlIndex);
	}
}
class devideIngredientToMixingBowlMethod extends Method {
	private final String ingredientName;
	private final int mixingBowlIndex;
	
	public devideIngredientToMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
		super(kitchen);
		this.ingredientName = ingredientName;
		this.mixingBowlIndex = mixingBowlIndex;
	}
	
	public void exec() {
		kitchen.devideIngredientToMixingBowl(ingredientName, mixingBowlIndex);
	}
}