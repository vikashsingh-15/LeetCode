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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return count;
    }

     private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {Sum of values, Number of nodes}
        }

        int[] leftStats = dfs(node.left);
        int[] rightStats = dfs(node.right);

        int sum = node.val + leftStats[0] + rightStats[0];
        int numNodes = 1 + leftStats[1] + rightStats[1];

        int subtreeAverage = sum / numNodes;

        if (node.val == subtreeAverage) {
            count++;
        }

        return new int[]{sum, numNodes};
    }
}