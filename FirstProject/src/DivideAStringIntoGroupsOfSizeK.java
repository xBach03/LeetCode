import java.util.Arrays;

public class DivideAStringIntoGroupsOfSizeK {
    public static String[] divideString(String s, int k, char fill) {
        int groupsCount = s.length() % k == 0 ? s.length() / k
                : (s.length() / k) + 1;
        String[] ans = new String[groupsCount];
        int index = 0;
        StringBuilder curr = new StringBuilder(k);
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && i % k == 0) {
                ans[index++] = curr.toString();
                curr.setLength(0);
            }
            curr.append(s.charAt(i));
        }
        if (curr.length() != k) {
            curr.append(String.valueOf(fill).repeat(Math.max(0, k - curr.length())));
        }
        ans[index] = curr.toString();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
    }
}
