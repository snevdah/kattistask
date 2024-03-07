import java.util.Scanner;

public class problemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] sums = new double[2];
        
        for (int i = 0; i < 2; i++) {
            double sum = 0;
            for (int x = 0; x < 3; x += 2) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                double div = 1.0 / (b - a + 1);
                for (int c = a; c <= b; c++) {
                    sum += div * c;
                }
            }
            sums[i] = sum;
        }
        
        if (Math.abs(sums[1] - sums[0]) < 1e-9) {
            System.out.println("Tie");
        } else {
            System.out.println(sums[0] > sums[1] ? "Gunnar" : "Emma");
        }
        scanner.close();
    }
}
