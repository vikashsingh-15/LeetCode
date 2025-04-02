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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }

        dfshelper(root);
        return count;

    }

    public int [] dfshelper(TreeNode root){
        if(root==null){
            return new int[] {0,0};
        }

        int left[]=dfshelper(root.left);
        int right[]=dfshelper(root.right);

        int sum=root.val+left[0]+right[0];
        int subCount=1+left[1]+right[1];

        if(root.val==sum/subCount){
            count++;
        }

        return new int[] {sum,subCount};

    }
}