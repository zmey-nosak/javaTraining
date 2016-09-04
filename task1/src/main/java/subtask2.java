import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Echetik on 03.09.2016.
 */
public class Subtask2 {
    private static void split() {
        System.out.println("----------------");
    }

    private static void method(double e) {
        split();
        int cnt = 1;
        double res;
        while (true) {
            res = 1 / Math.pow((cnt + 1), 2);
            System.out.println(res);
            if (e > res) {
                break;
            }
            cnt++;
        }
        System.out.println("Номер первого элемента для которого 1/(n+1)^2 < e для e = " + e + ": " + cnt);
    }

    private static void method3(double x1, double x2, double step) {
        split();
        System.out.println("|arg|value|");
        double tmp = x1;
        double res;
        while (tmp <= x2) {
            res = Math.tan(2 * tmp) - 3;
            System.out.println("|" + tmp + "|" + res + "|");
            tmp += step;
        }
    }

    private static void method4(int n) {
        split();
        if (n > 0) {
            int length = n * 2;
            int[] m = new int[length];
            Random rnd = new Random();
            for (int i = 0; i < length; i++) {
                m[i] = rnd.nextInt(100);
                System.out.print(m[i] + ", ");
            }
            System.out.println("");
            int max = m[0];
            int tmp;
            for (int i = 0; i < n; i++) {
                System.out.print((i == 0 ? "max(" : "") + m[i] + "+" + m[(2 * n - 1) - i] + (i == (n - 1) ? ") is " : ", "));
                tmp = m[i] + m[(2 * n - 1) - i];
                if (max <= tmp) {
                    max = tmp;
                }
            }
            System.out.println(max);
        }
    }

    private static void method5(int n) {
        split();
        int[][] m = new int[n][n];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i == j) {
                    m[i][j] = 1;
                }
                m[i][n - i - 1] = 1;
            }
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) {
        method(0.01);
        method3(1, 25, 2);
        method4(1);
        method5(9);
    }
}
