package algorithm;

public class Main {

    public static void main(String[] args) {
        double x = 2;
        int n = 6;
        System.out.println((new Main()).myPowUsingRecursion(x, n));
    }

    public double myPowUsingRecursion(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (n < 0) {
            return 1 / (x * myPowUsingRecursion(x, -(++n)));
        }
        double half = myPowUsingRecursion(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
