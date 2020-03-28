package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int[] coins = new int[] {1, 2, 5};
    int amount = 11;
    System.out.print("coins is ");
    for (int coin : coins) {
      System.out.print(coin + " ");
    }
    System.out.println();
    System.out.println("amount is " + amount);

    Main main = new Main();

    System.out.println(
        "using recursive, result is " + main.coinChangeUsingRecursive(coins, amount));

    System.out.println(
        "using memoization search, result is " + main.coinChangeUsingMemoization(coins, amount));
  }

  public int coinChangeUsingRecursive(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int result = Integer.MAX_VALUE;

    for (int coin : coins) {
      if (amount < coin) {
        continue;
      }
      int ret = coinChangeUsingRecursive(coins, amount - coin);
      if (ret == -1) {
        continue;
      }
      result = Math.min(result, ret + 1);
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public int coinChangeUsingMemoization(int[] coins, int amount) {
    if (coins == null || coins.length == 0) {
      return -1;
    }

    Integer[] memo = new Integer[amount + 1];

    return dfsHelper(coins, amount, memo);
  }

  private int dfsHelper(int[] coins, int amount, Integer[] memo) {
    if (amount == 0) {
      return 0;
    }

    if (memo[amount] != null) {
      return memo[amount];
    }

    int result = Integer.MAX_VALUE;

    for (int coin : coins) {
      if (amount < coin) {
        continue;
      }
      int ret = dfsHelper(coins, amount - coin, memo);
      if (ret == -1) {
        continue;
      }
      result = Math.min(result, ret + 1);
    }

    result = result == Integer.MAX_VALUE ? -1 : result;

    memo[amount] = result;

    return memo[amount];
  }
}
