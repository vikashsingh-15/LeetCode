//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int N, int[] numerator, int[] denominator) {
         Map<String, Integer> sumCount = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = numerator[i];
            int den = denominator[i];
            int gcd = gcd(num, den);
            
            // Simplify the fraction
            num /= gcd;
            den /= gcd;
            
            // Calculate the sum of the simplified fraction as a string to avoid floating-point inaccuracies
            String sumKey = (den - num) + "/" + den;
            
            // Check if the complement of the sumKey exists in the HashMap
            String complementKey = (num) + "/" + den;
            if (sumCount.containsKey(complementKey)) {
                count += sumCount.get(complementKey);
            }
            
            // Update the count of the current sumKey
            sumCount.put(sumKey, sumCount.getOrDefault(sumKey, 0) + 1);
        }
        
        return count;
    }
     private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

// TLE

// class Solution {
//     public static int countFractions(int N, int[] numerator, int[] denominator) {
//         int count=0;
//         for(int i=0;i<N;i++){
//             for(int j=i+1;j<N;j++){
              
//               double lcm= lcm(denominator[i],denominator[j]);
//               double term1=((lcm/denominator[i])*numerator[i]);
//                 double term2=((lcm/denominator[j])*numerator[j]);
//                 double sum=(double)((double)(term1+term2)/lcm);
//                 if(sum==1.0){
//                     count++;
//                 }
//             }
//         }
//         return count;
        
//     }
//      public static double lcm(int a, int b) {
//         return (a * b) / gcd(a, b);
//     }
//      public static double gcd(int a, int b) {
//         if (b == 0) {
//             return a;
//         }
//         return gcd(b, a % b);
//     }
// }

