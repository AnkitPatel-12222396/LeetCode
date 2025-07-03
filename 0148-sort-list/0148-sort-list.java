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
    public ListNode ms(ListNode head){
        if(head==null || head.next ==null) return head;
        ListNode mid = findMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode left = ms(head);
        ListNode right = ms(temp);

        return merge(left,right);

    }
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast =  head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next; 
        }
        return slow;
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail  = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }


    public ListNode sortList(ListNode head) {
        if(head==null || head.next ==null) return head;
        return ms(head);
    }
}