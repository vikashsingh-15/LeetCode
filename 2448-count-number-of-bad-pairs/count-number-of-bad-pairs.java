class Solution {

    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];

            // Count of previous positions with same difference
           int goodPair=map.getOrDefault(diff,0);

           badPairs+=pos-goodPair;

           map.put(diff,goodPair+1);


        }

        return badPairs;
    }
}