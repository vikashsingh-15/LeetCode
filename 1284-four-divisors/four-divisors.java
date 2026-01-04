class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans=0;

        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            int temp=0;
            int count=0;
            for  (int j=1;j<=Math.sqrt(x);j++){
                if(x%j==0){
                    int other = x / j;
                   if(other==j){
                    count++;
                    temp+=j;
                   }else{
                    count+=2;
                    temp+=j+other;
                   }
                }

            }

            if(count==4){
                ans+=temp;
            }
        }
       return ans; 
    }
}