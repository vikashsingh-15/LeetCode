//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends






// class Solution 
// {
//     //Function to find length of longest increasing subsequence.
//     static int longestSubsequence(int size, int nums[])
//     {
//         int[] dp = new int[size];
//         int len = 0;

//         for (int i=0;i<size;i++) {
//             int index = binarySearch(dp, 0, len, nums[i]);

//             dp[index] = nums[i];

//             if (index == len) {
//                 len++;
//             }
//         }

//         return len;
//     }
//      public static int binarySearch(int[] dp, int low, int high, int target) {
//         while (low < high) {
//             int mid = low + (high - low) / 2;
//             if (dp[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }
//         return low;
//     }
// } 






class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        int[] dp = new int[size];
        int len = 0;
        
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            
            if (index < 0) {
                index = -(index + 1);
            }
            
            dp[index] = num;
            
            if (index == len) {
                len++;
            }
        }
        
        return len;
    }
} 