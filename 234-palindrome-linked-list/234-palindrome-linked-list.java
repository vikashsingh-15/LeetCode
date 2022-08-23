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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy=head;        
        if(head==null || head.next==null){
            return true;
        }
        
        StringBuilder sb=new StringBuilder();
        //  for(ListNode ptr=head;ptr!=null;ptr=ptr.next)
        // {
        //     nm.append(ptr.val);
        // }
        
        while(dummy!=null){
            sb.append(dummy.val);
            dummy=dummy.next;
            
        }
        
         return sb.toString().equals(sb.reverse().toString());
        
    }
}