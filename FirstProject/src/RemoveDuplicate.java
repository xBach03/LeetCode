import java.util.Arrays;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int remover = 100000;
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] == nums[i + 1]) {
                int j = i + 2;
                while(j < nums.length && nums[j] == nums[i]) {
                    nums[j++] = remover;
                }
                i = j;
                continue;
            }
            i++;
        }
        Arrays.sort(nums);
        int ans = 0;
        for(int num : nums) {
            if(num < remover) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = new int[] {0,0,1,1,1,1,2,3,3};
        int ans = removeDuplicates(a);
        for(int num : a) {
            System.out.print(num + " ");
        }
        System.out.println(ans);
    }
}
