import java.util.*;

public class LexicographyMinimumString {
    public static String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        boolean[] isRemoved = new boolean[n];
        Map<Character, List<Integer>> map = new HashMap<>();
        Arrays.fill(isRemoved, false);
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '*') {
                char smallest = pq.poll();
                isRemoved[i] = true;
                isRemoved[map.get(smallest).removeLast()] = true;
            } else {
                pq.offer(current);
                map.putIfAbsent(current, new ArrayList<>());
                map.get(current).add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!isRemoved[i]) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(clearStars("ee**"));
    }
}
