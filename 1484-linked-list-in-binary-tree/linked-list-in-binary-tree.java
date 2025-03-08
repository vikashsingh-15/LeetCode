////TLE
// class Solution {
//     public boolean isSubPath(ListNode head, TreeNode root) {
//         return dfs(head, head, root);
//     }
    
//     private boolean dfs(ListNode head, ListNode cur, TreeNode root) {
//         if (cur == null) return true; 
//         if (root == null) return false; 

//         if (cur.val == root.val) {
//             if (dfs(head, cur.next, root.left) || dfs(head, cur.next, root.right)) {
//                 return true;
//             }
//         } 
        
//         // Restart from head if there's a mismatch
//         return dfs(head, head, root.left) || dfs(head, head, root.right);
//     }
// }


////way 2 - wrong ans


// class Solution {
//     public boolean isSubPath(ListNode head, TreeNode root) {
//         ListNode curr=head;
//         return dfs(head, curr, root);  
//     }
    
//     boolean dfs(ListNode head, ListNode cur, TreeNode root) {
       
//         if (cur == null) return true;
//         if (root == null) return false;
        
//         if (cur.val == root.val) cur = cur.next;
//         else if (head.val == root.val) head = head.next;
//         else cur = head;
//         return dfs(head, cur, root.left) || dfs(head, cur, root.right);
//     }
// }


////way 2

// class Solution {
//     public boolean isSubPath(ListNode head, TreeNode root) {
//         if (root == null) {
//             return false;
//         }
//         if (dfs(root, head)) {
//             return true;
//         }
//         return isSubPath(head, root.left) || isSubPath(head, root.right);
//     }

//     private boolean dfs(TreeNode root, ListNode head) {
//         if (head == null) {
//             return true;
//         }
//         if (root == null || root.val != head.val) {
//             return false;
//         }
//         return dfs(root.left, head.next) || dfs(root.right, head.next);
//     }
// }

////way 3

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true; 
        if (root == null) return false; 
        if (head.val == root.val) {
            return dfs(head.next, root.left) || dfs(head.next, root.right);
        }
        
        return false;
    }
}
