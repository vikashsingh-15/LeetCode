class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }

        int maxLength=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prev=arr[j];
                int expected=arr[i]+arr[j];
                int currLength=2;

                while(set.contains(expected)){
                    int temp=prev;
                    prev=expected;
                    expected=temp+prev;
                    currLength++;
                    maxLength=Math.max(currLength,maxLength);
                }
            }
        }

        return maxLength;
    }
}