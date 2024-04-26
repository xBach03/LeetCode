public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 1) {
            return heights[0];
        }
        int[] LessFromLeft = new int[heights.length];
        int[] LessFromRight = new int[heights.length];

        LessFromLeft[0] = -1;
        LessFromRight[heights.length - 1] = heights.length;
        for(int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]) {
                p = LessFromLeft[p];
            }
            LessFromLeft[i] = p;
        }
        for(int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while(p < heights.length && heights[p] >= heights[i]) {
                p = LessFromRight[p];
            }
            LessFromRight[i] = p;
        }
        int area = 0;
        for(int i = 0; i < heights.length; i++) {
            int current = heights[i] * (LessFromRight[i] - LessFromLeft[i] - 1);
            if(current > area) {
                area = current;
            }
        }
        return  area;
    }
    public static void main(String[] Args) {
        System.out.println(largestRectangleArea(new int[] {0,9}));
    }
}
