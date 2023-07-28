/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // way 1
        //         ArrayList<TreeNode> pathP = nodeToRootPath(root, p);
        //     ArrayList<TreeNode> pathQ = nodeToRootPath(root, q);
        //     if (pathP.isEmpty() || pathQ.isEmpty()) {
        //         return null;
        //     }
        //      // for(int i=0;i<pathP.size();i++){
        //      //     System.out.print(" "+ pathP.get(i).val);
        //      // }
        //      // System.out.println();
        //      //  for(int i=0;i<pathQ.size();i++){
        //      //     System.out.print(" "+ pathQ.get(i).val);
        //      // }
        //     TreeNode lca = null;
        //     int i = 0;
        //     while (i < pathP.size() && i < pathQ.size()) {
        //         if (pathP.get(i) == pathQ.get(i)) {
        //             lca = pathP.get(i);
        //         } else {
        //             break;
        //         }
        //         i++;
        //     }

        //     return lca;

        //way 2

        //         if (root == null) {
        //             return null;
        //         }
        //         if (root == p || root == q) {
        //             return root;
        //         }
        //         TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
        //         TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q);
        //         if (leftAncestor == null)
        //             return rightAncestor;
        //         if (rightAncestor == null)
        //             return leftAncestor;

        //         return root;

        //way 3
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    public ArrayList<TreeNode> nodeToRootPath(TreeNode node, TreeNode target) {
        ArrayList<TreeNode> list = new ArrayList<>();
        path(node, target, list);
        return list;
    }

    public boolean path(TreeNode root, TreeNode target, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            list.add(0, root);
            return true;
        }

        if (path(root.left, target, list) || path(root.right, target, list)) {
            list.add(0, root);
            return true;
        }

        return false;
    }
}
