// class Solution {
//     public long findScore(int[] nums) {
//         long ans = 0;
//         int[][] dp = new int[nums.length][2];
//         boolean[] marked = new boolean[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             dp[i][0] = nums[i];
//             dp[i][1] = i;
//         }
//         Arrays.sort(dp, (a, b) -> a[0] - b[0]);

//         for (int i = 0; i < nums.length; i++) {
//             int x = dp[i][0];
//             int index = dp[i][1];
//             if (!marked[index]) {
//                 ans += x;
//                 marked[index] = true;

//                 if (index >= 1) {
//                     marked[index - 1] = true;
//                 }
//                 if (index < nums.length - 1) {
//                     marked[index + 1] = true;
//                 }
//             }

//         }
//         return ans;
//     }
// }

////way 2

class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        Map <Integer,Integer>map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }

         TreeMap<Integer, Integer> sortedMap = new TreeMap<>(
            (key1, key2) -> {
                int compare = Integer.compare(map.get(key1), map.get(key2));
                if (compare == 0) {
                    return Integer.compare(key1, key2); 
                }
                return compare;
            }
        );

        sortedMap.putAll(map);



       

        for (int i = 0; i < nums.length; i++) {
            int index = sortedMap.firstEntry().getKey();
            int x = sortedMap.remove(index);
            if (nums[index]!=-1) {
                ans+=x;
                nums[index] = -1;
                if (index >0) {
                    nums[index - 1] = -1;
                }
                if (index < nums.length - 1) {
                    nums[index + 1] = -1;
                }
            }

        }


        return ans;
    }
}