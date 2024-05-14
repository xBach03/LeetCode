import java.util.Stack;

public class RemoveNthNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode temp = head;
        ListNode temp1 = null;
        ListNode temp2 = null;
        Stack<ListNode> stack = new Stack<>();
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while(n-- > 0) {
            temp2 = temp1;
            temp1 = stack.pop();
        }
        if(stack.size() > 0) {
            ListNode temp3 = stack.pop();
            temp3.next = temp2;
        } else {
            return temp2;
        }
        return ans;
    }
    public static void main(String[] Args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode ans = removeNthFromEnd(n1, 5);
        while(ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
