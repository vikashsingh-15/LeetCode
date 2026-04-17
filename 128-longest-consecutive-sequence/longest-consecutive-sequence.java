class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        TreeSet<Integer>set=new TreeSet<>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }


        int prev=set.first();
        set.pollFirst();
        int count=1;
        int max=0;


        while(!set.isEmpty()){
            int curr=set.pollFirst();

            if(prev+1==curr){
                count++;
            }else{
                max=Math.max(count,max);
                count=1;
            }

                prev=curr;
        }

        max=Math.max(count,max);
        return max;
    }
}