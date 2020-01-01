class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode curr = null;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ListNode newNode = new ListNode(l1.val);
                if(curr == null) {
                    curr = newNode;
                    newHead = curr;
                } else {
                    curr.next = newNode;
                    curr = newNode;
                }
                l1 = l1.next;
            } else {
                ListNode newNode = new ListNode(l2.val);
                if(curr == null) {
                    curr = newNode;
                    newHead = curr;
                } else {
                    curr.next = newNode;
                    curr = newNode;
                }
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            if(curr != null) {
                curr.next = l1;
            } else {
                newHead = l1;
            }
        } 
        if(l2 != null) {
            if(curr != null) {
                curr.next = l2;
            } else {
                newHead = l2;
            }
        }
        return newHead;
    }

}