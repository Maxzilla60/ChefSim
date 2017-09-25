import java.util.Random;

class Ingredient {
	private String name;
	private int value;
	private Measure measure;

	public Ingredient(int value, Measure measure, String name) {
		this.value = value;
		this.measure = measure;
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + value + " " + measure + " " + name;
	}

	public String getName() {
		return name;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public IngredientType getType() {
		return measure.getType();
	}

	public boolean isDry() {
		return true;
	}

	public void liquefy() {
		Measure[] liquidMeasures = {Measure.L, Measure.ML, Measure.DASH};
		int randomIndex = new Random().nextInt(liquidMeasures.length);
		measure = liquidMeasures[randomIndex];
	}
}
class DryIngredient extends Ingredient{
	@Override
	public boolean isDry() {
		return true;
	}

	public DryIngredient(int value, Measure measure, String name) {
		super(value, measure, name);
	}
}
class LiquidIngredient extends  Ingredient {
	public LiquidIngredient(int value, Measure measure, String name) {
		super(value, measure, name);
	}

	@Override
	public boolean isDry() {
		return false;
	}

	@Override
	public void liquefy() {
		return;
	}
}

class SimpleIngredient {
	private int value;
	private IngredientType type;

	public SimpleIngredient(int value, IngredientType type) {
		this.value = value;
		this.type = type;
	}

	@Override
	public String toString() {
		if (type == IngredientType.DRY || type == IngredientType.ANY) {return ""+value;}
		else {return ""+(char)value;}
	}

	public SimpleIngredient(int value) {
		this(value, IngredientType.ANY);
	}

	public SimpleIngredient(Ingredient ingredient) {
		this.value = ingredient.getValue();
		this.type = ingredient.getType();
	}

	public String _debugString() {
		return value + " " + type;
	}

	public void liquefy() {
		type = IngredientType.LIQUID;
	}

	public int getValue() {
		return value;
	}

	public IngredientType getType() {
		return type;
	}

	public void setValue(int value) {
		this.value = value;
	}
}