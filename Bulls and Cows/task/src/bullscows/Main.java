package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int secretLength = 1;

        if (scanner.hasNextInt()){
            secretLength = scanner.nextInt();
            if (secretLength == 0){
                System.out.println("Error: "+ secretLength +" must be greater than zero");
                System.exit(0);
            }
        } else {
            System.out.println("Error: "+ scanner.nextLine() +" isn't a valid number");
            System.exit(0);
        }

        System.out.println("Please, enter the number of possible symbols:");
        int secretSymbols = scanner.nextInt();

        if (secretLength > secretSymbols) {
            System.out.println("Error:it's not possible to generate a code with a length of "  + secretLength +
                    " with " + secretSymbols + " unique symbols.");
            System.exit(0);
        }
        if (secretSymbols >= 37){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        String secret = SecretCode(secretLength, secretSymbols);
        System.out.println("Okay, let's start a game!");
        GameCycle(secret);

    }

    private static int CheckBullsAndCows(String input, String secret) {

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i <= input.length() - 1; i++) {
            if (secret.charAt(i) == input.charAt(i)) {
                bulls++;
            } else if (secret.contains(input.substring(i, i + 1))) {
                cows++;

            }
        }
        if (cows == 0 && bulls == 0) {
            System.out.println("Grade: None.");
        } else {
            System.out.println("Grade:" + bulls + " bull(s) and " + cows + " cow(s)");
        }
        return bulls;
    }

    private static String SecretCode(int secretLength, int secretSymbols) {

        StringBuilder result = new StringBuilder("");
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz";
        String charsUsed = "";

        if (secretSymbols == 36) {
            charsUsed = AlphaNumericString;
        } else {
            charsUsed = AlphaNumericString.substring(0, secretSymbols);
        }

        //check length
        if (secretLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of 37 because there aren't enough unique digits.");
            System.exit(0);
        }
        //make sure digit is unique
        while (!(result.length() == secretLength)) {
            StringBuilder secretTransform = PseudoGen(secretLength, charsUsed);
            result = CodeWithUniqueDigits(secretTransform, secretLength);
        }
        System.out.println("The secret is prepared: " + "*".repeat(result.length()) + " " + charsUsed);
        return result.toString();
    }

    private static StringBuilder CodeWithUniqueDigits(StringBuilder secretTransform, int secretLength) {

        int i = 0;
        int count = 0;
        StringBuilder secretBuild = new StringBuilder();

        while (i < secretTransform.length()) {

            int idx = secretBuild.indexOf(String.valueOf(secretTransform.charAt(i)));
            if (idx != -1 && secretBuild.length() != 0) {
                i++;
                continue;
            }
            secretBuild.append(secretTransform.charAt(i));
            i++;
            count++;

            if (count == secretLength) {
                break;
            }
        }
        return secretBuild;

    }

    private static StringBuilder PseudoGen(int n, String subAlphaNumericString) {
        // create StringBuffer size of charsUsed
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (subAlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(subAlphaNumericString
                    .charAt(index));
        }

        return sb;

    }

    private static void GameCycle(String secret) {
        int turn = 1;
        int numBulls = 0;

        while (!(numBulls == secret.length())) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Turn : " + turn);
            String input = scanner.next();
            numBulls = CheckBullsAndCows(input, secret);
            turn++;

        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

}