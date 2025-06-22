import java.util.Arrays;

// Incorrect case: k > nums.length

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if(nums.length == 1) return;
        k = k % nums.length;
        int rotPtr = nums.length - k > 0 ? nums.length - k : -nums.length + k;
        int prev = rotPtr - 1 > 0 ? rotPtr - 1 : -rotPtr + 1;
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        while(rotPtr < nums.length) {
            ans[i++] = nums[rotPtr++];
        }
        while(prev >= 0) {
            ans[j--] = nums[prev--];
        }
        for(int n = 0; n < nums.length; n++) {
            nums[n] = ans[n];
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        rotate(nums, 4);
        for(int x : nums) {
            System.out.println(x);
        }
    }
}
