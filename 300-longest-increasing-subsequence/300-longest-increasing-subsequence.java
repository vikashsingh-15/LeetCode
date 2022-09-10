class Solution {

    public int lengthOfLIS(int[] nums) {
        //         //way 1
        //         int arr[]=new int [nums.length];
        //         int ans=Integer.MIN_VALUE;
        //         arr[0]=1;
        //         for(int i=1;i<nums.length;i++){
        //             int max=0;
        //             for(int j=0;j<i;j++){
        //                 if(nums[j]<nums[i] && arr[j]>max){
        //                    max=arr[j];
        //                 }
        //             }
        //             arr[i]=max+1;
        //             ans=Math.max(ans,arr[i]);//we can do that outside a loop also,just to chech max in arr;
        //         }

        //         return ans==Integer.MIN_VALUE?1:ans;

        //way 2
        int lis[] = new int[nums.length];
        Arrays.fill(lis, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; i++) { //to get longest increasing subsequence ending at this index i
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] >= lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
            ans = Math.max(ans, lis[i]); //update ans if we have maximum than cur ans
        }
        return ans;
    }
}
