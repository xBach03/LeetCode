import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    int k;
    Queue<Integer> pq;
    public KthLargestElement(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int i : nums) {
            this.add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
    public static void main(String[] Args) {
        KthLargestElement test = new KthLargestElement(3, new int[]{4, 5, 8, 2});
        System.out.println(test.add(3));
        System.out.println(test.add(5));
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));
    }
}
