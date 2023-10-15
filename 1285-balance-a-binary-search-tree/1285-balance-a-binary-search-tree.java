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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorderTraversal(root, lst);
        TreeNode head = buildTree(lst, 0, lst.size() - 1);
        return head;
    }

    public void inorderTraversal(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, lst);
        lst.add(root.val);
        inorderTraversal(root.right, lst);
    }

    public TreeNode buildTree(List<Integer> lst, int low, int high) {
        if (low > high) return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(lst.get(mid));
        root.left=buildTree(lst,low,mid-1);
        root.right=buildTree(lst,mid+1,high);
        return root;
    }
}
