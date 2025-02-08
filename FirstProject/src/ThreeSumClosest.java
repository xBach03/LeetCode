import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - current) < Math.abs(target - ans)) {
                    ans = current;
                }
                if (current > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-4, 2, 2, 3, 3, 3}, 0));
    }
}
