//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
//     public static int floor(Node root, int x) {
//         ArrayList<Integer> list = new ArrayList<>();
//         traversal(root, x, list);
        
//         int floorValue = -1; // Initialize to -1 when x is smaller than the smallest node
        
//         for (int value : list) {
//             if (value <= x) {
//                 floorValue = Math.max(value,floorValue);
//             }
//         }
        
//         return floorValue;
//     }

//     public static void traversal(Node root, int x, ArrayList<Integer> list) {
//         if (root == null) {
//             return;
//         }
//         traversal(root.left, x, list);
//         traversal(root.right, x, list);
//         list.add(root.data);
//     }
// }

//way 2

class Solution {
    public static int floor(Node root, int x) {
        return traversal(root, x, -1);
    }

    public static int traversal(Node root, int x, int ans) {
        if (root == null) {
            return ans;
        }
        if (root.data <= x) {
            ans = Math.max(ans, root.data);
        }

        ans = traversal(root.left, x, ans);
        ans = traversal(root.right, x, ans);

        return ans;
    }
}


