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

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int maxVal = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        while (prev != null) {
            maxVal = Math.max(maxVal, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }
        return maxVal;
        //way 2

        // Map<Integer, ListNode> nodeMap = new HashMap<>();
        // ListNode current = head;
        // int size = 0;

        // while (current != null) {
        //     nodeMap.put(size, current);
        //     size++;
        //     current = current.next;
        // }

        // int maxSum = Integer.MIN_VALUE;
        // current = head;

        // for (int i = 0; i < size / 2; i++) {
        //     int twinIndex = size - 1 - i;
        //     ListNode twinNode = nodeMap.get(twinIndex);
        //     int sum = current.val + twinNode.val;
        //     maxSum = Math.max(maxSum, sum);
        //     current = current.next;
        // }

        // return maxSum;

        //way 3

        //  Map<Integer, Integer> nodeMap = new HashMap<>();
        // ListNode current = head;
        // int size = 0;

        // while (current != null) {
        //     nodeMap.put(size, current.val);
        //     size++;
        //     current = current.next;
        // }

        // int maxSum = Integer.MIN_VALUE;
        // current = head;

        // for (int i = 0; i < size / 2; i++) {
        //     int twinIndex = size - 1 - i;
        //     int twinNodeVal = nodeMap.get(twinIndex);
        //     int sum = current.val + twinNodeVal;
        //     maxSum = Math.max(maxSum, sum);
        //     current = current.next;

        // }

        // return maxSum;
    }
}

//way 4 -> TLE
// class Solution {
//     public int pairSum(ListNode head) {
//         int maxSum = Integer.MIN_VALUE;
//         ListNode current = head;
//         int size = 0;
//         while (current != null) {
//             size++;
//             current = current.next;
//         }
//         current = head;
//         int i = 0;
//         while (current != null && i < size / 2) {
//             int twinIndex = size - 1 - i;
//             ListNode twinNode = getNodeAtIndex(head, twinIndex);
//             int sum = current.val + twinNode.val;
//             maxSum = Math.max(maxSum, sum);
//             current = current.next;
//             i++;
//         }
//         return maxSum;
// }
//     private ListNode getNodeAtIndex(ListNode head, int index) {
//         ListNode current = head;
//         int i = 0;
//         while (current != null && i < index) {
//             current = current.next;
//             i++;
//         }
//         return current;
//     }
// }


