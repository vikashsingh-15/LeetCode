class Solution {
    public boolean checkPowersOfThree(int n) {


        while(n>1){
            int rem=n%3;
            if(rem==2){
                return false;
            }
            n/=3;
        }
       return true; 
    }
}