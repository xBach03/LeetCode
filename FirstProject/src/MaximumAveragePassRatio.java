import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> pq = new PriorityQueue<>((a, b) ->
                Double.compare(b[0], a[0])
        );

        for (int[] classI : classes) {
            pq.offer(new double[] {
                    calcGain(classI[0], classI[1]),
                    classI[0],
                    classI[1]
            });
        }

        while (extraStudents-- > 0) {
            double[] currentClass = pq.poll();
            int currentPass = (int) currentClass[1];
            int currentTotal = (int) currentClass[2];
            pq.offer(new double[] {
                    calcGain(currentPass + 1, currentTotal + 1),
                    currentPass + 1,
                    currentTotal + 1
            });
        }

        double result = 0;
        while (!pq.isEmpty()) {
            double[] currentClass = pq.poll();
            int currentPass = (int) currentClass[1];
            int currentTotal = (int) currentClass[2];
            result += (double) currentPass / currentTotal;
        }
        return result / classes.length;
    }

    public double calcGain(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)
                - (double) pass / total);
    }
}
