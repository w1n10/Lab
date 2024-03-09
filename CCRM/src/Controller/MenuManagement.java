package Controller;



import View.Menu;
import View.ScreenView;
import java.util.Scanner;


public class MenuManagement extends Menu {
    ScreenView sv = new ScreenView();
    Scanner sc = new Scanner(System.in);
    public MenuManagement() {
    }

    public MenuManagement(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: 
                sv.Add();
                break;
            case 2: 
                sv.Delete();
            break;
            case 3:
                sv.viewAllTasks();
            break;
            case 4:
                System.exit(0);
        }
    }

}
