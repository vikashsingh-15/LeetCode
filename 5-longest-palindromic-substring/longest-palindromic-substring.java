class Solution {
    public String longestPalindrome(String str) {
        int dp[][]=new int [str.length()][str.length()];
        int start=0;
        int end=0;

        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp[0].length;i++,j++){
                if(str.charAt(i)==str.charAt(j)){
                    if(gap==0){
                        dp[i][j]=1;
                    }else if(gap==1){
                        dp[i][j]=1;
                    }else{
                        if(dp[i+1][j-1]==1){//diagonal down
                        dp[i][j]=1;
                        }
                    }
                }
                if(dp[i][j]==1){
                    start=i;
                    end=j;
                }

            }
        }
       return (str.substring(start,end+1));
    }
}