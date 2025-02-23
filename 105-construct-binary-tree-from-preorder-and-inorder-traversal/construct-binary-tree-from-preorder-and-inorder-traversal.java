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
//     public int preStart=0;
//     public TreeNode buildTree(int[] preorder, int[] inorder) { 
//         return recursion( preorder, inorder, 0, preorder.length - 1 );     
//     }
//     public TreeNode recursion(int[] preorder, int[] inorder,int left,int right) {
//         if(preStart == preorder.length || left>right){
//             return null;
//         }  
//         TreeNode root= new TreeNode(preorder[preStart]);
//         for(int i=left;i<=right;i++){
//             if(preorder[preStart]==inorder[i]){
//                 preStart++;     
//                 root.left=recursion(preorder, inorder, left,i-1 );
//                 root.right=recursion(preorder, inorder, i+1,right );
//                 break;
//             }
            
//         }
        
//         return root;
//     }    
// }

class Solution {
    int preStart=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recursion( preorder, inorder, 0, preorder.length - 1,map );     
    }
    public TreeNode recursion(int[] preorder, int[] inorder,int left,int right,HashMap<Integer,Integer>map) {
        if(preStart == preorder.length || left>right){
            return null;
        }  
        TreeNode root= new TreeNode(preorder[preStart]);
        int x=map.get(preorder[preStart]);
        preStart++;     
        root.left=recursion(preorder, inorder, left,x-1,map);
        root.right=recursion(preorder, inorder, x+1,right,map);
        
        return root;
    }    
}