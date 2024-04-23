import java.util.Stack;

public class DailyTemp {
    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        ans[length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < length; i++) {
            while ( !stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] Args) {
        for(int i : dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})) {
            System.out.println(i);
        }
    }
}
