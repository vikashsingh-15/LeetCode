/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
   public List <TreeNode> list=new ArrayList <>();
    public boolean isSubPath(ListNode head, TreeNode root) {  
        TreeNode dummy=root ;
        storingList(head,dummy);
        for(TreeNode elements : list){
            if( checkPath(head,elements)) return true;
        }
        
          return false;   
    }
    
    public void storingList(ListNode head, TreeNode root){
        if(head==null || root==null){
            return ;
        } 
        if(head.val==root.val){
            list.add(root);
        }
        storingList( head,root.left);
        storingList( head,root.right);
    }
    
    public boolean checkPath(ListNode head, TreeNode node){
        if(head==null) return true;//our linked list is empty sp false
        if (node==null) return false;
        
        if(node.val == head.val){
            return ( checkPath(head.next,node.left) || checkPath(head.next,node.right) );
        }
        
        return false;
    }
}