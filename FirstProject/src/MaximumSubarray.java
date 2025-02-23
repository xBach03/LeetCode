public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxEnding = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            ans = Math.max(ans, maxEnding);
        }
        return ans;
    }

    public static void main (String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(new int[] {1, 2, -1}));
    }
}
