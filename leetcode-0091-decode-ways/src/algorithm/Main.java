package algorithm;

import java.util.Arrays;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    String s = "1234";

    System.out.println("s is : " + s);

    System.out.println("using recursion , result is : " + main.numDecodingsUsingRecursion(s));

    System.out.println(
        "using memoization searching , result is : "
            + main.numDecodingsUsingMemoizationSearching(s));

    System.out.println(
        "using dynamic programming, result is : " + main.numDecodingsUsingDynamicProgramming(s));

    System.out.println(
        "using dynamic programming and optimization, result is : "
            + main.numDecodingsUsingDPAndOptimization(s));
  }

  public int numDecodingsUsingDPAndOptimization(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= s.length(); i++) {
      int oneDigit = Integer.valueOf(s.substring(i - 1, i));
      int twoDigits = Integer.valueOf(s.substring(i - 2, i));
      if (oneDigit >= 1 && oneDigit <= 9) {
        dp[i] = dp[i] + dp[i - 1];
      }
      if (twoDigits >= 10 && twoDigits <= 26) {
        dp[i] = dp[i] + dp[i - 2];
      }
    }

    return dp[s.length()];
  }

  public int numDecodingsUsingDynamicProgramming(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int[] dp = new int[s.length()];
    // dp[0] 表示一个大小为 1 的字符串，有一种解码
    dp[0] = 1;
    if (s.charAt(1) == '0') {
      if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
        dp[1] = 1;
      } else {
        return 0;
      }
    } else {
      if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
        dp[1] = 2;
      } else {
        dp[1] = 1;
      }
    }

    for (int i = 2; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        // s[i] 为 ‘0’ 时
        if (s.charAt(i - 1) == '0') {
          // 前一个为 ‘0’
          // 无解
          return 0;
        } else {
          // 前一个不为 ‘0’
          if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
            // s[i-1] 和 s[i] 组成的数 <= 26
            dp[i] = dp[i - 2];
          } else {
            // 无解
            return 0;
          }
        }
      } else {
        if (s.charAt(i - 1) == '0') {
          // 前一个为 ‘0’
          dp[i] = dp[i - 1];
        } else {
          // 前一个不为 ‘0’
          if ((s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
            // s[i-1] 和 s[i] 组成的数 <= 26
            dp[i] = dp[i - 1] + dp[i - 2];
          } else {
            // s[i-1] 和 s[i] 组成的数 > 26
            dp[i] = dp[i - 1];
          }
        }
      }
    }

    return dp[s.length() - 1];
  }

  public int numDecodingsUsingMemoizationSearching(String s) {
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
