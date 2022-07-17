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
    public List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode dummy = root;
        postorder(dummy);
        return list;
        
    }

    void postorder(TreeNode currnode) {
        if (currnode == null) {
            return;
        }
        postorder(currnode.left);
        postorder(currnode.right);
        list.add(currnode.val);
    }
}
