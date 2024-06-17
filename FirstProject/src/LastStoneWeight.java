import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : stones) {
            pq.add(i);
        }

        while(pq.size() >= 2) {
            int temp1 = pq.remove();
            int temp2 = pq.remove();
            pq.add(temp1 > temp2 ? temp1 - temp2 : temp2 - temp1);
        }
        return pq.peek() != null ? pq.peek() : 0;
    }
    public static void main(String[] Args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
