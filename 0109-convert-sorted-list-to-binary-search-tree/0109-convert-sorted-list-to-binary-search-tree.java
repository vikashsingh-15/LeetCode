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

    // public TreeNode sortedListToBST(ListNode head) {
    //     if (head == null) return null;
    //     if (head.next == null) return new TreeNode(head.val);
    //     ListNode slow = head, fast = head.next;
    //     while (fast.next != null && fast.next.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     ListNode mid = slow.next;
    //     slow.next = null;
    //     TreeNode root = new TreeNode(mid.val);
    //     root.left = sortedListToBST(head);
    //     root.right = sortedListToBST(mid.next);
    //     return root;
    // }

    ////WAY 2

    private TreeNode createBST(Integer[] nodeValues, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nodeValues[mid]);
        node.left = createBST(nodeValues, left, mid - 1);
        node.right = createBST(nodeValues, mid + 1, right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodeValues = new ArrayList<Integer>();
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            nodeValues.add(curr.val);
            curr = curr.next;
            size++;
        }
        return createBST(nodeValues.toArray(new Integer[size]), 0, size - 1);
    }
}
