import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> mp1 = new HashMap<>();
        Map<String, Character> mp2 = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            if(mp1.containsKey(pattern.charAt(i))) {
                if(!mp1.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
            if(mp2.containsKey(strs[i])) {
                if(mp2.get(strs[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
            mp1.put(pattern.charAt(i), strs[i]);
            mp2.put(strs[i], pattern.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
