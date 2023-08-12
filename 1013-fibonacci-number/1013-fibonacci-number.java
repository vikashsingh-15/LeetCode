class Solution {

    public int fib(int n) {
        //this is not nth fibonaci number,it is fibonaci of n number
        //f(0)=0,f(1)=1,f(2)=1,f(3)=2,f(4)=3,f(5)=5,f(6)=8
        //6th fibonaci=5
        //fibpnaci(6)=8


        //way 1
        // int qb[] = new int[n + 1];
        // return fibMemoize(n, qb);
        //way2
        //         if(n<=1){
        //             return n;
        //         }

        //         return fib(n-1)+fib(n-2);

        //way3
        // if(n==0 || n==1){
        //     return n;
        // }
        // int fibn1=fib(n-1);
        // int fibn2=fib(n-2);
        // int fibn=fibn1+fibn2;
        // return fibn;

        //way 4
          if (n <= 1) {
            return n;
        }
        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    public int fibMemoize(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        int fibn1 = fib(n - 1);
        int fibn2 = fib(n - 2);
        int fibn = fibn1 + fibn2;
        qb[n] = fibn;
        return fibn;
    }
}