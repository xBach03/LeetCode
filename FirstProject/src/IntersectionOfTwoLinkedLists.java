public class IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(headA.next != null) {
            headA = headA.next;
            countA++;
        }
        while(headB.next != null) {
            headB = headB.next;
            countB++;
        }
        if(headA != headB) return null;
        while(ptrA != null && ptrB != null) {
            while(countA > countB) {
                ptrA = ptrA.next;
                countA--;
            }
            while(countB > countA) {
                ptrB = ptrB.next;
                countB--;
            }
            if(ptrA == ptrB) return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
    }
}
