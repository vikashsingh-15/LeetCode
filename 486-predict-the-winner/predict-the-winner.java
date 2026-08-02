class Solution {
    public boolean predictTheWinner(int[] nums) {

        return canFirstWin(nums,0,nums.length-1)>=0;
        
    }

    public int canFirstWin (int nums[],int start,int end){
        if(start==end){
            return nums[start];
        }

        int chooseFirst=nums[start]-canFirstWin(nums,start+1,end);
        int chooseEnd=nums[end]-canFirstWin(nums,start,end-1);

        return Math.max(chooseFirst, chooseEnd);
    }
}