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
    int preStart=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return helper(preorder,postorder,0,postorder.length-1,map);
        
    }

    public TreeNode helper(int[] preorder,int[] postorder,int start,int end,Map<Integer,Integer>map){
        if(start>end ||  preStart >= preorder.length){
            return null;
        }
        TreeNode root= new TreeNode(preorder[preStart++]);

        if(start==end){
            return root;
        }
        int x=map.get(preorder[preStart]);

        root.left=helper(preorder,postorder,start,x,map);
        root.right=helper(preorder,postorder,x+1,end-1,map);
        return root;



    } 
}