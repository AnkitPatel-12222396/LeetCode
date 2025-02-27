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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        ListNode first = null;
        ListNode last = null;
        while(temp!= null){
            count++;
            temp = temp.next;
        }
        int revCount  = count-k+1;
        count = 0;
        temp = head;
        while(temp!=null){
            
                count++;
                if(count == k) first = temp;
                if(count == revCount) last = temp;
                temp = temp.next;
                
            
        }
        int firstVal = first.val;
        first.val = last.val;
        last.val = firstVal;
        return head;
    }
}