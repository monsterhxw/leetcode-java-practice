package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int[] coins = new int[] {1, 2};
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
      result = Math.min(result, ret == -1 ? -1 : ret + 1);
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
