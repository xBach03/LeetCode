import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() > t.length() || s.length() < t.length()) return false;
        int[] a = new int[27];
        int[] b = new int[27];
        for(int i = 0; i < s.length(); i++){
            a[s.charAt(i) - 'a']++;
            b[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 27; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] Args){
        System.out.println(isAnagram("r", "nagaram"));
    }
}
