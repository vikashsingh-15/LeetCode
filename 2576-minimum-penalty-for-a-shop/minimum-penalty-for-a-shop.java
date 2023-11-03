class Solution {

    public int bestClosingTime(String s) {
        int countY = 0;
        int totalY = 0;
        int totalN = 0;
        int countN = 0;
        // int ans = Integer.MAX_VALUE;
        int ans=0;
        int penalty = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                countY++;
            } else {
                countN++;
            }
        }

        if (countN == s.length()) {
            return 0;
        }
        if (countY == s.length()) {
            return countY ;
        }

        totalY = countY;
        totalN = countN;
        countY = 0;
        countN = 0;

        penalty=totalY;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') {
                countY++;
                if ((countN + (totalY - countY)) < penalty) {
                    ans = i+1;
                    penalty = countN + (totalY - countY);
                }
            } else {
                countN++;
                if ((countN) + (totalY - countY) < penalty) {
                         ans = i+1;                   
                    penalty = ((countN) + (totalY - countY));
                }
            }
        }
        return ans;
    }
}



// class Solution {
//     public int bestClosingTime(String customers) {
//         int penalty = 0;
//         for(int i=0;i<customers.length();i++){
//             if(customers.charAt(i)=='Y'){
//                 penalty++;
//             }
//         }
//         int min = penalty;
//         int hour = 0;
//         for(int i=0;i<customers.length();i++){
//             if(customers.charAt(i)=='Y'){
//                 penalty--;
//             } else {
//                 penalty++;
//             }
//             if(penalty<min){
//                 min = penalty;
//                 hour = i+1;
//             }
//         }
//         return hour;
//     }
// }
