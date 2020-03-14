package LeetCode;

public class LeetCode714 {
    /**
     * 我们维护两个变量cash和hold，
     * 前者表示当我们不持有股票时的最大利润，后者表示当我们持有股票时的最大利润
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
