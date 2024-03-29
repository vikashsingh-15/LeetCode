//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends




/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

// class Solution
// {
//     public static Node reverse(Node node, int k)
//     {
//       int count = 0;
//         Node dummy = new Node(-1); 
//         dummy.next = node;
//         Node prev = dummy;
//         Node curr = node;
//         while (curr != null) {
//             count++;
//             if (count == k) {
//                 prev = reverseGroup(prev, curr.next); 
//                 curr = prev.next; 
//                 count = 0;
//             } else {
//                 curr = curr.next; 
//             }
//         }
//         if(count<k && count!=0){
//             reverseGroup(prev, curr); 
//         }

//         return dummy.next; 
//     }
    
    
//      private static Node reverseGroup(Node prev, Node next) {
//       Node last = prev.next;
//     Node curr = last.next;

//     while (curr != next) {
//         Node forward = curr.next;
//         curr.next = prev.next;
//         prev.next = curr;
//         last.next = forward;
//         curr = forward;
//     }

//     return last;
//     }
// }

class Solution {
    public static Node reverse(Node node, int k) {
        Node current = node;
        Node next = null;
        Node prev = null;
        int count = 0;

        // Count the number of nodes in the current group
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursively reverse the next group and connect it to the current group's head
        if (next != null) {
            node.next = reverse(next, k);
        }

        // 'prev' is the new head of the reversed group
        return prev;
    }
}

