class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&& (checkRow(i,grid) || checkCol(j,grid))){
                    count++;
                }
            }

        } 
        return count;
    }

    public static boolean  checkRow(int row,int [][]grid){
       int serverCount = 0;
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[row][j] == 1) {
                serverCount++;
            }
        }
        return serverCount > 1;
    }

     public static boolean  checkCol(int col,int [][]grid){
        int serverCount = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                serverCount++;
            }
        }
        return serverCount > 1;
    }
}