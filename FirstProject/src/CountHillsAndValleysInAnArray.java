public class CountHillsAndValleysInAnArray {
    public static int countHillValley(int[] nums) {
        int count = 0;
        int i = 1;
        while (i < nums.length - 1) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }
            while (right < nums.length - 1 && nums[right] == nums[i]) {
                right++;
            }
            if ((left >= 0 && right < nums.length) &&
                    ((nums[left] > nums[i] && nums[right] > nums[i])
                    || (nums[left] < nums[i] && nums[right] < nums[i]))) {
                count++;
                i = right;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countHillValley(new int[] {6,6,5,5,4,1}));
    }
}
