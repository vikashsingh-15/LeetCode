class Solution {
    int mod = 1_000_000_007;
    public int concatenatedBinary(int n) {

        long ans=0;
        int len=0;

        for(int i=1;i<=n;i++){
            if((i & (i-1))==0){
                len++;
            }

            ans=((ans<<len) | i)%mod;
        }
        return (int)ans;
    }
}