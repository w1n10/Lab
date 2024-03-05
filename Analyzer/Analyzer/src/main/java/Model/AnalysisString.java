package Model;

import java.util.ArrayList;
import java.util.List;

public class AnalysisString {
    public List<Integer> getNumber(String input, String type) {
        List<Integer> numbers = extractNumbers(input);
        List<Integer> result = new ArrayList<>();

        switch (type) {
            case "perfectSquares":
                for (int number : numbers) {
                    if (isPerfectSquare(number)) {
                        result.add(number);
                    }
                }
                break;
            case "oddNumbers":
                for (int number : numbers) {
                    if (number % 2 != 0) {
                        result.add(number);
                    }
                }
                break;
            case "evenNumbers":
                for (int number : numbers) {
                    if (number % 2 == 0) {
                        result.add(number);
                    }
                }
                break;
            case "allNumbers":
                result.addAll(numbers);
                break;
        }

        return result;
    }

    public StringBuilder getCharacter(String input, String type) {
        StringBuilder characters = new StringBuilder(input);
        StringBuilder result = new StringBuilder();

        switch (type) {
            case "uppercaseChars":
                for (int i = 0; i < characters.length(); i++) {
                    char c = characters.charAt(i);
                    if (Character.isUpperCase(c)) {
                        result.append(c);
                    }
                }
                break;
            case "lowercaseChars":
                for (int i = 0; i < characters.length(); i++) {
                    char c = characters.charAt(i);
                    if (Character.isLowerCase(c)) {
                        result.append(c);
                    }
                }
                break;
            case "specialChars":
                for (int i = 0; i < characters.length(); i++) {
                    char c = characters.charAt(i);
                    if (!Character.isLetterOrDigit(c)) {
                        result.append(c);
                    }
                }
                break;
            case "allChars":
                result.append(characters);
                break;
        }

        return result;
    }

    private List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split("[^0-9]+");

        for (String part : parts) {
            if (!part.isEmpty()) {
                numbers.add(Integer.parseInt(part));
            }
        }

        return numbers;
    }

    private boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}