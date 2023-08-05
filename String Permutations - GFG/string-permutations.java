//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String input)
    {
        ArrayList<String> result = new ArrayList<>();
        permuteString1Helper(input.toCharArray(), 0, result);
        Collections.sort(result);
        return result;
    }
    
       public void permuteString1Helper(char[] chars, int start,List<String> result) {
        if (start == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            swap(chars, start, i);
            permuteString1Helper(chars, start + 1, result);
            swap(chars, start, i); // Backtrack to restore the original string
        }
    }
    
    
    public  void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
	   
}
