public class Container {
    public static int maxArea(int[] height) {
        int k = height.length - 1;
        int j = 0;
        int ans = 0;
        while(j < k) {
            int x = height[j] >= height[k] ? height[k] : height[j];
            int y = k - j;
            int area = x * y;
            if(area > ans) ans = area;
            if(x == height[j]) {
                j++;
            } else {
                k--;
            }
        }
        return ans;
    }
    public static void main(String[] Args) {
        System.out.println(maxArea(new int[]{1,1}));
    }
}
