//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
    
    // compute reverse of a number
    public static long rev(long n)
    {
        long rev_num = 0;
         while(n > 0) 
          { 
            rev_num = rev_num*10 + n%10; 
            n = n/10; 
          } 
          return rev_num;
    }
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
        //testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int N;
		    
		    
            //input N
		    N=sc.nextInt();
		    int R=0;
		    
		    	    
            // reverse the given number n
		    R=(int)rev(N);
	
            //power of the number to it's reverse
		    long ans=(long)obj.power(N,R);
		    System.out.println(ans);
		    
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
     static final int MOD = 1000000007;

    public long power(int N, int R) {
        if (N == 0) return 0;

        long x = N;
        long b = R;
        long res = 1;

        if (b < 0) {
             x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            b /= 2;
        }

        return res;
    }

}
