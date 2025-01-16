////Memory Limit Exceed
// class Solution {
//     public int xorAllNums(int[] nums1, int[] nums2) {
//         int lena = nums1.length;
//         int lenb = nums2.length;
//         int[] xorr = new int[lena * lenb];

      
//         for (int i = 0; i < lena; i++) {
//             for (int j = 0; j < lenb; j++) {
//                 xorr[i * lenb + j] = nums1[i] ^ nums2[j];
//             }
//         }
//         int result = 0;
//         for (int val : xorr) {
//             result ^= val;
//         }

//         return result;
//     }
// }

////way 2

class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
       
        int len1 = nums1.length;
        int len2 = nums2.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + len2);
        }
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + len1);
        }

        int ans = 0;
        for (int num : freq.keySet()) {
            if (freq.get(num) % 2 == 1) {
                ans ^= num;
            }
        }

        return ans;
    }
}
