// Brute Force -> TLE

// class Solution {

//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length()+s2.length()!=s3.length()){
//             return false;
//         }
//         return isInterleaveHelper(s1,s2,s3,0,0,0);
//     }

//     public boolean isInterleaveHelper(String s1, String s2, String s3, int s1Point, int s2Point, int s3Point) {
//         if(s3Point==s3.length()){
//             return true;
//         }
//         if((s1Point<s1.length()) && (s1.charAt(s1Point)==s3.charAt(s3Point))){
//             boolean f1=isInterleaveHelper(s1,s2,s3,s1Point+1,s2Point,s3Point+1);
//             if(f1==true){
//                 return true;
//             }
//         }
//          if(s2Point<s2.length() && s2.charAt(s2Point)==s3.charAt(s3Point)){
//             boolean f2=isInterleaveHelper(s1,s2,s3,s1Point,s2Point+1,s3Point+1);
//             if(f2==true){
//                 return true;
//             }
//         }
//          return false;

//     }
// }

//// way 2

//// optimized Recursion

// class Solution {

//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length()+s2.length()!=s3.length()){
//             return false;
//         }
//          Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
//         return isInterleaveHelper(s1,s2,s3,0,0,0,memo);
//     }

//     public boolean isInterleaveHelper(String s1, String s2, String s3, int s1Point, int s2Point, int s3Point,Boolean[][] memo) {
//         if(s3Point==s3.length()){
//             return true;
//         }
//         if (memo[s1Point][s2Point] != null) {
//             return memo[s1Point][s2Point];
//         }
//         if((s1Point<s1.length()) && (s1.charAt(s1Point)==s3.charAt(s3Point))){
//             boolean f1=isInterleaveHelper(s1,s2,s3,s1Point+1,s2Point,s3Point+1,memo);
//             memo[s1Point][s2Point]=f1;
//             if(f1==true){
//                 return true;
//             }
//         }
//          if(s2Point<s2.length() && s2.charAt(s2Point)==s3.charAt(s3Point)){
//             boolean f2=isInterleaveHelper(s1,s2,s3,s1Point,s2Point+1,s3Point+1,memo);
//             memo[s1Point][s2Point]=f2;
//             if(f2==true){
//                 return true;
//             }
//         }
//         memo[s1Point][s2Point]=false;
//          return false;

//     }
// }

////way 3
//DP _ TABULATION

// class Solution {

//     public boolean isInterleave(String s1, String s2, String s3) {
//         int rows = s1.length();
//         int cols = s2.length();
//         int len = s3.length();

//         if (rows + cols != len) {
//             return false;
//         }

//         boolean[][] dp = new boolean[rows + 1][cols + 1];

//         dp[0][0] = true;

//         for (int i = 1; i <= rows; i++) {
//             if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
//                 dp[i][0] = true;
//             }else{
//                 dp[i][0]=false;
//             }
//         }

//         for (int j = 1; j <= cols; j++) {
//             if (s2.charAt(j - 1) == s3.charAt(j - 1) &&  dp[0][j - 1]) {
//                 dp[0][j] = true;
//             }else{
//                 dp[0][j]=false;
//             }
//         }

//         for (int i = 1; i <= rows; i++) {
//             for (int j = 1; j <= cols; j++) {
//                 int s3point = i + j - 1;
//                 if ((s1.charAt(i - 1) == s3.charAt(s3point) && dp[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(s3point) && dp[i][j - 1])) {
//                     dp[i][j] = true;
//                 }
//             }
//         }
//         return dp[rows][cols];
//     }
// }



class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int rows = s1.length();
        int cols = s2.length();
        int len = s3.length();

        if (rows + cols != len) {
            return false;
        }

        boolean[][] dp = new boolean[rows + 1][cols + 1];

        dp[0][0] = true;

        

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                int s3point = i + j - 1;
                int s2point=j-1;
                int s1point=i-1;
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    if(s2.charAt(s2point)==s3.charAt(s3point) && dp[0][j-1]){
                        dp[i][j]=true;
                    }
                }else if(j==0){
                     if(s1.charAt(s1point)==s3.charAt(s3point) && dp[i-1][0]){
                        dp[i][j]=true;
                    }
                }else{
                     dp[i][j] = (s1.charAt(s1point) == s3.charAt(s3point) && dp[i - 1][j])
                            || (s2.charAt(s2point) == s3.charAt(s3point) && dp[i][j - 1]);
                }
            }
        }
        return dp[rows][cols];
    }
}
