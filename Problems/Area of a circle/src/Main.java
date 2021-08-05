import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double radius = scanner.nextFloat();
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println(area);
    }
}