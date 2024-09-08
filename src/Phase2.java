import java.util.List;

public class Phase2 {
    public static void runPhase2(List<String> tokens) {
        System.out.println("\n===================================================");
        System.out.println("Phase 2 Output (Granular Breakdown):");

        for (String token : tokens) {
            // Print the token only if it's not a delimiter
            if (!isDelimiter(token)) {
                printToken(token);  // Print the token
            }
        }
    }

    // Check if the token is a delimiter
    private static boolean isDelimiter(String token) {
        return " .,!-\n".contains(token);  // Check if the token is a delimiter
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
