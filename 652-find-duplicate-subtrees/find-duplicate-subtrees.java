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


// class Solution {

//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
//         List<TreeNode> list = new ArrayList<>();
//         traversal2(root, map, list);
//         return list;
//     }

//     public ArrayList<Integer> traversal2(TreeNode root, HashMap<ArrayList<Integer>, Integer> map, List<TreeNode> list) {
//         if (root == null) {
//             return new ArrayList<>();
//         }

//         ArrayList<Integer> leftSubtree = traversal2(root.left, map, list);
//         ArrayList<Integer> rightSubtree = traversal2(root.right, map, list);

//         ArrayList<Integer> currentSubtree = new ArrayList<>();
//         currentSubtree.addAll(leftSubtree);
//         currentSubtree.add(root.val);
//         currentSubtree.addAll(rightSubtree);

//         map.put(currentSubtree, map.getOrDefault(currentSubtree, 0) + 1);
//         if (map.get(currentSubtree) == 2) {
//             list.add(root);
//         }

//         return currentSubtree;
//     }
// }

class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        traversal(root, map, list);
        return list;
    }

    public String traversal(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "";
        }
        String str = "(" + traversal(root.left, map, list) + root.val + traversal(root.right, map, list) + ")";
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) {
            list.add(root);
        }
        return str;
    }
}
