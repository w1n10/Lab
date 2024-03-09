
import Controller.MenuManagement;

public class Main {
    public static void main(String[] args) {
        String[] mchon = {"Add Task","Delete Task","Display Task","Exit"};
        MenuManagement MenuManager = new MenuManagement("=== Task Program ===", mchon);
        MenuManager.run();
        
    }
}