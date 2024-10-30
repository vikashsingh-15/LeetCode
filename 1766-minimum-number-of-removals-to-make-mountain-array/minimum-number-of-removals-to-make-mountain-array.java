// class Solution {
//     public int minimumMountainRemovals(int[] nums) {
//          List<List<Integer>> subsequences = new ArrayList<>();
//         generateSubsequences(nums, 0, new ArrayList<>(), subsequences);
//         int minRemove=Integer.MAX_VALUE;

//         for(List<Integer>list:subsequences){
//             System.out.print("List = "+list.toString());
//             int incr = 0;
//             int decr = 0;
//             int incr2 = 0;
//             int decr2 = 0;
//             for(int i=1;i<list.size();i++){
//                 if (list.get(i-1)<list.get(i)){
//                     incr++;
//                 }
//                 else if(list.get(i-1)>list.get(i)){
//                     decr++;
//                 }
//                  if (list.get(i-1)>list.get(i)){
//                     incr2++;
//                 }
//                 else if(list.get(i-1)<list.get(i)){
//                     decr2++;
//                 }
//             }
//             if ((incr > 0 && decr > 0 && incr + decr == list.size() - 1)||(incr2 > 0 && decr2 > 0 && incr2 + decr2 == list.size())) {
//                 System.out.print("  mountain");
//                 minRemove = Math.min(minRemove, nums.length - list.size());
//             }
//             System.out.println();
//         }

//         return minRemove == Integer.MAX_VALUE ? 0 : minRemove;
//     }

//     private static void generateSubsequences(int[] nums, int index, List<Integer> current, List<List<Integer>> subsequences) {
//         if (index == nums.length) {
//             subsequences.add(new ArrayList<>(current));
//             return;
//         }

//         current.add(nums[index]);
//         generateSubsequences(nums, index + 1, current, subsequences);
//         current.remove(current.size() - 1);
//         generateSubsequences(nums, index + 1, current, subsequences);
//     }
// }

// class Solution {
//     public int minimumMountainRemovals(int[] arr) {
//         List<List<Integer>> subsequences = new ArrayList<>();
//         generateSubsequences(arr, 0, new ArrayList<>(), subsequences);
//         int minRemove = Integer.MAX_VALUE;

//         for (List<Integer> list : subsequences) {
//             System.out.print("List = " + list.toString());
//             int n = list.size();
//             int i = 0;
//             boolean invalid = false;
//             while (i < n - 1 && list.get(i) < list.get(i + 1)) {
//                 i++;
//             }
//             if (i == 0 || i == n - 1) {
//                 invalid = true;
//             }
//             int leftCount = i;
//             int rightCount = n - i - 1;

//             if (leftCount == rightCount) {
//                 while (i < n - 1 && list.get(i) > list.get(i + 1)) {
//                     i++;
//                 }
//                 if (i == n - 1 && !invalid && n > 3) {
//                     System.out.print("  mountain");
//                     minRemove = Math.min(minRemove, arr.length - list.size());
//                 }
//             }
//             System.out.println();
//         }

//         return minRemove == Integer.MAX_VALUE ? 0 : minRemove;
//     }

//     private static void generateSubsequences(int[] nums, int index, List<Integer> current,
//             List<List<Integer>> subsequences) {
//         if (index == nums.length) {
//             subsequences.add(new ArrayList<>(current));
//             return;
//         }

//         current.add(nums[index]);
//         generateSubsequences(nums, index + 1, current, subsequences);
//         current.remove(current.size() - 1);
//         generateSubsequences(nums, index + 1, current, subsequences);
//     }
// }







class Solution {

    private List<Integer> getLongestIncreasingSubsequenceLength(
        List<Integer> v
    ) {
        List<Integer> lisLen = new ArrayList<>(
            Collections.nCopies(v.size(), 1)
        );
        List<Integer> lis = new ArrayList<>();
        lis.add(v.get(0));

        for (int i = 1; i < v.size(); i++) {
            int index = lowerBound(lis, v.get(i));

            // Add to the list if v[i] is greater than the last element
            if (index == lis.size()) {
                lis.add(v.get(i));
            } else {
                // Replace the element at index with v[i]
                lis.set(index, v.get(i));
            }

            lisLen.set(i, lis.size());
        }

        return lisLen;
    }

    // Returns the index of the first element which is equal to or greater than target.
    private int lowerBound(List<Integer> lis, int target) {
        int left = 0, right = lis.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) numsList.add(num);

        List<Integer> lisLength = getLongestIncreasingSubsequenceLength(
            numsList
        );

        Collections.reverse(numsList);
        List<Integer> ldsLength = getLongestIncreasingSubsequenceLength(
            numsList
        );
        // Reverse the length array to correctly depict the lenght of longest decreasing subsequnec for each index.
        Collections.reverse(ldsLength);

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength.get(i) > 1 && ldsLength.get(i) > 1) {
                minRemovals = Math.min(
                    minRemovals,
                    N - lisLength.get(i) - ldsLength.get(i) + 1
                );
            }
        }

        return minRemovals;
    }
}