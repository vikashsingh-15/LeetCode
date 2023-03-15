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

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         boolean end = false;

//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();

//             if (node == null) {
//                 end = true;
//             } else {
//                 if (end) {
//                     return false;
//                 }
//                 queue.offer(node.left);
//                 queue.offer(node.right);
//             }
//         }
//         return true;
        

          Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;

        while (!queue.isEmpty()) {
            int size=queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

            if (node == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            
            }
        }

        return true;
        
        
        
        
    }
}
