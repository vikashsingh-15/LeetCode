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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            // System.out.print(" before first = " + first.val);
            // System.out.print(" before second = " + second.val);
            // System.out.print(" before current = " + current.val);

            // Swap the nodes
            // System.out.print(" point 1 first = " + first.val);
            first.next = second.next;
            // System.out.print(" point 2 first = " + first.val);
            // System.out.print(" point 1 second = " + second.val);
            second.next = first;
            // System.out.print(" point 2 second = " + second.val);
            current.next = second;
            // System.out.print(" after first = " + first.val);
            // System.out.print(" after second = " + second.val);
            current = current.next.next;
        }

        return dummy.next;
    }
}
