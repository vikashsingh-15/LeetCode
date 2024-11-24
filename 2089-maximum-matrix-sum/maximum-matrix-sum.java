class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum=0;
        int minValue=Integer.MAX_VALUE;
        int count=0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                totalSum+=Math.abs(matrix[i][j]);

                if(matrix[i][j]<0){
                    count++;
                }
                minValue=Math.min(minValue,Math.abs(matrix[i][j]));
            }
        }

        if(count%2!=0){
            totalSum-=2*minValue;
        }
        return totalSum;
        
    }
}