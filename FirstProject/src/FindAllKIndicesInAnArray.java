import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllKIndicesInAnArray {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        if (nums.length == 0) {
            return List.of();
        }
        List<Integer> res = new ArrayList<>();
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int left = Math.max(right, i - k);
                right = Math.min(nums.length - 1, i + k) + 1;
                for (int j = left; j < right; j++) {
                    res.add(j);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
    }
}
