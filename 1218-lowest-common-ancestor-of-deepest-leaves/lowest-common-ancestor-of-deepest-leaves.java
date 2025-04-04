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
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth=findMaxDepth(root);
        return findLCA(root,0,maxDepth);
        
    }

    public  int findMaxDepth(TreeNode node){
         if (node == null) return 0;
        return  1+Math.max(findMaxDepth(node.left),findMaxDepth(node.right));
    }

    public TreeNode findLCA(TreeNode node,int depth,int maxDepth){
        if(node==null){
            return null;
        }

        if(depth==maxDepth-1 && node.left==null && node.right==null){
            return node;
        }

        TreeNode left=findLCA(node.left,depth+1,maxDepth);
        TreeNode right=findLCA(node.right,depth+1,maxDepth);

        if (left != null && right != null) return node;

        if(left==null){
            return right;
        }
        return  left;



    }
}