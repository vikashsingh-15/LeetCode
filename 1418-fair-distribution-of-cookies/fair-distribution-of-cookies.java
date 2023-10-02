class Solution {
    int ans = Integer.MAX_VALUE;

    void helper(int[] cookies, int start, int k, int[] temp) {
        // System.out.println();
        // System.out.print("Start = " + start);
        // System.out.print(" k = " + k);
        // System.out.print(" Temp arr = " + Arrays.toString(temp));
        if (start == cookies.length) {
            int max = 0;
            for (int c : temp) max = Math.max(max, c);
            // System.out.print(" max = " + max);
            ans = Math.min(ans, max);
            // System.out.print(" ans = " + ans);
            return;
        }
        for (int i = 0; i < k; i++) {
            temp[i] += cookies[start];
            // System.out.print(" adding= " + cookies[start]);
            // System.out.print(" Temp arr after adding cookies = " + Arrays.toString(temp));
            helper(cookies, start + 1, k, temp);
            temp[i] -= cookies[start];
            // System.out.print(" removing = " + cookies[start]);
            // System.out.print(" Temp arr after removing cookies = " + Arrays.toString(temp));
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return ans;
    }
}