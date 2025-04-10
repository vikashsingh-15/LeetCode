////TLE

// class Solution {
//     public int numberOfAlternatingGroups(int[] colors, int k) {
//         int ans=0;

//         for(int i=0;i<colors.length;i++){
//             int prev=colors[i];
//             int count=0;
//             for(int j=i+1;j<i+k;j++){
//                 int index=j%colors.length;

//                 if(colors[index]!=prev){
//                     count++;
//                     prev=colors[index];
//                 }

//             }

//             if(count==k-1){
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }

////way 2

// class Solution {
//     public int numberOfAlternatingGroups(int[] colors, int k) {
//          int n = colors.length;
//         int ans = 0, alternatingCount = 1;
//         for (int i = 1; i < n+k-1; i++) {
//             if (colors[i % n] != colors[(i - 1+n) % n]) {
//                 alternatingCount++;
//             } else {
//                 alternatingCount = 1;
//             }
            
//             if (alternatingCount >= k) {
//                 ans++;
//             }
//         }
        
//         return ans;
//     }
// }

////way 3

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int altLength = 1;
        for(int i=1;i<n+k-1;i++){
         int curr = colors[i % n];
            int prev = colors[(i - 1) % n];

            if (curr != prev) {
                altLength++;
            } else {
                altLength = 1;
            }

            if (altLength >= k) {
                count++;
            }
        }

        return count;
    }
}
