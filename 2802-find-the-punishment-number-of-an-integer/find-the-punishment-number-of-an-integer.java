class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int square=i*i;
            if(helper(String.valueOf(square),0,i)){
                ans+=square;
            }
        }
        return ans;
    }

    public boolean helper(String str,int sum,int target){

        if(sum==target && str.length()==0){
            return true;
        }

       if (str.isEmpty() || sum > target) {
            return false;
        }

        for(int i=1;i<=str.length();i++){
            String left=str.substring(0,i);
            String right=str.substring(i);
            int leftValue = Integer.parseInt(left);
           
           if(helper(right,sum+leftValue,target)){
            return true;
           }
        }
        return false;

    }
}