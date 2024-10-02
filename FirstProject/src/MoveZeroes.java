import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
            if (i >= nums.length - count) {
                nums[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 0, 3, 12};
        moveZeroes(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
