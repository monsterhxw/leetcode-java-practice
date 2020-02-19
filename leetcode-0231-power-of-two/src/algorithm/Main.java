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
  }

  public boolean isPowerOfTwoUsingBitwiseOperation(int n) {
    if (n <= 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }
}
