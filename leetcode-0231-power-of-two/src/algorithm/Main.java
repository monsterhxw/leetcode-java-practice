package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int n = 8;

    System.out.println(
        "using bitwise operation, n is "
            + n
            + ", result is "
            + (new Main()).isPowerOfTwoUsingBitwiseOperation(n));

    System.out.println(
        "using iterative, n is "
            + n
            + ", result is "
            + (new Main()).isPowerOfTwoUsingIterative(n));

    System.out.println(
        "using recursive, n is "
            + n
            + ", result is "
            + (new Main()).isPowerOfTwoUsingRecursive(n));
  }

  public boolean isPowerOfTwoUsingBitwiseOperation(int n) {
    if (n <= 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }

  public boolean isPowerOfTwoUsingIterative(int n) {
    if (n <= 0) {
      return false;
    }

    while (n % 2 == 0) {
      n >>= 1;
    }

    return n == 1;
  }

  public boolean isPowerOfTwoUsingRecursive(int n) {
    if (n == 1){
      return true;
    }

    if (n <= 0 || n % 2 == 1) {
      return false;
    }

    return isPowerOfTwoUsingRecursive(n >> 1);
  }
}
