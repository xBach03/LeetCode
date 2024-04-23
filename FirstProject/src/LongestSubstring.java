import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = ans > (j - i + 1) ? ans : (j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] Args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
