import java.util.Stack;

public class ERPN {
    public static boolean signCheck(String x) {
        if(x.equals("+")|| x.equals("-") || x.equals("*") || x.equals("/")) {
            return true;
        }
        return false;
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < tokens.length; i++) {
            String j = tokens[i];
            if(!signCheck(j)) {
                stack.push(Integer.valueOf(j));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if(j.equals("+")) {
                    stack.push(a + b);
                } else if(j.equals("-")) {
                    stack.push(b - a);
                } else if(j.equals("/")) {
                    stack.push(b / a);
                } else {
                    stack.push(a * b);
                }
            }
        }
        return stack.peek();
    }
    public static void main(String[] Args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
