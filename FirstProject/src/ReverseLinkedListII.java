public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        int count = 1;
        ListNode outerRight = null;
        ListNode outerLeft = null;
        ListNode innerLeft = null;
        ListNode innerRight = null;
        ListNode temp = head;
        boolean counter = false;
        if(count == left) {
            innerLeft = temp;
            outerLeft = temp;
            counter = true;
        }
        while(temp != null) {
            if(count + 1 == left) {
                outerLeft = temp;
                innerLeft = temp.next;
            }
            if(count == right) {
                innerRight = temp;
                outerRight = temp.next;
            }
            count++;
            temp = temp.next;
        }
        ListNode rev = new ListNode(innerLeft.val, outerRight);
        innerLeft = innerLeft.next;
        while(innerLeft != innerRight) {
            ListNode innerRev = new ListNode(innerLeft.val);
            innerRev.next = rev;
            rev = innerRev;
            innerLeft = innerLeft.next;
        }
        innerLeft.next = rev;
        outerLeft.next = innerLeft;
        return counter ? head.next : head;
    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);
        ListNode ans = reverseBetween(n1, 1, 2);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
