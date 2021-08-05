import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        // write your code with StringBuilder here
        StringBuilder concatenate = new StringBuilder();
        int i = 0;
        for (String str : strings) { //used foreach
            concatenate.append(str);
        }

        while (i < concatenate.length()) {

            if (Character.isDigit(concatenate.charAt(i))) {
                concatenate.delete(i, i + 1);
            } else {
                i++;
            }
        }
        return concatenate.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}
