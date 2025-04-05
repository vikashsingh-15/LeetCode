class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int num:rolls){
            sum+=num;
        }
        int expectedTotal=mean*(n+rolls.length);
        int needed=expectedTotal-sum;

         if (needed < n || needed > n * 6) {
            return new int[0]; 
        }

        int base=needed/n;
        int arr[]=new int[n];
        Arrays.fill(arr, base);

        int rem=needed%n;

        for(int i=0;i<rem;i++){
            arr[i]+=1;
        }
        return arr;
    }
}