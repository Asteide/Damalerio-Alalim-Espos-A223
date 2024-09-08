import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("===================================================");
        System.out.println("Hi! Please enter a sentence:");
        String input = scanner.nextLine();  // Read user input

        String currentToken = "";  // To accumulate characters for the current token

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (isDelimiter(currentChar)) {
                if (!currentToken.isEmpty()) {
                    classifyAndPrintToken(currentToken);  // Print the token
                    currentToken = "";  // Mag reset sa token
                }
                if (currentChar != ' ') {  // Skip printing spaces
                    classifyAndPrintToken(Character.toString(currentChar));  // Print the delimiter
                }
            } else {
                currentToken += currentChar;  // Accumulate characters
            }
        }

        // Check's if theres remaining token
        if (!currentToken.isEmpty()) {
            classifyAndPrintToken(currentToken);
        }


        scanner.close();

        // Mag run sa phase 2
        Phase2.runPhase2(input);
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

    // Mag identify sa tokens as Word, Number, AlphaNumeric, Punctuation, or End of Line
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
