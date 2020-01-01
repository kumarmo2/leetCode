import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}

class  Solution {
    private static PriorityQueue<ListNode> pq = new PriorityQueue<>(new ListNodeComparator());
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode curr = null;
        initializePriorityQueue(lists);
        while(true) {
            ListNode nextNode = getNextNode();
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

    private static ListNode getNextNode() {
        ListNode nextNode = pq.poll();
        if(nextNode != null && nextNode.next != null) {
            pq.add(nextNode.next);
        }
        return nextNode;
    }
    
    private static void initializePriorityQueue(ListNode[] lists) {
        for (ListNode listNode : lists) {
            if(listNode != null) {
                pq.add(listNode);
            }
        }
    }


}