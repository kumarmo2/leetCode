class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            slow = slow.next;
            if(fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}