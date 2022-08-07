class Solution {

    public int subarraysDivByK(int[] arr, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            int rem = sum % k;
            if (rem < 0) {
                rem = rem + k;
            }
            if(rem==0){
                ans++;
            }

            if (map.containsKey(rem)) {
                ans = ans + map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}
