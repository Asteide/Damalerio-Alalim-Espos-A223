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
        System.out.println("Phase 1 Output:");

        // List to store tokens
        List<String> tokens = new ArrayList<>();  // Create a list to store tokens
        String currentToken = "";  // To accumulate characters for the current token

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (isDelimiter(currentChar)) {
                if (!currentToken.isEmpty()) {
                    tokens.add(currentToken);  // Add token to the list
                    currentToken = "";  // Reset the token
                }
                if (currentChar != ' ') {  // Skip spaces
                    tokens.add(Character.toString(currentChar));  // Add delimiter to the list
                }
            } else {
                currentToken += currentChar;  // Accumulate characters
            }
        }

        // Check if there's any remaining token
        if (!currentToken.isEmpty()) {
            tokens.add(currentToken);  // Add the last token to the list
        }

        // Print tokens
        for (String token : tokens) {
            classifyAndPrintToken(token);  // Print each token
        }

        // Always print the end-of-line token at the end
        System.out.println("Token: \"\\n\" - Type: End of Line");

        scanner.close();

        // Run Phase 2
        Phase2.runPhase2(tokens);  // Pass the list of tokens to Phase2
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
        } else if (".,!-:".contains(token)) {
            return "Punctuation";
        }
        return "Unknown";
    }

    // Identify delimiters (punctuation, spaces, etc.)
    private static boolean isDelimiter(char ch) {
        return " .,!-:".indexOf(ch) >= 0;
    }
}
