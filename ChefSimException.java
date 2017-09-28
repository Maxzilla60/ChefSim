// TODO: readable printstacktrace
public class ChefSimException extends Throwable{}
class IngredientNotFoundException extends ChefSimException {}
class EndOfLoopNotFoundException extends ChefSimException {}
class reloopException extends ChefSimException {}