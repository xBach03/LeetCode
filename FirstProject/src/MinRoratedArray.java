public class MinRoratedArray {
    public static int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int min = 5001;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < min) {
                min = nums[mid];
            }
            if(nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                int current = nums[left] > nums[right] ? nums[right] : nums[left];
                min = current > min ? min : current;
                right = mid - 1;
            }
        }
        return min;
    }
    public static void main(String[] Args) {
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
