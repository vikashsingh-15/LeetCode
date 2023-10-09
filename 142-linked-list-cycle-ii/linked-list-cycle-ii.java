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

    public ListNode detectCycle(ListNode head) {
        //  HashSet<ListNode> hs = new HashSet<>();
        // for (ListNode node = head; node != null; node = node.next) {
        //     if (hs.contains(node)) {
        //         return node;
        //     }
        //     hs.add(node);
        // }
        // return null;

        ////Way 2

        //         ListNode slow = head;
        //         ListNode fast = head;

        //         while (fast != null && fast.next != null) {
        //             slow = slow.next;
        //             fast = fast.next.next;
        //             if (slow == fast) {
        //                 slow = head;
        //                 while (slow != fast) {
        //                     slow = slow.next;
        //                     fast = fast.next;
        //                     }
        //                 return slow;
        //             }
        //         }

        //         return null;

        //way 3

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // System.out.print("slow is " + slow.val);
            // System.out.print(" fast is " + fast.val);
            System.out.println();

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        slow = head;

        // System.out.print(" serach start slow is " + slow.val);
        // System.out.print(" search start fast is " + fast.val);
        System.out.println();
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

            // System.out.print("slow is " + slow.val);
            // System.out.print(" fast is " + fast.val);
            // System.out.println();
        }

        return slow;
    }
}
