//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int x_xor_y=0;
        for(int num:nums){
            x_xor_y=x_xor_y^num;
        }

        int r_msb = x_xor_y & -x_xor_y; //r_msb=right most set bit
        int x=0;
        int y=0;
        for(int num:nums){
            if((num & r_msb)==0){
                x=x^num;
            }else{
                y=y^num;
            }
        }

        int ans[]=new int[2];
        if(x<=y){
            ans[0]=x;
            ans[1]=y;
        }else{
            ans[0]=y;
            ans[1]=x;
        }

        return ans;
    }
}