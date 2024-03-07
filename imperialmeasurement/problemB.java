import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lis = {1, 1000, 12, 3, 22, 10, 8, 3};
        Map<String, Integer> ind = new HashMap<>();
        ind.put("thou", 0); ind.put("th", 0);
        ind.put("inch", 1); ind.put("in", 1);
        ind.put("foot", 2); ind.put("ft", 2);
        ind.put("yard", 3); ind.put("yd", 3);
        ind.put("chain", 4); ind.put("ch", 4);
        ind.put("furlong", 5); ind.put("fur", 5);
        ind.put("mile", 6); ind.put("mi", 6);
        ind.put("league", 7); ind.put("lea", 7);

        String input = scanner.nextLine();
        String[] s = input.split(" ");
        int val = Integer.parseInt(s[0]);
        int f = ind.get(s[1]);
        int t = ind.get(s[3]);

        if (f == t) {
            System.out.println(val);
        } else if (f < t) {
            double p = 1;
            while (f != t) {
                f += 1;
                p /= lis[f];
            }
            System.out.println(p * val);
        } else {
            double p = 1;
            while (f != t) {
                p *= lis[f];
                f -= 1;
            }
            System.out.println(val * p);
        }

        scanner.close();
    }
}