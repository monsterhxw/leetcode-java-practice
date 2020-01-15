package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println((new Main()).maxProfitUsingGreedy(prices));
    }

    public int maxProfitUsingGreedy(int[] prices) {
        int result = 0;
        // 资本收益
        int capitalGain = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            capitalGain = prices[i + 1] - prices[i];
            // 最优解是 capital gain 为正数
            if (capitalGain > 0) {
                result += capitalGain;
            }
        }
        return result;
    }
}
