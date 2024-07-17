import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 1) return true;
        Map<Character, Character> mp = new HashMap<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            set1.add(s.charAt(i));
            set2.add(t.charAt(i));
        }
        if(set1.size() != set2.size()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(mp.containsKey(s.charAt(i))) {
                if(mp.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                } else {
                    mp.replace(s.charAt(i), t.charAt(i));
                }
            } else {
                mp.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
