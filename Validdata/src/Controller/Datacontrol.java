
package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Datacontrol {
    private Scanner scanner = new Scanner(System.in);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public  Date getDateFromInput() {
        while (true) {
            System.out.println("Date: ");
            String dateString = scanner.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.print("Invalid date format. Please enter again (dd/MM/yyyy):");
                }
            }
        }
    }
    
    public String getValidEmail(String prompt) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                return input;
            } else {
                System.out.println("Invalid Email Format.");
            }
        }
    }
    
    public String getValidPhoneNumber(String prompt) {
    String phoneRegex = "\\d{10,11}";
    Pattern pattern = Pattern.compile(phoneRegex);
    while (true) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (pattern.matcher(input).matches()) {
            return input;
        } else {
            System.out.println("Invalid Phone Number Format.");
        }
    }
}
    
}
