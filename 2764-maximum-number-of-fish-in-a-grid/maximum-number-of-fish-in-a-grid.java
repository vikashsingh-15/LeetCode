// class Solution {
//     public int findMaxFish(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int maxFishCount = 0;


//         boolean visited[][]=new boolean[n][m];

//          for (int row = 0; row < n; row++) {
//             for (int col = 0; col < m; col++) {
//                 if (grid[row][col] > 0 && !visited[row][col]) {
//                     maxFishCount = Math.max(
//                         maxFishCount,
//                         dfs(grid, row, col,visited)
//                     );
//                 }
//             }
//         }

//         return maxFishCount;

        
//     }

//     public static int  dfs(int[][] grid,int row,int col,boolean[][] visited){

//         if(row<0 || row>=grid.length||col<0 || col>=grid[0].length|| grid[row][col]==0 || visited[row][col]){
//             return 0;
//         }

//         visited[row][col]=true;

//         int top=dfs(grid,row+1,col,visited);
//         int down=dfs(grid,row-1,col,visited);
//         int left=dfs(grid,row,col-1,visited);
//         int right=dfs(grid,row,col+1,visited);

//         return grid[row][col]+top+down+left+right;
//     }
// }

////WAY 2

// class Solution {
//     public int findMaxFish(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int maxFishCount = 0;


//         boolean visited[][]=new boolean[n][m];

//          for (int row = 0; row < n; row++) {
//             for (int col = 0; col < m; col++) {
//                 if (grid[row][col] > 0 ) {
//                     maxFishCount = Math.max(
//                         maxFishCount,
//                         dfs(grid, row, col,visited)
//                     );
//                 }
//             }
//         }

//         return maxFishCount;

        
//     }

//     public static int  dfs(int[][] grid,int row,int col,boolean[][] visited){

//         if(row<0 || row>=grid.length||col<0 || col>=grid[0].length|| grid[row][col]==0 || visited[row][col]){
//             return 0;
//         }

//         visited[row][col]=true;

//         int top=dfs(grid,row+1,col,visited);
//         int down=dfs(grid,row-1,col,visited);
//         int left=dfs(grid,row,col-1,visited);
//         int right=dfs(grid,row,col+1,visited);

//         return grid[row][col]+top+down+left+right;
//     }
// }

////way 3


class Solution {
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxFishCount = 0;


        boolean visited[][]=new boolean[n][m];

         for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] > 0 ) {
                   grid[row][col]=dfs(grid, row, col,visited);
                   maxFishCount=Math.max(maxFishCount,grid[row][col]);
                }
            }
        }

        return maxFishCount;

        
    }

    public static int  dfs(int[][] grid,int row,int col,boolean[][] visited){

        if(row<0 || row>=grid.length||col<0 || col>=grid[0].length|| grid[row][col]==0 || visited[row][col]){
            return 0;
        }

        visited[row][col]=true;

        int top=dfs(grid,row+1,col,visited);
        int down=dfs(grid,row-1,col,visited);
        int left=dfs(grid,row,col-1,visited);
        int right=dfs(grid,row,col+1,visited);

        return grid[row][col]+top+down+left+right;
    }
}