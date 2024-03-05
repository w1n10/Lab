package Controller;



import Model.Datainput;
import View.Menu;
import java.util.Scanner;


public class MenuManagement extends Menu {
    Scanner sc = new Scanner(System.in);
    Datainput di = new Datainput();
    public MenuManagement() {
    }

    public MenuManagement(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: 
                di.Email();
                break;
            case 2: 
                di.Phone();
            break;
            case 3:
                di.Date();
            break;
            case 4:
                System.exit(0);
        }
    }

}
