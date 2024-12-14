class Solution {
    public long continuousSubarrays(int[] arr) {

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        int  left=0;
        int right=0;
        long windowLen=0,ans=0;

        min=max=arr[0];

        for( right=0; right <arr.length;right++){
            max=Math.max(max,arr[right]);
            min=Math.min(min,arr[right]);

            if(max-min <2){
                ans+=(right-left+1);
            }else{
                while(max-min>2){
                    if(arr[left]==min || arr[left]==max){
                        min = arr[left + 1];
                        max=arr[left+1];
                        for (int k = left + 1; k <= right; k++) {
                            max = Math.max(max, arr[k]);
                            min = Math.min(min, arr[k]);
                        }

                    }
                    left++;
                }
                ans+=(right-left+1);

            }

        }


       return ans; 
    }
}