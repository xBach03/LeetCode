import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            Character t = s.charAt(i);
            if(t == '{' || t == '[' || t == '(') {
                stack.push(t);
                count++;
            } else if(count != 0) {
                count--;
                if(t == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if(t == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if(t == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }
        if(count == 0) return false;
        return true;
    }
    public static void main(String[] Args) {
        System.out.println(isValid("(]"));
    }
}
