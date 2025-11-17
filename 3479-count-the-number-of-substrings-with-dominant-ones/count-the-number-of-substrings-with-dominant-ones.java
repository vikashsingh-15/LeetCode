//TLE
// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int[] pre = new int[n + 1];
//         pre[0]=0;
        
//         int count=0;
//         for(int i=0;i<s.length();i++){
//            int x=s.charAt(i)-'0';
//             pre[i+1]=pre[i]+x;
//         }
//         int ans=0;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 int countOne=pre[j+1]-pre[i];
//                 int countZero = (j - i + 1) - countOne;

//                 if(countOne>=countZero*countZero){
//                     ans++;
//                 }

//             }
//         }

//         return ans;
        
//     }
// }

////way2
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];

        // Build prefix sum of 1's
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (s.charAt(i) - '0');
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n;j++ ) {   // <-- for-loop with manual control

                int countOne = pre[j + 1] - pre[i];
                int countZero = (j - i + 1) - countOne;
                int sq = countZero * countZero;

                // Case 1: zeros^2 > ones — skip ahead
                if (sq > countOne) {
                    int skip = sq - countOne;
                    j += skip-1;
                    if (j >= n) break;
                }

                // Case 2: zeros^2 == ones — valid
                else if (sq == countOne) {
                    ans++;
                   
                }

                // Case 3: zeros^2 < ones — valid + jump
                else {
                    ans++;

                    int k = (int) Math.sqrt(countOne) - countZero;
                    int next = j + k;

                    if (next >= n) {
                        ans += (n - j - 1);
                        break;
                    } else {
                        ans += k;
                    }

                    j = next;  
                }
            }
        }

        return ans;
    }
}
