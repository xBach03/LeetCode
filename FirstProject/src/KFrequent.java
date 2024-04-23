import java.lang.reflect.Array;
import java.util.*;

public class KFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(nums[i])) {
                mp.put(nums[i], 1);
            } else {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            }
        }
        Map<Integer, Integer> mp2 = new HashMap<>();
        int j = 0;
        int[] a = new int[mp.size()];
        for(int i : mp.keySet()){
            mp2.put(mp.get(i), i);
            a[j++] = mp.get(i);
        }
        int x = 0;
        Arrays.sort(a);
        int[] ans = new int[k];
        for(int l = mp.size() - 1; l >= mp.size() - k; l--){
            ans[x++] = mp2.get(a[l]);
        }
        return ans;
    }
    public static void main(String[] Args){
            int[] ans = topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
            for(int x : ans){
//                System.out.println(x);
            }
    }
}
