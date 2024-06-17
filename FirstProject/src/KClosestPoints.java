import java.util.*;

public class KClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {
        Queue<Double> pq = new PriorityQueue<>();
        Map<Double, Integer[]> mp = new HashMap<>();
        for(int[] i : points) {
            int x = i[0];
            int y = i[1];
            double temp = Math.sqrt(x * x + y * y);
            pq.add(temp);
            if(mp.containsKey(temp)) {
                Integer[] currentArr = mp.get(temp);
                int j = 0;
                Integer[] newArr = new Integer[currentArr.length + 2];
                while(j < currentArr.length) {
                    newArr[j] = currentArr[j];
                    j++;
                }
                newArr[j] = x;
                newArr[++j] = y;
                mp.replace(temp, newArr);
            } else {
                mp.put(temp, new Integer[]{x, y});
            }

        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            double min = pq.remove();
            Integer[] arr = mp.get(min);
            for(int j = 0; j < arr.length; j++) {
                ans[i][0] = arr[j];
                j += 1;
                ans[i][1] = arr[j];
                if(j + 1 < arr.length) {
                    i++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] Args) {
        int[][] ans = kClosest(new int[][] {{0, 1}, {1, 0}, {-2, 4}}, 2);
        for(int[] i : ans) {
            System.out.println(i[0] + " " + i[1]);
        }

    }
}
