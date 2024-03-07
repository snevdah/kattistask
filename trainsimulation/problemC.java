import java.util.Scanner;

public class problemC {

    private static boolean first(int[] current, int cap, Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        current[0] += b;
        return a == 0 && b <= cap && (c == 0 || b == cap);
    }

    private static boolean next(int[] current, int cap, Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a > current[0]) return false;
        current[0] -= a;
        if (current[0] + b > cap) return false;
        current[0] += b;
        return c == 0 || current[0] == cap;
    }

    private static boolean last(int[] current, Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        return a == current[0] && b == 0 && c == 0;
    }

    private static void dump(int n, Scanner scanner) {
        while (n-- > 0) {
            scanner.nextInt(); // a
            scanner.nextInt(); // b
            scanner.nextInt(); // c
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        boolean possible = true;
        int[] current = {0};
        if (!(possible = first(current, c, scanner))) dump(n - 1, scanner);

        for (int i = 1; i < n - 1 && possible; i++) {
            if (!(possible = next(current, c, scanner))) {
                dump(n - i - 1, scanner);
                break;
            }
        }

        if (possible) possible = last(current, scanner);

        System.out.println(possible ? "possible" : "impossible");
        scanner.close();
    }
}