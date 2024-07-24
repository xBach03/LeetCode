import java.util.Objects;

public class LongestPalindromic {
    public static boolean checkPalindrome(String x) {
        int leftPtr = 0;
        int rightPtr = x.length() - 1;
        while(leftPtr < rightPtr) {
            if(x.charAt(leftPtr) != x.charAt(rightPtr)) return false;
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length(); j > 0; j--) {
                if(i > j) break;
                String x = s.substring(i, j);
                if(x.length() < ans.length()) return ans;
                if(x.length() > ans.length() && checkPalindrome(x)) {
                    ans = x;
                }
            }
        }
        return ans;
    }
    public static void main(String[] Args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
