import java.util.Stack;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        if(s.length() == 1) return s;
        int left = 0;
        int right = s.length() - 1;
        while(s.charAt(left) == ' ') {
            left++;
        }
        while(s.charAt(right) == ' ') {
            right--;
        }
        if(left == right) return String.valueOf(s.charAt(left));
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for(int i = left; i < right; i++) {
            if(i == right - 1) {
                while(i <= right) {
                    if(s.charAt(i) != ' ') temp.append(s.charAt(i));
                    i++;
                }
                stack.add(temp.toString());
                break;
            }
            if(s.charAt(i) != ' ' && s.charAt(i + 1) == ' ') {
                temp.append(s.charAt(i));
                stack.add(temp.toString());
                temp = new StringBuilder();
                continue;
            }
            if(s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            String x = stack.pop();
            ans.append(x);
            if(!stack.isEmpty()) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" asdasd df f"));
    }

}
