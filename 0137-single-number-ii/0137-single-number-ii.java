class Solution {

    public int singleNumber(int[] nums) {
        //         int seenOnce = 0;
        //         int seenTwice = 0;

        //         for (int num : nums) {
        //             seenOnce = ~seenTwice & (seenOnce ^ num);
        //             seenTwice = ~seenOnce & (seenTwice ^ num);
        //         }

        //         return seenOnce;

        //WAY 2
        // int result = 0;
        // for (int i = 0; i < 32; i++) {
        //     int count = 0;
        //     int mask = 1 << i;
        //     for (int num : nums) {
        //         if ((num & mask) != 0) {
        //             count++;
        //         }
        //     }
        //     if (count % 3 != 0) {
        //         result |= mask;
        //     }
        // }
        // return result;

        
        
        //way 3
        // wrong approach work only when ans is not negative

        //         int tn=Integer.MAX_VALUE, tnp1=0, tnp2=0;

        //         for(int i=0;i<nums.length;i++){
        //             int cwt=tn&nums[i];
        //             int cwtnp1=tnp1&nums[i];
        //             int cwtnp2=tnp2&nums[i];

        //             tn=tn & (~cwt);
        //             tnp1=cwt | tnp1;

        //             tnp1=tnp1&(~cwtnp1);
        //             tnp2=cwtnp1 | tnp2;

        //             tnp2=tnp2&(~cwtnp2);
        //             tn=cwtnp2 | tn;
        //         }

        //         return (int)tnp1;

        //way 4

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
