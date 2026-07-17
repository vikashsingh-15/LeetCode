import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            arr[i] = gcd(max, nums[i]);
        }

        Arrays.sort(arr);

        long ans = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            ans += gcd(arr[l], arr[r]);
            l++;
            r--;
        }

        return ans;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}