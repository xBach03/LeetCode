import java.util.*;
import java.util.stream.Collectors;

public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n + 1);
        List<String> temp = new ArrayList<>(n + 1);
        for (int i = 1; i <= n; i++) {
            temp.add(String.valueOf(i));
        }
        List<String> sorted = temp.stream().sorted(
                new Comparator<>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int length = Math.min(o1.length(), o2.length());
                        for (int i = 0; i < length; i++) {
                            if (o1.charAt(i) < o2.charAt(i)) {
                                return -1;
                            }

                            if (o1.charAt(i) > o2.charAt(i)) {
                                return 1;
                            }
                        }
                        return 0;
                    }
                }
        ).toList();
        for (int i = 0; i < n; i++) {
            res.add(Integer.valueOf(sorted.get(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
    }

}
