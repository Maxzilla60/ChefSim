// TODO: readable printstacktrace
public class ChefSimException extends Throwable {}
class IngredientNotFoundException extends ChefSimException {}
class EndOfLoopNotFoundException extends ChefSimException {}
class StartOfLoopNotFoundException extends ChefSimException {}
class reloopNotification extends ChefSimException {
    public String verb;
    public reloopNotification(String verb) {
        super();
        this.verb = verb;
    }
}
class endLoopNotification extends ChefSimException {
    public String verb;
    public endLoopNotification(String verb) {
        super();
        this.verb = verb;
    }
}