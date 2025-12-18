class Solution {
    public int maxProfit(int[] price) {
        //         int minSoFar=Integer.MAX_VALUE;
        //         int sell=0;

        //         for(int  i=0;i<price.length;i++){
        //             minSoFar=Math.min(minSoFar,price[i]);
        //             sell=Math.max(sell,price[i]-minSoFar);
        //         }
        //         return sell;

        //way 2

        //   int n = price.length;
        // int[] maxPrices = new int[n];
        // int maxPrice = Integer.MIN_VALUE;
        // for (int i = n - 1; i >= 0; i--) {
        //     maxPrice = Math.max(maxPrice, price[i]);
        //     maxPrices[i] = maxPrice;
        // }
        // int maxProfit = 0;
        // for (int i = 0; i < n ; i++) {
        //     int profit = maxPrices[i] - price[i];
        //     maxProfit = Math.max(maxProfit, profit);
        // }

        // return maxProfit;

        //// way 3

        int n = price.length;
        int minPrices[] = new int[n];
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, price[i]);
            minPrices[i] = minPrice;
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int profit = price[i] - minPrices[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;

    }
}