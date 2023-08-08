//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static long largestPrimeFactor(int N) {
       for(int i = 2; i<=Math.sqrt(N); i++){
          if(N%i==0){
             N = N/i;
             i--;
            }
        }
    return N; 
    }
}

// class Solution{
//     static long largestPrimeFactor(int N) {
//          long maxPrime = -1;

//         // Divide the number by 2 until it becomes odd
//         while (N % 2 == 0) {
//             maxPrime = 2;
//             N /= 2;
//         }

//         // Check for odd factors from 3 to the square root of N
//         for (int i = 3; i <= Math.sqrt(N); i += 2) {
//             while (N % i == 0) {
//                 maxPrime = i;
//                 N /= i;
//             }
//         }

//         // If N becomes a prime greater than 2
//         if (N > 2) {
//             maxPrime = N;
//         }

//         return maxPrime;
//     }
// }

