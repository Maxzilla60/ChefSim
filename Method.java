// TODO: st, nd, rd, th, ...
interface MethodExecutable {
    public void exec() throws IngredientNotFoundException, reloopNotification, endLoopNotification;
}
public abstract class Method implements MethodExecutable {
    protected Chef kitchen;

    protected Method(Chef kitchen) {
        this.kitchen = kitchen;
    }

    public String getVerb() {
        return null;
    }

    public String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
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

    @Override
    public String toString() {
        return "Take " + ingredientName + " from refrigerator.";
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

    @Override
    public String toString() {
        String output = "Put " + ingredientName + " into ";
        if (mixingBowlIndex != 0) {
            output += mixingBowlIndex + "th ";
        }
        output += "mixing bowl.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Fold " + ingredientName + " into ";
        if (mixingBowlIndex != 0) {
            output += mixingBowlIndex + "th ";
        }
        output += "mixing bowl.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Add " + ingredientName;
        if (mixingBowlIndex != 0) {
            output += " to " + mixingBowlIndex + "th mixing bowl";
        }
        output += ".";
        return  output;
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

    @Override
    public String toString() {
        String output = "Remove " + ingredientName;
        if (mixingBowlIndex != 0) {
            output += " from " + mixingBowlIndex + "th mixing bowl";
        }
        output += ".";
        return  output;
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

    @Override
    public String toString() {
        String output = "Combine " + ingredientName;
        if (mixingBowlIndex != 0) {
            output += " into " + mixingBowlIndex + "th mixing bowl";
        }
        output += ".";
        return  output;
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

    @Override
    public String toString() {
        String output = "Devide " + ingredientName;
        if (mixingBowlIndex != 0) {
            output += " into " + mixingBowlIndex + "th mixing bowl";
        }
        output += ".";
        return  output;
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

    @Override
    public String toString() {
        String output = "Add dry ingredients";
        if (mixingBowlIndex != 0) {
            output += " to " + mixingBowlIndex + "th mixing bowl";
        }
        output += ".";
        return  output;
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

    @Override
    public String toString() {
        return "Liquefy " + ingredientName + ".";
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

    @Override
    public String toString() {
        String output = "Liquefy contents of the ";
        if (mixingBowlIndex != 0) {
            output += "" + mixingBowlIndex + "th ";
        }
        output += "mixing bowl.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Stir ";
        if (mixingBowlIndex != 0) {
            output += "the " + mixingBowlIndex + "th mixing bowl ";
        }
        output += "for " + minutes + " minutes.";
        return  output;
    }
}
class stirIngredientIntoMixingBowlMethod extends Method {
    private final String ingredientName;
    private final int mixingBowlIndex;

    public stirIngredientIntoMixingBowlMethod(Chef kitchen, String ingredientName, int mixingBowlIndex) {
        super(kitchen);
        this.ingredientName = ingredientName;
        this.mixingBowlIndex = mixingBowlIndex;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.stirIngredientIntoMixingBowl(ingredientName, mixingBowlIndex);
    }

    @Override
    public String toString() {
        String output = "Stir " + ingredientName + " into the ";
        if (mixingBowlIndex != 0) {
            output += "" + mixingBowlIndex + "th ";
        }
        output += "mixing bowl.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Mix ";
        if (mixingBowlIndex != 0) {
            output += "the " + mixingBowlIndex + "th mixing bowl ";
        }
        output += "well.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Clean ";
        if (mixingBowlIndex != 0) {
            output += "" + mixingBowlIndex + "th ";
        }
        output += "mixing bowl.";
        return  output;
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

    @Override
    public String toString() {
        String output = "Pour contents of the ";
        if (mixingBowlIndex != 0) {
            output += "" + mixingBowlIndex + "th ";
        }
        output += "mixing bowl into the ";
        if (bakingDishIndex != 0) {
            output += "" + bakingDishIndex + "th ";
        }
        output += "baking dish.";
        return  output;
    }
}
class servesMethod extends Method {
    private final int bakingDishesAmount;

    public servesMethod(Chef kitchen, int bakingDishesAmount) {
        super(kitchen);
        this.bakingDishesAmount = bakingDishesAmount;
    }

    public void exec() throws IngredientNotFoundException {
        kitchen.serves(bakingDishesAmount);
    }

    @Override
    public String toString() {
        return "\nServes " + bakingDishesAmount + ".";
    }
}

class verbIngredient extends Method {
    private final String verb;
    private final String ingredientName;

    public verbIngredient(Chef kitchen, String verb, String ingredientName) {
        super(kitchen);
        this.verb = verb;
        this.ingredientName = ingredientName;
    }

    public void exec() throws IngredientNotFoundException, endLoopNotification {
        if (kitchen.ingredientIsZero(ingredientName)) {
            throw new endLoopNotification(verb);
        }
    }

    @Override
    public String toString() {
        return "" + capitalize(verb) + " the " + ingredientName + ".";
    }

    @Override
    public String getVerb() {
        return verb;
    }
}
class verbIngredientUntilVerbed extends Method {
    private final String verb;
    private final String ingredientName;

    public verbIngredientUntilVerbed(Chef kitchen, String verb, String ingredientName) {
        super(kitchen);
        this.verb = verb;
        this.ingredientName = ingredientName;
    }

    public void exec() throws IngredientNotFoundException, reloopNotification {
        kitchen.decrementIngredient(ingredientName);
        throw new reloopNotification(verb);
    }

    @Override
    public String toString() {
        return "" + capitalize(verb) + " the " + ingredientName + " until " + verb + "ed.";
    }

    @Override
    public String getVerb() {
        return verb;
    }
}