package com.company;

enum Measure {
	G(IngredientType.DRY, "g"), KG(IngredientType.DRY, "kg"), PINCH(IngredientType.DRY, "pinch", "pinches"),
	ML(IngredientType.LIQUID, "ml"), L(IngredientType.LIQUID, "l"), DASH(IngredientType.LIQUID, "dash", "dashes"),
	CUP(IngredientType.ANY, "cup", "cups"), TEASPOON(IngredientType.ANY, "teaspoon", "teaspoons"), TABLESPOON(IngredientType.ANY, "tablespoon", "tablespoons");

	private final IngredientType type;
	private final String singularString; // TODO: Remove
	private final String pluralString;

	Measure(IngredientType type, String singular) {
		this(type, singular, singular);
	}
	Measure(IngredientType type, String singular, String plural) {
		this.type = type;
		this.singularString = singular;
		this.pluralString = plural;
	}

	public boolean isDry() {
		if (isAny()) return true;
		return this.type == IngredientType.DRY;
	}

	public boolean isLiquid() {
		if (isAny()) return true;
		return this.type == IngredientType.LIQUID;
	}

	public boolean isAny() {
		return this.type == IngredientType.ANY;
	}

	@Override
	public String toString() {
		return this.pluralString;
	}

	public IngredientType getType() {
		return this.type;
	}
}
enum IngredientType {
	DRY, LIQUID, ANY
}