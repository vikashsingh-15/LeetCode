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
    ArrayList<Integer> al = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i < al.size(); i++) {
            minDist = Math.min(minDist, al.get(i) - al.get(i - 1));
        }
        return minDist;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        al.add(root.val);
        inOrder(root.right);
    }
}
