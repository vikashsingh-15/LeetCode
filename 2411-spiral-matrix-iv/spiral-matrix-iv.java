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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode curr=head;
        int arr[][]=new int[m][n];
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=-1;
            }
        }

        while(curr!=null){
            for(int i=left;i<=right && curr != null;i++){
                arr[top][i]=curr.val;
                curr=curr.next;
            }
            top++;
            for(int i=top;i<=bottom && curr!=null;i++){
                arr[i][right]=curr.val;
                curr=curr.next;
            }
            right--;

            for(int i=right;i>=left && curr!=null;i--){
                arr[bottom][i]=curr.val;
                curr=curr.next;
            }
            bottom--;

            for(int i=bottom;i>=top && curr!=null;i--){
                arr[i][left]=curr.val;
                curr=curr.next;
            }
            left++;
        }
       
        return arr;
        
    }
}