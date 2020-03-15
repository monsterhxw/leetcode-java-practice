package algorithm;

import java.util.Arrays;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    String s = "1025";

    System.out.println("s is : " + s);

    System.out.println("using recursion , result is : " + main.numDecodingsUsingRecursion(s));

    System.out.println(
        "using memoization searching , result is : "
            + main.numDecodingUsingMemoizationSearching(s));
  }

  public int numDecodingUsingMemoizationSearching(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int[] memo = new int[s.length() + 1];

    Arrays.fill(memo, -1);

    return memoizationHelper(0, s, memo);
  }

  private int memoizationHelper(int index, String s, int[] memo) {
    if (index == s.length()) {
      return 1;
    }

    if (s.charAt(index) == '0') {
      return 0;
    }

    if (memo[index] != -1) {
      return memo[index];
    }

    int oneNumber = memoizationHelper(index + 1, s, memo);

    int twoNumber = 0;
    if (index < s.length() - 1) {
      if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
        twoNumber = memoizationHelper(index + 2, s, memo);
      }
    }

    return memo[index] = oneNumber + twoNumber;
  }

  public int numDecodingsUsingRecursion(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    return dfsHelper(0, s);
  }

  private int dfsHelper(int index, String s) {
    if (index == s.length()) {
      return 1;
    }

    if (s.charAt(index) == '0') {
      return 0;
    }

    int oneNumber = dfsHelper(index + 1, s);

    int twoNumber = 0;
    if (index < s.length() - 1) {
      if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
        twoNumber = dfsHelper(index + 2, s);
      }
    }

    return oneNumber + twoNumber;
  }
}
