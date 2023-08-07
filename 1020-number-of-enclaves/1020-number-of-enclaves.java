// class Solution {
//     public int numEnclaves(int[][] grid) {
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(i==0 ||j==0 || i==grid.length-1 || j==grid[0].length-1){//to run code on border only
//                     if(grid[i][j]==1){
//                         dfs(grid,i,j);
//                     }
//                 }
//             }
//         }
//         int count=0;
//          for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                     if(grid[i][j]==1){
//                       count++;
//                      }
//             }
//         } 
//         return count;
//     }
    
//     public static void dfs(int [][] grid,int i,int j){
//         if(i<0 ||j<0 || i>=grid.length||j>=grid[0].length||grid[i][j]==0){
//             return;
//         }else{
//             grid[i][j]=0;
//             dfs(grid,i+1,j);
//             dfs(grid,i-1,j);
//             dfs(grid,i,j+1);
//             dfs(grid,i,j-1);
//         }
//     }
// }

class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        
        //along the row
        for(int row=0;row<m;row++){
            // if(grid[row][0]==1){
            //     dfs(grid,row,0);
            // }
            // if(grid[row][n-1]==1){
            //      dfs(grid,row,n-1);
            // }
                dfs(grid,row,0);
                 dfs(grid,row,n-1);            
        }
        
        //along the col
        for(int col=0;col<n;col++){
            // if(grid[0][col]==1){
            //     dfs(grid,0,col);
            // }
            // if(grid[m-1][col]==1){
            //      dfs(grid,m-1,col);
            // }
            
                dfs(grid,0,col);
                 dfs(grid,m-1,col);
        }
        
         int count=0;
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1){
                      count++;
                     }
            }
        } 
        return count;
        
    }
    
        public static void dfs(int [][] grid,int i,int j){
        if(i<0 ||j<0 || i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return;
        }else{
            grid[i][j]=0;
            dfs(grid,i+1,j);
            dfs(grid,i-1,j);
            dfs(grid,i,j+1);
            dfs(grid,i,j-1);
        }
    }
}