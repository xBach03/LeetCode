import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    private Map<Integer, DoubleLinkedList> mp;
    private int capacity;
    private DoubleLinkedList head, tail;
    public class DoubleLinkedList {
        private DoubleLinkedList previous, next;
        private int key, val;
    }
    public void addNode(DoubleLinkedList node) {
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }
    public void moveToHead(DoubleLinkedList node) {
        // Remove node in between of the list
        DoubleLinkedList prevNode = node.previous;
        DoubleLinkedList nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.previous = prevNode;

        // Add next to the head
        addNode(node);
    }
    public DoubleLinkedList popTail() {
        DoubleLinkedList currentTail = tail.previous;
        DoubleLinkedList prevCurrent = currentTail.previous;
        DoubleLinkedList nextCurrent = currentTail.next;
        prevCurrent.next = nextCurrent;
        nextCurrent.previous = prevCurrent;
        return currentTail;
    }


    public LRUCache(int capacity) {
        mp = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new DoubleLinkedList();
        head.previous = null;
        tail = new DoubleLinkedList();
        tail.next = null;
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        DoubleLinkedList current = mp.get(key);
        if(current == null) {
            return -1;
        }
        this.moveToHead(current);
        return current.val;
    }

    public void put(int key, int value) {
        if(mp.containsKey(key)) {
            DoubleLinkedList current = mp.get(key);
            current.val = value;
            moveToHead(current);
        } else {
            if(mp.size() == capacity) {
                DoubleLinkedList current = popTail();
                DoubleLinkedList newNode = new DoubleLinkedList();
                newNode.key = key;
                newNode.val = value;
                addNode(newNode);
                mp.remove(current.key);
                mp.put(key, newNode);
            } else {
                DoubleLinkedList newNode = new DoubleLinkedList();
                newNode.key = key;
                newNode.val = value;
                addNode(newNode);
                mp.put(key, newNode);
            }

        }
    }
    public static void main(String[] Args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println(cache1.get(1));
        cache1.put(3, 3);
        System.out.println(cache1.get(2));
        cache1.put(4, 4);
        System.out.println(cache1.get(1));
        System.out.println(cache1.get(3));
        System.out.println(cache1.get(4));
    }
}


