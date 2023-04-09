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
public class Solution {
    public boolean hasCycle(ListNode head) {
             HashSet<ListNode> hs = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (hs.contains(node)) {
                return true;
            }
            hs.add(node);
        }
        return false;
    }
}