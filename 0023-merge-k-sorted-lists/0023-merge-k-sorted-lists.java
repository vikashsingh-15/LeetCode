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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
         for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        while (! pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            if (curr.next != null) {
                pq.add(curr.next);
            }
            dummy = dummy.next;
        }
        return ans.next;
    }
}