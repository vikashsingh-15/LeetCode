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
        //  Map<Character, Integer> map = new HashMap<>();
        // Queue<Character> queue = new LinkedList<>();
        // Set<Character> set = new LinkedHashSet<>();

        // String ans = "";

        // for (int i = 0; i < str.length(); i++) {
        //     char c = str.charAt(i);
        //     if (map.containsKey(c)) {
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         if (set.contains(c)) {
        //             set.remove(c);
        //         }
        //     } else {
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         set.add(c);
        //     }

        //     if (!set.isEmpty()) {
        //         ans += set.iterator().next();
        //     } else {
        //         ans += "#";
        //     }
        // }

        // return ans;
        
        
        
        int[] count = new int[26]; // assuming only lowercase alphabets
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
            queue.add(c);

            while (!queue.isEmpty() && count[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(queue.peek());
            }
        }

        return ans.toString();
    }
}