class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
      int n = A.length;
        int[] ans = new int[n];
        Set<Integer> elementsInA = new HashSet<Integer>();
        Set<Integer> elementsInB = new HashSet<Integer>();
        int count=00;

        for(int i=0;i<A.length;i++){
            elementsInA.add(A[i]);
            elementsInB.add(B[i]);
             count=0;
            for(int x:elementsInA){
                if(elementsInB.contains(x)){
                    count++;
                }

            }
            ans[i]=count;
        }
        return ans;

    }
}