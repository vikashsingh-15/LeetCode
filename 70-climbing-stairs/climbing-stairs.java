 ////way  1 --> Reverse DP
// class Solution {
//     public int climbStairs(int n) {

//         int  arr[]=new int [n+1];
//         arr[n]=1;
//         arr[n-1]=1;

//         for(int i=n-2;i>=0;i--){
//             arr[i]=arr[i+1]+arr[i+2];
//         }

//         return arr[0];
        
//     }
// }

//way 2 --> forward dp
// class Solution {    
//     public int climbStairs(int n) {

//         if(n<2){
//             return n;
//         }
//         int dp[]=new int [n+1];
//         dp[0]=0;
//         dp[1]=1;
//         dp[2]=2;

//         for(int i=3;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//         }
//         return dp[n];
//     }
// }

////way 3 --> recusrion  --> TLE

// class Solution {
//     public int climbStairs(int n) {
//         return solve(n);
//     }

//     public int solve(int n){
//         if(n<0){
//             return 0;
//         }
//         if(n==0){
//             return 1;
//         }
//          int one_step=solve(n-1);
//          int two_step=solve(n-2);

//          return one_step+two_step;
//     }
// }


////way 4 -> Recussion memoized
// class Solution {

//     int dp[]=new int [46];
//     public int climbStairs(int n) {
//         return solve(n);
//     }

//     public int solve(int n){
//         if(n<0){
//             return 0;
//         }
//         if(n==0){
//             return 1;
//         }
//         if(dp[n]!=0){
//             return dp[n];
//         }
//          int one_step=solve(n-1);
//          int two_step=solve(n-2);
//         int count=one_step+two_step;
//          dp[n]=count;
//          return count;
//     }
// }


////way 5 -->smart approach

class Solution {
    int climbStairs(int n) {

        if(n <= 2){
            return n;
        }

        int prev_2 = 1;
        int prev_1 = 2;

        for (int i = 3; i <= n; i++) {
            int curr = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = curr;
        }

        return prev_1;
    }
}