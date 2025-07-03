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

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;
        ListNode curr = head;

        while (true) {
            ListNode kth = getKthNode(curr, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;

            // Detach group and reverse it
            kth.next = null;
            ListNode reversedHead = reverse(curr);

            // Connect reversed group with previous and next parts
            groupPrev.next = reversedHead;
            curr.next = groupNext;

            // Move pointers to the next group
            groupPrev = curr;
            curr = groupNext;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && --k > 0) {
            curr = curr.next;
        }
        return curr;
    }
}