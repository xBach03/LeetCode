import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null && head.random == null) {
            return new Node(head.val);
        }
        if(head.next == null && head.random != null) {
            Node n1 = new Node(head.val);
            n1.random = n1;
            return n1;
        }
        Node ans = new Node(head.val);
        ans.next = new Node(head.next.val);
        Node temp1 = ans.next;
        Node temp2 = head.next;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, ans);
        while (temp2 != null) {
            map.put(temp2 ,temp1);
            if(temp2.next != null) {
                temp1.next = new Node(temp2.next.val);
            } else {
                temp1.next = null;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = ans;
        temp2 = head;
        while(temp2 != null) {
            if(temp2.random != null) {
                temp1.random = map.get(temp2.random);
            } else {
                temp1.random = null;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return ans;
    }
    public static void main(String[] Args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n7.random = null;
        n13.next = n11;
        n13.random = n7;
        n11.next = n10;
        n11.random = n1;
        n10.next = n1;
        n10.random = n11;
        n1.next = null;
        n1.random = n7;
        Node ans = copyRandomList(n7);
        while(ans != null) {
            System.out.print(ans.val + " ");
            if(ans.random != null) {
                System.out.print(ans.random.val);
            } else {
                System.out.print("null");
            }
            System.out.println();
            ans = ans.next;
        }
    }
}
