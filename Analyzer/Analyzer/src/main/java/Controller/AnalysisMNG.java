package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Model.AnalysisString;
import View.Menu;

public class AnalysisMNG extends Menu {
    private AnalysisString analysisString;

    public AnalysisMNG() {
        analysisString = new AnalysisString();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.print("Enter a string: ");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Map<String, Object> result = analyzeString(input);
                displayResult(result);
                break;
            case 2:
                System.out.print("Enter another string: ");
                Scanner anotherScanner = new Scanner(System.in);
                String anotherInput = anotherScanner.nextLine();
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
    }

    public Map<String, Object> analyzeString(String input) {
        Map<String, Object> result = new HashMap<>();
        result.put("perfectSquares", analysisString.getNumber(input, "perfectSquares"));
        result.put("oddNumbers", analysisString.getNumber(input, "oddNumbers"));
        result.put("evenNumbers", analysisString.getNumber(input, "evenNumbers"));
        result.put("allNumbers", analysisString.getNumber(input, "allNumbers"));
        result.put("uppercaseChars", analysisString.getCharacter(input, "uppercaseChars"));
        result.put("lowercaseChars", analysisString.getCharacter(input, "lowercaseChars"));
        result.put("specialChars", analysisString.getCharacter(input, "specialChars"));
        result.put("allChars", analysisString.getCharacter(input, "allChars"));
        return result;
    }

    private void displayResult(Map<String, Object> result) {
        System.out.println("------------ Analysis Result ------------");
        System.out.println("Perfect Squares: " + result.get("perfectSquares"));
        System.out.println("Odd Numbers: " + result.get("oddNumbers"));
        System.out.println("Even Numbers: " + result.get("evenNumbers"));
        System.out.println("All Numbers: " + result.get("allNumbers"));
        System.out.println("Uppercase Characters: " + result.get("uppercaseChars"));
        System.out.println("Lowercase Characters: " + result.get("lowercaseChars"));
        System.out.println("Special Characters: " + result.get("specialChars"));
        System.out.println("All Characters: " + result.get("allChars"));
        System.out.println("-----------------------------------------");
    }
}