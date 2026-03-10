// class Solution {

//     public int fib(int n) {
//         if(n<1){
//             return n;
//         }
//        int  prev_2=0;//two no back prev 2
//        int prev_1=1;// onw no back prev 

//        for(int i=2;i<=n;i++){
//         int current=prev_1+prev_2;
//         prev_2=prev_1;
//         prev_1=current;

//        }
//         return prev_1;
//     }
// }

//way 2

// class Solution {

//     public int fib(int n) {
//         if (n <= 1) {
//             return n;
//         }
//         return fib(n - 1) + fib(n - 2);

//         //way3
//         // if(n==0 || n==1){
//         //     return n;
//         // }
//         // int fibn1=fib(n-1);
//         // int fibn2=fib(n-2);
//         // int fibn=fibn1+fibn2;
//         // return fibn;
//     }
// }


////way  3


class Solution {

    public int fib(int n) {
        int dp[] = new int[n + 1];
        return fibMemoize(n, dp);
    }

    public int fibMemoize(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int fibn1 = fibMemoize(n - 1,dp);
        int fibn2 = fibMemoize(n - 2,dp);
        int fibn = fibn1 + fibn2;
        dp[n] = fibn;
        return fibn;
    }
}