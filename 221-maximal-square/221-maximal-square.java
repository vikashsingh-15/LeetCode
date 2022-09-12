class Solution {
    public int maximalSquare(char[][] arr) {
        
      int dp[][]=new int [arr.length] [arr[0].length];
        int ans=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr[0].length-1;j>=0;j--){
                if(i==arr.length-1 || j==arr[0].length-1){
                    dp[i][j]=arr[i][j] -'0' ;
                    ans=Math.max(dp[i][j],ans);  
                }         
                else{
                    if(arr[i][j]=='0'){
                        dp[i][j]=0;
                    }else{
                        // System.out.println(i +" " +j);
                        int min=Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
                        dp[i][j]=min+1;    
                        ans=Math.max(dp[i][j],ans);  
                    }
                }
            }
        }
        
        
        return ans*ans;
    }
}