class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int[] sign = new int[]{-1,1};
        int result = Integer.MIN_VALUE;
        int n = arr1.length;

        for(int a=0; a<2; a++){
            for(int b=0; b<2; b++){
                int sum=0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int i=0; i<n; i++){
                    sum = (sign[a]*arr1[i]) + (sign[b]*arr2[i]) + i;
                    max = Math.max(max,sum);
                    min = Math.min(min,sum);
                    result = Math.max(result, max - min);
                }

                                  }                                                                                                                                                                                                             
        }

        return result;
    }
}