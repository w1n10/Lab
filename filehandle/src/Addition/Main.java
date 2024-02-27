
package Addition;


import View.MainMenu;

public class Main {
    public static void main(String[] args) {
        String[] mchon = {"Find person info","Copy Text to new file","Exit"};
        MainMenu MenuManager = new MainMenu("=== File Processing ===", mchon);
        MenuManager.run();
        
    }
}
