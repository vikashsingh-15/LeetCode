//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends




class Solution
{
    public String FirstNonRepeating(String str)
    {

  Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            queue.add(c);

            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(queue.peek());
            }
        }

        return ans.toString();
        
        
        
        
    //   int[] count = new int[26]; // assuming only lowercase alphabets
    //     Queue<Character> queue = new LinkedList<>();
    //     StringBuilder ans = new StringBuilder();

    //     for (int i = 0; i < str.length(); i++) {
    //         char c = str.charAt(i);
    //         count[c - 'a']++;
    //         queue.add(c);
            
    //         while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
    //             queue.poll();
    //         }

    //         if (queue.isEmpty()) {
    //             ans.append('#');
    //         } else {
    //             ans.append(queue.peek());
    //         }
    //     }

    //     return ans.toString();
    }
}