import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size() - 1;
        int i = 0;
        while (i <= n) {
            if (!list.get(i).equals(list.get(n))) {
                return false;
            }
            i++;
            n--;
        }

        return true;
    }
}
