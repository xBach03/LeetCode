public class RemoveLinkedListElement {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        ListNode result = ans;
        while(head != null) {
            if(head.val != val) {
                ans.next = new ListNode(head.val);
                ans = ans.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
