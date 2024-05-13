import java.util.List;
import java.util.Stack;

public class ReoderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        ListNode ans = head;
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size() / 2;
        ListNode temp1 = ans;
        ListNode temp2 = temp1.next;
        while(size > 0) {
            temp1.next = stack.pop();
            temp1 = temp1.next;
            temp1.next = temp2;
            temp1 = temp1.next;
            temp2 = temp2.next;
            size--;
        }
        temp1.next = null;
    }
    public static void main(String[] Args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reorderList(n1);
        while(n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
