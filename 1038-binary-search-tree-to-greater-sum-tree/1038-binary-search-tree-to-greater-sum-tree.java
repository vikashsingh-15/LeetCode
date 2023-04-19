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
     int ans = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root!=null){
            bstToGst(root.right);
            // System.out.print(" For root value = "+root.val);
            ans += root.val;
            // System.out.println(" ans is = "+ans);
            root.val = ans;
            // System.out.print(" checking For root left = "+root.left);
            bstToGst(root.left);
        }
        return root;
    }
}