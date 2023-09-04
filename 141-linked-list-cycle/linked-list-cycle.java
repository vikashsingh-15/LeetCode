/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//              HashSet<ListNode> hs = new HashSet<>();
//         for (ListNode node = head; node != null; node = node.next) {
//             if (hs.contains(node)) {
//                 return true;
//             }
//             hs.add(node);
//         }
//         return false;
//     }
// }

public class Solution{
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if there are less than 2 nodes.
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps

            if (slow == fast) {
                return true; // If the two pointers meet, there's a cycle.
            }
        }

        return false; // If fast pointer reaches the end, there's no cycle.
    }
}