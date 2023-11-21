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
   public boolean isSymmetric(TreeNode root) {
        if(root==null) return true; 
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left==right;
        }       
        if(left.val!=right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}



/*
class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
         if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> levelOrder = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();

                if (temp != null) {
                    if (temp.left != null) {
                        levelOrder.add(temp.left.data);
                    }
                    if (temp.right != null) {
                        levelOrder.add(temp.right.data);
                    }

                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }

            if (levelOrder.size() % 2 != 0) {
                return false;
            }
            if (!isSymetryLevel(levelOrder)) {
                return false;
            }
        }
        return true;
         
    }
    public static boolean isSymetryLevel(ArrayList<Integer>list){
         while (list.size() > 0) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            if (first != last) {
                return false;
            }
            list.remove(0);
            list.remove(list.size() - 1);
        }

        return true;
    }
}


*/
