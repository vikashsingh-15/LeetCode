class Solution {
    public int maxProfit(int[] price) {
        int buy=Integer.MAX_VALUE;
        int sell=0;
        
        for(int  i=0;i<price.length;i++){
            buy=Math.min(buy,price[i]);
            sell=Math.max(sell,price[i]-buy);
        }
        
        return sell;
        
    }
}