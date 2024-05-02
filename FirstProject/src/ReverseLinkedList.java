import java.util.List;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode ptr1 = head;
        head = head.next;
        ptr1.next = null;
        ListNode ptr2 = head;
        while(head != null) {
            head = head.next;
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = head;
        }
        return ptr1;
    }
    public static void main(String[] Args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode ans = reverseList(n1);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
