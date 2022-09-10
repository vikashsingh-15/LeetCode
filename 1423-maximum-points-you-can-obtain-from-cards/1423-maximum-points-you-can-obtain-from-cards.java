class Solution {
    public int maxScore(int[] arr, int k) {
        
        //way 1
        
        int sum=0;
        for(int i=arr.length-k;i<arr.length;i++){
            sum+=arr[i];
        }
        int max=sum;
        // int max=0;
        for(int i=0;i<k;i++){
            sum=sum+arr[i]-arr[arr.length-k+i];
            max=Math.max(sum,max);
        }
        return max;
    }
}