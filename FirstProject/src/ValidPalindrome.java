public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder x = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                x.append((char) (s.charAt(i) + 32));
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                x.append(s.charAt(i));
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                x.append(s.charAt(i));
            }
        }
        int j = x.length() - 1;
        for(int i = 0; i <= j; i++) {
            if(x.charAt(i) != x.charAt(j - i)) {
                return false;
            }
        }
        return true;
    }
    public static void test(int a) {
        a += 5;
    }
    public static void main(String[] Args) {
//        System.out.println(isPalindrome("0P"));
        int x = 5;
        test(x);
        System.out.println(x);
    }
}
