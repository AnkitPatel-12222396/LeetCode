class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        k = k % length;
        if (k == 0) return head; 
        
        current = head;
        ListNode fast = head;
        while(k>0){
            k--;
            fast = fast.next;
        }
        while(fast.next!=null){
            current = current.next;
            fast = fast.next;
        }
        ListNode temp= current.next;
        current.next = null;
        fast.next = head;
        head = temp;
        return head;
    }
}
