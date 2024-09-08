import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("===================================================");
        System.out.println("Hi! Please enter a sentence:");
        String input = scanner.nextLine();  // Read user input

        // List to store tokens
        List<String> tokens = new ArrayList<>();  // Create a list to store tokens
        String currentToken = "";  // To accumulate characters for the current token

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (isDelimiter(currentChar)) {
                if (!currentToken.isEmpty()) {
                    tokens.add(currentToken);  // Add token to the list
                    classifyAndPrintToken(currentToken);  // Print the token
                    currentToken = "";  // Reset the token
                }
                if (currentChar != ' ') {  // Skip printing spaces
                    tokens.add(Character.toString(currentChar));  // Add delimiter to the list
                    classifyAndPrintToken(Character.toString(currentChar));  // Print the delimiter
                }
            } else {
                currentToken += currentChar;  // Accumulate characters
            }
        }

        // Check if there's any remaining token
        if (!currentToken.isEmpty()) {
            tokens.add(currentToken);  // Add the last token to the list
            classifyAndPrintToken(currentToken);
        }

        scanner.close();

        // Run Phase 2
        Phase2.runPhase2(tokens);
    }

    // Method to classify and print the token
    private static void classifyAndPrintToken(String token) {
        // Ignore spaces
        if (token.equals(" ")) {
            return;  // Skip spaces
        }

        String type = classifyToken(token);
        System.out.println("Token: \"" + token + "\" - Type: " + type);
    }

    // Identify tokens as Word, Number, AlphaNumeric, Punctuation, or End of Line
    private static String classifyToken(String token) {
        if (token.matches("[a-zA-Z]+")) {
            return "Word";
        } else if (token.matches("[0-9]+(\\.[0-9]+)?")) {
            return "Number";
        } else if (token.matches("[a-zA-Z0-9]+")) {
            return "AlphaNumeric";
        } else if (".,!-".contains(token)) {
            return "Punctuation";
        } else if (token.equals("\n")) {
            return "End of Line";
        }
        return "Unknown";
    }

    // Identify delimiters (punctuation, spaces, etc.)
    private static boolean isDelimiter(char ch) {
        return " .,!-".indexOf(ch) >= 0;
    }
}
