public class SellStockII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int mark = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(mark < prices[i]) {
                ans += prices[i] - mark;
                mark = prices[i];
            }
            if(mark > prices[i]) {
                mark = prices[i];
            }
        }
        return ans;
    }
}
