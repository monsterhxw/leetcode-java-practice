package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int n = 11;

    Main main = new Main();

    System.out.println("n(B) = " + Integer.toBinaryString(n));
    System.out.println("optimization : " + main.hammingWeightOptimization(n));
    System.out.println("ordinary : " + main.hammingWeight(n));
  }

  // you need to treat n as an unsigned value
  public int hammingWeightOptimization(int n) {
    int result = 0;

    while (n != 0) {
      n &= n - 1;
      result++;
    }

    return result;
  }

  public int hammingWeight(int n) {
    int result = 0;
    int mask = 1;

    for (int i = 0; i < 32; i++) {
      if ((n & mask) != 0) {
        result++;
      }
      mask <<= 1;
    }

    return result;
  }
}
