
import java.util.Arrays;
import java.util.HashSet;


public class CheckInclusion {
    public static boolean checkPermutation(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int i = 0;
        int j = s1.length();
        int[] a = new int[26];
        int[] b = new int[26];
        for(int k = 0; k < s1.length(); k++) {
            a[s1.charAt(k) - 'a']++;
        }
        while(j < s2.length()) {
            for(int k = i; k < j; k++) {
                b[s2.charAt(k) - 'a']++;
            }
            if(checkPermutation(a, b)) {
                return true;
            }
            i++;
            j++;
            b = new int[26];
        }
        return false;
    }
    public static void main(String[] Args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
