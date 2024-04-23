public class SellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        int mark = 0;
        for(int i = 1; i < n; i++) {
            if(prices[i] < prices[mark]) mark = i;
            int current = prices[i] - prices[mark];
            if(current > sum) sum = current;
        }
        return sum;
    }
    public static void main(String[] Args) {
        System.out.println(maxProfit(new int[] {1,2}));
    }
}
