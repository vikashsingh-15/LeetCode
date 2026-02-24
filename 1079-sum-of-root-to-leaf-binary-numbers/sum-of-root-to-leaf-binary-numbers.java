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
//  */
// class Solution {
//     public int sumRootToLeaf(TreeNode root) {
//          return dfs(root, 0);
//     }

//      private int dfs(TreeNode node, int current) {
//         if(node==null){
//             return 0;
//         }

//         current=current*2+node.val;

//         if(node.left==null  && node.right==null){
//             return current;
//         }

//         int leftVal=dfs(node.left,current);
//         int  rightVal=dfs(node.right,current);

//         return leftVal+rightVal;

//      }
// }

//way 2

// class Solution {

//     public int sumRootToLeaf(TreeNode root) {
//         return dfs(root, 0);
//     }

//     private int dfs(TreeNode node, int current) {
//         if (node == null)
//             return 0;

//         // build binary number
//         current = (current << 1) | node.val;

//         if (node.left == null && node.right == null)
//             return current;

//         return dfs(node.left, current)
//              + dfs(node.right, current);
//     }
// }


//way 3

class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private int dfs(TreeNode node, String path) {
        if (node == null)
            return 0;

        // build binary string
        path = path + node.val;
        
        if (node.left == null && node.right == null) {
            // convert binary string to decimal
            return Integer.parseInt(path, 2);
        }

        return dfs(node.left, path)
             + dfs(node.right, path);
    }
}
