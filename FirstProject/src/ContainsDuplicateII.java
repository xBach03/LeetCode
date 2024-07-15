import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                if(Math.abs(mp.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    mp.replace(nums[i], i);
                }
            } else {
                mp.put(nums[i], i);
            }
        }
        return false;
    }
}
