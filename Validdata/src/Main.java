
import Controller.MenuManagement;

public class Main {
    public static void main(String[] args) {
        String[] mchon = {"Email Checking","Phone Checking","Date Checking","Exit"};
        MenuManagement MenuManager = new MenuManagement("=== Validate Progaram ===", mchon);
        MenuManager.run();
        
    }
}