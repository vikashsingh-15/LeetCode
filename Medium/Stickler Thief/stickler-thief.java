//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    public int MaxMoney(int arr[], int idx, int dp[]){
        if(idx < 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        int pickMoney = arr[idx] + MaxMoney(arr, idx-2, dp);
        int notPickMoney = 0 + MaxMoney(arr, idx-1, dp);
        
        return dp[idx] = Math.max(pickMoney, notPickMoney);
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return MaxMoney(arr, n-1, dp);
    }
}