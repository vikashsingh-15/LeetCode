class Solution {

    public long mostPoints(int[][] arr) {
        int n = arr.length;
        long dp[] = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            // System.out.println("Checking = " + i);
            int point = arr[i][0];
            int jump = arr[i][1];
            // System.out.print(" point = " + point);
            // System.out.print(" jump = " + jump);
            int nextQuestion = Math.min(n, i + jump + 1);
            // System.out.print(" next question = " + nextQuestion);
            dp[i] = Math.max(dp[i + 1], point + dp[nextQuestion]);
            //             System.out.print(" dp{nextQuestion }= " + dp[nextQuestion]);
            //             System.out.print(" dp{i+1 }= " + dp[i+1]);
            //             System.out.println(" dp{i }= " + dp[i]);
        }

        return dp[0];
    }
}
