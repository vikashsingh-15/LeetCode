// ////Memory exceed
// class Solution {
//     int min = Integer.MAX_VALUE;

//     public int minCapability(int[] nums, int k) {
//         List<List<Integer>> list = new ArrayList<>();
//         helper(nums, k, list, new ArrayList<>(), 0);

//         for (List<Integer> subset : list) {
//             min = Math.min(min, Collections.max(subset)); 
//         }

//         return min;
//     }

//     public void helper(int[] nums, int k, List<List<Integer>> list, List<Integer> l1, int index) {
//         if (l1.size() == k) {
//             list.add(new ArrayList<>(l1));
//             return;
//         }

//         if (index >= nums.length) {
//             return;
//         }
//         l1.add(nums[index]);
//         helper(nums, k, list, l1, index + 2);
//         l1.remove(l1.size() - 1); // Backtrack

//         helper(nums, k, list, l1, index + 1);
//     }
// }


////way 2 TLE

// class Solution {
//     int min = Integer.MAX_VALUE;

//     public int minCapability(int[] nums, int k) {
//         helper(nums, k, new ArrayList<>(), 0);
//         return min;
//     }

//     public void helper(int[] nums, int k, List<Integer> l1, int index) {
//         if (l1.size() == k) {
//             int maxInSubset = Collections.max(l1);
//             min = Math.min(min, maxInSubset);
//             return;
//         }

//         if (index >= nums.length) {
//             return;
//         }

//         l1.add(nums[index]);
//         helper(nums, k, l1, index + 2);
//         l1.remove(l1.size() - 1); // Backtrack

       
//         helper(nums, k, l1, index + 1);
//     }
// }

////way 3 
class Solution {
       public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        while(left<right){
            int mid = left + (right - left) / 2;
            if (canPick(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canPick(int[] nums, int k, int maxCap) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
           if(nums[i]<=maxCap){
            count++;
            i += 2;
           }else{
            i++;
           }
           if (count >= k) return true;
        }
        return false;
    }
}
