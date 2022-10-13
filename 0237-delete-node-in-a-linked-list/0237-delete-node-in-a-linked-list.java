/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //  ListNode nextNode = node.next;
        // node.val = nextNode.val;
        // node.next = nextNode.next;
        // nextNode.next = null;
        
        
        // //way 2
        //  node.val=node.next.val;
        // node.next=node.next.next;
        
        
        //way 3
        
        if(node == null){
            return;
        }
        if(node.next == null){
            node.val =0;
            node.next = null;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }
}