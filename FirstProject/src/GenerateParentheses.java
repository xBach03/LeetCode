import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public void Backtracker(List<String> ans, String str, int open, int close, int count) {
        if(str.length() == 2 * count) {
            ans.add(str);
            return;
        }
        if(open < count) {
            Backtracker(ans, str + "(", open + 1, close, count);
        }
        if(close < open){
            Backtracker(ans, str + ")", open, close + 1, count);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Backtracker(ans, "", 0 , 0, n);
        return ans;
    }
    public static void main(String[] Args) {
        GenerateParentheses generator = new GenerateParentheses();
        for(String i : generator.generateParenthesis(3)) {
            System.out.println(i);
        }
    }
}
