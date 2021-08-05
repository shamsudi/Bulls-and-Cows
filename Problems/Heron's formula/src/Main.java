import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double perimeter = (a + b + c) / 2.0;

        double s = Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));

        System.out.println(s);
    }
}

