//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                GfG g = new GfG();
                if(g.isSymmetric(root) == true)
                    System.out.println("True");
                else
                    System.out.println("False");
        	
                t--;
            
        }
    }
}



// } Driver Code Ends


/*
class of the node of the tree is as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
// complete this function
// return true/false if the is Symmetric or not
// class GfG
// {
//     // return true/false denoting whether the tree is Symmetric or not
//     public static boolean isSymmetric(Node root)
//     {
//          return helper(root, root);
//     }
//     public static boolean helper(Node root1, Node root2){
//         if(root1==null && root2==null)return true;
//         if(root1==null || root2==null)return false;
//         if(root1.data != root2.data)return false;
//         return helper(root1.left, root2.right) && helper(root1.right, root2.left);
//     }
// }


class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
         if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> levelOrder = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();

                if (temp != null) {
                    if (temp.left != null) {
                        levelOrder.add(temp.left.data);
                    }
                    if (temp.right != null) {
                        levelOrder.add(temp.right.data);
                    }

                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }

            if (levelOrder.size() % 2 != 0) {
                return false;
            }
            if (!isSymetryLevel(levelOrder)) {
                return false;
            }
        }
        return true;
         
    }
    public static boolean isSymetryLevel(ArrayList<Integer>list){
         while (list.size() > 0) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            if (first != last) {
                return false;
            }
            list.remove(0);
            list.remove(list.size() - 1);
        }

        return true;
    }
}