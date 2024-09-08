public class Phase2 {
    public static void runPhase2(String sentence) {
        System.out.println("\n===================================================");
        System.out.println("Phase 2 Output (Granular Breakdown):");

        String currentToken = "";

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (isDelimiter(currentChar)) {
                if (!currentToken.isEmpty()) {
                    printToken(currentToken);  // Print the word/number token
                    currentToken = "";  // Clear the token
                }
            } else {
                currentToken += currentChar;  // Accumulate characters
            }
        }

        // Print any remaining token
        if (!currentToken.isEmpty()) {
            printToken(currentToken);
        }
    }

    // Check if the character is a delimiter
    private static boolean isDelimiter(char ch) {
        return " .,!-".indexOf(ch) >= 0;
    }

    // Print the token and its characters
    private static void printToken(String token) {
        // Skip printing if the token is a space
        if (token.equals(" ")) {
            return;  // Skip spaces
        }

        System.out.print("Token: " + token + " ---> ");
        for (int i = 0; i < token.length(); i++) {
            System.out.print("'" + token.charAt(i) + "'");
            if (i < token.length() - 1) System.out.print(", ");
        }
        System.out.println();
    }
}
