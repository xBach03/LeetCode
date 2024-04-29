public class TrappingRainWater {
    public static int trap(int[] height) {
        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        for(int i = 0; i < height.length; i++) {
            result += Math.min(maxRight[i], maxLeft[i]) - height[i];
        }
        return result;
    }
    public static void main(String[] Args) {
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }
}
