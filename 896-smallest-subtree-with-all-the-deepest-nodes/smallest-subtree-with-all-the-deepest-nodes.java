/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public TreeNode subtreeWithAllDeepest(TreeNode root) {
//         int maxDepth=findMaxDepth(root);
//         return findsubtreeWithAllDeepest(root,0,maxDepth);
        
//     }

//     public int findMaxDepth(TreeNode root){
//         if(root==null){
//             return 0;
//         }

//         int leftDepth=findMaxDepth(root.left);
//         int rightDepth=findMaxDepth(root.right);
//         return 1+Math.max(leftDepth,rightDepth);


//         // return 1+Math.max(findMaxDepth(root.left),findMaxDepth(root.right));
//     }

//     public TreeNode findsubtreeWithAllDeepest(TreeNode node,int depth,int maxDepth){

//         if(node==null){
//             return null;
//         }

//          if(depth==maxDepth-1 && node.left==null && node.right==null){
//             return node;
//         }

//         TreeNode left=findsubtreeWithAllDeepest(node.left,depth+1,maxDepth);
//         TreeNode right=findsubtreeWithAllDeepest(node.right,depth+1,maxDepth);

//         if (left != null && right != null) return node;

//         if(left==null){
//             return right;
//         }
//         return  left;

//     }

// }

// ////way 2
// class Solution {
//     public TreeNode subtreeWithAllDeepest(TreeNode root) {
//         return dfs(root).node;
//     }

//     private Pair dfs(TreeNode root) {
//         if (root == null)
//             return new Pair(null, 0);

//         Pair left = dfs(root.left);
//         Pair right = dfs(root.right);

//         if (left.depth > right.depth)
//             return new Pair(left.node, left.depth + 1);

//         if (right.depth > left.depth)
//             return new Pair(right.node, right.depth + 1);

//         // equal depth -> this node contains all deepest nodes
//         return new Pair(root, left.depth + 1);
//     }

//     class Pair {
//         TreeNode node;
//         int depth;

//         Pair(TreeNode n, int d) {
//             node = n;
//             depth = d;
//         }
//     }
// }


////way 3

class Solution {
    HashMap<TreeNode, Integer> depthMap = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {   
         dfs(root);                        
         return helper(root);         
     } 
     private int dfs(TreeNode node){
             if(node == null) 
                return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int depth = 1 + Math.max(left, right);
        depthMap.put(node, depth);
        return depth;    
      }
      
    // finds the smallest subtree with all deepest nodes    
    private TreeNode helper(TreeNode node){
            if(node == null)
                return null;
        int leftDepth  = node.left  == null ? 0 : depthMap.get(node.left);
        int rightDepth = node.right == null ? 0 : depthMap.get(node.right);
        if(leftDepth == rightDepth)
                    return node;
        if(leftDepth > rightDepth)
                    return helper(node.left);
        return helper(node.right);
         }
         
    }