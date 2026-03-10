class Solution {

    public int fib(int n) {
        if(n<1){
            return n;
        }
       int  prev_2=0;//two no back prev 2
       int prev_1=1;// onw no back prev 

       for(int i=2;i<=n;i++){
        int current=prev_1+prev_2;
        prev_2=prev_1;
        prev_1=current;

       }
        return prev_1;
    }
}