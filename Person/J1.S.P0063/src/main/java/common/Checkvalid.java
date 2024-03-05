package common;

import java.util.Scanner;

public class Checkvalid {

    private Scanner sc;

    public Checkvalid() {
        sc = new Scanner(System.in);
    }

    public int getInt(String mess) {
        while (true) {
            try {
                System.out.println(mess);
                int input = sc.nextInt();
                if (input >= 0 && String.valueOf(input).length() <= 6) {
                    return input;
                } else {
                    System.out.println("Vui long nhap lai:  ");
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap dung du lieu. Hay nhap lai:  ");
                sc.nextLine();
            }
        }
    }

    public String getString(String mess) {
        while (true) {
            System.out.println(mess);
            String input = sc.nextLine();
            try {
                if (input.matches("[a-zA-Z]+") && input != null) {
                    return input;
                }

            } catch (Exception e) {
                System.out.println("Vui long nhap lai: ");
                 sc.nextLine();
            }
        }
    }
    public double getDouble(String mess) {
        while (true) {
            try {
                System.out.println(mess);
                double input;
                input = sc.nextDouble();
                if (input >= 0 && String.valueOf(input).length() <= 6) {
                    return input;
                } else {
                    System.out.println("Vui long nhap lai:  ");
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap dung du lieu. Hay nhap lai:  ");
                sc.nextLine();
            }
        }
    }
     public String getOrigin(String mess) {
            System.out.println(mess);
            sc.nextLine();
            String input = sc.nextLine();;
            while(input.isEmpty())
            {
                System.out.println("Vui long nhap lai: ");
                input=sc.nextLine();
            }
            return input;
        }
     public float getFloat(String mess)
     {
         System.out.println(mess);
          
            float input = sc.nextFloat();
            
            while(!Float.isFinite(input)||input<=0)
            {
                System.out.println("Vui long nhap lai: ");
                sc.nextLine();
                input=sc.nextFloat();
            }
            return input;
     }
     public double getSalary(String mess)
     {
        double input=getDouble(mess);

         while(input<0)
         {
             System.out.println("Salary is greater than zero: ");
             System.out.print("Please input salary: ");
               sc.nextLine();
               input = sc.nextInt();
         }
        return input;
     }
     
}
    
    
