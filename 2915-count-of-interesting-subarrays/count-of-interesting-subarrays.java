////way 1-TLE
// class Solution {
//     public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//          int n = nums.size();
//         long count = 0;

//         for(int i=0;i<n;i++){
//             int cnt=0;

//             for(int j=i;j<n;j++){
//                 if(nums.get(j)%modulo==k){
//                     cnt++;
//                 }
//                  if (cnt % modulo == k) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

////way 2

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] diff = new int[n];
        
        // Precompute the diff array
        for (int i = 0; i < n; i++) {
            diff[i] = (nums.get(i) % modulo == k) ? 1 : 0;
        }
        
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            prefix += diff[i];
            
            int rem = (prefix - k + modulo) % modulo;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            
            int currentMod = prefix % modulo;
            map.put(currentMod, map.getOrDefault(currentMod, 0) + 1);
        }
        
        return count;
    }
}
