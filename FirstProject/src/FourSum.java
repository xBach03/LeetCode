import java.util.*;
import java.util.stream.Collectors;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int current = nums[i] + nums[j] + nums[left] + nums[right];
                    if (current == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (current > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        for (List<Integer> i : fourSum(new int[]{1, 0, -1, 0, -2, 2},  0)) {
            System.out.println(i);
        }
    }
}
