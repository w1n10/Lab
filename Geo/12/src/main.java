
import Model.Input;
import Model.Validation;
import View.View;
public class main {
       public static void main(String[] args) {
        Input model = new Input();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
