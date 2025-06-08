import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if(nums.length == 1){
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1){
                if(nums[i - 1] != temp) {
                    String range = temp + "->" + nums[i - 1];
                    ans.add(range);
                } else {
                    ans.add(String.valueOf(temp));
                }
                temp = nums[i];
            }
            if(i == nums.length - 1) {
                if(temp != nums[i]) {
                    ans.add(temp + "->" + nums[i]);
                } else {
                    ans.add(String.valueOf(temp));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<String> result = summaryRanges(new int[]{0,1,2,4,5,7});
        for(String i : result) {
            System.out.println(i);
        }
    }
}
