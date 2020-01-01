class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode curr = null;
        while(true) {
            ListNode nextNode = getNextNodeAndUpdateList(lists);
            if(nextNode == null) {
                break;
            }
            if(curr == null) {
                curr = nextNode;
                head = nextNode;
            } else {
                curr.next = nextNode;
                curr = curr.next;
            }
        }
        return head;
    }

    private static ListNode getNextNodeAndUpdateList(ListNode[] lists) {
        ListNode nextNode = null;
        int smallestNodeIndex = -1;
        // for (ListNode listNode : lists) {
        for (int i = 0; i < lists.length ; i++) {
            ListNode listNode = lists[i];
            if(listNode != null) {
                if(nextNode == null) {
                    smallestNodeIndex = i;
                    nextNode = listNode;
                } else {
                    if(listNode.val < nextNode.val) {
                        nextNode = listNode;
                        smallestNodeIndex = i;
                    }
                }
            }
        }
        if(smallestNodeIndex > -1) {
            lists[smallestNodeIndex] = lists[smallestNodeIndex].next;
        }
        return nextNode;
    }
}