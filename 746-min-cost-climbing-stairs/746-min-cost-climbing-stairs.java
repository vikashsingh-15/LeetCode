class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int dp[]=new int [arr.length+1];
         for(int i=2;i<=arr.length;i++){
          dp[i]=Math.min((dp[i-1]+arr[i-1]),(dp[i-2]+arr[i-2])); 
        }
        return dp[dp.length-1];
    }
}