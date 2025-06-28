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
        ListNode slow= head;
        ListNode fast = head;

        if(head==null ||head.next==null) return null;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow== fast){
                fast = head;
                break;
            }
            
        }
        if(fast!=head) return null;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

        
    }
}