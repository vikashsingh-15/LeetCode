class Solution {
    public int largestCombination(int[] nums) {

        int bitCount[]=new int [24];

        for(int i=0;i<24;i++ ){
            for(int num:nums){
                if((num &  (1<<i))!=0){
                    bitCount[i]++;
                }

            }
        }

        int max=0;

        for(int count:bitCount){
            if(count>max){
                max=count;
            }
        }

        return max;
        
    }
}