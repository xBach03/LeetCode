import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementArray {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Integer ans = 0;
        for (int i : nums) {
            pq.add(i);
        }
        while (k-- > 0) {
            ans = pq.remove();
        }
        return ans;
    }
    public static void main(String[] Args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
