class Solution {
    public int tribonacci(int n) {
         int T0=0;
        int T1=1;
        int T2=1;
        int Tn=0;
        
        if(n==0 || n==1){
            return n;
        }
        else if(n==2){
            return T2;
        }
        else{
            for(int i=3;i<=n;i++){
                Tn=T0+T1+T2;
                T0=T1;
                T1=T2;
                T2=Tn;
            }
        }
        
        return Tn;
        
    }
}