class Solution {

    public int countPrimes(int n) {
        //Way 1 -- Seive of erathosthenes

        int[] arr=new int[n];
        for(int i=2;i*i<arr.length;i++){
           for(int j=i+i;j<arr.length;j=j+i){ // i ke sare factors to mark kar raha hai ie=2+2=4 ;4+2=6;6+2=8...
               arr[j]=1;
           }
        }
        int out=0;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==0)
                out++;
        }
        return out;
        
        //Way 2

        //         boolean[] isprime = new boolean[n];
        //         int count = 0;
        //         for (int i = 2; i * i <= n; i++) {
        //             for (int j = i * 2; j < n; j += i) {
        //                 isprime[j] = true;
        //             }
        //         }

        //         for (int i = 2; i < isprime.length; i++) {
        //             if (isprime[i] == false) {
        //                 count++;
        //             }
        //         }
        //         return count;

        // Way 3 ---Time limit Excided;

        //         int count = 0;
        //         for (int i = 2; i < n; i++) {
        //             if (isPrime(i)) {
        //                 count++;
        //             }
        //         }
        //         return count;
        //     }

        //     public boolean isPrime(int num) {
        //         if (num % 2 == 0 && num != 2) {
        //             return false;
        //         }
        //         if (num % 3 == 0 && num != 3) {
        //             return false;
        //         }
        //         for (int i = 6; i <= Math.sqrt(num) + 1; i = i + 6) {
        //             if (num % (i - 1) == 0 || num % (i + 1) == 0) {
        //                 return false;
        //             }
        //         }
        //         return true;

    }
}
