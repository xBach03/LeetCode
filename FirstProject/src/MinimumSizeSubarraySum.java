public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) {
            if(nums[0] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            while(sum >= target) {
                ans = Math.min(right - left + 1, ans);
                sum -= nums[left++];
            }
            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(6, new int[]{10,2,3}));
    }
}
