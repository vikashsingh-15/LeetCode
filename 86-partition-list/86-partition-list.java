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

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);

        ListNode l1 = less;
        ListNode l2 = more;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                l1.next = new ListNode(curr.val);
                l1 = l1.next;
            } else {
                l2.next = new ListNode(curr.val);
                l2 = l2.next;
            }

            curr = curr.next;
        }

        l1.next = more.next;

        return less.next;
    }
}
