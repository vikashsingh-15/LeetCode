class Solution {

    public int ways(String[] pizza, int k) {
      final int mod = 1000000000 + 7;
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][][] dp = new int[55][55][11];
        int[][] cnt = new int[55][55];

        for(int i = 1; i <= rows; i++)
            for(int j= 1; j <= cols; j++){
                cnt[i][j] = cnt[i-1][j] + cnt[i][j-1] - cnt[i-1][j-1] + (pizza[rows-i].charAt(cols-j) == 'A' ? 1 : 0);
            }
        for(int i = 0; i <= rows; i++) dp[i][0][0] = 1;

        for(int i = 0; i <= rows; i++)
            for(int j = 0; j<= cols; j++)
                for(int p = 0; p < k; p++)
                    if(dp[i][j][p] != 0){
                        for(int ii = i+1; ii <= rows; ii++)
                            if(cnt[ii][j] - cnt[i][j] > 0)
                                dp[ii][j][p+1] = (dp[ii][j][p+1] + dp[i][j][p]) % mod;
                        for(int jj = j+1; jj <= cols; jj++)
                            if(cnt[i][jj] - cnt[i][j] > 0)
                                dp[i][jj][p+1] = (dp[i][jj][p+1] + dp[i][j][p]) % mod;
                    }
        return dp[rows][cols][k]; 
    }
}