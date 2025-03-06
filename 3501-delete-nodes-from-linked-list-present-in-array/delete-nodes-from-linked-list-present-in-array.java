// class Solution {
//     public ListNode modifiedList(int[] nums, ListNode head) {
//         Set<Integer> toBeDel = new HashSet<>();
//         for(var num : nums)toBeDel.add(num);
//         ListNode dummyHead = new ListNode();
//         dummyHead.next = head;
//         ListNode curr = dummyHead, prev = dummyHead;
//         while(curr != null){
//             ListNode nextNode = curr.next;
//             if(toBeDel.contains(curr.val)){
//                 prev.next = nextNode;
//             }else{
//                 prev = curr;
//             }
//             curr = curr.next;
//         }
//         return dummyHead.next;
//     }
// }

////way 2

// class Solution {
//     public ListNode modifiedList(int[] nums, ListNode head) {
//         Set<Integer> toDel = new HashSet<>();
//         for (var num : nums) {
//             toDel.add(num);
//         }
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode curr = dummy;

//         while (curr.next != null) { 
//             if (toDel.contains(curr.next.val)) {
//                 curr.next = curr.next.next; 
//             } else {
//                 curr = curr.next;
//             }
//         }

//         return dummy.next; 
//     }
// }


////way 3

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toDel = new HashSet<>();
        for (var num : nums) {
            toDel.add(num);
        }
        while (head != null && toDel.contains(head.val)) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (toDel.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}

/*
If you use curr without a dummy head, you might run into problems when deleting the actual head of the list.
int[] nums = {1, 2, 3}; 
head = [1 -> 2 -> 3 -> 4 -> 5]

When head.val is in nums, head should move forward.
But curr is pointing at head, so there’s no easy way to remove head itself without additional logic.

This Works:
First, move head forward if it needs to be deleted.
Then, traverse using curr, deleting nodes as usual.

 */