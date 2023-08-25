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

class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
         Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleaveHelper(s1,s2,s3,0,0,0,memo);
    }

    public boolean isInterleaveHelper(String s1, String s2, String s3, int s1Point, int s2Point, int s3Point,Boolean[][] memo) {
        if(s3Point==s3.length()){
            return true;
        }
        if (memo[s1Point][s2Point] != null) {
            return memo[s1Point][s2Point];
        }
        if((s1Point<s1.length()) && (s1.charAt(s1Point)==s3.charAt(s3Point))){
            boolean f1=isInterleaveHelper(s1,s2,s3,s1Point+1,s2Point,s3Point+1,memo);
            memo[s1Point][s2Point]=f1;
            if(f1==true){
                return true;
            }
        }
         if(s2Point<s2.length() && s2.charAt(s2Point)==s3.charAt(s3Point)){
            boolean f2=isInterleaveHelper(s1,s2,s3,s1Point,s2Point+1,s3Point+1,memo);
            memo[s1Point][s2Point]=f2;
            if(f2==true){
                return true;
            }
        }
        memo[s1Point][s2Point]=false;
         return false;

    }
}
// class Solution {

//     public boolean isInterleave(String s1, String s2, String s3) {

        
//     }

//     public boolean isInterleaveHelper(String s1, String s2, String s3, int s1Point, int s2Point, int s3Point) {


//     }
// }
