class Solution {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0;i<m;i++){
            countSort(mat,i,0);
        }
        for(int i=0;i<n;i++){
            countSort(mat,0,i);
        }
        return mat;
    }
    
    public void countSort(int [][]mat,int row,int col){
        int m = mat.length;
        int n = mat[0].length;
        int i=row;int j=col;
        int dummy[]=new int[101];
        while(i<m && j<n){
            dummy[mat[i][j]]++;
            i++;
            j++;
        }
         i=row;
         j=col;
        for(int k=1;k<dummy.length;k++){
            while(dummy[k]>0){
                mat[i][j]=k;
                dummy[k]--;
                i++;
                j++;
            }
        }
        
    }
}
