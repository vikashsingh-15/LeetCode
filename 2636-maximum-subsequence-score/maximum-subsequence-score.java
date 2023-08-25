class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
         int n = nums1.length;
        int[][] res = new int[n][2];
        for(int i=0; i<n; i++){
            res[i][0]=nums1[i];
            res[i][1]=nums2[i];
            // or
            // res[i] = new int[]{nums1[i], nums2[i]};
        }

        Arrays.sort(res, (a, b) -> b[1] - a[1]);

        long ans=0;
        long sum=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(res[i][0]);
            sum+=res[i][0];
            if(pq.size()==k){
                ans=Math.max(ans,sum*res[i][1]);
                sum-=pq.poll();
            }

        }
        return ans;
    }
}


//way 2 -> TLE

// class Solution {

//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         List<List<Integer>> subsequences1 = new ArrayList<>();
//         generateSubsequences1Helper(nums1, new ArrayList<>(), 0, subsequences1, k);

//         List<List<Integer>> subsequences2 = new ArrayList<>();
//         generateSubsequences1Helper(nums2, new ArrayList<>(), 0, subsequences2, k);

//         long maxScore = 0;

//         for (int i = 0; i < subsequences1.size(); i++) {
//             List<Integer> subsequence1 = subsequences1.get(i);
//             List<Integer> subsequence2 = subsequences2.get(i);
//             // System.out.println("subsequence 1: " + subsequence1);
//             // System.out.println("subsequence 2: " + subsequence2);

//             int score = calculateScore(subsequence1, subsequence2);
//             maxScore = Math.max(maxScore, score);
//         }

//         for (List<Integer> subsequence1 : subsequences1) {
//             for (List<Integer> subsequence2 : subsequences2) {}
//         }

//         return maxScore;
//     }

//     private void generateSubsequences1Helper(int[] arr, List<Integer> current, int index, List<List<Integer>> subsequences, int k) {
//         if (current.size() == k) {
//             subsequences.add(new ArrayList<>(current));
//             return;
//         }

//         if (index >= arr.length) {
//             return;
//         }

//         // Include the current element
//         current.add(arr[index]);
//         generateSubsequences1Helper(arr, current, index + 1, subsequences, k);
//         current.remove(current.size() - 1);

//         // Exclude the current element
//         generateSubsequences1Helper(arr, current, index + 1, subsequences, k);
//     }

//     private int calculateScore(List<Integer> subsequence1, List<Integer> subsequence2) {
//         int sum = 0;
//         for (int num : subsequence1) {
//             sum += num;
//         }

//         int min = Integer.MAX_VALUE;
//         for (int num : subsequence2) {
//             if (num < min) {
//                 min = num;
//             }
//         }

//         int score = sum * min;
//         return score;
//     }
// }
