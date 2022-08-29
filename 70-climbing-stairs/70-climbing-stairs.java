class Solution {

    public int climbStairs(int n) {
        // int qb[] = new int[n + 1];
        // return climbStairsMemo(n, qb);
        return climbStairsTebul(n);

    }

    public int climbStairsMemo(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) {
            return qb[n];
        }
        int num1 = climbStairsMemo(n - 1, qb);
        int num2 = climbStairsMemo(n - 2, qb);
        qb[n] = num1 + num2;
        return num1 + num2;
    }

    public int climbStairsTebul(int n) {
        int dp[] = new int[n + 1];
        dp[0]=1;
        
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        
        return dp[n];
    }
}
