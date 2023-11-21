class Solution {

    public int countNicePairs(int[] nums) {
       int mod = 1_000_000_007;

        Map<Integer, Integer> map = new HashMap<>();
        int nicePairs = 0;

        for (int num : nums) {
            int diff = num - reverse(num);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        for (int count : map.values()) {
            //   nicePairs = (int) ((nicePairs + (long) count * (count - 1) / 2) % mod);

            //   //or//
            long additionalPairs = (long) count * (count - 1) / 2;
            long updatedNicePairs = nicePairs + additionalPairs;
            int finalNicePairs = (int) (updatedNicePairs % mod);
            nicePairs = finalNicePairs;
        }

        return nicePairs;
    }

    public int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num = num / 10;
        }
        return reversed;

        // String numStr = Integer.toString(num);
        // StringBuilder reversedStr = new StringBuilder(numStr).reverse();
        // return Integer.parseInt(reversedStr.toString());
    }
}
