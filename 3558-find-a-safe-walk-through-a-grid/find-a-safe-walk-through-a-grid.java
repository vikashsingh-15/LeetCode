// class Solution {

//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         int m = grid.size();
//         int n = grid.get(0).size();

//         int[][] dist = new int[m][n];
//         for (int[] row : dist)
//             Arrays.fill(row, Integer.MAX_VALUE);

//         Deque<int[]> dq = new ArrayDeque<>();

//         dist[0][0] = grid.get(0).get(0);
//         dq.offerFirst(new int[]{0, 0});

//         int[] dr = {-1, 1, 0, 0};
//         int[] dc = {0, 0, -1, 1};

//         while (!dq.isEmpty()) {
//             int[] cur = dq.pollFirst();
//             int r = cur[0];
//             int c = cur[1];

//             for (int k = 0; k < 4; k++) {
//                 int nr = r + dr[k];
//                 int nc = c + dc[k];

//                 if (nr < 0 || nr >= m || nc < 0 || nc >= n)
//                     continue;

//                 int cost = grid.get(nr).get(nc);

//                 if (dist[r][c] + cost < dist[nr][nc]) {
//                     dist[nr][nc] = dist[r][c] + cost;
//                     dq.offerLast(new int[]{nr, nc});
//                 }
//             }
//         }

//         return dist[m - 1][n - 1] < health;
//     }
// }

//DFS

class Solution {
     int m, n;
    int[][] maxHealth;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        maxHealth = new int[m][n];

        for (int[] row : maxHealth)
            Arrays.fill(row, -1);

        return dfs(0, 0, health, grid);
    }

    private boolean dfs(int r, int c, int health, List<List<Integer>> grid) {

        health-=grid.get(r).get(c);

        if(health<=0){
            return false;
        }

        if (r == m - 1 && c == n - 1)
            return true;


        if (maxHealth[r][c] >= health)
            return false;

        maxHealth[r][c] = health;


        for(int i=0;i<4;i++){
            int nr=r+dir[i][0];
            int nc=c+dir[i][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (dfs(nr, nc, health, grid)){
                   return true;
                }    
            }
        }

        return false;
    }
}
