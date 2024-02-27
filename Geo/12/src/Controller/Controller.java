
import Model.Input;
import Model.Validation;
import View.View;


public class Controller {
    private Input model;
    private View view;
    Validation vl = new Validation();
    
    public Controller(Input model, View view) {
        this.model = model;
        this.view = view;
        
    }

    public void run() {
        int choice;
        do {
            view.displayMenu();
            choice = vl.getIntAboveZeroFromInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    calculateSuperlativeEquation();
                    break;
                case 2:
                    calculateQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void calculateSuperlativeEquation() {
        double A = vl.getDoubleFromInput("Enter coefficient A: ");
        check(A);
        double B = vl.getDoubleFromInput("Enter coefficient B: ");
        check(B);
        double c=B/A;
        view.displayEvenOddSquare(c);
    }

    private void calculateQuadraticEquation() {
        double a = vl.getDoubleFromInput("Enter coefficient A: ");
        check(a);
        double b = vl.getDoubleFromInput("Enter coefficient B: ");
        check(b);
        double c = vl.getDoubleFromInput("Enter coefficient C: ");
        check(c);
        double de=  (b*b-4*a*c);
        view.displayEquation(((b-Math.sqrt(de))/c), ((b+Math.sqrt(de))/c));
    }
    public boolean isPerfectNumber(double number) {
        if (number <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }
    public void check(double num){
        if (num%2==0){
            view.displaymes(num," is a even number");
        }else
        {
            view.displaymes(num,"A is a odd number");
        }
        if (isPerfectNumber(num)){
            view.displaymes(num,"A is perfect number");
        }
    }
}

