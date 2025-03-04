// class Solution {
//     public boolean checkPowersOfThree(int n) {
//         while(n>1){
//             int rem=n%3;
//             if(rem==2){
//                 return false;
//             }
//             n/=3;
//         }
//        return true; 
//     }
// }

//// way 2
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 1 || n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}
