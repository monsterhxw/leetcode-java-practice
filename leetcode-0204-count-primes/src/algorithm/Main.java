package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int n = 499979;

    System.out.println("n is : " + n);

    System.out.println("inefficient approach, result is : " + main.countPrimesInefficient(n));

    System.out.println("efficient approach, result is : " + main.countPrimesEfficient(n));
  }

  public int countPrimesEfficient(int n) {
    if (n <= 2) {
      return 0;
    }

    int count = 0;

    boolean[] notPrime = new boolean[n];

    for (int i = 2; i < n; i++) {
      if (notPrime[i]) {
        continue;
      }
      count++;
      for (int j = 2; j * i < n; j ++) {
        notPrime[i * j] = true;
      }
    }

    return count;
  }

  public int countPrimesInefficient(int n) {
    if (n <= 1) {
      return 0;
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }

    return count;
  }

  private boolean isPrime(int n) {
    for (int j = 2; j <= Math.sqrt(n); j++) {
      if (n % j == 0) {
        return false;
      }
    }
    return true;
  }
}
