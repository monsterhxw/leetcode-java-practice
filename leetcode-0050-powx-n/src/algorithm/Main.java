package algorithm;

public class Main {

    public static void main(String[] args) {
        double x = 2;
        int n = 6;
        System.out.println("using recursion : " + (new Main()).myPowUsingRecursion(x, n));
        System.out.println("using optimizing recursion : " + (new Main()).myPowUsingRecursionOptimization(x, n));
        System.out.println("using iteration : " + (new Main()).myPowUsingIteration(x, n));
    }

    public double myPowUsingIteration(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        long N = Math.abs((long)n);
        double answer = 1.0d;
        while (N > 0) {
            if ((N & 1) == 1) {
                answer = answer * x;
            }
            N = N >> 1;
            x = x * x;
        }
        return N < 0 ? 1 / answer : answer;
    }

    public double myPowUsingRecursionOptimization(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (n < 0) {
            return 1 / (x * myPowUsingRecursionOptimization(x, -(++n)));
        }
        return (n % 2 == 0) ? myPowUsingRecursionOptimization(x * x, n / 2) : x * myPowUsingRecursionOptimization(x * x, n / 2);
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
