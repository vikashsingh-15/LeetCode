class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
      int n = A.length;
        int[] ans = new int[n];
        Set<Integer> elementsInA = new HashSet<Integer>();
        Set<Integer> elementsInB = new HashSet<Integer>();

         for (int i = 0; i < n; ++i) {
             elementsInA.add(A[i]);
            elementsInB.add(B[i]);
            int common = 0;

            for(int x : elementsInA){
                if(elementsInB.contains(x)){
                    common++;
                }
            }

            ans[i]=common;
         }
        return ans;
    }
}