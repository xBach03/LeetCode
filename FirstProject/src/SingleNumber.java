import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums) {
            if (Objects.nonNull(mp.get(i)) && mp.get(i) == 1) {
                mp.replace(i, 2);
            } else {
                mp.put(i, 1);
            }
        }
        for (int key : mp.keySet()) {
            if (mp.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }
}
