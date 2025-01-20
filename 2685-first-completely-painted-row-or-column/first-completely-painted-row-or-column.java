class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length, numCols = mat[0].length;
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int value = mat[row][col];
                map.put(value, new Pair(row, col));
            }
        }

        for(int i=0;i<arr.length;i++){
           int num = arr[i];
            Pair<Integer, Integer> pos = map.get(num);
            int row = pos.getKey();
            int col = pos.getValue();
            mat[row][col]=-1;
            if(checkRow(row,mat)||checkColumn(col,mat)){
                return i;
            }
        }

        return -1;
    }

    private boolean checkRow(int row, int[][] mat) {
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) {
                return false;
            }
        }
        return true;
    }
}