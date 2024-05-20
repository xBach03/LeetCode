import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            set.add(head);
            if(set.contains(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
