package View;


import Controller.FileController;
import java.util.Scanner;
import View.Menu;


public class MainMenu extends Menu {


    public MainMenu() {
    }

    public MainMenu(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        FileController cr = new FileController();
         switch (n) {
        case 1: 
            cr.Function1();
            break;
        case 2: 
            System.out.println("------------- Copy text --------------");
            cr.getFilePathInput();
            break;
        case 3:
            System.exit(0);
    }
    }

}
