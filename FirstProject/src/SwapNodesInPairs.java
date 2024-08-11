import java.util.ArrayList;
import java.util.List;

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode ans = new ListNode(temp.val);
        ListNode result = ans;
        ans.next = new ListNode(head.val);
        ans = ans.next;
        while(temp.next != null) {
            temp = temp.next.next != null ? temp.next.next : null;
            head = head.next.next != null ? head.next.next : null;
            if(temp != null) {
                ans.next = new ListNode(temp.val);
                ans = ans.next;
            }
            if(head != null) {
                ans.next = new ListNode(head.val);
                ans = ans.next;
            }
            if(head == null || temp == null) {
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode ans = swapPairs(n1);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
