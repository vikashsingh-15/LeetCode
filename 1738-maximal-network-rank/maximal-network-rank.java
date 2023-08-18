class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
          boolean[][] connected = new boolean[n][n];
        int[] count = new int[n];
        int maxRank = 0;
        
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            connected[city1][city2] = true;
            connected[city2][city1] = true;
            count[city1]++;
            count[city2]++;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = count[i] + count[j];
                if (connected[i][j]) {
                    rank--;
                }
                maxRank = Math.max(maxRank, rank);
            }
        }
        
        return maxRank; 
    }
}