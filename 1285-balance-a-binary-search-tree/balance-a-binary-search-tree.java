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
        List<Integer>inOrder=new ArrayList<>();
        inOrderTravel(root,inOrder);
        return createBalancedBST(inOrder,0,inOrder.size()-1);
        
    }

    public void inOrderTravel(TreeNode root,List<Integer>inOrder){

        if(root==null){
            return;
        }

        inOrderTravel(root.left,inOrder);
        inOrder.add(root.val);
        inOrderTravel(root.right,inOrder);
    }


       private TreeNode createBalancedBST( List<Integer> inorder, int start, int end){
             if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode leftSubtree = createBalancedBST(inorder, start, mid - 1);
        TreeNode rightSubtree = createBalancedBST(inorder, mid + 1, end);

        TreeNode node = new TreeNode();
        node.val=inorder.get(mid);
        node.left = leftSubtree;
        node.right = rightSubtree;

        return node;
       }
}