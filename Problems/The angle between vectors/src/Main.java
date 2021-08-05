import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int vectorU1 = scanner.nextInt();
        int vectorU2 = scanner.nextInt();
        int vectorV1 = scanner.nextInt();
        int vectorV2 = scanner.nextInt();

        double lengthU = Math.hypot(vectorU1, vectorU2);
        double lengthV = Math.hypot(vectorV1, vectorV2);
        double dotProd = vectorU1 * vectorV1 + vectorU2 * vectorV2;

        double angle = Math.acos(dotProd / (lengthU * lengthV));
        System.out.println(Math.toDegrees(angle));

    }
}