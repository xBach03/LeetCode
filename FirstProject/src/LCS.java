import java.util.HashMap;
import java.util.HashSet;

public class LCS {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> mp = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            mp.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(!mp.contains(nums[i] - 1)) {
                int count = 1;
                int j = nums[i];
                while(mp.contains(j + 1)) {
                    j++;
                    count++;
                }
                if(count > ans) ans = count;
            }
        }
        return ans;
    }
    public static void main(String[] Args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
