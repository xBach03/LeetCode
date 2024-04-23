public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int curl = 1;
        for(int i = 0; i < nums.length; i++){
            ans[i] = curl;
            curl *= nums[i];
        }
        curl = 1;
        for(int i = nums.length - 1; i >=0; i--){
            ans[i] *= curl;
            curl *= nums[i];
        }
        return ans;
    }
}
