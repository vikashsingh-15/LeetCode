class Solution {

    public int maxProfit(int[] prices) {
        //         //WAy 1
        //         int buy = 0;
        //         int sell = 0;
        //         int profit = 0;

        //         for (int i = 1; i < prices.length; i++) {
        //             if (prices[i] >= prices[i - 1]) {
        //                 sell++;
        //             } else {
        //                 profit += prices[sell] - prices[buy];
        //                 sell = buy = i;
        //             }
        //         }

        //         profit += prices[sell] - prices[buy];

        //         return profit;

        //way 2
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
