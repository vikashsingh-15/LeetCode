class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[]=new int[cost.length+1];
         dp[n] = 0;
        dp[n - 1] = cost[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.min(dp[i+1],dp[i+2])+cost[i];
        }
         return Math.min(dp[0], dp[1]);
    }
}

// class Solution {
//     public int minCostClimbingStairs(int[] arr) {
//         int dp[]=new int [arr.length+1];
//          for(int i=2;i<=arr.length;i++){
//           dp[i]=Math.min((dp[i-1]+arr[i-1]),(dp[i-2]+arr[i-2])); 
//         }
//         return dp[dp.length-1];
//     }
// }