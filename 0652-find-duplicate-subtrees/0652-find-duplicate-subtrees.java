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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> hm = new HashMap<>();
        List<TreeNode> R = new ArrayList<>();
        traversal(root,R, hm);
        return R; 
    }
     public static String traversal(TreeNode node, List<TreeNode> R, HashMap<String, Integer> hm){
        if(node==null){
            return "";
        }
        String s = "("+ traversal(node.left,R,hm) + node.val + traversal(node.right,R,hm)+")";
        hm.put(s,hm.getOrDefault(s,0)+1);
        if(hm.get(s)==2){
            R.add(node);
        }
        return s;
    }
}