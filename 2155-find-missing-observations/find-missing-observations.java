class Solution {
    public int[] missingRolls(int[] rolls, int m, int n) {
        int sumOfNum=(rolls.length+n)*m;
        int sum=0;
        for(int i=0;i<rolls.length;i++){
            sum+=rolls[i];
        }
        int missingNo=sumOfNum-sum;
        if(missingNo>n*6 || missingNo<n){
            return new int [] {};
        }
        int ans[]=new int[n];
        Arrays.fill(ans,missingNo/n);
        missingNo %=n;
        for(int i=0;i<missingNo;++i){
            ++ans[i];
        }
        return ans;
    }
}