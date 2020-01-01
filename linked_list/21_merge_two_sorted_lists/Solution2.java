class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode curr = null;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ListNode tempL1 = l1;
                l1 = l1.next;
                if(curr == null) {
                    curr = tempL1;
                    newHead = tempL1;
                } else {
                    curr.next = tempL1;
                    curr = curr.next;
                }
            } else {
                ListNode tempL2 = l2;
                l2 = l2.next;
                if(curr == null) {
                    curr = tempL2;
                    newHead = tempL2;
                } else {
                    curr.next = tempL2;
                    curr = curr.next;
                }
            }
        }
        if(l1 != null) {
            if(curr == null) {
                return l1;
            } else {
                curr.next = l1;
            }
        }
        if(l2 != null) {
            if(curr == null) {
                return l2;
            } else {
                curr.next = l2;
            }
        }
        return newHead;
    } 
}