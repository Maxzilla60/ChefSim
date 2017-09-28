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
	
	public void exec() throws IngredientNotFoundException {
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
	
	public void exec() throws IngredientNotFoundException {
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
	
	public void exec() throws IngredientNotFoundException {
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
	
	public void exec() throws IngredientNotFoundException {
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
	
	public void exec() throws IngredientNotFoundException {
		kitchen.devideIngredientToMixingBowl(ingredientName, mixingBowlIndex);
	}
}
class addDryIngredientsToMixingBowlMethod extends Method {
    private final int mixingBowlIndex;

    public addDryIngredientsToMixingBowlMethod(Chef kitchen, int mixingBowlIndex) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.addDryIngredientsToMixingBowl(mixingBowlIndex);
    }
}
class liquefyIngredientMethod extends Method {
    private final String ingredientName;

    public liquefyIngredientMethod(Chef kitchen, String ingredientName) {
        super(kitchen);
        this.ingredientName = ingredientName;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.liquefyIngredient(ingredientName);
    }
}
class liquefyContentsOfTheMixingBowlMethod extends Method {
    private final int mixingBowlIndex;

    public liquefyContentsOfTheMixingBowlMethod(Chef kitchen, int mixingBowlIndex) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.liquefyContentsOfTheMixingBowl(mixingBowlIndex);
    }
}
class stirTheMixingBowlForMinutesMethod extends Method {
    private final int mixingBowlIndex;
    private final int minutes;

    public stirTheMixingBowlForMinutesMethod(Chef kitchen, int mixingBowlIndex, int minutes) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
        this.minutes = minutes;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.stirTheMixingBowlForMinutes(mixingBowlIndex, minutes);
    }
}
class mixMixingBowlWellMethod extends Method {
    private final int mixingBowlIndex;

    public mixMixingBowlWellMethod(Chef kitchen, int mixingBowlIndex) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.mixMixingBowlWell(mixingBowlIndex);
    }
}
class cleanMixingBowlMethod extends Method {
    private final int mixingBowlIndex;

    public cleanMixingBowlMethod(Chef kitchen, int mixingBowlIndex) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.cleanMixingBowl(mixingBowlIndex);
    }
}
class pourContentsOfMixingBowlIntoBakingDishMethod extends Method {
    private final int mixingBowlIndex;
    private final int bakingDishIndex;

    public pourContentsOfMixingBowlIntoBakingDishMethod(Chef kitchen, int mixingBowlIndex, int bakingDishIndex) {
        super(kitchen);
        this.mixingBowlIndex = mixingBowlIndex;
        this.bakingDishIndex = bakingDishIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.pourContentsOfMixingBowlIntoBakingDish(mixingBowlIndex, bakingDishIndex);
    }
}