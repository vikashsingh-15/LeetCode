class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int [m][n];
        int result=0;
        for(int i=0;i<m;i++){
            if(matrix[i][n-1]==1){
                dp[i][n-1]=1;
                result += 1;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[m-1][i]==1){
                dp[m-1][i]=1;
                result += 1;
            }
        }
        if (matrix[m - 1][n - 1] == 1) {
            result--;
        }

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
               
                if(matrix[i][j]==1){
                   dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));  
                   result+=dp[i][j];                  
                }
            }
        }
        return result;
    }
}