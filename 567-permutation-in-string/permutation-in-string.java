class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;
        int[] arr = new int[26];
        for(int i=0;i<n;i++){
            arr[s1.charAt(i)-'a']++;
         }
         for(int i = 0;i<m;i++){
            arr[s2.charAt(i)-'a']--;
            if(i-n >= 0){
                arr[s2.charAt(i-n)-'a']++;
            }
            if(zero(arr)) {
                return true;
            }
        }
        return false;

    }

    public boolean zero(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}


//// way 2

// class Solution {

//     public boolean checkInclusion(String s1, String s2) {
//         int n1 = s1.length(), n2 = s2.length();
//         if (n1 > n2) {
//             return false;
//         }
        
//         int[] freq = new int[26];
//         for (int i = 0; i < n1; i++) {
//             freq[s1.charAt(i) - 'a']++;
//         }
        
//         int left = 0, right = 0;
//         while (right < n2) {
//             char ch = s2.charAt(right);
//             freq[ch - 'a']--;
//             while (freq[ch - 'a'] < 0) {
//                 freq[s2.charAt(left) - 'a']++;
//                 left++;
//             }
//             if (right - left + 1 == n1) {
//                 return true;
//             }
//             right++;
//         }
//         return false;
//     }
// }

