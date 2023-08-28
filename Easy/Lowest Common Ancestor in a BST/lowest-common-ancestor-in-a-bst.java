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

class GfG {
    
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
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    BST g = new BST();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    System.out.println(g.LCA(root,x,y).data);
                t--;
            
        }
    }
  
}


// } Driver Code Ends




//User function Template for Java



// class BST
// {   
//     //Function to find the lowest common ancestor in a BST. 
// 	Node LCA(Node root, int n1, int n2)
// 	{
//           if (root == null) 
//             return null;
        
//         if (root.data == n1 || root.data == n2) {
//             return root;
//         }
//         Node leftAncestor = LCA(root.left, n1, n2);
//         Node rightAncestor = LCA(root.right, n1, n2);
        
//         if (leftAncestor == null){
//             return rightAncestor;
//         }
            
//         if (rightAncestor == null){
//             return leftAncestor;
//         }
            
        
//         return root;
//     }
    
// }


class BST {
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        ArrayList<Node> pathP = nodeToRootPath(root, n1);
        ArrayList<Node> pathQ = nodeToRootPath(root, n2);
        
        if (pathP.isEmpty() || pathQ.isEmpty()) {
            return null;
        }
        
        Node lca = null;
        int i = 0;
        
        while (i < pathP.size() && i < pathQ.size()) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            } else {
                break;
            }
            i++;
        }

        return lca;
    }

    // Function to find the path from root to a target node.
    ArrayList<Node> nodeToRootPath(Node node, int x) {
        ArrayList<Node> list = new ArrayList<>();
        path(node, x, list);
        return list;
    }

    // Recursive function to find the path from root to the target node.
    boolean path(Node root, int target, ArrayList<Node> list) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            list.add(0, root);
            return true;
        }

        if (path(root.left, target, list) || path(root.right, target, list)) {
            list.add(0, root);
            return true;
        }

        return false;
    }
}




