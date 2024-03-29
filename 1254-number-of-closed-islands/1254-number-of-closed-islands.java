class Solution {
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 ||j==0 || i==grid.length-1 || j==grid[0].length-1){//to run code on border only
                    if(grid[i][j]==0){
                        dfs(grid,i,j);
                    }
                }
            }
        }
        int count=0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==0){
                        dfs(grid,i,j);
                      count++;
                     }
            }
        } 
        return count;
    }
    
     public static void dfs(int [][] grid,int i,int j){
        if(i<0 ||j<0 || i>=grid.length||j>=grid[0].length||grid[i][j]==1){
            return;
        }else{
            grid[i][j]=1;
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}

// class Solution {
//     public int closedIsland(int[][] grid) {
        
//     }
// }