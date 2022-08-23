class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int k =0,l=0;
        int c=1;
        while(c<mat.length){
        for(int i =0;i<mat.length-1;i++){
            for(int j =0;j<mat[i].length-1;j++){
                k=i+1;
                l=j+1;
                if(mat[i][j]>mat[k][l]){
                    int temp = mat[i][j];
                    mat[i][j] = mat[k][l];
                    mat[k][l] = temp;
                }
            }
        }
            c++;
        }
        return mat;
        
    }
}