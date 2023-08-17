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
    LinkedList<ArrayList<Integer>> list = new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        helper(root, new ArrayList<Integer>());
        int sum = 0;
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            // System.out.println(list.get(i));
            for (int j : list.get(i)) {
                num = num * 10 + j;
            }
            sum = sum + num;
            num = 0;
        }
        return sum;
    }

    void helper(TreeNode root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(new ArrayList<Integer>(path));
        } else {
            helper(root.left, path);
            helper(root.right, path);
        }
        path.remove(path.size() - 1);
    }
}


// way 2

// class Solution {

//     public int sumNumbers(TreeNode root) {
//         return dfs(root, 0);
//     }

//     static int dfs(TreeNode node, int currentNum) {
//         if (node == null) {
//             return 0;
//         }

//         currentNum = currentNum * 10 + node.val;

//         if (node.left == null && node.right == null) {
//             return currentNum;
//         }

//         int leftSum = dfs(node.left, currentNum);
//         int rightSum = dfs(node.right, currentNum);

//         return leftSum + rightSum;
//     }
// }
