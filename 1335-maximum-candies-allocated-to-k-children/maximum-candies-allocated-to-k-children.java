class Solution {
    public int maximumCandies(int[] arr, long k) {
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }

        int left=1;
        int right=max;

        while(left<=right){
           int  mid = left + (right - left) / 2;
            if(helper(arr,k,mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;  
    }

    private boolean helper(int arr[],long k,int numOfCandies){

         long maxNumOfChildren = 0;
        for(int i=0;i<arr.length;i++){
             maxNumOfChildren +=arr[i]/numOfCandies;
        }

        return maxNumOfChildren>=k;
    }
}