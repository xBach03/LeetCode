import java.awt.*;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode ans = temp;
        int remainder = 0;
        if(l1.val + l2.val >= 10) {
            remainder = 1;
            temp.val = (l1.val + l2.val) % 10;
        } else {
            temp.val = l1.val + l2.val;
        }
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            temp.next = new ListNode();
            temp = temp.next;
            int sum = l1.val + l2.val + remainder;
            if(sum >= 10) {
                temp.val = sum % 10;
                remainder = 1;
            } else {
                temp.val = sum;
                remainder = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode nodeRemainder = l1 == null ? l2 : l1;
        while(remainder == 1) {
            if(nodeRemainder == null) {
                temp.next = new ListNode(1);
                temp = temp.next;
                break;
            }
            int sum = nodeRemainder.val + remainder;
            if(sum >= 10) {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
                remainder = 1;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                remainder = 0;
            }
            nodeRemainder = nodeRemainder.next;
        }
        temp.next = nodeRemainder;
        return ans;
    }
    public static void main(String[] Args) {
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(9, l3);
        ListNode l1 = new ListNode(9, l2);
        ListNode n3 = new ListNode(9);
        ListNode n2 = new ListNode(9, n3);
        ListNode n1 = new ListNode(9, n2);
        ListNode ans = addTwoNumbers(l1, n1);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
