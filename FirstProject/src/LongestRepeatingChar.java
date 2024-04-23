import java.util.HashMap;

public class LongestRepeatingChar {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, max = 0;
        for(int j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'A']++;
            max = max > count[s.charAt(j) - 'A'] ? max : count[s.charAt(j) - 'A'];
            if(j - i + 1 - max > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

        }
        return s.length() - i;
    }
    public static void main(String[] Args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
