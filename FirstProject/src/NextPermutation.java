import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        int breakPoint = -1;
        int smallestIndex = -1;
        int smallest = 101;

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                breakPoint = i - 1;
                break;
            }
        }

        if (breakPoint == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int j = nums.length - i - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return;
        }

        for (int i = nums.length - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint] && nums[i] < smallest) {
                smallestIndex = i;
                smallest = nums[i];
            }
        }

        if (smallestIndex != -1) {
            int temp = nums[smallestIndex];
            nums[smallestIndex] = nums[breakPoint];
            nums[breakPoint] = temp;
        }

        System.out.println(Arrays.toString(nums));

        int j = nums.length - 1;
        for (int i = breakPoint + 1; i < (nums.length + breakPoint + 1) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
        }

    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 3, 2};
        nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }
}
