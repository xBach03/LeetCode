import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] charsCount = new int[26];
        for(char i : tasks) {
            charsCount[i - 65]++;
        }
        int max = Arrays.stream(charsCount).max().orElse(0);
        int count = 0;
        for(int i : charsCount) {
            if(i == max) {
                count++;
            }
        }
        int total = (n + 1) * (max - 1) + count;
        return Math.max(total, tasks.length);
    }
    public static void main(String[] Args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
