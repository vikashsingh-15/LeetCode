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
    // //way 1
    //  List <Integer>list=new LinkedList<>();
    // public int kthSmallest(TreeNode root, int k) {
    //      helper(root);
    //     return list.get(k-1);  
    // }
    //  public void helper(TreeNode root) {
    //      if(root==null){
    //          return;
    //      }
    //      helper(root.left);
    //      list.add(root.val);
    //      helper(root.right); 
    // }
    
     
    //way 2
    int count=0;
    int res;
    // int b;
    public int kthSmallest(TreeNode root, int k) {
        // this.b=k;
        helper(root,k);
        return res;
    }
    
    public void helper(TreeNode root, int k){
        if(root==null){
            return;
        }
        
        helper(root.left,k);
        count++;
        if(count==k){
            res=root.val;
        }
        helper(root.right,k);
    }
}