// TODO: readable printstacktrace
public class ChefSimException extends Throwable{}
class IngredientNotFoundException extends ChefSimException {}
class EndOfLoopNotFoundException extends ChefSimException {}
class StartOfLoopNotFoundException extends ChefSimException {}
class reloopException extends ChefSimException {
    public String verb;
    public reloopException(String verb) {
        super();
        this.verb = verb;
    }
}
class endLoopException extends ChefSimException {
    public String verb;
    public endLoopException(String verb) {
        super();
        this.verb = verb;
    }
}