public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int minIndex = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid =  (left + right) / 2;
            if(nums[mid] < nums[minIndex]) {
                minIndex = mid;
            } else if(nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if(nums[mid] < nums[left] && nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                int current = nums[left] > nums[right] ? right : left;
                minIndex = nums[current] > nums[minIndex] ? minIndex : current;
                right = mid - 1;
            }
        }
        if(nums[minIndex] == target) {
            return minIndex;
        }
        right = nums.length - 1;
        left = 0;
        if(target > nums[minIndex] && target <= nums[right]) {
            left = minIndex;
        } else {
            right = minIndex;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] Args) {
        System.out.println(search(new int[] {1, 3}, 3));
    }
}
