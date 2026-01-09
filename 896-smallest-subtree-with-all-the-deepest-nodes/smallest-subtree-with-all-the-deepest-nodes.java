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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth=findMaxDepth(root);
        return findsubtreeWithAllDeepest(root,0,maxDepth);
        
    }

    public int findMaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftDepth=findMaxDepth(root.left);
        int rightDepth=findMaxDepth(root.right);
        return 1+Math.max(leftDepth,rightDepth);


        // return 1+Math.max(findMaxDepth(root.left),findMaxDepth(root.right));
    }

    public TreeNode findsubtreeWithAllDeepest(TreeNode node,int depth,int maxDepth){

        if(node==null){
            return null;
        }

         if(depth==maxDepth-1 && node.left==null && node.right==null){
            return node;
        }

        TreeNode left=findsubtreeWithAllDeepest(node.left,depth+1,maxDepth);
        TreeNode right=findsubtreeWithAllDeepest(node.right,depth+1,maxDepth);

        if (left != null && right != null) return node;

        if(left==null){
            return right;
        }
        return  left;

    }

}